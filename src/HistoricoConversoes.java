import java.util.ArrayList;
import java.util.List;

public class HistoricoConversoes {
    private static final int MAX_CONVERSOES = 10;
    private static final List<String> conversoes = new ArrayList<>();

    public static void adicionarConversao(String conversao) {
        if (conversoes.size() >= MAX_CONVERSOES) {
            conversoes.remove(0);
        }
        conversoes.add(conversao);
    }

    public static void exibirHistorico() {
        System.out.println("\n--- Histórico de Conversões ---");
        for (String conversao : conversoes) {
            System.out.println(conversao);
        }
        System.out.println("--------------------------------");
    }
}
