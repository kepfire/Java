import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionAnalyzerTest {

    @Test
    public void testFindTopTenExpenses() {
        List<Transaction> transactions = List.of(
                new Transaction("05-12-2023", -7850.0, "Сільпо"),
                new Transaction("07-12-2023", -1200.0, "Аптека"),
                new Transaction("10-12-2023", 80000.0, "Зарплата"),
                new Transaction("12-12-2023", 1500.0, "Авторські винагороди"),
                new Transaction("14-12-2023", -3200.0, "Комунальні послуги"),
                new Transaction("15-12-2023", -150.0, "Кав'ярня"),
                new Transaction("16-12-2023", -5000.0, "Ресторан"),
                new Transaction("17-12-2023", -200.0, "Кінотеатр"),
                new Transaction("18-12-2023", -2500.0, "Магазин електроніки"),
                new Transaction("19-12-2023", -450.0, "Супермаркет")
        );

        List<Transaction> topExpenses = TransactionAnalyzer.findTopTenExpenses(transactions);

        assertEquals(-7850.0, topExpenses.get(0).getAmount());
        assertEquals("Сільпо", topExpenses.get(0).getDescription());
        assertEquals(-5000.0, topExpenses.get(1).getAmount());
        assertEquals("Ресторан", topExpenses.get(1).getDescription());
        assertEquals(-3200.0, topExpenses.get(2).getAmount());
        assertEquals("Комунальні послуги", topExpenses.get(2).getDescription());
    }
}
