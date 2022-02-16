package com.justynsoft.da.string;

import com.justynsoft.da.integer.PalindromeInteger;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] arr = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(arr));
        String[] arr2 = {"dog", "racecar", "car"};
        System.out.println(longestCommonPrefix(arr2));
        String[] arr3 = {""};
        System.out.println(longestCommonPrefix(arr3));
        String[] arr4 = {"c","c"};
        System.out.println(longestCommonPrefix(arr4));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String value = "";
        int j = 0;
        OUT:
        while (j < strs[0].length()) {
            value = value + Character.toString(strs[0].charAt(j));
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].length() < value.length()) {
                    value = value.substring(0, value.length() - 1);
                    break OUT;
                }
                String curr = strs[i].substring(0, value.length());
                if (value.equals(curr)) {
                    continue;
                } else {
                    value = value.substring(0, value.length() - 1);
                    break OUT;
                }
            }

            j++;
        }

        return value;

    }
}
