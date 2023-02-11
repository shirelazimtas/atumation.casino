package com.example.atumation.dictionary;

import java.util.Arrays;

public class LastString {

    public String lastDictionaryString(String str) {
        String strLocalCase = str.toLowerCase();
        String cleanStr = strLocalCase.replaceAll("[?@#$,^&-]", "");
        cleanStr = cleanStr.replaceAll("\\d", "");
        char charArray[] = cleanStr.toCharArray();
        Arrays.sort(charArray);
        String reverseString = new StringBuilder(new String(charArray)).reverse().toString();
        return reverseString;
    }

}
