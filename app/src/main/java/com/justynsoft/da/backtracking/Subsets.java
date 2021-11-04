package com.justynsoft.da.backtracking;
import java.util.List;
import java.util.ArrayList;

public class Subsets{
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i = 1; i <= nums.length; i++){
            backtracking(result, new ArrayList<Integer>(), nums, i, 0);
        }

        return result;

    }

    private void backtracking(List<List<Integer>> result, List<Integer> temp, int[] nums, int length, int i){
        if(temp.size() == length){
            result.add(new ArrayList<Integer>(temp));
            return;
        }

        for(int j = i; j < nums.length; j++){
            if(temp.contains(nums[j])){
                continue;
            }

            temp.add(nums[j]);
            backtracking(result, temp, nums, length, j+1);
            temp.remove(temp.size() - 1);
        }

    }
}
