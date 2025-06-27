package antonio.lieto;

public class Giochidatavolo extends Giochi{
    public int numeroGiocatori;
    public int durataMedia;


    public Giochidatavolo(int id, String titolo, int anno, int prezzo, int numeroGiocatori, int durataMedia) throws IllegalAccessException {
        super(id, titolo, anno, prezzo);

        if(numeroGiocatori < 2 || numeroGiocatori >10){
            throw new IllegalAccessException("i giocatori devono essere almeno 2 e massimo 10");
        }

        this.numeroGiocatori = numeroGiocatori;
        this.durataMedia = durataMedia;
    }

        public int getNumeroGiocatori() {
            return numeroGiocatori;
        }

        public void setNumeroGiocatori(int numeroGiocatori) {
            this.numeroGiocatori = numeroGiocatori;
        }

        public int getDurataMedia() {
            return durataMedia;
        }

        public void setDurataMedia(int durataMedia) {
            this.durataMedia = durataMedia;
        }

    @Override
    public String toString() {
        return "Giochidatavolo{" +
                "numeroGiocatori=" + numeroGiocatori +
                ", durataMedia=" + durataMedia +
                '}';
    }
}
