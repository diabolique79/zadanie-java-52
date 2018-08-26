
import java.io.*;
import java.util.*;

public class Main {

    public static final String NAME = "Imię";
    public static final String LASTNAME = "Nazwisko";
    public static final String SCORE = "wynik";

    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(System.in);
        ArrayList<Player> list = new ArrayList<>();
        wczytajDane(sc, list);
        sortMethod(sc, list);
        fileWriter(list);

    }

    public static void wczytajDane(Scanner sc, ArrayList<Player> list) {

        Scanner scan = new Scanner(System.in);
        String firstName = "";
        String lastName = "";
        int score;
        boolean end = false;
        int z = 0;

        do {


            System.out.println("Wprowadź imię lub stop: /Stop zakończy działanie programu/ ");
            firstName = scan.nextLine();

            if (firstName.equalsIgnoreCase("stop")) {

                end = true;
            } else {
                System.out.println("Wprowadź nazwisko: ");
                lastName = scan.nextLine();

                System.out.println("Wprowadź wynik: ");
                score = scan.nextInt();
                scan.nextLine();
                list.add(new Player(firstName, lastName, score));
                z++;


            }

        } while (!end);

    }

    public static void sortMethod(Scanner sc, ArrayList<Player> list) {

        System.out.println("Wybierz metodę sortowania: /Wpisz Imię lub Nazwisko lub Wynik/");
        String name = sc.nextLine();

        if (name.equalsIgnoreCase(Main.NAME)) {

            Collections.sort(list, new Player.PlayerNameComparator());
            printData(list);
        }
        if (name.equalsIgnoreCase(Main.LASTNAME)) {

            Collections.sort(list, new Player.PlayerLastNameComparator());
            printData(list);
        }
        if (name.equalsIgnoreCase(Main.SCORE)) {

            Collections.sort(list, new Player.PlayerScoreComparator());
            printData(list);
        }

    }

    public static void printData(ArrayList<Player> list) {

        for (Player player : list) {
            System.out.println(player.getFirstName() + " " + player.getLastName() + " " + player.getScore());

        }

    }

    public static void fileWriter(ArrayList<Player> list){

        String fileName = "testFile.txt";
        try{
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);

            for (Player player : list) {
                bw.write(player.getFirstName()+ " " + player.getLastName() +" " + player.getScore() + "\n");
            }
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Zapisano do pliku.");
    }


}




