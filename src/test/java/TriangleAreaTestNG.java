import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TriangleAreaTestNG {
    @Test
    public void testAreaWithPositiveNumbers() {
        assertEquals(TriangleArea.findArea(10,10), 50.0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testAreaWithNegativeBase() {
        TriangleArea.findArea(-2, 1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testAreaWithNegativeHeight() {
        TriangleArea.findArea(1, -1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testAreaWithNegativeBaseAndHeight() {
        TriangleArea.findArea(-1, -1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testAreaWithZeroBase() {
        TriangleArea.findArea(0, 1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testAreaWithZeroHeight() {
        TriangleArea.findArea(1, 0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testAreaWithZeroBaseAndHeight() {
        TriangleArea.findArea(0, 0);
    }



}
