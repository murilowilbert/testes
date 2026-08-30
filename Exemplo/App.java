package Exemplo;

public class App {

    public static void main(String[] args) {
        Serie serie = new Serie("Breaking Bad");
        serie.adicionarTemporada(new Temporada(1, 7));
        serie.adicionarTemporada(new Temporada(2, 13));
        serie.exibir();
    }
}
