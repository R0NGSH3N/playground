package com.justynsoft.da.integer;

public class ReverseInteger {

    public static void main(String[] args){
        System.out.println(reverse2(1463847412 ));
    }

    public static int reverse2(int x){
        if(x < 10){
            return x;
        }

        int result = 0;
        while(x != 0){
            if(result > Integer.MAX_VALUE /10 ){
                return 0;
            }
            if(result < Integer.MIN_VALUE /10){
                return 0;
            }

            int res = x % 10;
            x = x /10;

            if(result == Integer.MAX_VALUE /10 && res > 7){
                return 0;
            }

            if(result == Integer.MIN_VALUE /10 && res < -8){
                return 0;
            }

            result = result * 10 + res;
        }

        return result;
    }


    public static int reverse(int x){
        if(x < 10){
            return x;
        }
        int left = x;
        String result = "";
        while(left > 10){
            int residual = left%10 ;
            left = left/10;
            result = result + residual;
        }

        result = result + left;
        return Integer.parseInt(result);
    }
}
