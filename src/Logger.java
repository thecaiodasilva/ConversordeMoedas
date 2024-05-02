import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class Logger {
    private static final String LOG_FILE = "conversion_logs.txt";

    public static void salvarLog(String log) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE, true))) {
            writer.println(log);
        } catch (IOException e) {
            System.out.println("Erro ao salvar log.");
        }
    }

    public static String criarLog(String from, String to, double valueInput, double convertedValue) {
        return String.format("%s - Convertido %.2f %s para %.2f %s", LocalDateTime.now(), valueInput, from, convertedValue, to);
    }
}
