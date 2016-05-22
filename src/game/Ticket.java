package game;

import java.io.Serializable;

/**
 * Created by ralph on 2016/1/16.
 */
public class Ticket implements Serializable{
    private int color;
    public static final int WHITE = 0;
    public static final int YELLOW = 1;
    public static final int BLUE = 2;
    public static final int GREEN = 3;
    public static final int RED = 4;
    public static final int DARKBLUE = 5;
    public static final int ORANGE = 6;
    public static final int PINK = 7;
    public static final int RANBOW = 8;

    public Ticket(int _color){
        color = _color;
    }
    public int getColor(){
        return color;
    }

}
