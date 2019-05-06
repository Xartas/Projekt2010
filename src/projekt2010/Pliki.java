package projekt2010;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pliki {

    public static void wczytajDane() {

        // --- Wczytanie do listy dostawców ---
        List<Dostawca> listaDostawcow = new ArrayList<>();
        File plikDane = new File("dostawcy.csv");
        try{
            Scanner skaner = new Scanner(plikDane);
            while (skaner.hasNextLine()){
                String bufor = skaner.nextLine();
                String[] buforTable = bufor.split(";");
                String dostawcaNazwa = buforTable[0];
                String dostawcaMiejscowosc = buforTable[1];
                String dostawcaUlica = buforTable[2];
                String dostawcaNrKlienta = buforTable[3];
                Dostawca nowyDostawca = new Dostawca(dostawcaNazwa, dostawcaMiejscowosc, dostawcaUlica, dostawcaNrKlienta);
                listaDostawcow.add(nowyDostawca);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Brak pliku \"dostawcy.csv\"!");
        }

        for (Dostawca dostawca:listaDostawcow) {
            System.out.printf("'%-36S'", dostawca.getNazwa());
            System.out.printf("'%-36S'", dostawca.getMiejscowosc());
            System.out.printf("'%-36S'", dostawca.getUlica());
            System.out.printf("'%-5S'", dostawca.getNrKlienta());
            System.out.println();
        }
    }
}
