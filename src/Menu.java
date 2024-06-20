import java.util.Scanner;

import Models.MinhaAPI;

public class Menu {
    public Menu() {

        Scanner leitura = new Scanner(System.in);
        System.out.println("\r\n" +
                "██████  ███████ ███    ███     ██    ██ ██    ██ ███    ██ ██████   ██████  \r\n" +
                "██   ██ ██      ████  ████     ██    ██ ██    ██ ████   ██ ██   ██ ██    ██ \r\n" +
                "██████  █████   ██ ████ ██     ██    ██ ██    ██ ██ ██  ██ ██   ██ ██    ██ \r\n" +
                "██   ██ ██      ██  ██  ██      ██  ██  ██    ██ ██  ██ ██ ██   ██ ██    ██ \r\n" +
                "██████  ███████ ██      ██       ████    ██████  ██   ████ ██████   ██████  \r\n" +
                "                                                                            \r\n" +
                "                                                                            \r\n" +
                "");

        System.out.println("Ola, Seja bem vindo ao nosso conversor de moedas \r\n" +
                "escolha uma das opções abaixo.");

        int opcaoMenu;
        MinhaAPI MinhaApi = new MinhaAPI();

        try {

            String Menu = "\r\n" +
                    "  __  __ ______ _   _ _    _ \r\n" +
                    " |  \\/  |  ____| \\ | | |  | |\r\n" +
                    " | \\  / | |__  |  \\| | |  | |\r\n" +
                    " | |\\/| |  __| | . ` | |  | |\r\n" +
                    " | |  | | |____| |\\  | |__| |\r\n" +
                    " |_|  |_|______|_| \\_|\\____/ \r\n" +
                    "                             \r\n" +
                    "                             \r\n" +
                    "" +
                    """
                            --------------------------------------------
                            1\t Dólar (USD)\t\t ====>\t Real Brasil (BRL)
                            2\t Euro (EUR)\t\t\t ====>\t Real Brasil (BRL)
                            3\t Yuan China (CNY)\t ====>\t Real Brasil (BRL)
                            4\t Real Brasil (BRA)\t ====>\t Yuan China (CNY)
                            5\t Real Brasil (BRA)\t ====>\t Euro (EUR)
                            6\t Real Brasil (BRA)\t ====>\t Dólar (USD)
                            7\t Mais opções de conversões
                            8\t Histórico de conversões
                            9\t SAIR
                            -------------------------------------------------
                            """;

            System.out.println(Menu);
            System.out.print("Escolha uma opcao: ");

            do {
                opcaoMenu = leitura.nextInt();

                switch (opcaoMenu) {
                    case 1:
                        System.out.println("Digite o valor para converter!");
                        double valorConversao = leitura.nextInt();

                        System.out.println("A conversão foi realizada com sucesso!");

                        String resultado = MinhaApi.ConverterMoeda("USD", "BRL", valorConversao);
                        System.out.println(resultado);

                        break;

                    case 2:
                        System.out.println("Digite o valor para converter!");
                        valorConversao = leitura.nextInt();

                        System.out.println("A conversão foi realizada com sucesso!");

                        resultado = MinhaApi.ConverterMoeda("EUR", "BRL", valorConversao);
                        System.out.println(resultado);

                        break;

                    case 3:
                        System.out.println("Digite o valor para converter!");
                        valorConversao = leitura.nextInt();

                        System.out.println("A conversão foi realizada com sucesso!");

                        resultado = MinhaApi.ConverterMoeda("CNY", "BRL", valorConversao);
                        System.out.println(resultado);

                        break;

                    case 4:
                        System.out.println("Digite o valor para converter!");
                        valorConversao = leitura.nextInt();

                        System.out.println("A conversão foi realizada com sucesso!");

                        resultado = MinhaApi.ConverterMoeda("BRL", "CNY", valorConversao);
                        System.out.println(resultado);

                        break;

                    case 5:
                        System.out.println("Digite o valor para converter!");
                        valorConversao = leitura.nextInt();

                        System.out.println("A conversão foi realizada com sucesso!");

                        resultado = MinhaApi.ConverterMoeda("BRL", "EUR", valorConversao);
                        System.out.println(resultado);

                        break;

                    case 6:
                        System.out.println("Digite o valor para converter!");
                        valorConversao = leitura.nextInt();

                        System.out.println("A conversão foi realizada com sucesso!");

                        resultado = MinhaApi.ConverterMoeda("BRL", "USD", valorConversao);
                        System.out.println(resultado);

                        break;

                    case 9:
                        System.out.println("Fim do programa!");
                        break;

                    default:
                        System.out.println("Opção inválida!");
                        break;

                }
                System.out.print("Digite uma nova opcao: ");

            } while (opcaoMenu != 9);

            leitura.close();

        } catch (Exception e) {

        }

    }

}
