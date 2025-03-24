import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FactorialTest {

    @Test
    public void testFactorialOfZero() {
        assertEquals(1, Factorial.findFactorial(0));
    }

    @Test
    public void testFactorialOfNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> Factorial.findFactorial(-2));
    }

    @Test
    public void testFactorilaOfOne() {
        assertEquals(1, Factorial.findFactorial(1));
    }

    @Test
    public void testFactorialOfTen() {
        assertEquals(3628800, Factorial.findFactorial(10));
    }
}
