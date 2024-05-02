import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean continuar = true;

        while (continuar) {
            System.out.println("""
                    Seja bem-vinde ao conversor de moedas;
                    Gostaria de converter qual moeda?;
                    1) Real brasileiro
                    2) Dólar americano
                    3) Euro
                    4) Libra esterlina
                    5) Peso argentino
                    6) Rand sul-africano
                    7) Rúpia indiana
                    8) Outras moedas
                    9) Histórico de conversões
                    10) Sair
                    \nEscolha uma opção válida:""");
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    ConversorMoedas.converterMoeda("BRL", selecionarMoeda(scanner));
                    break;
                case 2:
                    ConversorMoedas.converterMoeda("USD", selecionarMoeda(scanner));
                    break;
                case 3:
                    ConversorMoedas.converterMoeda("EUR", selecionarMoeda(scanner));
                    break;
                case 4:
                    ConversorMoedas.converterMoeda("GBP", selecionarMoeda(scanner));
                    break;
                case 5:
                    ConversorMoedas.converterMoeda("ARS", selecionarMoeda(scanner));
                    break;
                case 6:
                    ConversorMoedas.converterMoeda("ZAR", selecionarMoeda(scanner));
                    break;
                case 7:
                    ConversorMoedas.converterMoeda("INR", selecionarMoeda(scanner));
                    break;
                case 8:
                    outrasMoedas(scanner);
                    break;
                case 9:
                    HistoricoConversoes.exibirHistorico();
                    break;
                case 10:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção de 1 a 10.");
            }
        }
    }

    private static String selecionarMoeda(Scanner scanner) {
        System.out.println("Selecione a moeda para a qual deseja converter:");
        int index = 1;
        for (String moeda : MoedasDisponiveis.MOEDAS) {
            System.out.println(index + ") " + moeda);
            index++;
        }
        int opcao = scanner.nextInt();
        return MoedasDisponiveis.MOEDAS[opcao - 1];
    }

    private static void outrasMoedas(Scanner scanner) {
        System.out.println("Função em desenvolvimento.");
    }
}
