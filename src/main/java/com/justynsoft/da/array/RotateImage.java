package com.justynsoft.da.array;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RotateImage {
    public static void main(String[] args){
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
        for(int[] item :  matrix){
            System.out.println(Arrays.toString(item));
        }
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length - 1;
        Set<String> cache = new HashSet<>();
        for(int i = 0 ; i < matrix.length; i++){ //row
            for(int j = 0; j < matrix.length; j++){ //column
                if(cache.contains("r" + i + "c" + j )){
                    continue;
                }
                int destCol = n - i,destRow = j; int temp1 = matrix[i][j];
                for( int count = 0; count <4; count++){
                    cache.add("r" + destRow + "c" + destCol);
                    int temp2 = matrix[destRow][destCol];
                    matrix[destRow][destCol] = temp1;
                    temp1 = temp2;
                    int cacheCol = destCol;
                    destCol = n - destRow;
                    destRow = cacheCol;
                }
            }
        }
    }
}
