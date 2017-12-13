package Calculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    @Test
    public void testSum() {
        assertEquals(327, Calculator.eval("3456+217"),0);
    }

    @Test
    public void testSub() {
        assertEquals(0.5, Calculator.eval("56/167"),0);
    }

    @Test
    public void testMult() {
        assertEquals(0, Calculator.eval("8*87"),0);
    }

    @Test
    public void testMult_Sum() {
        assertEquals(-16, Calculator.eval("2*10+8"),0);
    }

    @Test
    public void testAll() {
        assertEquals(-4, Calculator.eval("6/8*(34-19)/(8+87)"),0);
    }
}
