package client;

import java.util.ArrayList;

public class GameData {
    private ArrayList<ArrayList<String>> playerInfo;
    private ArrayList<String> playerName;
    private ArrayList<Integer> ticketForDraw;
    private ArrayList<String> ticket;
    private ArrayList<Integer> colors;
    private int roadID;
    private int roadColor;
    private boolean finish;

    public GameData() {
        playerInfo = new ArrayList<>();
        playerName = new ArrayList<>();
        ticketForDraw = new ArrayList<>();
        ticket = new ArrayList<>();
    }
    public GameData(ArrayList<ArrayList<String>> _playerInfo, ArrayList<String > _playerName, ArrayList<Integer> _ticketForDraw, ArrayList<String> _ticket, ArrayList<Integer> _colors, int _roadID, int _color, boolean _finish){
        playerInfo = new ArrayList<>(_playerInfo);
        playerName = new ArrayList<>(_playerName);
        ticketForDraw = new ArrayList<>(_ticketForDraw);
        ticket = new ArrayList<>(_ticket);
        colors = new ArrayList<>(_colors);
        roadID = _roadID;
        roadColor = _color;
        finish = _finish;
    }
    public int getRoadID(){
        return roadID;
    }

    public int getRoadColor() {
        return roadColor;
    }

    public boolean isFinish() {
        return finish;
    }

    public ArrayList<ArrayList<String>> getPlayerInfo() {
        return playerInfo;
    }

    public ArrayList<String> getTicket() {
        return ticket;
    }

    public ArrayList<Integer> getTicketForDraw() {
        return ticketForDraw;
    }

    public ArrayList<String> getPlayerName() {
        return playerName;
    }

    public ArrayList<Integer> getColors() {
        return colors;
    }

    public void setPlayerInfo(ArrayList<ArrayList<String>> playerInfo) {
        this.playerInfo = playerInfo;
    }

    public void setPlayerName(ArrayList<String> playerName) {
        this.playerName = playerName;
    }

    public void setTicket(ArrayList<String> ticket) {
        this.ticket = ticket;
    }

    public void setTicketForDraw(ArrayList<Integer> ticketForDraw) {
        this.ticketForDraw = ticketForDraw;
    }
}
