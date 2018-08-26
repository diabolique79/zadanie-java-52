import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Player implements Comparable<Player> {

    private String firstName;
    private String lastName;
    private int score;


    public Player(String firstName, String lastName, int score) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.score = score;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(Player o) {
        return 0;
    }

    public static class PlayerNameComparator implements Comparator<Player>{

        @Override
        public int compare(Player o1, Player o2) {
            return o1.getFirstName().compareTo(o2.getFirstName());
        }
    }

    public static class PlayerLastNameComparator implements Comparator<Player>{

        @Override
        public int compare(Player o1, Player o2) {
            return o1.getLastName().compareTo(o2.getLastName());
        }
    }

    public static class PlayerScoreComparator implements Comparator<Player>{

        @Override
        public int compare(Player o1, Player o2) {

            if(o2 == null) return -1;
            if(o1.getScore() > o2.getScore()) return 1;
            else if(o1.getScore() < o2.getScore()) return -1;
            else return 0;

        }
    }
}
