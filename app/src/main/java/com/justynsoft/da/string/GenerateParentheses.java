package com.justynsoft.da.string;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args){
        List<String> result = generateParenthesis(3);
        System.out.println(result);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if(n == 0) return result;
        dfs("",result, 0,0, n );
        return result;
    }

    public static void dfs(String path,List<String> result, int openCount, int closeCount, int n){
//        if(openCount == n && closeCount == n){
//           result.add(path);
//           return;
//        }

        if(path.length() == n * 2){
           result.add(path);
           return;
        }
        if(openCount < n){
            String openPath = path + "(";
            dfs(openPath, result, openCount + 1, closeCount, n);
        }

        if(closeCount < openCount && closeCount < n){
            String closePath = path + ")";
            dfs(closePath, result, openCount, closeCount +1, n);
        }


    }
}
