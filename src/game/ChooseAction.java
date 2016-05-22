package game;

import java.io.Serializable;

/**
 * Created by ralph on 2016/1/18.
 */
public class ChooseAction implements Serializable {
    private int first;
    private int second;
    public ChooseAction(){
        first = -1;
        second = -1;
    }
    public int getFirst(){
        return first;
    }

    public int getSecond() {
        return second;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public void setSecond(int second) {
        this.second = second;
    }
}
