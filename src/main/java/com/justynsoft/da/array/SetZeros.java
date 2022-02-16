package com.justynsoft.da.array;

import java.util.HashSet;
import java.util.Set;

public class SetZeros {

    public static void main(String[] args){
        SetZeros obj = new SetZeros();
        int[][] matrix = new int[][]{{0, 2, 3, 4, 5}, {6,7,8,9,1}, {1,2,3,0,5},{6,7,8,9,2}};
        obj.setZeroes(matrix);
        for(int i = 0 ; i < matrix.length; i++){
           for(int j = 0; j< matrix[0].length; j++){
               System.out.print(matrix[i][j] + ",");
           }
           System.out.println("");
        }
    }

    public void setZeroes(int[][] matrix) {
        Set<Integer> rowSet = new HashSet();
        Set<Integer> columnSet = new HashSet<>();
        int count = 0;
        for(int i = 0 ; i <  matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    rowSet.add(i);
                    columnSet.add(j);
                }
            }
        }

        for(int i = 0 ; i < matrix.length; i++){
            if(rowSet.contains(i)){
                for(int j = 0; j <  matrix[i].length; j ++){
                    matrix[i][j] = 0;
                }
            }else{
                for(int j = 0; j <  matrix[i].length; j++){
                    if(columnSet.contains(j)){
                        matrix[i][j] = 0;
                    }
                }
            }
        }
    }
}
