package game;

import server.Request;
import server.Server;
import server.ServerPlayer;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ralph on 2016/1/16.
 */
public class Boardgame {
    private ArrayList<ServerPlayer> players;
    private Shuffler shuffler;
    private Map map;
    private ArrayList<Ticket> openTickets;
    private ArrayList<Ticket> coveredTickets;
    private ArrayList<Mission> topMissions;

    public Boardgame(ArrayList<ServerPlayer> _players){
        players = new ArrayList<>(_players);
        shuffler = new Shuffler();
        map = new Map();
        openTickets = new ArrayList<>();
        topMissions = new ArrayList<>();
        coveredTickets = new ArrayList<>();
    }
    public void broadcast(Request message){
        for(ServerPlayer player : players)
            player.send(message);
    }
    public void process() {
        init();
        gameStage();
        scoreStage();
    }
    public void gameStage(){
        while(true){
            int stopI = -1;
            for(int i = 0; i < players.size(); ++i){
                if(stopI == i)
                    return;
                Request turn = new Request(coveredTickets, topMissions, i);
                broadcast(turn);
                Request decision = new Request(0);
                while(decision.getType() != 8)
                    decision = players.get(i).getDecision();
                decision.setTickets(new ArrayList<>(coveredTickets));
                decision.setType(10);
                broadcast(decision);
                switch (decision.getDecision()){
                    case 0:
                        map.setChoosed(decision.getRoadIndex());
                        break;
                    case 1:
                        ChooseAction action = decision.getAction();
                        if(action.getFirst() == 5){
                            coveredTickets.remove(0);
                        }
                        else{
                            openTickets.remove(action.getFirst());
                            openTickets.add(action.getFirst(), coveredTickets.remove(0));
                        }
                        if(action.getSecond() == 5){
                            coveredTickets.remove(0);
                        }
                        else if(action.getSecond() != -1){
                            openTickets.remove(action.getSecond());
                            openTickets.add(action.getSecond(), coveredTickets.remove(0));
                        }
                        while(coveredTickets.size() < 2 && !shuffler.outOfTicket()){
                            coveredTickets.add(shuffler.getTicket());
                        }
                        break;
                    case 2:
                        topMissions = new ArrayList<>(shuffler.getNMission(1));
                        break;
                }
                if(players.get(i).getSteps() <= 2)
                    stopI = i;

            }
        }

    }

    public void scoreStage(){
        Request openMissions = new Request(9);
        for(ServerPlayer player : players){
            openMissions.add(player.getMissions());
        }
        broadcast(openMissions);

    }
    public void init(){
        for(int i = 0; i < players.size(); ++i){
            players.get(i).gameInit(shuffler.getNTicket(4), shuffler.getNMission(1), i, map);
        }
        Request initState = new Request(5);
        for(ServerPlayer player : players){
            initState.setPlayerInfo(player.getMissionNumber());
        }
        openTickets.addAll(shuffler.getNTicket(5));
        topMissions.addAll(shuffler.getNMission(1));
        coveredTickets.addAll(shuffler.getNTicket(2));
        initState.setTickets(openTickets);
        broadcast(initState);
    }
}
