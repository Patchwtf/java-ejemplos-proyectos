package org.example.util;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {
    @Test
    public void testRepeatOnce() {
        Assert.assertEquals( "hola", StringUtil.repeat("hola", 1));
    }
    @Test
    public void testRepeatMultipleTimes() {
        Assert.assertEquals( "holaholaholaholahola", StringUtil.repeat("hola", 5));
    }
    @Test
    public void testRepeatZero() {
        Assert.assertEquals( "", StringUtil.repeat("hola", 0));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testRepeatNegative() {
        StringUtil.repeat("hola", -1);
    }
}