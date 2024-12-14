
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        calculator.divide(1.0, 0.0);
    }
}
