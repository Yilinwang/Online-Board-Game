package game;


import java.util.ArrayList;
/**
 * Created by ralph on 2016/1/17.
 */
public class Map {
    private ArrayList<Road> roads;
    public static final int WHITE = 0;
    public static final int YELLOW = 1;
    public static final int BLUE = 2;
    public static final int GREEN = 3;
    public static final int RED = 4;
    public static final int DARKBLUE = 5;
    public static final int ORANGE = 6;
    public static final int PINK = 7;
    public static final int GRAY = 8;
    public Map(){
        roads = new ArrayList<>();
        roads.add(new Road(1, 2, 1, GRAY, 0));
        roads.add(new Road(1, 2, 1, GRAY, 1));
        roads.add(new Road(1, 6, 3, DARKBLUE, 2)); //adjust 160118-4
        roads.add(new Road(2, 3, 1, GRAY, 3));
        roads.add(new Road(2, 3, 1, GRAY, 4));
        roads.add(new Road(2, 6, 4, GRAY, 5));
        roads.add(new Road(2, 10, 6, YELLOW, 6));
        roads.add(new Road(3, 4, 5, GREEN, 7));
        roads.add(new Road(3, 4, 5, PINK, 8));
        roads.add(new Road(3, 8, 6, BLUE, 9));
        roads.add(new Road(4, 5, 3, YELLOW, 10));
        roads.add(new Road(4, 5, 3, PINK, 11));
        roads.add(new Road(4, 8, 5, ORANGE, 12));
        roads.add(new Road(4, 8, 5, WHITE, 13));
        roads.add(new Road(5, 7, 2, GRAY, 14));
        roads.add(new Road(5, 9, 3, GRAY, 15));
        roads.add(new Road(5, 13, 6, DARKBLUE, 16));
        roads.add(new Road(6, 10, 4, GRAY, 17));
        roads.add(new Road(6, 14, 6, WHITE, 18));
        roads.add(new Road(7, 8, 3, ORANGE, 19));
        roads.add(new Road(8, 10, 3, PINK, 20));
        roads.add(new Road(8, 11, 3, YELLOW, 21));
        roads.add(new Road(8, 11, 3, RED, 22));
        roads.add(new Road(9, 11, 5, WHITE, 23));
        roads.add(new Road(9, 12, 3, GRAY, 24));
        roads.add(new Road(9, 13, 3, GRAY, 25));
        roads.add(new Road(10, 11, 4, GREEN, 26));
        roads.add(new Road(10, 14, 4, BLUE, 27));
        roads.add(new Road(10, 15, 6, ORANGE, 28));
        roads.add(new Road(10, 16, 5, RED, 29));
        roads.add(new Road(11, 12, 2, GRAY, 30));
        roads.add(new Road(11, 16, 4, PINK, 31));
        roads.add(new Road(11, 17, 4, DARKBLUE, 32));
        roads.add(new Road(11, 17, 4, ORANGE, 33));
        roads.add(new Road(11, 18, 4, RED, 34));
        roads.add(new Road(12, 13, 2, GRAY, 35));
        roads.add(new Road(12, 18, 3, BLUE, 36));
        roads.add(new Road(13, 18, 5, YELLOW, 37));
        roads.add(new Road(13, 19, 4, RED, 38));
        roads.add(new Road(13, 20, 6, GREEN, 39));
        roads.add(new Road(14, 15, 4, DARKBLUE, 40));
        roads.add(new Road(14, 21, 6, GRAY, 41));
        roads.add(new Road(15, 16, 1, GRAY, 42)); //adjust 160118
        roads.add(new Road(15, 16, 1, GRAY, 43)); //adjust 160118
        roads.add(new Road(15, 21, 5, GRAY, 44)); //adjust 160118-2
        roads.add(new Road(15, 22, 3, RED, 45));
        roads.add(new Road(15, 27, 6, PINK, 46));
        roads.add(new Road(16, 17, 1, GRAY, 47));
        roads.add(new Road(16, 17, 1, GRAY, 48));
        roads.add(new Road(16, 22, 4, BLUE, 49));
        roads.add(new Road(17, 18, 1, GRAY, 50)); //adjust 160118
        roads.add(new Road(17, 18, 1, GRAY, 51)); //adjust 160118
        roads.add(new Road(17, 23, 2, BLUE, 52));
        roads.add(new Road(17, 23, 2, PINK, 53));
        roads.add(new Road(18, 19, 1, GRAY, 54)); //adjust 160118
        roads.add(new Road(18, 19, 1, GRAY, 55)); //adjust 160118
        roads.add(new Road(18, 24, 2, GRAY, 56));
        roads.add(new Road(19, 20, 2, GRAY, 57)); //adjust 160118
        roads.add(new Road(19, 20, 2, GRAY, 58)); //adjust 160118
        roads.add(new Road(19, 24, 2, GRAY, 59));
        roads.add(new Road(20, 25, 2, GRAY, 60));
        roads.add(new Road(21, 27, 2, GRAY, 61));
        roads.add(new Road(21, 31, 5, DARKBLUE, 62));
        roads.add(new Road(22, 23, 2, WHITE, 63));
        roads.add(new Road(22, 23, 2, GREEN, 64));
        roads.add(new Road(22, 27, 4, WHITE, 65));
        roads.add(new Road(22, 28, 3, ORANGE, 66));
        roads.add(new Road(22, 28, 3, DARKBLUE, 67));
        roads.add(new Road(23, 24, 1, GRAY, 68)); //adjust 160118-3
        roads.add(new Road(23, 26, 3, GRAY, 69)); //adjust 160118-3
        roads.add(new Road(23, 28, 5, GREEN, 70));
        roads.add(new Road(24, 25, 3, GREEN, 71));
        roads.add(new Road(24, 26, 3, WHITE, 72));
        roads.add(new Road(25, 30, 4, YELLOW, 73));
        roads.add(new Road(25, 30, 4, ORANGE, 74));
        roads.add(new Road(25, 36, 6, RED, 75));
        roads.add(new Road(26, 28, 4, YELLOW, 76));
        roads.add(new Road(26, 29, 3, DARKBLUE, 77));
        roads.add(new Road(26, 30, 1, GRAY, 78));
        roads.add(new Road(27, 31, 3, ORANGE, 79)); //adjust 160118-4
        roads.add(new Road(27, 28, 2, GRAY, 80));
        roads.add(new Road(28, 29, 2, GRAY, 81));
        roads.add(new Road(28, 33, 2, WHITE, 82));
        roads.add(new Road(28, 33, 2, GREEN, 83));
        roads.add(new Road(28, 34, 2, GRAY, 84));
        roads.add(new Road(29, 30, 2, GRAY, 85));
        roads.add(new Road(29, 30, 2, GRAY, 86));
        roads.add(new Road(29, 34, 2, GRAY, 87));
        roads.add(new Road(29, 34, 2, GRAY, 88));
        roads.add(new Road(29, 35, 2, GRAY, 89));
        roads.add(new Road(30, 35, 2, GRAY, 90));
        roads.add(new Road(30, 36, 5, BLUE, 91));
        roads.add(new Road(31, 32, 2, GRAY, 92));
        roads.add(new Road(31, 32, 2, GRAY, 93));
        roads.add(new Road(31, 33, 3, BLUE, 94));
        roads.add(new Road(32, 33, 2, YELLOW, 95));
        roads.add(new Road(32, 33, 2, RED, 96));
        roads.add(new Road(33, 34, 2, ORANGE, 97));
        roads.add(new Road(33, 34, 2, DARKBLUE, 98));
        roads.add(new Road(35, 36, 4, PINK, 99));
    }
    public Road get(int i){
        return roads.get(i);
    }
    public void setChoosed(int i){
        roads.get(i).setChoosed();
    }
}
