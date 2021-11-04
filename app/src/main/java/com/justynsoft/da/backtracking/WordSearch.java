package com.justynsoft.da.backtracking;

public class WordSearch{
    
    public boolean exist(char[][] board, String word) {
        int i = 0; int j = 0;
        int p = 0;
        while(i < board.length && j < board[0].length){
            if(word.charAt(p) != board[i][j]){
                p = 0;
            }
            if(p == word.length() -1){
                return true;
            }


            if(j< board[i].length -1 &&
                    board[i][j+1] == word.charAt(p)){
                j++;
            }else if(i < board.length - 1 &&
                    board[i+1][j] == word.charAt(p)){
                i++;
            }

        }

        return false;
    }

   public static void main(String[] args){
        WordSearch ws = new WordSearch();
        ws.exist(null, null);
    }

   
    /**
    public boolean exist(char[][] board, String word) {
        int pointer = 0;
        for(int i = 0; i < board.length; i++){
            char[] in = board[i];
            for(int j = 0 ; j < in.length; j++){
                char curr = word.charAt(pointer);
                if(curr == board[i][j]){
                    if(pointer == word.length() -1){
                        return true;
                    }else{
                        pointer++;
                    }
                }else{
                    pointer = 0;
                }
            }
        }
        return false;
        
    } **/
}
