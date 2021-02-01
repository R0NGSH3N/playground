package com.justynsoft.da.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
    public static void main(String[] args){
        int[] nums = new int[]{1,2,1};
        List<List<Integer>> result = permuteUnique(nums);
        System.out.println(result);
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        dfs(new ArrayList<>(),result, nums, new ArrayList<>());
        return result;
    }

    public static void dfs(List<Integer> path, List<List<Integer>> result, int[] nums, List<Integer> visited) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
        } else {
            for(int i = 0; i < nums.length; i ++){
                if(visited.contains(i)){
                    continue;
                }

                if(i > 0 && nums[i - 1] == nums[i]){
                    continue;
                }

                if( i> 0 && !visited.contains( i - 1 )){
                    continue;
                }
                visited.add(i);
                path.add(nums[i]);
                dfs( path, result, nums, visited);
                visited.remove(visited.size() -1);
                path.remove(path.size() -1 );
            }
        }
    }
}
