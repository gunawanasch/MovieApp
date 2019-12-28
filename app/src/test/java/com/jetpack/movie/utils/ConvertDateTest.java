package com.jetpack.movie.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConvertDateTest {

    @Test
    public void convertNewFormat() {
        String date = "2019-06-15";
        assertEquals("Jun 15, 2019", new ConvertDate().newFormatDate(date));
    }

}