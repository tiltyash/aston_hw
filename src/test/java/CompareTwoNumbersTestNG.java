import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CompareTwoNumbersTestNG {

    @Test
    public void testFirstNumberGreater() {
        assertEquals(CompareTwoNumbers.compare(2, 1), "2 больше чем 1");
    }

    @Test
    public void testSecondNumberGreater() {
        assertEquals(CompareTwoNumbers.compare(1, 2), "1 меньше чем 2");
    }

    @Test
    public void testNumbersEqual() {
        assertEquals(CompareTwoNumbers.compare(1, 1), "1 равно 1");
    }
}
