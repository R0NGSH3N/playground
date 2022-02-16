package com.justynsoft.da.string;

import java.util.Arrays;

public class AddBinary {

    public static void main(String[] args){
        AddBinary obj = new AddBinary();
        System.out.println(obj.addBinary("11", "1"));
    }

    public String addBinary(String a, String b){
        StringBuffer sb = new StringBuffer();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int reminder = 0;

        while (i >= 0 || j >= 0){
            int sum = reminder; //这个sum用来记录每一位的相加结果，这个sum的值只有0，1，2,3
            //这个是判断字符串a还在范围内吗？如果在，就取，不在就不加了，这里范围是指，我们从个位数加，也就是从字符串的尾部开始，每加一次，就把i减1，减到负数就出了范围。
            if(i >= 0){
                sum += a.charAt(i) - '0'; //这个trick在notes中解释了
            }
            if(j >= 0){
                sum += b.charAt(j) - '0';
            }

            //到这里sum就完成了当前位数的加，数值是{0，1，2, 3}，这样用模2来得到
            // 0%2 = 0； 1%2 = 0； 2%2 = 0, 3%2 = 1
            sb.append(sum % 2);  //因为我们是从尾部开始加，这里加是加反的，最后还要reverse以下就可以了
            // 0/2 = 0； 1/2 = 0； 2/2 = 1, 3/2 = 1
            reminder = sum / 2;
            i--;j--;

        }

        if(reminder > 0){
            sb.append(reminder);
        }

        //最后把string buffer反转一下
        sb.reverse();
        return sb.toString();

    }

    public String addBinaryOld(String a, String b) {
        int maxLength = Math.max(a.length(), b.length());
        char[] result = new char[maxLength];
        char reg = '0';
        for(int i = 0; i < maxLength; i++){
            char charA = a.length() - 1 - i >= 0 ? a.charAt(a.length() - 1 - i) : 0;
            char charB = b.length() - 1 - i >= 0 ? b.charAt(b.length() - 1 - i) : 0;

            if(charA == '0'){
                if(charB == '0'){
                    result[maxLength - 1 - i] = reg;
                    reg = 0;
                }else{
                    if(reg == '1'){
                        result[maxLength - 1 - i] = 0;
                        reg = 1;
                    }else{
                        result[maxLength - 1 - i] = 0;
                        reg = 0;
                    }
                }

            }else{
                if(charB == '0'){
                    if(reg == '1'){
                        result[maxLength - 1 - i] = 0;
                        reg = 1;
                    }else{
                        result[maxLength - 1 - i] = 1;
                        reg = 0;
                    }
                }else{
                    if(reg == '1'){
                        result[maxLength - 1 - i] = 1;
                        reg = 1;
                    }else{
                        result[maxLength - 1 - i] = 0;
                        reg = 1;
                    }
                }

            }
        }

        if(reg == 1){
            char[] res = Arrays.copyOf(result, result.length + 1);
            res[0] = '1';
            for(int i = 0; i < result.length; i++){
                res[i + 1]= result[i];
            }

            return null;
        }else {
            return new String(result);
        }

    }
}
