package com.justynsoft.da.string;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfDigits {
    static final String[] keypad = { "0","1","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public static void main(String[] args){
        List<String> result = letterCombinations("234");
        System.out.println(result);
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null || digits.length() ==0 ){
            return result;
        }
        int firstDigit = Character.getNumericValue(digits.charAt(0));
        String nextGroup = keypad[firstDigit];
        for(int i = 0;  i < nextGroup.length() ;  i++){
            dfs(nextGroup.charAt(i), "", result, digits, 1);
        }

        return result;
    }

    public static void dfs(char begin, String path, List<String> result, String digits, int pos){
        if(path == ""){
            path = begin + "";
        }
        //exit condition
        if(pos >= digits.length()){
            result.add(path);
            return;
        }


        int nextDigit = Character.getNumericValue(digits.charAt(pos));
        String nextGroup = keypad[nextDigit];
        for(int i = 0; i < nextGroup.length(); i++){
            char currChar = nextGroup.charAt(i);
            String newpath = path + currChar;
            dfs(begin, newpath, result, digits, pos + 1);
        }
    }
}
