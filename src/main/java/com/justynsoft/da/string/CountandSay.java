package com.justynsoft.da.string;

public class CountandSay {

    public static void main(String[] args){
        countAndSay(10);
    }

    public static String countAndSay(int n) {

        String prevString = "1";
        if(n == 1){
            return "1";
        }
        String currString = "";
        for(int i = 1 ; i < n; i++){
            char[] array = prevString.toCharArray();
            currString = "";
            int counter = 0;
            char prevChar = 'n';
            for(int j = 0; j <  array.length; j++){
                char currChar = array[j];
                if(currChar != prevChar && prevChar != 'n'){
                    currString = currString + counter + prevChar;
                    prevChar = currChar;
                    counter = 1;
                    if(j == array.length -1){
                        currString = currString + 1 + currChar;
                    }
                }else{
                    if(prevChar == 'n'){
                        prevChar = currChar;
                    }
                    counter ++;
                    if(j == array.length -1){
                        currString = currString + counter + currChar;
                    }
                }
            }

            prevString = currString;
        }

        return currString;


    }
}
