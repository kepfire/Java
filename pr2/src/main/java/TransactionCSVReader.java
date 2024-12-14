import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class TransactionCSVReader {

    public static List<Transaction> readTransactions(String filePath) {
        return readData(filePath, values -> new Transaction(values[0], Double.parseDouble(values[1]), values[2]));
    }

    private static List<Transaction> readData(String filePath, Function<String[], Transaction> processor) {
        List<Transaction> transactions = new ArrayList<>();
        try {
            URL url = new URL(filePath);
            try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(",");
                    transactions.add(processor.apply(values));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return transactions;
    }
}
