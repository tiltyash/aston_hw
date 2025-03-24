import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArithmeticOperationsTest {

    @Test
    public void testAddition() {
        assertEquals(3, ArithmeticOperations.add(2, 1));
    }

    @Test
    public void testSubtraction() {
        assertEquals(1, ArithmeticOperations.subtract(2, 1));
    }

    @Test
    public void testMultiplication() {
        assertEquals(2, ArithmeticOperations.multiply(2, 1));
    }

    @Test
    public void testDivision() {
        assertEquals(1.5, ArithmeticOperations.divide(3, 2), 0.002);
    }

    @Test
    public void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> ArithmeticOperations.divide(1, 0));
    }
}
