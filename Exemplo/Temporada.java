package Exemplo;

public class Temporada {

    private int numero;
    private int episodios;

    public Temporada(int numero, int episodios) {
        this.numero = numero;
        this.episodios = episodios;
    }

    public String toString() {
        return "Temporada " + numero + " - " + episodios + " episódios";
    }
}
