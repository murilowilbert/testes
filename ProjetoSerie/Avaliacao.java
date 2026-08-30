package ProjetoSerie;

public class Avaliacao {
    private int nota;
    private String critica;
    private Serie serie;

    public Avaliacao(int nota, String critica) {
        this.nota = nota;
        this.critica = critica;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public void setCritica(String critica) {
        this.critica = critica;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public int getNota() {
        return nota;
    }

    public String getCritica() {
        return critica;
    }

    public Serie serie() {
        return serie;
    }
}
