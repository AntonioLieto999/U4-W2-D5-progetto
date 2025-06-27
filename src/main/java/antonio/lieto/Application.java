package antonio.lieto;

import antonio.lieto.entities.Generi;
import com.github.javafaker.Faker;

import java.util.Arrays;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Collezione collezione = new Collezione();

        while(true) {
            System.out.println("----Menu----");
            System.out.println("1.aggiungi gioco");
            System.out.println("2.rimuovi gioco per ID");
            System.out.println("3.aggiorna gioco per ID");
            System.out.println("4.cerca per ID");
            System.out.println("5.cerca giochi per prezzo");
            System.out.println("6.cerca giochi da tavolo");
            System.out.println("7.visualizza i giochi");
            System.out.println("0.Esci");
            System.out.print("scelta: ");

            int scelta = scanner.nextInt();
            scanner.nextLine();

            switch (scelta) {
                case 1 -> {
                    System.out.println("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("titolo: ");
                    String titolo = scanner.nextLine();
                    System.out.println("anno:");
                    int anno = scanner.nextInt();
                    System.out.println("prezzo: ");
                    int prezzo = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("tipo di gioco(1. videogioco 2.gioco da tavolo");
                    int tipo = scanner.nextInt();
                    scanner.nextLine();

                    if(tipo == 1) {
                        System.out.println("piattaforma: ");
                        String piattaforma = scanner.nextLine();
                        System.out.println("durata (ore): ");
                        double durata = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.println("Genere (picchiaduro,Rpg,MMO ecc.): ");
                        String gen = scanner.nextLine();
                        try {
                            Generi genere = Generi.valueOf(gen);
                            Videogiochi vg = new Videogiochi(id,titolo,anno,prezzo,piattaforma,durata,genere);
                            collezione.addGioco(vg);
                        }catch (IllegalArgumentException e) {
                            System.out.println("genere non valido");
                        }
                    } else if (tipo == 2) {
                        System.out.println("numero di giocatori (2-10): ");
                        int numGiocatori = scanner.nextInt();
                        System.out.println("durata media (minuti): ");
                        int durata = scanner.nextInt();
                        Giochidatavolo gdt = null;
                        try {
                            gdt = new Giochidatavolo(id, titolo, anno, prezzo, numGiocatori, durata);
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        }
                        collezione.addGioco(gdt);
                    }else  {
                        System.out.println("tipo non valido.");
                    }
                }
                case 2 -> {
                    System.out.println("ID da rimuovere: ");
                    int id = scanner.nextInt();
                    collezione.rimuoviGioco(id);
                }
                case 3 -> {
                    System.out.println();
                }
            }
        }
    }
}
