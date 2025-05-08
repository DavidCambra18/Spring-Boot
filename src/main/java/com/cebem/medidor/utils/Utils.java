package com.cebem.medidor.utils;

public class Utils {
    public static boolean isPalindrome(String text){
        String inverse = new StringBuilder(text).reverse().toString();
        return text.equalsIgnoreCase(inverse);
    }
}
