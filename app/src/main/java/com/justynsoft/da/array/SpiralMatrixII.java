package com.justynsoft.da.array;

public class SpiralMatrixII {
    public static void main(String[] args){
        int[][] result = generateMatrix(5);
        System.out.println(result);
    }

    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int startRowPos = 0, startColPos = 0, count = n - 1;
        int prevRowPos = 0, prevColPos = 0;
        result[0][0] = 1;
        String turn = "right";

        for(int i = 2; i <= n * n; i ++ ){

            if(turn.equals("right")){
                prevColPos += 1;
                result[prevRowPos][prevColPos] = i;
                if(prevColPos == count){
                    turn = "down";
                }
                continue;
            }

            if(turn.equals("down")){
                prevRowPos += 1;
                result[prevRowPos][prevColPos] = i;
                if(prevColPos == count && prevRowPos == count){
                    turn = "left";
                }
                continue;
            }

            if(turn.equals("left")){
                prevColPos -= 1;
                result[prevRowPos][prevColPos] = i;
                if(prevColPos == startColPos ){
                    turn = "up";
                }
                continue;
            }

            if(turn.equals("up")){
                prevRowPos -= 1;
                result[prevRowPos][prevColPos] = i;
                //check if we need to turn right
                if(prevRowPos == startRowPos + 1){
                    startRowPos = prevRowPos;
                    startColPos = prevColPos + 1;
                    count -= 1;
                    turn = "right";
                }
            }
        }


        return result;
    }
}
