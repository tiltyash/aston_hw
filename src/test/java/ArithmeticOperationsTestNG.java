import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ArithmeticOperationsTestNG {

    @Test
    public void testAddition() {
        assertEquals(ArithmeticOperations.add(2,1), 3);
    }

    public void testSubtraction() {
        assertEquals(ArithmeticOperations.subtract(2, 1), 1);
    }

    @Test
    public void testMultiplication() {
        assertEquals(ArithmeticOperations.multiply(2, 1), 2);
    }

    @Test
    public void testDivision() {
        assertEquals(ArithmeticOperations.divide(3, 2), 1.5, 0.002);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivisionByZero() {
        ArithmeticOperations.divide(1, 0);
    }
}
