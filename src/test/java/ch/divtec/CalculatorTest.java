package ch.divtec;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void addNormal() {
        assertEquals(4, calculator.add(2, 2));
    }

    @Test
    void addNegative() {
        assertEquals(-1, calculator.add(2, -3));
    }

    @Test
    void subtractNormal() {
        assertEquals(1, calculator.subtract(3, 2));
    }

    @Test
    void subtractNegative() {
        assertEquals(-1, calculator.subtract(-3, -2));
    }

    @Test
    void multiplyNormal() {
        assertEquals(4, calculator.multiply(2, 2));
    }

    @Test
    void multiplyNegative() {
        assertEquals(4, calculator.multiply(-2, -2));
    }

    @Test
    void multiplyFirstZero() {
        assertEquals(0.0, calculator.multiply(0, -564838));
    }

    @Test
    void factorialOfZero() {
        assertEquals(1, calculator.factorial(0));
    }

    @Test
    void factorialDecimal() {

        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.factorial(3.2)
        );

        String expectedMessage = "Number must be an integer";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void factorialNegative() {

        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.factorial(-5)
        );

        String expectedMessage = "Number must be positive";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}