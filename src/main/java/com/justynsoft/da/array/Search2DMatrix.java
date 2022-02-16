package com.justynsoft.da.array;

public class Search2DMatrix {
    public static void main(String[] args){
        Search2DMatrix obj = new Search2DMatrix();
        //int[][] matrix = new int[][]{{1, 2, 3, 4, 5}, {6,7,8,9,10}, {11,12,13,14,15},{16,17,18,19,20}};

        int[][] matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        System.out.println(obj.searchMatrix(matrix, 13));
//        System.out.println(obj.searchMatrix(matrix, -1));
//        System.out.println(obj.searchMatrix(matrix, 390));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){return false;}
        int m = matrix.length;
        int n = matrix[0].length;
        int startRow = 0, startCol = 0;
        int endRow = m, endCol = n;

        while(startRow <= endRow ){
            int midRow = (endRow + startRow) / 2 ;
            //确认在这一行中, 再使用“列”二分
            if(target > matrix[midRow][0] && target < matrix[midRow][n - 1] ){
                //列的二分法
                while(startCol <= endCol){
                    int midCol = ( endCol + startCol) / 2 ;
                    if(matrix[midRow][midCol] ==  target){
                        return true;
                    }else if(matrix[midRow][midCol] >  target){
                        endCol = midCol - 1 ;
                    }else{
                        startCol = midCol + 1;
                    }
                }

                return false;
            }else if(target > matrix[midRow][n - 1]){
                startRow = midRow +1 ;
            }else{
                endRow = midRow -1 ;
            }
        }

        return false;
    }
}
