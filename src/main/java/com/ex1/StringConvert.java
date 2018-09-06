package com.ex1;


public class StringConvert {
    public String reverse(String sample) {
       StringBuilder sb = new StringBuilder();
        for (int i = sample.length()-1; i>=0; i--) {
            sb.append(sample.charAt(i));
        }
        return sb.toString();
    }
}
