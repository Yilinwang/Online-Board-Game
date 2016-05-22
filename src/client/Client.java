package client;

import game.Mission;
import game.Ticket;
import server.Request;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by ralph on 2016/1/16.
 */
public class Client extends Thread{
    public static final int ROAD = 1;
    public static final int TICKET = 2;
    public static final int MISSION = 3;

    private Socket socket;
    private Scanner scanner;
    private Out out;
    private ObjectInputStream in;
    private boolean ignore;
    private int type;
    private int color;
    private int drawTimes;
    private GameControler gameControler;
    private final Object tableStageLock;
    private boolean tableStage;
    private boolean joinTable;
    private ArrayList<ArrayList<String> > tables;

    private String action;

    private String name;
    private final Object nameStageLock;
    private final Object roadPressLock;
    private final Object ticketPressLock;
    private final Object guiTableLock;
    private final Object guiGameLock;
    private boolean guiGame;

    private final Object guiMissionLock;
    private final Object guiRefreshLock;
    private boolean guiNewest;
    private GameData gameData;
    public boolean finish;

    private final Object guiInitLock;
    private boolean guiInit;

    public Client(String addr, int port){
        socket = new Socket();

        tables = new ArrayList<>();
        for(int i = 0; i < 3; ++i){
            ArrayList<String> buffer = new ArrayList<>();
            for(int j = 0; j < 5; ++j)
                buffer.add("");
            tables.add(buffer);
        }
        tableStageLock = new Object();
        tableStage = false;
        gameControler = new GameControler();
        nameStageLock = new Object();
        roadPressLock = new Object();
        ticketPressLock = new Object();
        guiTableLock = new Object();
        guiGameLock = new Object();
        guiMissionLock = new Object();
        guiInitLock = new Object();
        guiRefreshLock = new Object();
        guiNewest = false;
        ignore = true;
        joinTable = false;
        guiInit = false;
        guiGame =false;
        finish = false;
        action = "";
        type = 0;
        color = -1;
        drawTimes = 2;
        gameData = new GameData();
        InetSocketAddress isa = new InetSocketAddress(addr, port);
        try {
            socket.connect(isa);
        }catch (Exception e){
            System.err.println("Client failed to start.");
        }
        try {
            in = new ObjectInputStream(socket.getInputStream());
            out = new Out(new ObjectOutputStream(socket.getOutputStream()));
        } catch (Exception e){
            System.err.println("error!!!!");
        }
    }
    public void setUserName(String _name){
        synchronized (nameStageLock) {
            name = _name;
            nameStageLock.notify();
        }
    }
    public ArrayList<ArrayList<String>> getTable(){
        return new ArrayList<>(tables);
    }
    public int roadPressed(int roadIndex){
        /* return value
        *  1. success
        *  0. wrong color or not enough ticket
        *  -1. ignore
         */
        synchronized (roadPressLock){
            if(ignore)
                return -1;
            else{
                if(type != TICKET && type != MISSION){
                    if(gameControler.travel(roadIndex, color)){
                        ignore = true;
                        Request request = new Request(8, 0);
                        request.setRoad(roadIndex, gameControler.getPlayerInfo());
                        out.write(request);
                        return 1;
                    }
                    else
                        return 0;
                }
                else
                    return -1;
            }
        }
    }
    public boolean select(int tableID){
        Request request = new Request();
        request.setChooseTable(tableID);
        synchronized (guiTableLock){
            out.write(request);
            try {
                guiTableLock.wait();
            } catch (Exception e){
                System.err.println("unexpected exception in client.select");
            }
        }
        if(joinTable){
            for(int i = 0; i < 5; ++i) {
                System.out.println(tables.get(tableID).get(i));
                if (tables.get(tableID).get(i).contentEquals("")) {
                    tables.get(tableID).remove(i);
                    tables.get(tableID).add(i, name);
                    break;
                }
            }
        }

        return joinTable;
    }
    public void waitGame(){
        synchronized (guiGameLock){
            if(!guiGame) {
                try {
                    guiGameLock.wait();
                } catch (Exception e) {
                    System.err.println("unexpected exception in client.waitGame");
                }
            }
        }
    }
    public GameData waitInit(){
        synchronized (guiInitLock){
            if(!guiInit) {
                try {
                    guiInitLock.wait();
                } catch (Exception e){
                    System.err.println("gui init interrupted");
                }
            }
        }
        return gameControler.getGameData();
    }
    public ArrayList<String> getSelfData(){
        return gameControler.getSelfData();
    }
    public GameData getGameData(){
        if(finish)
            return gameData;
        return gameControler.getGameData();
    }
    public String getAction(){
        return action;
    }
    public int getColor(){
        return gameControler.getPosition();
    }
    public void colorPressed(int _color){
        color = _color;
        System.out.println(color);
    }
    public boolean ticketPressed(int no){
        synchronized (ticketPressLock) {
            if (ignore)
                return false;
            if(drawTimes--<=0){
                ignore = true;
                return false;
            }
            type = TICKET;
            switch (gameControler.drawTicket(no, drawTimes)){
                case 1:
                    drawTimes = 0;
                    ignore = true;
                    type = 0;
                    action = "Get a ticket " + name;
                    out.write(gameControler.getAction());
                    break;
                case -1:
                    drawTimes++;
                    return false;
                case 0:
                    if(drawTimes == 0) {
                        ignore = true;
                        action = "Get a ticket " + name;
                        type = 0;
                        out.write(gameControler.getAction());
                    }
                    break;
            }
        }
        return true;
    }
    public Mission drawMission(){
        if(ignore)
            return null;
        if(gameControler.hasMission()) {
            Request request = gameControler.missionOK();
            action = "Get a mission " + name;
            out.write(request);
            ignore = true;
            return request.getMissions().get(0);
        }
        return null;
    }
    public void nameStage(){
        System.err.println("in stage!!!");
        synchronized (nameStageLock){
            try {
                nameStageLock.wait();
            } catch (Exception e){
                System.out.println("Client interrupted.");
            }
        }
        System.err.println("get name!!! " + name);
        Request request = new Request();
        request.setName(name);
        try {
            out.write(request);
        } catch (Exception e) {
            System.err.println("Socket broken!!");
        }

    }
    public void lobbyStage() {
        //Lobby
        while (true) {
            Request request;
            try {
                request = (Request) in.readObject();
            } catch (Exception e) {
                System.out.println("System closed.");
                return;
            }
            switch (request.getType()) {
                case 0: //lobby broadcast
                    tables = new ArrayList<>(request.getTables());
                    break;

                case 3: //join table success
                    synchronized (guiTableLock){
                        joinTable = request.getSuccess();
                        guiTableLock.notify();
                        if(joinTable)
                            return;
                    }
                    break;
            }
        }
    }
    public void gameStage(){
        //Game
        //Init
        try{
            Request request = (Request) in.readObject();
            System.err.printf("Get request, type : %d", request.getType());
            gameControler.addTickets(request.getHand());
            gameControler.setPosition(request.getPosition());
            gameControler.setName(name);
            synchronized (guiGameLock){
                guiGame = true;
                guiGameLock.notify();
            }
            Request init = (Request) in.readObject();
            System.err.printf("Get request, type : %d", init.getType());
            System.err.println(init.getPlayerInfos());
            System.err.println(init.getTickets());
            gameControler.initPlayers(init.getPlayerInfos());
            gameControler.getOpenTickets(init.getTickets());
            synchronized (guiInitLock){
                guiInit = true;
                guiInitLock.notify();
            }
        }catch (Exception e){
            System.err.println(e.toString());
            System.err.println("System closed.");
            return;
        }
        while(true){
            Request request;
            try {
                request = (Request) in.readObject();
                System.out.println("Get Request");
                System.out.println(request.getType());
                switch (request.getType()){
                    case 7: // player's turn
                        if(request.getPosition() == gameControler.getPosition()){
                            gameControler.setRound(request.getTickets(), request.getMissions());
                            action = "My turn " + name;
                            System.out.println("My turn");
                            drawTimes = 2;
                            ignore = false;
                        }
                        break;
                    case 9: // final
                        scoreStage(request.getOpenMissions());
                        return;
                    case 10: // player's decision
                        System.out.println("Request.getAfterDecision");
                        System.out.println(request.getAfterDecision());
                        gameControler.updatePlayer(request.getAfterDecision());
                        if(request.getAfterDecision().getPosition() != gameControler.getPosition()){
                            switch (request.getDecision()){
                                case 0:
                                    action = gameControler.visited(request.getRoadIndex(), request.getAfterDecision().getPlayerName(), request.getAfterDecision().getPosition());
                                    break;
                                case 1:
                                    action = gameControler.otherPlayerAction(request.getAction(), request.getAfterDecision().getPlayerName(), request.getTickets());
                                    break;
                                case 2:
                                    action = gameControler.otherPlayerMission(request.getMissions(), request.getAfterDecision().getPlayerName());
                                    break;
                            }
                        }
                        break;

                }
            } catch (Exception e){
                e.printStackTrace();
                System.out.println("System closed.");
                return;
            }
        }
    }
    public void scoreStage(ArrayList<ArrayList<Mission>> openMissions){
        ArrayList<Integer> roadScore = gameControler.getScore();
        ArrayList<Integer> missionScore = gameControler.getMissionScore(openMissions);
        ArrayList<Integer> finalScore = new ArrayList<>();
        for(int i = 0; i < 5; ++i){
            finalScore.add(roadScore.get(i) + missionScore.get(i));
        }
        gameData = new GameData(null, gameControler.getNames(), null, null, finalScore, -1, -1, true);
        finish = true;
        try{
            Thread.sleep(3000);
        } catch (Exception e){
            System.err.println("Final stage interrupted");
        }
    }
    public void reset(){

        tables = new ArrayList<>();
        for(int i = 0; i < 3; ++i){
            ArrayList<String> buffer = new ArrayList<>();
            for(int j = 0; j < 5; ++j)
                buffer.add("");
            tables.add(buffer);
        }
        tableStage = false;
        gameControler = new GameControler();
        guiNewest = false;
        ignore = true;
        joinTable = false;
        guiInit = false;
        guiGame =false;
        finish = false;
        action = "";
        type = 0;
        color = -1;
        drawTimes = 2;
        gameData = new GameData();
    }
    @Override
    public void run(){
        out.start();
        nameStage();
        while(true) {
            lobbyStage();
            gameStage();
            reset();
        }
    }
}
