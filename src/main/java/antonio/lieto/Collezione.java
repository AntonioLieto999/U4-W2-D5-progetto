package antonio.lieto;


import java.util.ArrayList;
import java.util.List;

public class Collezione {
    public List<Giochi> giochi;

    public Collezione() {
        giochi = new ArrayList<>();
    }

    public boolean addGioco(Giochi gioco) {
        for (int i =0; i < giochi.size();i++) {
            if(giochi.get(i).getId() == gioco.getId()) {
                System.out.println("gioco con ID: " + gioco.getId());
                return false;
            }
        }
        giochi.add(gioco);
        return true;
    }

    public Giochi cercaId(int id) {
        for(int i = 0; i < giochi.size();i++){
            if(giochi.get(i).getId() == id){
                return giochi.get(i);
            }
        }
        return null;
    }

    public List<Giochi> cercaPrezzo(int prezzoMax) {
        return giochi.stream()
                .filter(g -> g.getPrezzo() < prezzoMax)
                .toList();
    }

    public List<Giochidatavolo> ricercaPerNumeroDiGiocatori(int num) {
        return giochi.stream()
                .filter(g -> g instanceof Giochidatavolo)
                .map(g -> (Giochidatavolo) g)
                .filter(gdt -> gdt.getNumeroGiocatori() == num)
                .toList();
    }

    public void stampaIGiochi() {
        for (int i = 0; i < giochi.size(); i++) {
            System.out.println(giochi.get(i));
        }
    }

    public boolean rimuoviGioco (int id) {
        for (int i = 0; i <giochi.size(); i++) {
            if (giochi.get(i).getId() == id){
                giochi.remove(i);
                System.out.println("gioco con ID " + id + " rimosso");
                return true;
            }
        }
        System.out.println("gioco " + id + " non trovato");
        return false;
    }

    public boolean aggiornaGioco(int id, Giochi nuovoGioco) {
        for (int i = 0; i< giochi.size(); i++) {
            if (giochi.get(i).getId() == id) {
                if (giochi.get(i).getId() != id) {
                    System.out.println("l'ID deve essere lo stesso");
                    return false;
                }
                giochi.set(i, nuovoGioco);
                System.out.println("gioco con ID " + id + "aggiornato");
                return true;
            }
        }
        System.out.println("gioco con ID" + id + "non trovato");
        return false;
    }
}
