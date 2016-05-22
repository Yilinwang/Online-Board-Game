package server;

import java.net.Socket;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by ralph on 2016/1/16.
 */
public class Server extends Thread{
    private Listen listener;
    private final LinkedBlockingQueue<ServerPlayer> selector;
    private ArrayList<ServerPlayer> players;
    private ArrayList<Table> tables;
    public Server(int port){
        listener = new Listen(port);
        players = new ArrayList<>();
        selector = new LinkedBlockingQueue<>();
        tables = new ArrayList<>();
        for (int i = 0; i < 3; ++i)
            tables.add(new Table());
    }
    public void request(ServerPlayer player){
        synchronized (selector){
            selector.offer(player);
        }
    }
    public void broadcast(Request message){
        for(ServerPlayer player : players){
            player.send(message);
        }
    }
    @Override
    public void run(){
        listener.start();
        for(Table table : tables)
            table.start();
        while(true){
            for(Socket socket : listener.getConnections()) {
                ServerPlayer player = new ServerPlayer(socket, this);
                player.start();
                players.add(player);
            }
            synchronized (selector){
                ArrayList<ServerPlayer> buffer = new ArrayList<>(10);
                selector.drainTo(buffer, 10);
                for(int i = 0; i < buffer.size(); ++i){
                    ServerPlayer player = buffer.get(i);
                    switch (player.getPlayerRequest()){
                        case 1:
                            players.remove(i);
                            break;
                        case 2:
                            int table = player.getTable();
                            if(tables.get(table).hasSeat()) {
                                tables.get(table).assign(player);
                                players.remove(i);
                                player.setLobbyReply(true);
                            }
                            else{
                                player.setLobbyReply(false);
                            }
                    }
                }
            }
            Request tableStatus = new Request(0);
            for(Table table: tables){
                ArrayList<String> playerName = new ArrayList<>();
                for(int i = 0; i < table.getPlayers().size(); ++i)
                    playerName.add(table.getPlayers().get(i).getUser());
                for(int i = table.getPlayers().size(); i < 5; ++i){
                    playerName.add("");
                }
                tableStatus.addTable(playerName);
            }
            broadcast(tableStatus);
            for(Table table: tables){
                if(table.isFinish()){
                    players.addAll(table.getPlayers());
                    table.reset();
                }
            }
            try{
                Thread.sleep(100);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args){
        int port = 5410;
        try{
            port = Integer.valueOf(args[0]);
        }
        catch (Exception e){
            System.err.println("No specific of port number... Default 5410  ");
        }

        Server server = new Server(port);
        server.start();
    }
}
