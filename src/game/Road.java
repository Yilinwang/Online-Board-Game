package game;

import java.io.Serializable;

/**
 * Created by ralph on 2016/1/17.
 */
public class Road implements Serializable {
    private int cityOne;
    private int cityTwo;
    private int cost;
    private int color;
    private int index;
    private boolean choosed;
    public Road(int _cityOne, int _cityTwo, int _cost, int _color, int _index){
        cityOne = _cityOne;
        cityTwo = _cityTwo;
        cost = _cost;
        color = _color;
        index = _index;
        choosed = false;
    }
    public int getCityOne(){
        return cityOne;
    }

    public int getCityTwo(){
        return cityTwo;
    }

    public int getColor() {
        return color;
    }

    public boolean isChoosed() {
        return choosed;
    }

    public int getCost() {
        return cost;
    }

    public void setChoosed(){
        choosed = true;
    }
}
