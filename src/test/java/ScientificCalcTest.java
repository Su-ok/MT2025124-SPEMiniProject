import static org.junit.Assert.*;
import org.junit.Test;
import org.example.ScientificCalculator;

public class ScientificCalcTest {

    private static final double DELTA = 1e-15;

    @Test
    public void testSquareRoot() {
        assertEquals("Square root of 16 should be 4", 4.0, Math.sqrt(16.0), DELTA);
        assertEquals("Square root of 25 should be 5", 5.0, Math.sqrt(25.0), DELTA);
    }

    @Test
    public void testFactorial() {
        assertEquals("Factorial of 5 should be 120", 120, ScientificCalculator.factorial(5));
        assertEquals("Factorial of 0 should be 1", 1, ScientificCalculator.factorial(0));
    }

    @Test
    public void testLogarithm() {
        assertEquals("Natural log of 1 should be 0", 0.0, Math.log(1.0), DELTA);
    }

    @Test
    public void testPower() {
        assertEquals("2 to the power 3 should be 8", 8.0, Math.pow(2.0, 3.0), DELTA);
    }
}
