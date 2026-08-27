import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Produto {
    private int id;
    private String nome;
    private double preco;
    private int estoque;

    public Produto(int id, String nome, double preco, int estoque) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public static void main(String[] args) {
        int escolha;
        int id;
        String nome;
        double preco;
        int estoque;
        int voltagem;
        int quantidade;

        ArrayList<Produto> listaProdutos = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        FerramentaEletrica novoProduto = new FerramentaEletrica(101, "Parafusadeira", 100.0, 10, 12);
        listaProdutos.add(novoProduto);
        novoProduto = new FerramentaEletrica(102, "Furadeira", 100.0, 10, 12);
        listaProdutos.add(novoProduto);
        novoProduto = new FerramentaEletrica(103, "Serra tico-tico", 100.0, 10, 12);
        listaProdutos.add(novoProduto);
        novoProduto = new FerramentaEletrica(104, "Lixadeira", 100.0, 10, 12);
        listaProdutos.add(novoProduto);

        while (true) {
            System.out.println("1 - Novo Produto");
            System.out.println("2 - Vender Produto");
            System.out.println("3 - Excluir Produto");
            System.out.println("4 - Consultar Produtos");

            while (true) {
                System.out.print("Escolha uma opção: ");
                if (scanner.hasNextInt()) {
                    escolha = Integer.parseInt(scanner.nextLine());
                    break;
                } else {
                    System.out.println("Opção Inválida! Digite um número inteiro.");
                    scanner.nextLine();
                }
            }

            switch (escolha) {
                case 1: {
                    System.out.print("Nome: ");
                    nome = scanner.nextLine();

                    System.out.print("ID: ");
                    while (true) {
                        System.out.print("ID (Apenas números): ");
                        if (scanner.hasNextInt()) {
                            id = Integer.parseInt(scanner.nextLine());
                            break;
                        } else {
                            System.out.println("ID Inválido! Digite APENAS números");
                            scanner.nextLine();
                        }
                    }

                    System.out.print("Preço: ");
                    while (true) {
                        System.out.print("Preço: ");
                        if (scanner.hasNextInt()) {
                            preco = Double.parseDouble(scanner.nextLine());
                            break;
                        } else {
                            System.out.println("Preço Inválido! Digite um valor válido");
                            scanner.nextLine();
                        }
                    }

                    System.out.print("Estoque: ");
                    while (true) {
                        System.out.print("Preço: ");
                        if (scanner.hasNextInt()) {
                            estoque = Integer.parseInt(scanner.nextLine());
                            break;
                        } else {
                            System.out.println("Estoque Inválido! Digite apenas números");
                            scanner.nextLine();
                        }
                    }

                    System.out.println("Voltagem: ");
                    while (true) {
                        System.out.print("Preço: ");
                        if (scanner.hasNextInt()) {
                            voltagem = Integer.parseInt(scanner.nextLine());
                            break;
                        } else {
                            System.out.println("Voltagem Inválida! Digite apenas números");
                            scanner.nextLine();
                        }
                    }

                    novoProduto = new FerramentaEletrica(id, nome, preco, estoque, voltagem);
                    listaProdutos.add(novoProduto);
                    System.out.println("Produto cadastrado com sucesso!");
                    System.out.println("=================================");
                    break;
                }

                case 2: {
                    for (Produto produto : listaProdutos) {
                        System.out.println(produto.getId() + " - Nome: " + produto.getNome() + " | Estoque ATUAL: "
                                + produto.getEstoque());
                    }
                    while (true) {
                        System.out.print("Qual produto deseja vender (ID): ");
                        if (scanner.hasNextInt()) {
                            escolha = Integer.parseInt(scanner.nextLine());
                            break;
                        } else {
                            System.out.println("Opção Inválida! Digite um número inteiro.");
                            scanner.nextLine();
                        }
                    }
                    while (true) {
                        System.out.print("Quantidade: ");
                        if (scanner.hasNextInt()) {
                            quantidade = Integer.parseInt(scanner.nextLine());
                            break;
                        } else {
                            System.out.println("Quantidade Inválida! Digite um número inteiro.");
                            scanner.nextLine();
                        }
                    }

                    for (Produto produto : listaProdutos) {
                        if (escolha == produto.getId()) {
                            if (produto.getEstoque() < quantidade) {
                                System.out.println("Estoque insuficiente!");
                                System.out.println("=================================");
                            } else {
                                produto.setEstoque(produto.getEstoque() - quantidade);
                                System.out.println("Produto vendido com sucesso!");
                                System.out.println("=================================");
                            }
                            break;
                        } else {
                            System.out.println("Nenhum produto cadastrado com o ID: " + escolha);
                            System.out.println("=================================");
                        }
                    }
                    break;
                }

                case 3: {
                    for (Produto produto : listaProdutos) {
                        System.out.println(produto.getId() + " - Nome: " + produto.getNome() + " | Estoque ATUAL: "
                                + produto.getEstoque());
                    }
                    while (true) {
                        System.out.print("Qual produto deseja excluir (ID): ");
                        if (scanner.hasNextInt()) {
                            escolha = Integer.parseInt(scanner.nextLine());
                            break;
                        } else {
                            System.out.println("Opção Inválida! Digite um número inteiro.");
                            scanner.nextLine();
                        }
                    }

                    for (Produto produto : listaProdutos) {
                        if (escolha == produto.getId()) {
                            listaProdutos.remove(produto);
                            System.out.println("Produto excluído com sucesso!");
                            System.out.println("=================================");
                            break;
                        } else {
                            System.out.println("Nenhum produto cadastrado com o ID: " + escolha);
                            System.out.println("=================================");
                        }
                    }
                    break;
                }

                case 4: {
                    for (Produto produto : listaProdutos) {
                        System.out.println(produto.getId() + " - Nome: " + produto.getNome());
                    }
                    System.out.println("=================================");
                    break;
                }
            }
            scanner.close();

        }
    }
}
