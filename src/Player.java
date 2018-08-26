import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Player implements Comparable<Player> {

    private String firstName;
    private String lastName;
    private String score;


    public Player(String firstName, String lastName, String score) {
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

    public String getScore() {
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

            return o1.getScore().compareTo(o2.getScore());
        }
    }
}
