package antonio.lieto;

import antonio.lieto.entities.Generi;
import com.github.javafaker.Faker;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Collezione collezione = new Collezione();

        collezione.addGioco(new Videogiochi(1111, "Elden Ring", 2022, 60, "PC", 80, Generi.RPG));
        collezione.addGioco(new Videogiochi(2222, "Street Fighter", 2023, 70, "PS5", 12, Generi.PICCHIADURO));
        collezione.addGioco(new Videogiochi(3333, "League of Legends", 2009, 0, "PC", 999, Generi.MOBA));
        collezione.addGioco(new Videogiochi(4444, "Hollow Knight(il mio gioco preferito)", 2017, 15, "Switch", 30, Generi.METROIDVANIA));
        collezione.addGioco(new Videogiochi(5555, "World of Warcraft", 2004, 20, "PC", 300, Generi.MMORPG));

        try {
            collezione.addGioco(new Giochidatavolo(1616, "Cluedo", 1949, 30, 6, 45));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        try {
            collezione.addGioco(new Giochidatavolo(1717, "UNO", 1971, 10, 4, 20));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        try {
            collezione.addGioco(new Giochidatavolo(1818, "Gioco dell'Oca", 1500, 15, 4, 30));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        try {
            collezione.addGioco(new Giochidatavolo(1919, "Risiko", 1957, 35, 6, 120));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        try {
            collezione.addGioco(new Giochidatavolo(2020, "Tavola Ouija", 1890, 25, 2, 20));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

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
                    System.out.println("id da aggiornare: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    Giochi g = collezione.cercaId(id);
                    if(g == null){
                        System.out.println("gioco non trovato");
                    }else {
                        System.out.println("nuovo titolo: ");
                        String titolo = scanner.nextLine();
                        System.out.println("nuovo anno: ");
                        int anno = scanner.nextInt();
                        System.out.println("nuovo prezzo: ");
                        int prezzo = scanner.nextInt();
                        scanner.nextLine();

                        if (g instanceof Videogiochi) {
                            System.out.println("nuova piattaforma: ");
                            String piattaforma = scanner.nextLine();
                            System.out.println("nuova durata: ");
                            double durata = scanner.nextDouble();
                            scanner.nextLine();
                            System.out.println("nuovo genere: ");
                            String gen = scanner.nextLine();
                            try {
                                Generi genere = Generi.valueOf(gen);
                                Videogiochi nuovoVG = new Videogiochi(id, titolo, anno, prezzo, piattaforma, durata, genere);
                                collezione.aggiornaGioco(id,nuovoVG);
                            } catch (IllegalArgumentException e) {
                                System.out.println("genere non valito");
                            }
                        } else if (g instanceof Giochidatavolo) {
                            System.out.println("nuovo numero di giocatori: ");
                            int num = scanner.nextInt();
                            System.out.println("nuova durata media: ");
                            int durata = scanner.nextInt();
                            Giochidatavolo nuovoGDT = null;
                            try {
                                nuovoGDT = new Giochidatavolo(id, titolo, anno, prezzo, num, durata);
                            } catch (IllegalAccessException e) {
                                throw new RuntimeException(e);
                            }
                            collezione.aggiornaGioco(id,nuovoGDT);
                        }
                    }
                }
                case 4 -> {
                    System.out.println("ID da cercare: ");
                    int id = scanner.nextInt();
                    Giochi trovato = collezione.cercaId(id);
                    if (trovato != null){
                        System.out.println(trovato);
                    }else {
                        System.out.println("gioco non trovato");
                    }
                }
                case 5 -> {
                    System.out.println("prezzo massimo: ");
                    int prezzo = scanner.nextInt();
                    List<Giochi> risultati = collezione.cercaPrezzo(prezzo);
                    risultati.forEach(System.out::println);
                }
                case 6 -> {
                    System.out.println("numero di giocatori: ");
                    int num = scanner.nextInt();
                    List<Giochidatavolo> risultati = collezione.ricercaPerNumeroDiGiocatori(num);
                    risultati.forEach(System.out::println);
                }
                case 7 -> collezione.stampaIGiochi();

                case 0 -> {
                    System.out.println("uscita dal programma.");
                    scanner.close();
                }
                default -> System.out.println("scelta non valida");
            }
        }
    }
}
