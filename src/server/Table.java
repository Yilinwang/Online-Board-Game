package server;

import game.Boardgame;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by ralph on 2016/1/16.
 */
public class Table extends Thread{
    private final ArrayList<ServerPlayer> players;
    private boolean finish;
    private final Object statusLock;
    public Table(){
        players = new ArrayList<>();
        statusLock = new Object();
    }
    private void broadcast(Request message){
        for(ServerPlayer player : players){
            player.send(message);
        }
    }
    public boolean hasSeat(){
        return players.size() < 5;
    }
    public void assign(ServerPlayer player){
        synchronized (players) {
            players.add(player);
            players.notify();
        }
    }
    public boolean isFinish(){
        synchronized (statusLock){
            if(finish){
                finish = false;
                return true;
            }
            else
                return false;
        }
    }
    public void reset(){
        players.clear();
        finish = false;
    }
    public ArrayList<ServerPlayer> getPlayers(){
        return new ArrayList<>(players);
    }
    @Override
    public void run(){
        finish = false;
        synchronized (players){
            while(players.size() < 5){
                try {
                    players.wait();
                } catch (Exception e){
                    System.err.println("Table interrupt");
                }
            }
        }
        Boardgame game = new Boardgame(players);
        try{
            Thread.sleep(1000);
        } catch (Exception e){
            System.err.println("Interrupted");
        }
        game.process();
        synchronized (statusLock) {
            finish = true;
        }
    }
}
