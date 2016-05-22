package server;


import game.*;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by ralph on 2016/1/16.
 */
public class ServerPlayer extends Thread{
    private static final int[] roadScore = {0, 1, 2, 4, 7, 15, 21};
    private Out out;
    private ObjectInputStream in;
    private Server server;
    private String name;
    private int decisionInLobby;
    private int table;
    private boolean lobbyReply;
    private final Object serverReply;
    private boolean ready;
    private Map map;
    private int score;
    private int tickets;
    private ArrayList<Mission> missions;
    private int steps;
    private int position;


    public ServerPlayer(Socket socket, Server _server){
        server = _server;
        table = 0;
        serverReply = new Object();
        ready = false;
        try {
            out = new Out(new ObjectOutputStream(socket.getOutputStream()));
            in = new ObjectInputStream(socket.getInputStream());
        }catch (Exception e){
            System.err.println("Server Player create error!!!!");
        }

        tickets = 0;
        missions = new ArrayList<>();
        steps = 45;
        score = 0;
        missions = new ArrayList<>();
    }
    public void setLobbyReply(boolean _lobbyReply){
        synchronized (serverReply) {
            lobbyReply = _lobbyReply;
            serverReply.notify();
        }
    }
    public int getPlayerRequest(){
        return decisionInLobby;
    }
    public int getTable(){
        return table;
    }
    public void send(Request message){
        out.write(message);

    }
    public String getUser(){
        return name;
    }
    public void inLobby(){
        ready = true;
        while(true){
            Request request;
            try{
                request = (Request)in.readObject();
            } catch (Exception e){
                System.err.printf("%s read from socket error.", name);
                continue;
            }
            decisionInLobby = request.getType();
            switch (decisionInLobby){
                case 1: //leave
                    server.request(this);
                    return;
                case 2: //join a table
                    synchronized (serverReply) {
                        server.request(this);
                        table = request.getTable();
                        try {
                            serverReply.wait();
                        } catch (Exception e){
                            System.err.printf("Interrupt occur in %s", name);
                        }
                        if(lobbyReply){
                            Request success = new Request();
                            success.setSuccess(true);
                            send(success);
                            return;
                        }
                        else{
                            Request failed = new Request();
                            failed.setSuccess(false);
                            send(failed);
                        }
                    }
                    break;
            }
        }
    }
    public void gameInit(ArrayList<Ticket> _tickets, ArrayList<Mission> _missions, int _position, Map _map){
        tickets += _tickets.size();
        missions.addAll(_missions);
        position = _position;
        map = _map;
        Request request = new Request(new Hand(_tickets), missions, position);
        out.write(request);
    }
    public PlayerInfo getMissionNumber(){
        return new PlayerInfo(tickets, 0, position, steps, score, name);

    }
    public int getSteps(){
        return steps;
    }
    public Request getDecision(){
        try{
            Request request = (Request) in.readObject();
            switch (request.getDecision()){
                case 0:
                    steps -= map.get(request.getRoadIndex()).getCost();
                    tickets -= map.get(request.getRoadIndex()).getCost();
                    score += roadScore[map.get(request.getRoadIndex()).getCost()];
                    break;
                case 1:
                    if(request.getAction().getFirst() != -1)
                        tickets++;
                    if(request.getAction().getSecond() != -1)
                        tickets++;
                    break;
                case 2:
                    missions.addAll(request.getMissions());
                    break;
            }
            return request;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("No decision !!!!!!!!!");
            e.printStackTrace();
            return null;

        }

    }
    public boolean getResponse(){
        try {
            Request request = (Request) in.readObject();
            return true;
        } catch (Exception e){
            System.out.println("Socket broken!!");
            return false;
        }
    }
    public ArrayList<Mission> getMissions(){
        return new ArrayList<>(missions);
    }
    @Override
    public void run(){
        out.start();
        try {
            name = ((Request)in.readObject()).getName();
            System.out.println(name);
        } catch (Exception e){
            //System.err.println(e.getMessage());
            System.err.println("Player create fail.");
        }
        inLobby();
    }
}
