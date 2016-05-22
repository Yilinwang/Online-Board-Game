package game;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by ralph on 2016/1/18.
 */
public class Hand implements Serializable{
    private int[] tickets;
    public Hand(){
        tickets = new int[9];
        for (int i = 0; i < 9 ; ++i){
            tickets[i] = 0;
        }
    }
    public Hand(ArrayList<Ticket> _tickets){
        tickets = new int[9];
        for (int i = 0; i < 9 ; ++i){
            tickets[i] = 0;
        }
        for(Ticket ticket : _tickets){
            tickets[ticket.getColor()]++;
        }

    }
    public Hand(Hand _hand){
        tickets = new int[9];
        for(int i = 0 ; i < 9; ++i)
            tickets[i] = _hand.tickets[i];
    }
    public int[] getTickets(){
        return tickets;
    }
    public void addAll(ArrayList<Ticket> _tickets){
        for(Ticket ticket : _tickets)
            tickets[ticket.getColor()] ++;
    }
    public int size(){
        int sum = 0;
        for(int i = 0; i < 9; ++i)
            sum += tickets[i];
        return sum;
    }
}
