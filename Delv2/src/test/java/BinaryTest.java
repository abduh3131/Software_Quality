package com.ontariotechu.sofe3980U;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryTest {

    @Test
    public void testOr() {
        assertEquals("0", Binary.or(new Binary("0"), new Binary("0")).getValue());
        assertEquals("101", Binary.or(new Binary("100"), new Binary("101")).getValue());
        assertEquals("111", Binary.or(new Binary("111"), new Binary("101")).getValue());
    }

    @Test
    public void testAnd() {
        assertEquals("0", Binary.and(new Binary("0"), new Binary("0")).getValue());
        assertEquals("100", Binary.and(new Binary("100"), new Binary("101")).getValue());
        assertEquals("101", Binary.and(new Binary("111"), new Binary("101")).getValue());
    }

    @Test
    public void testMultiply() {
        assertEquals("0", Binary.multiply(new Binary("0"), new Binary("101")).getValue());
        assertEquals("0", Binary.multiply(new Binary("100"), new Binary("0")).getValue());
        assertEquals("1100100", Binary.multiply(new Binary("100"), new Binary("110")).getValue());
    }
}
