package Outros;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Teste_HashMap {

    public static int lerNumero(Scanner scanner, String mensagem, String mensagemErro) {
        while (true) {
            System.out.print(mensagem);
            if (scanner.hasNextInt()) {
                int valor = Integer.parseInt(scanner.nextLine());
                return valor;
            } else {
                System.out.println(mensagemErro);
                scanner.nextLine();
            }
        }
    }

    public static double lerDouble(Scanner scanner, String mensagem, String mensagemErro) {
        while (true) {
            System.out.print(mensagem);
            try {
                String valor = scanner.nextLine().trim().replace(",", ".");
                return Double.parseDouble(valor);
            } catch (NumberFormatException e) {
                System.out.println(mensagemErro);
            }
        }
    }

    public static void main(String[] args) {
        Map<Integer, Produto> listaPorId = new HashMap<>();
        int escolha;
        int id;
        String nome;
        double preco;
        int estoque;
        int voltagem;
        int quantidade;

        Scanner scanner = new Scanner(System.in);
        listaPorId.put(101, new FerramentaEletrica(101, "Parafusadeira", 100.0, 10, 12));
        listaPorId.put(102, new FerramentaEletrica(102, "Furadeira", 100.0, 10, 12));
        listaPorId.put(103, new FerramentaEletrica(103, "Serra tico-tico", 100.0, 10, 12));
        listaPorId.put(104, new FerramentaEletrica(104, "Lixadeira", 100.0, 10, 12));

        while (true) {
            System.out.println("1 - Novo Produto");
            System.out.println("2 - Vender Produto");
            System.out.println("3 - Excluir Produto");
            System.out.println("4 - Consultar Produtos");
            System.out.println("0 - Sair");

            escolha = lerNumero(scanner, "Escolha uma opção: ", "Opção Inválida! Digite um número inteiro.");

            switch (escolha) {
                case 1: {
                    System.out.print("Nome: ");
                    nome = scanner.nextLine();
                    while (true) {
                        id = lerNumero(scanner, "ID (Apenas números): ", "ID Inválido! Digite APENAS números");
                        if (listaPorId.containsKey(id)) {
                            System.out.printf("Já existe um produto cadastrado com o ID: %d. Tente novamente.\n", id);
                        } else {
                            break;
                        }
                    }
                    preco = lerDouble(scanner, "Preço: ", "Preço Inválido! Digite um valor válido");
                    estoque = lerNumero(scanner, "Estoque: ", "Estoque Inválido! Digite apenas números");
                    voltagem = lerNumero(scanner, "Voltagem: ", "Voltagem Inválida! Digite apenas números");
                    listaPorId.put(id, new FerramentaEletrica(id, nome, preco, estoque, voltagem));
                    System.out.println("Produto cadastrado com sucesso!");
                    System.out.println("=================================");
                    break;
                }

                case 2: {
                    if (!listaPorId.isEmpty()) {
                        for (Produto produto : listaPorId.values()) {
                            System.out.println(produto.getId() + " - Nome: " + produto.getNome() + " | Estoque ATUAL: "
                                    + produto.getEstoque());
                        }
                        escolha = lerNumero(scanner, "Qual produto deseja vender (ID): ",
                                "Opção Inválida! Digite um número inteiro.");
                        quantidade = lerNumero(scanner, "Quantidade: ",
                                "Quantidade Inválida! Digite um número inteiro.");

                        Produto produto = listaPorId.get(escolha);
                        if (produto != null) {
                            if (produto.getEstoque() < quantidade) {
                                System.out.println("Estoque insuficiente!");
                            } else {
                                produto.setEstoque(produto.getEstoque() - quantidade);
                                System.out.println("Produto vendido com sucesso!");
                            }
                        } else {
                            System.out.println("Nenhum produto cadastrado com o ID: " + escolha);
                        }
                        System.out.println("=================================");
                        break;
                    } else {
                        System.out.println("Nenhum produto cadastrado!");
                    }
                    System.out.println("=================================");
                    break;
                }

                case 3: {
                    if (!listaPorId.isEmpty()) {
                        for (Produto produto : listaPorId.values()) {
                            System.out.println(produto.getId() + " - Nome: " + produto.getNome() + " | Estoque ATUAL: "
                                    + produto.getEstoque());
                        }
                        escolha = lerNumero(scanner, "Qual produto deseja excluir (ID): ",
                                "Opção Inválida! Digite um número inteiro.");

                        if (listaPorId.containsKey(escolha)) {
                            listaPorId.remove(escolha);
                            System.out.println("Produto excluído com sucesso!");
                        } else {
                            System.out.println("Nenhum produto cadastrado com o ID: " + escolha);
                        }
                        System.out.println("=================================");
                        break;
                    } else {
                        System.out.println("Nenhum produto cadastrado!");
                        System.out.println("=================================");
                    }
                    break;
                }

                case 4: {
                    if (!listaPorId.isEmpty()) {
                        for (Produto produto : listaPorId.values()) {
                            System.out.println(produto.getId() + " - Nome: " + produto.getNome());
                        }
                        System.out.println("=================================");
                        break;
                    } else {
                        System.out.println("Nenhum produto cadastrado!");
                    }
                    break;
                }

                case 0: {
                    System.out.println("Saindo do sistema...");
                    scanner.close();
                    return;
                }

                default: {
                    System.out.println("Opção Inválida! Escolha uma opção do menu.");
                    System.out.println("=================================");
                    break;
                }
            }
        }
    }
}
