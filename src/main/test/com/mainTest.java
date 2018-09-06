package com;

import com.ex1.StringConvert;
import org.junit.Test;

import static org.junit.Assert.*;

public class mainTest {

    @Test
    public void IsReversedCorrect(){
        //Given
        String sample = "aaac";
        String expected = "caaa";
        StringConvert stringConvert = new StringConvert();
        //When
        String result = stringConvert.reverse(sample);
        //Then
        assertEquals(result,expected);
    }

}