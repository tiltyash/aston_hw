import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TriangleAreaTest {
    @Test
    public void testAreaWithPositiveNumbers() {
        assertEquals(50.0, TriangleArea.findArea(10, 10), 0.002);
    }

    @Test
    public void testAreaWithNegativeBase() {
        assertThrows(IllegalArgumentException.class, () -> TriangleArea.findArea(-2, 1));
    }

    @Test
    public void testAreaWithZeroBase() {
        assertThrows(IllegalArgumentException.class, () -> TriangleArea.findArea(0, 1));
    }

    @Test
    public void testAreaWithZeroHeight() {
        assertThrows(IllegalArgumentException.class, () -> TriangleArea.findArea(1, 0));
    }

    @Test
    public void testAreaWithZeroBaseAndHeight() {
        assertThrows(IllegalArgumentException.class, () -> TriangleArea.findArea(0, 0));
    }
}
