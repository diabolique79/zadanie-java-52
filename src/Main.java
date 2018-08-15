import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("Wprowadź dane pierwszego zawodnika: ");
        Scanner scan = new Scanner(System.in);
        List<Player> players = new ArrayList();
        int z = 0;
        PrintWriter file = new PrintWriter("dane.csv");
        BufferedWriter bw = new BufferedWriter(file);
        String firstName;
        String lastName;
        Integer score = 0;
        String napis = "0";

        try {
            while (!napis.equals("stop")) {

                System.out.println("Wprowadź imię i nazwisko oraz zdobyte punkty: ");
                napis = scan.nextLine();
                String tab[] = napis.split(" ");
                firstName = tab[0];
                lastName = tab[1];
                score = Integer.parseInt(tab[2]);
                System.out.println(tab[0] + " " + tab[1] + " " + tab[2]);
                players.add(new Player(firstName, lastName, score));
                z++;
                for (int i = 0; i < players.size(); i++) {
                    bw.write(firstName + "," + lastName + "," + score);
                    bw.newLine();
                }
                bw.close();

            }
        }catch (ArrayIndexOutOfBoundsException e){

            System.out.println("Niepoprawny parametr. ");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}

