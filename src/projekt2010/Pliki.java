package projekt2010;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Pliki {

    public static void wczytajDane() {

        // --- Wczytanie do listy dostawców ---
        List<String> dostawcy = new ArrayList<String>();
        File plikDane = new File("dostawcy.csv");
        try{
            Scanner skaner = new Scanner(plikDane);
            while (skaner.hasNextLine()){
                String bufor = skaner.nextLine();
                String[] buforTable = bufor.split(";");
                for (String s:buforTable) {
                   dostawcy.add(s);
                }
                dostawcy.add("\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Brak pliku \"dostawcy.csv\"!");
        }

        System.out.print(dostawcy);
    }
}
