package client;

import game.*;
import server.Request;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.SplittableRandom;

/**
 * Created by ralph on 2016/1/18.
 */
public class GameControler {
    private static final int[] roadScore = {0, 1, 2, 4, 7, 15, 21};
    private Map map;
    private ArrayList<Ticket> openTickets;
    private ArrayList<Ticket> coveredTickets;
    private ArrayList<Mission> missions;
    private ArrayList<Mission> coveredMissions;
    private ArrayList<PlayerInfo> playerInfos;
    private int[] tickets;
    private int step;
    private int position;
    private int score;
    private String name;
    private ChooseAction chooseAction;
    private ArrayList<ArrayList<Integer>> roads;

    private int bufferRoad;
    private int bufferColor;
    public GameControler(){
        map = new Map();
        score = 0;
        step = 45;
        tickets = new int[9];
        for(int i = 0; i < 9; ++i)
            tickets[i] = 0;
        missions = new ArrayList<>();
        openTickets = new ArrayList<>();
        chooseAction = new ChooseAction();
        playerInfos = new ArrayList<>();
        roads = new ArrayList<>();
        for(int i = 0; i < 5; ++i){
            roads.add(new ArrayList<>());
        }
        bufferColor = 0;
        bufferRoad = -1;
    }
    public boolean travel(int roadIndex, int color){
        Road road = map.get(roadIndex);
        System.out.printf("travel : %d %d %d %d\n", color, road.getColor(), road.getCost(), roadIndex);
        if((!road.isChoosed())){
            if(road.getCost() > step)
                return false;
            if(road.getColor() == Map.GRAY){
                if(color == -1) {
                    return false;
                }
                if(tickets[color] >= road.getCost()){
                    tickets[color] -= road.getCost();
                    step -= road.getCost();
                    score += roadScore[road.getCost()];
                    roads.get(position).add(roadIndex);
                    return true;
                }
                else {
                    if(color != Ticket.RANBOW && (tickets[color] + tickets[Ticket.RANBOW] >= road.getCost())){
                        int left = road.getCost() - tickets[color];
                        tickets[color] = 0;
                        tickets[Ticket.RANBOW] -= left;
                        step -= road.getCost();
                        score += roadScore[road.getCost()];
                        roads.get(position).add(roadIndex);
                        return true;
                    }
                    else
                        return false;

                }
            }
            else{
                if(color != Ticket.RANBOW && road.getColor() != color) {
                    return false;
                }
                if(tickets[color] >= road.getCost()) {
                    tickets[color] -= road.getCost();
                    step -= road.getCost();
                    score += roadScore[road.getCost()];
                    roads.get(position).add(roadIndex);
                    return true;
                }
                else{
                    if(color != Ticket.RANBOW && (tickets[color] + tickets[Ticket.RANBOW] >= road.getCost())){
                        int left = road.getCost() - tickets[color];
                        tickets[color] = 0;
                        tickets[Ticket.RANBOW] -= left;
                        step -= road.getCost();
                        score += roadScore[road.getCost()];
                        roads.get(position).add(roadIndex);
                        return true;
                    }
                    else
                        return false;
                }
            }
        }
        return false;
    }
    public void setPosition(int _position){
        position = _position;
        System.out.print(name+" "+Integer.toString(position));
    }

    public int getPosition() {
        return position;
    }

    public String visited(int roadIndex, String _name, int _position){
        map.setChoosed(roadIndex);
        bufferColor = _position;
        bufferRoad = roadIndex;
        return new StringBuilder(_name).append(" travels from ").append(map.get(roadIndex).getCityOne()).append(" to ").append(map.get(roadIndex).getCityTwo()).toString();
    }
    public void addTickets(Hand _ticket){
        for(int i = 0; i < 9; ++i)
            tickets[i] += _ticket.getTickets()[i];
    }
    public void addMissions(ArrayList<Mission> _mission){
        missions.addAll(_mission);
    }
    public PlayerInfo getPlayerInfo(){
        int sum = 0;
        for(int i = 0; i < 9; ++i)
            sum += tickets[i];
        return new PlayerInfo(sum, missions.size(), position, step, score, name);
    }
    public void setRound(ArrayList<Ticket> _coveredTickets, ArrayList<Mission> _missions){
        coveredTickets = new ArrayList<>(_coveredTickets);
        coveredMissions = new ArrayList<>(_missions);
        chooseAction = new ChooseAction();
    }
    public int drawTicket(int no, int step){
        int returnValue = 0;
        if(no == 5){
            tickets[coveredTickets.remove(0).getColor()] ++;
            if(step == 1)
                chooseAction.setFirst(no);
            else
                chooseAction.setSecond(no);
        }
        else {
            if(openTickets.get(no).getColor() == Ticket.RANBOW){
                if(step == 1)
                    returnValue = 1;
                else
                    return -1;
            }
            tickets[openTickets.get(no).getColor()]++;
            openTickets.remove(no);
            openTickets.add(no, coveredTickets.remove(0));
            if(step == 1)
                chooseAction.setFirst(no);
            else
                chooseAction.setSecond(no);


        }
        return returnValue;

    }
    public Request getAction(){
        Request action = new Request(8, 1);
        action.setAction(chooseAction);
        action.setAfterDecision(getPlayerInfo());
        return action;
    }
    public boolean hasMission(){
        return missions.size() <= 5;
    }
    public Request missionOK(){
        missions.addAll(coveredMissions);
        Request request = new Request(8, 2);
        request.setMissions(coveredMissions);
        request.setAfterDecision(getPlayerInfo());
        return request;
    }
    public void updatePlayer(PlayerInfo playerInfo){
        playerInfos.remove(playerInfo.getPosition());
        playerInfos.add(playerInfo.getPosition(), playerInfo);
    }
    public void initPlayers(ArrayList<PlayerInfo> _playerInfos){
        playerInfos.addAll(_playerInfos);
    }
    public String otherPlayerAction(ChooseAction _action, String _name, ArrayList<Ticket> coveredTickets){
        if(_action.getFirst() != -1 && _action.getFirst() != 5){
            openTickets.remove(_action.getFirst());
            openTickets.add(_action.getFirst(), coveredTickets.remove(0));
        }
        if(_action.getFirst() == 5)
            coveredTickets.remove(0);
        if(_action.getSecond() != -1 && _action.getSecond() != 5){
            openTickets.remove(_action.getSecond());
            openTickets.add(_action.getSecond(), coveredTickets.remove(0));
        }
        return new StringBuilder(_name).append(" takes ").append(_action.getFirst()).append(" and ").append(_action.getSecond()).toString();
    }
    public String otherPlayerMission(ArrayList<Mission> _missions, String _name){
        return new StringBuilder(_name).append(" takes a missions").toString();
    }
    public void setName(String _name){
        name = _name;
    }
    public GameData getGameData(){
        ArrayList<ArrayList<String>> players = new ArrayList<>();
        ArrayList<String> playerName = new ArrayList<>();
        ArrayList<Integer> colors = new ArrayList<>();
        for(PlayerInfo playerInfo : playerInfos){
            if(playerInfo.getPosition() != position) {
                ArrayList<String> buffer = new ArrayList<>();
                buffer.add(Integer.toString(playerInfo.getScore()));
                buffer.add(Integer.toString(playerInfo.getTickets()));
                buffer.add(Integer.toString(playerInfo.getStep()));
                buffer.add(Integer.toString(playerInfo.getMissions()));
                players.add(buffer);
                playerName.add(playerInfo.getPlayerName());
                colors.add(playerInfo.getPosition());
            }
        }
        ArrayList<Integer> _open = new ArrayList<>();
        for(Ticket ticket : openTickets){
            _open.add(ticket.getColor());
        }
        ArrayList<String> my_tickets = new ArrayList<>();
        for(int i = 0; i < 9; ++i){
            my_tickets.add(Integer.toString(tickets[i]));
        }
        return new GameData(players, playerName, _open, my_tickets, colors, bufferRoad, bufferColor, false);

    }
    public ArrayList<String> getSelfData(){
        ArrayList<String> data = new ArrayList<>();
        data.add(Integer.toString(score));
        data.add(Integer.toString(playerInfos.get(position).getTickets()));
        data.add(Integer.toString(step));
        data.add(Integer.toString(missions.size()));
        return data;
    }
    public void getOpenTickets(ArrayList<Ticket> _open){
        openTickets = new ArrayList<>(_open);
        System.out.println(openTickets.size());
    }
    public ArrayList<Integer> getScore(){
        ArrayList<Integer> scores = new ArrayList<>();
        for(PlayerInfo playerInfo : playerInfos)
            scores.add(playerInfo.getScore());
        return scores;
    }
    public ArrayList<String> getNames(){
        ArrayList<String> names = new ArrayList<>();
        for(PlayerInfo playerInfo : playerInfos)
            names.add(playerInfo.getPlayerName());
        return names;
    }
    public ArrayList<Integer> getMissionScore(ArrayList<ArrayList<Mission>> openMissions){
        ArrayList<Integer> missionScores = new ArrayList<>();
        for(int i = 0; i < 5; ++i) {
            int Mscore = 0;
            int[][] matrix = new int[36][36];
            for (Integer j : roads.get(i)) {
                matrix[map.get(j).getCityOne()][map.get(j).getCityTwo()] = 1;
                matrix[map.get(j).getCityTwo()][map.get(j).getCityOne()] = 1;
            }
            for (Mission mission : openMissions.get(i)) {
                if (connect(mission.getCityOne(), mission.getCityTwo(), matrix))
                    Mscore += mission.getValue();
                else
                    Mscore -= mission.getValue();
            }
            missionScores.add(Mscore);
        }
        return missionScores;
    }
    public boolean connect(int from, int to, int[][] matrix){
        HashSet<Integer> visit = new HashSet<>();
        ArrayList<Integer> queue = new ArrayList<>();
        queue.add(from);
        while(queue.size()!=0){
            int x = queue.remove(0);
            for(int i = 0; i < 36; ++i){
                if(matrix[x][i] != 0) {
                    if(i == to)
                        return true;
                    if (!visit.contains(i)) {
                        visit.add(i);
                        queue.add(i);
                    }
                }
            }
        }
        return  false;
    }
}
