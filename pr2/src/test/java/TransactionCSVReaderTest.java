import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionCSVReaderTest {

    @Test
    public void testReadTransactions() {
        String filePath = "https://informer.com.ua/dut/java/pr2.csv";
        List<Transaction> transactions = TransactionCSVReader.readTransactions(filePath);

        assertEquals(26, transactions.size());
        assertEquals("05-12-2023", transactions.get(0).getDate());
        assertEquals(-7850.0, transactions.get(0).getAmount());
        assertEquals("Сільпо", transactions.get(0).getDescription());
    }
}
