package com.justynsoft.da.string;

public class strStr {
    public static void main(String[] args){
        System.out.println(strStr("hello", "lo"));
        //System.out.println(strStr("aaa", "a"));
    }

    public static int strStr(String haystack, String needle) {
        //needle is empty, then return 0;
        if (needle == null || needle.length() == 0) {
            return 0;
        }

        //if haysack is empty, return -1
        if(haystack == null || haystack.length() == 0){
            return -1;
        }

        //needle size > haysack, return -1
        if(needle.length() > haystack.length()){
            return -1;
        }

        if(needle.length() == haystack.length()){
            return needle.equals(haystack) ? 0 : -1;
        }

        char[] arr = haystack.toCharArray();
        char[] needleArr = needle.toCharArray();
        for (int i = 0; i < arr.length - needle.length() + 1; i++) {
            int counter = 0;
            inner:
            for (int j = i; j < needle.length() + i; j++) {
                if (arr[j] == needleArr[counter]) {
                    if(counter == needle.length() - 1){
                        return i;
                    }
                    counter = counter +1;
                } else {
                    break inner;
                }
            }
        }

        return -1;
    }
}
