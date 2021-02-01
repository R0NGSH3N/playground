package com.justynsoft.da.integer;

public class ClimbStairs {

    public static void main(String[] args){
        ClimbStairs obj = new ClimbStairs();
        System.out.println(obj.climbStairs(5));

    }

    public int climbStairs(int n) {
        if(n <= 1){
            return 1;
        }
        int[] result = new int[n + 1];
        result[0] = 1;
        result[1] = 1;

        //从第二层加起，一直加到第n层
        for(int i = 2; i <= n; i++){
            result[i] = result[i - 1] + result[ i - 2];
        }


        //最后返回第n个的数值就对了。
        return result[n];
    }
}
