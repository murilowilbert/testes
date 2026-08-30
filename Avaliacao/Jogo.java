package Avaliacao;

public class Jogo {
    private String titulo;
    private String descricao;
    private int anoLancamento;
    private Avaliacao avaliacao;

    public Jogo() {
    }

    public Jogo(String titulo, String descricao, int anoLancamento) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.anoLancamento = anoLancamento;
    }

    public Jogo(String titulo, String descricao, int anoLancamento, Avaliacao avaliacao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.anoLancamento = anoLancamento;
        this.avaliacao = avaliacao;
    }

    public Jogo(String titulo, String descricao, int anoLancamento, int nota, String critica) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.anoLancamento = anoLancamento;
        this.avaliacao = new Avaliacao(nota, critica);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public void setAvaliacao(int nota, String critica) {
        if (this.avaliacao == null) {
            this.avaliacao = new Avaliacao(nota, critica);
        } else {
            this.avaliacao.setNota(nota);
            this.avaliacao.setCritica(critica);
        }
    }

    public void exibirInfo() {
        System.out.println("--------------------------------------------------");
        System.out.println("Titulo: " + titulo);
        System.out.println("Descrição: " + descricao);
        if (avaliacao != null) {
            System.out.println(anoLancamento + " - Nota: " + avaliacao.getNotaEmAsteriscos());
            System.out.println("Crítica:\n" + avaliacao.getCritica());
        } else {
            System.out.println(anoLancamento + " - Sem avaliação cadastrada.");
        }
        System.out.println("--------------------------------------------------");
    }
}
