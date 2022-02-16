package com.justynsoft.da.string;

public class LengthOfLastWord {

    public static void main(String[] args){
        String te = " ";
        System.out.println(lengthOfLastWord(te));
    }

    public static int lengthOfLastWord(String s) {

        //String sTrim = s.trim();
        String[] arr = s.split(" ");
        if(arr.length == 0){
            return 0;
        }
        return arr[arr.length -1].length();

    }
}
