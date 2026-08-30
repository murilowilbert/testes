package ProjetoSerie;

public class Serie {
    private String titulo;
    private String sinopse;
    private int anoLancamento;
    private Avaliacao avaliacao;

    public Serie() {
    }

    public Serie(String titulo, String sinopse, int anoLancamento, Avaliacao avaliacao) {
        this.titulo = titulo;
        this.sinopse = sinopse;
        this.anoLancamento = anoLancamento;
        this.avaliacao = avaliacao;
        if (this.avaliacao != null) {
            this.avaliacao.setSerie(this);
        }
    }

    public Serie(String titulo, String sinopse, int anoLancamento, int nota, String critica) {
        this.titulo = titulo;
        this.sinopse = sinopse;
        this.anoLancamento = anoLancamento;
        this.avaliacao = new Avaliacao(nota, critica);
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getSinopse() {
        return sinopse;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void exibirInfo() {
        System.out.println("===========================");
        System.out.println("Nome: " + titulo);
        System.out.println("Sinopse: " + sinopse);
        System.out.println("Ano de lançamento: " + anoLancamento);
        if (avaliacao != null) {
            System.out.println("Avaliação: " + avaliacao.getNota());
            System.out.println("Crítica: " + avaliacao.getCritica());
        } else {
            System.out.println("Avaliação: Sem avaliação cadastrada.");
        }
        System.out.println("===========================");
    }
}
