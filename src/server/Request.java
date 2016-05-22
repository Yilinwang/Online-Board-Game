package server;

import game.*;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by ralph on 2016/1/16.
 */
public class Request implements Serializable{
    private String name;
    private int type;
    private int table;
    private boolean success;
    private ArrayList<String> players;
    private ArrayList<ArrayList<String> > tables;
    private ArrayList<ArrayList<Mission>> openMissions;
    private ArrayList<Ticket> tickets;
    private Hand hand;
    private ArrayList<Mission> missions;
    private int position;
    private ArrayList<PlayerInfo> playerInfos;
    private int dropMission;
    private int decision;
    private ChooseAction action;
    private int roadIndex;
    private PlayerInfo afterDecision;
    /*   type :
    *       0. Lobby broadcast
    *       1. Leave lobby
    *       2. Choose a table to join
    *       3. Join table success
    *       4. Init statement for a player
    *       5. Broadcast game state.
    *       6. The number of drop mission
    *       7. The turn of a player
    *       8. Players decision
    *       9. final
    *       10. game broadcast
    **/
    public Request(){
    }
    public void setName(String _name){
        name = _name;
    }
    public String getName() {
        return name;
    }
    public void setType(int _type){
        type = _type;
    }
    public int getType(){
        return type;
    }
    public void setTable(int _table) {
        table = _table;
    }
    public int getTable(){
        return table;
    }
    public boolean getSuccess(){
        return success;
    }
    public void setLeave(){
        type = 1;
    }
    public void setChooseTable(int _table){
        type = 2;
        table = _table;
    }
    public void setSuccess(boolean _success){
        type = 3;
        success = _success;
    }
    public void addTable(ArrayList<String> table){
        tables.add(new ArrayList<>(table));
    }
    public ArrayList<Ticket> getTickets(){
        return tickets;
    }
    public ArrayList<Mission> getMissions(){
        return missions;
    }
    public int getPosition(){
        return position;
    }
    public void setPlayerInfo(PlayerInfo playerInfo) {
        playerInfos.add(playerInfo);
    }
    public ArrayList<PlayerInfo> getPlayerInfos(){
        return playerInfos;
    }
    public void setDropMission(int _dropMission){
        type = 6;
        dropMission = _dropMission;
    }
    public int getDecision(){
        return decision;
    }
    public int getRoadIndex(){
        return roadIndex;
    }
    public ArrayList<ArrayList<String>> getTables(){
        return tables;
    }
    public Hand getHand(){
        return hand;
    }
    public void setRoad(int _roadIndex, PlayerInfo _player){
        roadIndex = _roadIndex;
        afterDecision = _player;
    }
    public void setTickets(ArrayList<Ticket> _tickets){
        tickets = new ArrayList<>(_tickets);
    }
    public int getDropMission(){
        return dropMission;
    }
    public Request(Request r){
        name = r.name;
        type = r.type;
        table = r.table;
        success = r.success;
        players = new ArrayList<>(r.players);
        tables = new ArrayList<>(r.tables);
        tickets = new ArrayList<>(r.tickets);
        missions = new ArrayList<>(r.missions);
        position = r.position;
        playerInfos = new ArrayList<>(r.playerInfos);
    }
    public Request(Table t){
        for(ServerPlayer player : t.getPlayers())
            players.add(player.getUser());
    }
    public Request(int _type){
        type = _type;
        tables = new ArrayList<>();
        openMissions = new ArrayList<>();
        tickets = new ArrayList<>();
        playerInfos = new ArrayList<>();
    }
    public Request(Hand _hand, ArrayList<Mission> _missions, int _position){
        type = 4;
        hand = new Hand(_hand);
        missions = new ArrayList<>(_missions);
        position = _position;
    }
    public Request(ArrayList<Ticket> _tickets, ArrayList<Mission> _missions, int _position){
        type = 7;
        tickets = new ArrayList<>(_tickets);
        missions = new ArrayList<>(_missions);
        position = _position;
    }
    public Request(int _type, int _decision){
        type = _type;
        decision = _decision;
    }

    public void setAction(ChooseAction _action){
        action = _action;
    }

    public void setAfterDecision(PlayerInfo _playerInfo){
        afterDecision = _playerInfo;
    }
    public ChooseAction getAction(){
        return action;
    }
    public PlayerInfo getAfterDecision(){
        return afterDecision;
    }
    public void add(ArrayList<Mission> _missions){
        openMissions.add(new ArrayList<>(_missions));
    }
    public void setMissions(ArrayList<Mission> _missions){
        missions = new ArrayList<>(_missions);
    }
    public ArrayList<ArrayList<Mission>> getOpenMissions(){
        return openMissions;
    }
}
