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
        for (Giochi p : giochi) {
            if(p.getId() == gioco.getId()) {
                System.out.println("gioco con ID: " + gioco.getId());
                return false;
            }
        }
        giochi.add(gioco);
        return true;
    }
}
