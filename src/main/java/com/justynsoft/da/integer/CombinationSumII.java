package com.justynsoft.da.integer;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumII {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(0, new ArrayList<>(), result, candidates, target);
        return result;
    }

    public static void dfs(int pos, List<Integer> path, List<List<Integer>> result, int[] nums, int remain ){
        if(remain < 0){
            return ;
        }else if(remain == 0){
            result.add(new ArrayList<>(path));
        }else{
            for(int i= pos; i< nums.length ; i++){
                if(i > pos && nums[i -1] ==  nums[i]){
                    continue;
                }
                path.add(nums[i]);
                dfs(i + 1 , path, result, nums, remain - nums[i]);
                path.remove(path.size() -1 );
            }
        }
    }


}
