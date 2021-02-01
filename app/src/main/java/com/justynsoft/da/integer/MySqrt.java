package com.justynsoft.da.integer;

public class MySqrt {

    public static void main(String[] args){
        MySqrt obj = new MySqrt();
        System.out.println("result:" + obj.mySqrt(8));
    }

    public int mySqrt(int x) {
        //如果是负数，我们不计算，直接返回x
        if (x < 0){
            return x;
        }

        int end = x;
        int start = 1;
        while (start <= end ){
            //这里不同于其他二分法，要加上低位数：（20 - 10 ）/ 2 = 5， 但是要我们要算的数字是15 = start + 5
            long mid = (end - start ) / 2 + start; //mid要定义成long防止溢出
            if(mid * mid == x){
                return (int)mid;
            }else if( mid * mid < x){
                start = (int)mid + 1; //从mid加一开始，因为mid已经被测过了
            }else{
                end = (int)mid - 1;
            }
        }

        return end; //因为end和start已经重合了，所以只要回end就可以了

    }

    public int mySqrt2(int x){
        long result = x;
        while (result * result > x){
            result = (result + x / result) / 2;
        }
        return (int)result;
    }
}
