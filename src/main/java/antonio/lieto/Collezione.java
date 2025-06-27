package antonio.lieto;

import javax.sound.midi.Soundbank;
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

    public List<Giochi> cercaPrezzo(int prezzoMax){
        List<Giochi> ritornoDelPrezzo = new ArrayList<>();
        for (int i = 0; i <giochi.size(); i++) {
            if(giochi.get(i).getPrezzo() < prezzoMax) {
                ritornoDelPrezzo.add(giochi.get(i));
            }
        }
        return ritornoDelPrezzo;
    }
}
