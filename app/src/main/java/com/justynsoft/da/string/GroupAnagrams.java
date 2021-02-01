package com.justynsoft.da.string;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] arr = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(arr);
        System.out.println(result);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        for (String s : strs) {
            int[] mappingArr = new int[26];
            Arrays.fill(mappingArr, 0);
            for (char c : s.toCharArray()) {
                mappingArr[c - 'a'] += 1;
            }
            if (!result.containsKey(Arrays.toString(mappingArr))) {
                result.put(Arrays.toString(mappingArr), new ArrayList<>());
            }
            result.get(Arrays.toString(mappingArr)).add(s);
        }

        return new ArrayList<>(result.values());
    }

    public static List<List<String>> groupAnagramsOLD(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        for (int i = 0; i < strs.length; i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String sortedStr = String.valueOf(arr);
            if (map.containsKey(sortedStr)) {
                List<String> value = map.get(sortedStr);
                value.add(strs[i]);
            } else {
                List<String> value = new ArrayList<>();
                value.add(strs[i]);
                map.put(sortedStr, value);
            }
        }

        return new ArrayList<List<String>>(map.values());
    }
}
