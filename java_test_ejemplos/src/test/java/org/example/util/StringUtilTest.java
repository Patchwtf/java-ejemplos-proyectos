package org.example.util;

class StringUtilTest {
    public static void main(String[] args) {
        assertEquals(StringUtil.repeat("hola", 3), "holaholahol");
    }

    private static void assertEquals(String result, String expected) {
        if(!result.equals(expected)) throw new RuntimeException(result + " is not equal to " + expected);
    }
}