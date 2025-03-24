import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompareTwoNumbersTest {
    @Test
    public void testFirstNumberGreater() {
        assertEquals("2 больше чем 1", CompareTwoNumbers.compare(2, 1));
    }

    @Test
    public void testSecondNumberGreater() {
        assertEquals("1 меньше чем 2", CompareTwoNumbers.compare(1, 2));
    }

    @Test
    public void testNumbersEqual() {
        assertEquals("1 равно 1", CompareTwoNumbers.compare(1, 1));
    }
}
