package game;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by ralph on 2016/1/16.
 */
public class Shuffler {
    private ArrayList<Ticket> tickets;
    private ArrayList<Mission> missions;
    private int top_ticket;
    private int top_mission;
    public Shuffler(){
        tickets = new ArrayList<>();
        missions = new ArrayList<>();
        top_ticket = 0;
        for(int i = 0; i < 8; ++i){
            for(int j = 0; j < 35; ++j)
                tickets.add(new Ticket(i));
        }
        for(int i = 0; i < 30; ++i){
            tickets.add(new Ticket(8));
        }

        missions.add(new Mission(5, 33, 21));
        missions.add(new Mission(15, 20, 8));
        missions.add(new Mission(21, 26, 8));
        missions.add(new Mission(33, 30, 6));
        missions.add(new Mission(3, 26, 17));
        missions.add(new Mission(1, 31, 20));
        missions.add(new Mission(15, 13, 10));
        missions.add(new Mission(27, 36, 10));
        missions.add(new Mission(3, 9, 11));
        missions.add(new Mission(19, 33, 11));
        missions.add(new Mission(6, 8, 7));
        missions.add(new Mission(6, 9, 13));
        missions.add(new Mission(5, 36, 20));
        missions.add(new Mission(14, 24, 11));
        missions.add(new Mission(4, 30, 17));
        missions.add(new Mission(17, 20, 5));
        missions.add(new Mission(5, 22, 16));
        missions.add(new Mission(11, 28, 11));
        missions.add(new Mission(22, 12, 9));
        missions.add(new Mission(1, 12, 13));
        missions.add(new Mission(32, 36, 12));
        missions.add(new Mission(22, 25, 7));
        missions.add(new Mission(31, 30, 9));
        missions.add(new Mission(2, 33, 22));
        missions.add(new Mission(11, 13, 4));
        missions.add(new Mission(10, 5, 8));
        missions.add(new Mission(14, 20, 12));
        missions.add(new Mission(31, 15, 13));
        missions.add(new Mission(21, 18, 9));
        missions.add(new Mission(2, 5, 9));

        Collections.shuffle(tickets);
        Collections.shuffle(missions);

    }
    public Ticket getTicket(){
        return tickets.get(top_ticket++);
    }
    public ArrayList<Ticket> getNTicket(int n){
        top_ticket += n;
        return new ArrayList<>(tickets.subList(top_ticket-n, top_ticket));
    }
    public ArrayList<Mission> getNMission(int n){
        top_mission += n;
        return new ArrayList<>(missions.subList(top_mission-n, top_mission));
    }
    public boolean outOfTicket(){
        return top_ticket == tickets.size();
    }
    public boolean outOfMission(int n){
        return (top_mission + n) >= missions.size();
    }
}
