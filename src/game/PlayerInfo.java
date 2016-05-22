package game;

import java.io.Serializable;

/**
 * Created by ralph on 2016/1/17.
 */
public class PlayerInfo implements Serializable{
    private int tickets;
    private int missions;
    private int position;
    private int step;
    private int score;
    private String name;
    public PlayerInfo(int _tickets, int _missions, int _position, int _step, int _score, String _name){
        tickets = _tickets;
        missions = _missions;
        position = _position;
        step = _step;
        score = _score;
        name = _name;
    }

    public int getTickets(){
        return tickets;
    }
    public int getMissions(){
        return missions;
    }
    public int getPosition(){
        return position;
    }
    public int getStep(){
        return step;
    }

    public int getScore() {
        return score;
    }
    public String getPlayerName(){
        return name;
    }
}
