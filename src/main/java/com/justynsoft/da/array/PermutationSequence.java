package com.justynsoft.da.array;

import com.justynsoft.da.integer.PalindromeInteger;

import java.util.*;

public class PermutationSequence {

    public static void main(String[] args){
        System.out.println(getPermutation(3, 4));
    }

    public static String getPermutation(int n, int k) {
        List<String> result = new ArrayList<>();
        dfs(n, k, "", result );
        //System.out.println(result);
        return result.get(result.size() -1);
    }

    public static void dfs(int n, int k, String temp, List<String> result){
        if(temp.length() == n){
            result.add(temp);
            return;
        }else{
            for(int i = 1; i <= n ; i++){
                //skip the duplicate
                if(temp.contains(i+"")){
                    continue;
                }
                temp = temp + i;
                dfs(n, k, temp, result);
                if(result.size()== k){
                   break;
                }else{
                    //chop the last one
                    temp = temp.substring(0, temp.length() - 1 );
                }
            }
        }
    }
}
