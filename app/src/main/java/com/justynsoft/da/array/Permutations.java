package com.justynsoft.da.array;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3};
        System.out.println(permute(arr));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs( new ArrayList<>(), result, nums);
        return result;
    }

    public static void dfs( List<Integer> path, List<List<Integer>> result, int[] nums) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
        }else{
            for (int i = 0; i < nums.length; i++) {
                if(path.contains(nums[i]))continue;
                path.add(nums[i]);
                dfs(path, result, nums);
                path.remove(path.size() - 1);
            }
        }
    }
}
