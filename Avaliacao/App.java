package Avaliacao;

import java.util.Scanner;

public class App {
    public static int lerInt(Scanner scanner, String mensagem, String mensagemErro) {
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

    public static String lerString(Scanner scanner, String mensagem, String mensagemErro) {
        while (true) {
            System.out.print(mensagem);
            String texto = scanner.nextLine().trim();
            if (!texto.isEmpty()) {
                return texto;
            } else {
                System.out.println(mensagemErro);
            }
        }
    }

    public static void main(String[] args) {
        int escolha;
        int nota;
        Scanner scanner = new Scanner(System.in);
        Jogo[] listaJogos = new Jogo[10];
        listaJogos[0] = new Jogo("GTA VI", "Um jogo de mundo aberto.", 2026, 5, "Excelente");

        System.out.println("====================================================");
        System.out.println("    SISTEMA DE GERENCIAMENTO DE JOGOS JOGADOS");
        System.out.println("====================================================");

        while (true) {
            System.out.println("\n1 - Cadastrar novo jogo");
            System.out.println("2 - Listar jogos cadastrados");
            System.out.println("3 - Atualizar cadastro");
            System.out.println("4 - Sair");

            while (true) {
                escolha = lerInt(scanner, "Escolha uma opção: ", "Erro! Digite um número inteiro.");
                if (escolha >= 1 && escolha <= 4) {
                    break;
                } else {
                    System.out.printf("A opção (%d) não existe! Tente novamente.\n", escolha);
                }
            }

            switch (escolha) {
                case 1: {
                    String titulo = lerString(scanner, "Digite o titulo: ", "Erro! Digite um titulo válido.");
                    String descricao = lerString(scanner, "Digite a descrição: ", "Erro! Digite uma descrição válida.");
                    int anoLancamento = lerInt(scanner, "Digite o ano de lançamento: ",
                            "Erro! Digite um número inteiro.");

                    while (true) {
                        nota = lerInt(scanner, "Digite a nota (0 a 5): ", "Erro! Digite um número inteiro.");
                        if (nota >= 0 && nota <= 5) {
                            break;
                        } else {
                            System.out.println("Nota inválida! Digite uma nota entre 0 à 5.");
                        }
                    }

                    String critica = lerString(scanner, "Digite a crítica: ", "Erro! Digite uma crítica válida.");

                    boolean cadastrado = false;
                    for (int i = 0; i < listaJogos.length; i++) {
                        if (listaJogos[i] == null) {
                            listaJogos[i] = new Jogo(titulo, descricao, anoLancamento, nota, critica);
                            cadastrado = true;
                            System.out.println("\nJogo cadastrado com sucesso!");
                            break;
                        }
                    }

                    if (!cadastrado) {
                        System.out.println("\nLimite de jogos atingido! Não é possível cadastrar mais jogos.");
                    }
                    break;
                }

                case 2: {
                    System.out.println("\n--- JOGOS CADASTRADOS ---");
                    boolean temJogos = false;
                    for (Jogo jogo : listaJogos) {
                        if (jogo != null) {
                            jogo.exibirInfo();
                            temJogos = true;
                        }
                    }
                    if (!temJogos) {
                        System.out.println("Nenhum jogo cadastrado.");
                    }
                    break;
                }

                case 3: {
                    boolean temJogos = false;
                    for (int i = 0; i < listaJogos.length; i++) {
                        if (listaJogos[i] != null) {
                            System.out.printf("\n%d - %s", i + 1, listaJogos[i].getTitulo());
                            temJogos = true;
                        }
                    }
                    System.out.println();
                    if (!temJogos) {
                        System.out.println("Nenhum jogo cadastrado!");
                        break;
                    }
                    while (true) {
                        escolha = lerInt(scanner, "Qual cadastro deseja alterar (índice): ",
                                "Erro! Digite um número inteiro.");
                        escolha--;
                        if (escolha >= 0 && escolha < listaJogos.length && listaJogos[escolha] != null) {
                            System.out.println("Título: " + listaJogos[escolha].getTitulo());
                            String titulo = lerString(scanner, "Atualizar (digite '-1' para manter): ",
                                    "Erro! Digite um titulo válido.");
                            System.out.println("=======================");
                            System.out.println("Descrição: " + listaJogos[escolha].getDescricao());
                            String descricao = lerString(scanner, "Atualizar (digite '-1' para manter): ",
                                    "Erro! Digite uma descrição válida.");
                            System.out.println("=======================");
                            System.out.println("Ano de lançamento: " + listaJogos[escolha].getAnoLancamento());
                            int anoLancamento = lerInt(scanner, "Atualizar (digite '-1' para manter): ",
                                    "Erro! Digite um número inteiro");
                            System.out.println("=======================");
                            System.out.println("Nota: " + listaJogos[escolha].getAvaliacao().getNota());
                            while (true) {
                                nota = lerInt(scanner, "Atualizar (digite '-1' para manter): ",
                                        "Erro! Digite um número inteiro");
                                if (nota >= 0 && nota <= 5 || nota == -1) {
                                    break;
                                } else {
                                    System.out.println("Nota inválida! Digite uma nota entre 0 à 5.");
                                }
                            }
                            System.out.println("=======================");
                            System.out.println("Crítica: " + listaJogos[escolha].getAvaliacao().getCritica());
                            String critica = lerString(scanner, "Atualizar (digite '-1' para manter): ",
                                    "Erro! Digite uma crítica válida");
                            System.out.println("=======================");
                            if (!titulo.equals("-1")) {
                                listaJogos[escolha].setTitulo(titulo);
                            }

                            if (!descricao.equals("-1")) {
                                listaJogos[escolha].setDescricao(descricao);
                            }

                            if (anoLancamento != -1) {
                                listaJogos[escolha].setAnoLancamento(anoLancamento);
                            }

                            if (nota != -1) {
                                listaJogos[escolha].getAvaliacao().setNota(nota);
                            }

                            if (!critica.equals("-1")) {
                                listaJogos[escolha].getAvaliacao().setCritica(critica);
                            }
                            System.out.println("Jogo atualizado com sucesso!");
                            break;
                        } else {
                            System.out.println("Opção inválida! Escolha um dos índices listados.");
                        }
                    }
                }

                case 4: {
                    System.out.println("Saindo do sistema...");
                    scanner.close();
                    return;
                }
            }
        }
    }
}
