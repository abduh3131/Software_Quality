package com.ontariotechu.sofe3980U;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for Binary class.
 */
public class BinaryTest {
    /**
     * Test The constructor with a valid binary value
     */
    @Test
    public void normalConstructor() {
        Binary binary = new Binary("1001001");
        assertTrue(binary.getValue().equals("1001001"));
    }

    /**
     * Test The constructor with an invalid binary value of out-of-range digits
     */
    @Test
    public void constructorWithInvalidDigits() {
        Binary binary = new Binary("1001001211");
        assertTrue(binary.getValue().equals("0"));
    }

    /**
     * Test The constructor with an invalid binary value of alphabetic characters
     */
    @Test
    public void constructorWithInvalidChars() {
        Binary binary = new Binary("1001001A");
        assertTrue(binary.getValue().equals("0"));
    }

    /**
     * Test The constructor with an invalid binary value that has a sign
     */
    @Test
    public void constructorWithNegativeSign() {
        Binary binary = new Binary("-1001001");
        assertTrue(binary.getValue().equals("0"));
    }

    /**
     * Test The constructor with a zero tailing valid binary value
     */
    @Test
    public void constructorWithZeroTailing() {
        Binary binary = new Binary("00001001");
        assertTrue(binary.getValue().equals("1001"));
    }

    /**
     * Test The constructor with an empty string
     */
    @Test
    public void constructorEmptyString() {
        Binary binary = new Binary("");
        assertTrue(binary.getValue().equals("0"));
    }

    /**
     * Test The add functions with two binary numbers of the same length
     */
    @Test
    public void add() {
        Binary binary1 = new Binary("1000");
        Binary binary2 = new Binary("1111");
        Binary binary3 = Binary.add(binary1, binary2);
        assertTrue(binary3.getValue().equals("10111"));
    }

    /**
     * Test The add functions with two binary numbers, the length of the first argument is less than the second
     */
    @Test
    public void add2() {
        Binary binary1 = new Binary("1010");
        Binary binary2 = new Binary("11");
        Binary binary3 = Binary.add(binary1, binary2);
        assertTrue(binary3.getValue().equals("1101"));
    }

    /**
     * Test The add functions with two binary numbers, the length of the first argument is greater than the second
     */
    @Test
    public void add3() {
        Binary binary1 = new Binary("11");
        Binary binary2 = new Binary("1010");
        Binary binary3 = Binary.add(binary1, binary2);
        assertTrue(binary3.getValue().equals("1101"));
    }

    /**
     * Test The add functions with a binary numbers with zero
     */
    @Test
    public void add4() {
        Binary binary1 = new Binary("0");
        Binary binary2 = new Binary("1010");
        Binary binary3 = Binary.add(binary1, binary2);
        assertTrue(binary3.getValue().equals("1010"));
    }

    /**
     * Test The add functions with two zeros
     */
    @Test
    public void add5() {
        Binary binary1 = new Binary("0");
        Binary binary2 = new Binary("0");
        Binary binary3 = Binary.add(binary1, binary2);
        assertTrue(binary3.getValue().equals("0"));
    }

    @Test
    public void testOr() {
        Binary num1 = new Binary("1010");
        Binary num2 = new Binary("0110");
        Binary expectedResult = new Binary("1110");
        Binary result = Binary.or(num1, num2);
        assertEquals(expectedResult.getValue(), result.getValue(), "OR operation test failed");

        // Add two more test cases for the 'or' method if needed
    }

    @Test
    public void testAnd() {
        Binary num1 = new Binary("1010");
        Binary num2 = new Binary("0110");
        Binary expectedResult = new Binary("0010");
        Binary result = Binary.and(num1, num2);
        assertEquals(expectedResult.getValue(), result.getValue(), "AND operation test failed");

        // Add two more test cases for the 'and' method if needed
    }
    /**
     * Tests the binary multiplication functionality of the {@link Binary} class.
     * This test verifies that the {@code multiply} method correctly calculates the product
     * of two binary numbers. It uses two predefined binary numbers, multiplies them,
     * and compares the result with the expected binary product.
     * <p>
     * In this case, the binary numbers "1010" and "0110" are multiplied, and the
     * expected result is "111100". The test asserts that the actual result from
     * the {@code multiply} method matches this expected result.
     */
    @Test
    public void testMultiply() {
        Binary num1 = new Binary("1010");
        Binary num2 = new Binary("0110");
        Binary expectedResult = new Binary("111100"); // Corrected expected result
        Binary result = Binary.multiply(num1, num2);
        assertEquals(expectedResult.getValue(), result.getValue(), "Multiply operation test failed");
    }


}
