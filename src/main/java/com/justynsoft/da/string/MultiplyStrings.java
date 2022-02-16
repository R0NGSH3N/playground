package com.justynsoft.da.string;

public class MultiplyStrings {
    public static void main(String[] args){
        System.out.println(multiply("881095803",  "601"));
        //System.out.println(multiply("1", "130"));
        //System.out.println(multiply("123456789", "987654321"));
    }
    public static  String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        char[] num1CharArr = num1.toCharArray();
        char[] num2CharArr = num2.toCharArray();
        String finalResults = "";
        String extPos = "";
        for(int i = num2CharArr.length -1 ; i >= 0; i --){
            if(num2CharArr[i] == 0){
                continue;
            }
            int cache = 0, reminder = 0, internalResult = 0;
            String internalResultStr = "", intPos = "";
            for(int j = num1CharArr.length -1; j>= 0; j--){
               if(num1CharArr[j] ==0 ){
                   continue;
               }else{
                   int result = Character.getNumericValue(num1CharArr[j]) * Character.getNumericValue(num2CharArr[i]) + cache;
                   if(result >= 10){
                       reminder = result % 10;
                       cache = result /10;
                   }else{
                       reminder = result;
                       cache = 0;
                   }
                   internalResultStr = sumString(internalResultStr, reminder + intPos);
                   intPos += "0";
               }
            }
            if(cache != 0){
                internalResultStr = sumString(internalResultStr, cache + intPos);
            }


            if(!internalResultStr.equals("0")){
                finalResults = sumString(finalResults, internalResultStr + extPos);
            }
            extPos += "0";
        }
        return finalResults;

    }

    private static String sumString(String num1, String num2) {
        int carry = 0;
        int num1_index = num1.length() - 1;
        int num2_index = num2.length() - 1;
        String ans = "";
        while (num1_index >= 0 || num2_index >= 0) {
            int n1 = num1_index >= 0 ? num1.charAt(num1_index) - '0' : 0;
            int n2 = num2_index >= 0 ? num2.charAt(num2_index) - '0' : 0;
            int sum = n1 + n2 + carry;
            carry = sum / 10;
            ans = sum % 10 + "" + ans;
            num1_index--;
            num2_index--;
        }
        if (carry > 0) {
            ans = carry + "" + ans;
        }
        return ans;
    }

    public static String multiply9c(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return null;
        }

        int len1 = num1.length(), len2 = num2.length();
        int len3 = len1 + len2;
        int i, j, product, carry;

        int[] num3 = new int[len3];
        for (i = len1 - 1; i >= 0; i--) {
            carry = 0;
            for (j = len2 - 1; j >= 0; j--) {
                product = carry + num3[i + j + 1] +
                        Character.getNumericValue(num1.charAt(i)) *
                                Character.getNumericValue(num2.charAt(j));
                num3[i + j + 1] = product % 10;
                carry = product / 10;
            }
            num3[i + j + 1] = carry;
        }

        StringBuilder sb = new StringBuilder();
        i = 0;

        while (i < len3 - 1 && num3[i] == 0) {
            i++;
        }

        while (i < len3) {
            sb.append(num3[i++]);
        }

        return sb.toString();
    }
}
