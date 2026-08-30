package Exemplo;

public class Serie {

    private String titulo;
    private Temporada[] temporadas = new Temporada[10];
    private int total;

    public Serie(String titulo) {
        this.titulo = titulo;
    }

    public void adicionarTemporada(Temporada temporada) {
        temporadas[total++] = temporada;
    }

    public void exibir() {
        System.out.println(titulo + ":");
        for (int i = 0; i < total; i++) {
            System.out.println("  " + temporadas[i]);
        }
    }
}