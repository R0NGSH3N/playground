package com.justynsoft.da.backtracking;

import java.util.List;
import java.util.ArrayList;

public class Combinations{
    public List<List<Integer>> combine(int n, int k){

        List<Integer> sample = new ArrayList<Integer>();
        for(int i = 1; i <= n ; i++){
            sample.add(i);
        }

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        backTracking(result, new ArrayList<Integer>(), sample, k, 0);

        return result;

    }

    public void backTracking(List<List<Integer>> result, List<Integer> temp, List<Integer> sample, int k, int i){
        if(temp.size() == k){
            result.add(new ArrayList<Integer>(temp));
            return;
        }

        for(int j = i ; j < sample.size(); j++){
            if(temp.contains(sample.get(j))){
                continue;
            }

            temp.add(sample.get(j));
            backTracking(result, temp, sample, k, j + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args){
        Combinations obj = new Combinations();
        obj.combine(4, 2);
    }

}
