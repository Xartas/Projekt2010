package projekt2010;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pliki {

    public static void wczytajDane() {

        // --- Wczytanie do listy dostawców ---
        List<Dostawcy> listaDostawcow = new ArrayList<>();
        File plikDane = new File("dostawcy.csv");
        try{
            Scanner skaner = new Scanner(plikDane);
            while (skaner.hasNextLine()){
                String bufor = skaner.nextLine();
                String[] buforTable = bufor.split(";");
                Dostawcy nowyDostawca = new Dostawcy();
                nowyDostawca.setNazwa(buforTable[0]);
                nowyDostawca.setMiejscowosc(buforTable[1]);
                nowyDostawca.setUlica(buforTable[2]);
                nowyDostawca.setNrKlienta(buforTable[3]);
                listaDostawcow.add(nowyDostawca);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Brak pliku \"dostawcy.csv\"!");
        }

        for (Dostawcy dostawca:listaDostawcow) {
            System.out.printf("'%-36S'", dostawca.getNazwa());
            System.out.printf("'%-36S'", dostawca.getMiejscowosc());
            System.out.printf("'%-36S'", dostawca.getUlica());
            System.out.printf("'%-5S'", dostawca.getNrKlienta());
            System.out.println();
        }
    }
}
