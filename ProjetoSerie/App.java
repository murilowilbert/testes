package ProjetoSerie;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class App {
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

    public static String lerString(Scanner scanner, String mensagem, String mensagemErro) {
        while (true) {
            System.out.print(mensagem);
            String valor = scanner.nextLine().trim();
            if (!valor.isEmpty()) {
                return valor;
            }
            System.out.println(mensagemErro);
        }
    }

    public static void main(String[] args) {
        int contator = 1;
        HashMap<Integer, Serie> listaSeries = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1 - Adicionar Série");
            System.out.println("2 - Consultar Séries");
            System.out.println("3 - Sair do Programa");
            int escolha = lerNumero(scanner, "Escolha uma opção:", "Opção inválida! Tente novamente.");
            switch (escolha) {
                case 1: {
                    String titulo = lerString(scanner, "Digite o nome: ", "Nome Inválido! Tente novamente.");
                    String sinopse = lerString(scanner, "Digite a sinopse: ", "Sinopse Inválida! Tente novamente.");
                    int anoLancamento = lerNumero(scanner, "Digite o ano de lançamento: ",
                            "Erro! Digite um número inteiro.");
                    int nota = lerNumero(scanner, "Digite a sua nota (0 à 5): ", "Nota inválida! Tente novamente.");
                    String critica = lerString(scanner, "Digite sua crítica: ", "Crítica inválida! Tente novamente.");
                    listaSeries.put(contator, new Serie(titulo, sinopse, anoLancamento, nota, critica));
                    contator++;
                    break;

                }

                case 2: {
                    for (Serie serie : listaSeries.values()) {
                        serie.exibirInfo();
                    }
                    break;
                }

                case 3: {
                    return;
                }

                default: {
                    System.out.println("Opção inválida! Digite entre 1 à 3.");
                    break;
                }
            }

        }
    }
}
