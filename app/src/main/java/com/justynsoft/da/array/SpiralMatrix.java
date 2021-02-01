package com.justynsoft.da.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SpiralMatrix {
    public static void main(String[] args) {
        //int[][] matrix = new int[][]{{1, 2, 3, 4, 5}, {6,7,8,9,10}, {11,12,13,14,15},{16,17,18,19,20}};
        //int[][] matrix = new int[][]{};
        int[][] matrix = new int[][]{{3},{2}};
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null){
            return new ArrayList<>();
        }
        int rowCount = matrix.length;
        if(rowCount == 0){
            return new ArrayList<>();
        }
        int colCount = matrix[0] != null ? matrix[0].length : 0 ;
        if(colCount == 0 ){
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>(rowCount * colCount);
        int listLenght = rowCount * colCount;
        rowCount = rowCount - 1;
        colCount = colCount - 1;
        int prevRowPos = -1, prevColPos = -1;
        int startRowPos = 0, startColPos = 0;
        Set<String> positionSet = new HashSet<>();
        String turn = "right";
        for (int i = 0; i < listLenght; i++) {
            //start point
            if (prevRowPos == -1 && prevColPos == -1) {
                result.add(matrix[startRowPos][startColPos]);
                if(!positionSet.add("(" + startRowPos + "," + startColPos + ")" )){
                    break;
                }
                prevRowPos = startRowPos;
                prevColPos = startColPos;
                if(prevColPos == colCount){
                    turn = "down";
                }else{
                    turn = "right";
                }
                continue;
            }

            if (turn == "right") { //move right
                prevColPos = prevColPos + 1;
                result.add(matrix[prevRowPos][prevColPos]);
                if(!positionSet.add("(" + prevRowPos + "," + prevColPos + ")" )){
                    break;
                }
                if(prevColPos == colCount){
                    turn = "down";
                }

                continue;
            }

            if (turn == "down") {
                prevRowPos = prevRowPos + 1;
                result.add(matrix[prevRowPos][prevColPos]);
                if(!positionSet.add("(" + prevRowPos + "," + prevColPos + ")" )){
                    break;
                }
                if(prevRowPos == rowCount){
                    turn = "left";
                }
                continue;
            }

            if (turn == "left"){
                prevColPos = prevColPos - 1;
                if(prevColPos == startColPos){
                    turn = "up";
                }
                result.add(matrix[prevRowPos][prevColPos]);
                if(!positionSet.add("(" + prevRowPos + "," + prevColPos + ")")){
                    break;
                }
                continue;
            }

            if (turn == "up"){
                result.add(matrix[prevRowPos - 1][prevColPos]);
                if(!positionSet.add("(" + (prevRowPos - 1) + "," + prevColPos + ")")){
                    break;
                }
                prevRowPos = prevRowPos - 1;
                //when we reach the last element of this round, reset the startRowPos, startColPos
                //also reset the prevColPos and prevRowPos, then let row/col count -1
                //and reset turn to right -- we always start to turn right
                if (prevRowPos == startRowPos + 1 && prevColPos == startColPos) {
                    startRowPos = startRowPos + 1;
                    startColPos = startColPos + 1;
                    prevColPos = -1;
                    prevRowPos = -1;
                    rowCount = rowCount - 1;
                    colCount = colCount - 1;
                    turn = "right";
                }
                continue;
            }


        }
        return result;
    }
}

