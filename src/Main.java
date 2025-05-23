import services.ConverseService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConverseService conversaoService = new ConverseService();

        System.out.println("*****************************************************************");
        System.out.println("Seja bem-vindo/a ao Conversor de Moedas ");
        System.out.println("*****************************************************************");

        while (true) {
            exibirMenu();  // Exibe as opções do menu
            int opcao = scanner.nextInt();

            // Se a opção for 7, sai do loop e encerra o programa
            if (opcao == 7) {
                System.out.println("Saindo do conversor. Até logo!");
                break;
            }

            System.out.print("Digite o valor que deseja converter: ");
            double valor = scanner.nextDouble();

            System.out.print("Digite a moeda de origem (ex: EUR, CNY, JPY, USD): ");
            String moedaOrigem = scanner.next().toUpperCase();

            // Lógica de conversão baseada na opção escolhida
            switch (opcao) {
                case 1:
                    // Dólar >> Euro (USD para EUR)
                    conversaoService.converterEExibir("USD", valor, "EUR");
                    break;
                case 2:
                    // Euro >> Dólar (EUR para USD)
                    conversaoService.converterEExibir("EUR", valor, "USD");
                    break;
                case 3:
                    // Dólar >> Yen Japonês (USD para JPY)
                    conversaoService.converterEExibir("USD", valor, "JPY");
                    break;
                case 4:
                    // Yen Japonês >> Dólar (JPY para USD)
                    conversaoService.converterEExibir("JPY", valor, "USD");
                    break;
                case 5:
                    // Dólar >> Yuan Chinês (USD para CNY)
                    conversaoService.converterEExibir("USD", valor, "CNY");
                    break;
                case 6:
                    // Yuan Chinês >> Dólar (CNY para USD)
                    conversaoService.converterEExibir("CNY", valor, "USD");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }

        scanner.close();
    }

    // Exibe as opções do menu
    private static void exibirMenu() {
        System.out.println("\nEscolha uma opção:");
        System.out.println("1) Dólar >> Euro (USD para EUR)");
        System.out.println("2) Euro >> Dólar (EUR para USD)");
        System.out.println("3) Dólar >> Yen Japonês (USD para JPY)");
        System.out.println("4) Yen Japonês >> Dólar (JPY para USD)");
        System.out.println("5) Dólar >> Yuan Chinês (USD para CNY)");
        System.out.println("6) Yuan Chinês >> Dólar (CNY para USD)");
        System.out.println("7) Sair");
        System.out.print("Escolha uma opção válida: ");
    }
}
