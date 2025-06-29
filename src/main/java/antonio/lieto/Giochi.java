package antonio.lieto;

public abstract class Giochi {
    protected int id;
    protected String titolo;
    protected int anno;
    protected int prezzo;

    public Giochi (int id,String titolo, int anno,int prezzo){
        this.id = id;
        this.titolo = titolo;
        this.anno = anno;
        this.prezzo = prezzo;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public int getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }

    @Override
    public String toString() {
        return "Giochi{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", anno=" + anno +
                ", prezzo=" + prezzo +
                '}';
    }
}
