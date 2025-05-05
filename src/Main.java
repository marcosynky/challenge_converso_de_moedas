package model;


import services.ConversaoService;

import java.util.Scanner;

public class ConversorDeMoeda {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConversaoService conversaoService = new ConversaoService();

        System.out.println("*****************************************************************");
        System.out.println("Seja bem-vindo/a ao Conversor de Moeda =]");
        System.out.println("*****************************************************************");

        while (true) {
            exibirMenu();
            int opcao = scanner.nextInt();
            if (opcao == 7) {
                System.out.println("Saindo do conversor. Até logo!");
                break;
            }

            System.out.print("Digite o valor que deseja converter: ");
            double valor = scanner.nextDouble();

            System.out.print("Digite a moeda de origem (ex: USD, EUR, ARS): ");
            String moedaOrigem = scanner.next().toUpperCase();

            switch (opcao) {
                case 1:
                    conversaoService.converterEExibir(moedaOrigem, valor, "ARS");
                    break;
                case 2:
                    conversaoService.converterEExibir(moedaOrigem, valor, "USD");
                    break;
                case 3:
                    conversaoService.converterEExibir(moedaOrigem, valor, "BRL");
                    break;
                case 4:
                    conversaoService.converterEExibir(moedaOrigem, valor, "USD");
                    break;
                case 5:
                    conversaoService.converterEExibir(moedaOrigem, valor, "COP");
                    break;
                case 6:
                    conversaoService.converterEExibir(moedaOrigem, valor, "USD");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
        scanner.close();
    }

    // Exibe as opções do menu
    private static void exibirMenu() {
        System.out.println("1) Dólar >> Peso argentino");
        System.out.println("2) Peso argentino >> Dólar");
        System.out.println("3) Dólar >> Real brasileiro");
        System.out.println("4) Real brasileiro >> Dólar");
        System.out.println("5) Dólar >> Peso colombiano");
        System.out.println("6) Peso colombiano >> Dólar");
        System.out.println("7) Sair");
        System.out.print("Escolha uma opção válida: ");
    }
}
