package com.justynsoft.da.integer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args){
        int[] arr = new int[]{2,3,6,7};
        List<List<Integer>> result = combinationSum(arr, 7);

    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        //Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(0, path, result, candidates, target );
        //backtrack(result, new ArrayList<>(), candidates, target, 0);

        return result;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start) {
        if (remain < 0) return;
        else if (remain == 0) list.add(new ArrayList<>(tempList));
        else {
            for (int i = start; i < nums.length; i++) {
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void dfs( int pos, List<Integer> path, List<List<Integer>> result, int[] candidates, int remain) {
//        if (pos == candidates.length - 1) {
//            return;
//        }

//        int sum = 0;
//        for (Integer element : path) {
//            sum += element;
//        }

        if (remain < 0) {
            return;
        }else if (remain == 0) {
            result.add(new ArrayList<>(path));
        }else {
            for(int i = pos ; i< candidates.length; i++){
                path.add(candidates[i]);
                dfs(i, path, result, candidates, remain - candidates[i]);
                path.remove(path.size() -1);

            }
        }

    }
}
