
package Outros;

public class FerramentaEletrica extends Produto {
    private int voltagem;

    public FerramentaEletrica(int id, String nome, double preco, int estoque, int voltagem) {
        super(id, nome, preco, estoque);
        this.voltagem = voltagem;
    }

    public int getVoltagem() {
        return voltagem;
    }

    public void setVoltagem(int voltagem) {
        this.voltagem = voltagem;
    }
}
