package com.justynsoft.da.integer;

public class ContainerWithMostWater {

    public static void main(String[] args){
        int[] test = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(test));
    }

    public static int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max = 0;
        int minLength = 0;
        while( j > i){
            int left = height[i];
            int right = height[j];

            minLength = Math.min(left, right) ;
            max = Math.max(minLength * (j - i), max);
            if( left <= right){
                i++;
            }else{
                j--;
            }
        }

        return max;
    }

}
