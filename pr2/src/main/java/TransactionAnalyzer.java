import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;


public abstract class TransactionAnalyzer {
    public static double calculateTotalBalance(List<Transaction> transactions) {
        double balance = 0;
        for (Transaction transaction : transactions) {
            balance += transaction.getAmount();
        }
        return balance;
    }

    public static int countTransactionsByMonth(String monthYear, List<Transaction> transactions) {
        int count = 0;
        for (Transaction transaction : transactions) {
            LocalDate date = LocalDate.parse(transaction.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            String transactionMonthYear = date.format(DateTimeFormatter.ofPattern("MM-yyyy"));
            if (transactionMonthYear.equals(monthYear)) {
                count++;
            }
        }
        return count;
    }

    public static List<Transaction> findTopTenExpenses(List<Transaction> transactions) {
        return transactions.stream()
                .filter(t -> t.getAmount() < 0)
                .sorted(Comparator.comparing(Transaction::getAmount))
                .limit(10)
                .collect(Collectors.toList());
    }

    public static Optional<Transaction> findLargestExpense(List<Transaction> transactions, LocalDate startDate, LocalDate endDate) {
        return transactions.stream()
                .filter(t -> t.getAmount() < 0)
                .filter(t -> {
                    LocalDate date = LocalDate.parse(t.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                    return (date.isEqual(startDate) || date.isAfter(startDate)) && (date.isEqual(endDate) || date.isBefore(endDate));
                })
                .min(Comparator.comparing(Transaction::getAmount));
    }

    public static Optional<Transaction> findSmallestExpense(List<Transaction> transactions, LocalDate startDate, LocalDate endDate) {
        return transactions.stream()
                .filter(t -> t.getAmount() < 0)
                .filter(t -> {
                    LocalDate date = LocalDate.parse(t.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                    return (date.isEqual(startDate) || date.isAfter(startDate)) && (date.isEqual(endDate) || date.isBefore(endDate));
                })
                .max(Comparator.comparing(Transaction::getAmount));
    }
}
