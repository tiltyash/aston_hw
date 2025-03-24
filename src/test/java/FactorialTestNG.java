import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class FactorialTestNG {

    @Test
    public void testFactorialOfZero() {
        assertEquals(Factorial.findFactorial(0), 1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialOfNegativeNumber() {
        Factorial.findFactorial(-1);
    }

    @Test
    public void testFactorialOfOne() {
        assertEquals(Factorial.findFactorial(1), 1);
    }

    @Test
    public void testFactorialOfTen() {
        assertEquals(Factorial.findFactorial(10), 3628800);
    }
}
