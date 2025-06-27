package antonio.lieto;

import antonio.lieto.entities.Generi;

public class Videogiochi extends Giochi {
    public String piattaforma;
    public double durata;
    public Generi genere;

    public Videogiochi(int id,String titolo,int anno,int prezzo,String piattaforma,double durata,Generi genere){
        super(id, titolo, anno, prezzo);
        this.piattaforma = piattaforma;
        this.durata = durata;
        this.genere = genere;
    }

    public String getPiattaforma() {
        return piattaforma;
    }

    public void setPiattaforma(String piattaforma) {
        this.piattaforma = piattaforma;
    }

    public double getDurata() {
        return durata;
    }

    public void setDurata(double durata) {
        this.durata = durata;
    }

    public Generi getGenere() {
        return genere;
    }

    public void setGenere(Generi genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Videogiochi{" +
                "piattaforma='" + piattaforma + '\'' +
                ", durata=" + durata +
                ", genere=" + genere +
                '}';
    }
}
