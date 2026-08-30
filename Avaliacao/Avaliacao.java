package Avaliacao;

public class Avaliacao {
    private int nota;
    private String critica;

    public Avaliacao() {
    }

    public Avaliacao(int nota, String critica) {
        this.nota = nota;
        this.critica = critica;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getCritica() {
        return critica;
    }

    public void setCritica(String critica) {
        this.critica = critica;
    }

    public String getNotaEmAsteriscos() {
        return "*".repeat(Math.max(0, nota));
    }
}
