package org.example.util;

import org.junit.Test;

import static org.example.util.PasswordUtil.SecurityLevel.*;
import static org.junit.Assert.*;

public class PasswordUtilTest {

    @Test
    public void weakLessThanEigthChars() {
        assertEquals(WEAK, PasswordUtil.assessPassword("1234567"));
    }
    @Test
    public void weakOnlyLetters() {
        assertEquals(WEAK, PasswordUtil.assessPassword("abcdefgh"));
    }
    @Test
    public void mediumLettersAndNumbers() {
        assertEquals(MEDIUM, PasswordUtil.assessPassword("abcd1234"));
    }
    @Test
    public void strongLettersNumbersAndSimbols() {
        assertEquals(MEDIUM, PasswordUtil.assessPassword("abcD1234#!"));
    }
}