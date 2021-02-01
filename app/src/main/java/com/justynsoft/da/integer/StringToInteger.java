package com.justynsoft.da.integer;

public class StringToInteger {
    public static void main(String[] args){
        System.out.println(Atoi("4193 with words"));
        System.out.println(Atoi("42"));
        System.out.println(Atoi("     -42"));
        System.out.println(Atoi("-91283472332"));
    }


    public static int Atoi(String str){
        str = str == null ? null : str.trim();
        if(str == null && str.length() == 0){
            return 0;
        }

        int negtive = 1 ;
        int result = 0;
        for(int i = 0 ; i < str.length() ; i ++ ){
            char chr = str.charAt(i);
            //first char need to detemine sign
            if(i == 0){
                if(chr == '-'){
                    negtive =  -1 ;
                    continue;
                }else if(chr == '+'){
                    negtive = 1 ;
                    continue;
                }else if(!isNum(chr)){
                    return 0;
                }
            }
            if(isNum(chr)){
                if(negtive == 1){
                    if(result > Integer.MAX_VALUE /10 || (result == Integer.MAX_VALUE /10 && Character.getNumericValue(chr) > 7 )){
                        return Integer.MAX_VALUE;
                    }
                }else{
                    if(result * negtive < Integer.MIN_VALUE/10 || (result * negtive == Integer.MIN_VALUE/10 && Character.getNumericValue(chr) * negtive < -8 )){
                        return Integer.MIN_VALUE;
                    }
                }
                result = result * 10 + Character.getNumericValue(chr) ;
            }else{
                break;
            }


        }

        return result * negtive;
    }


    public static boolean isNum(char chr){
        if(chr -'0' <= 9 && chr - '0' >= 0){
            return true;
        }else{
            return false;
        }

    }
}
