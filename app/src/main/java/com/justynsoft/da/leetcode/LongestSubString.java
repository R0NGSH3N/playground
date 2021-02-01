package com.justynsoft.da.leetcode;

import java.util.HashSet;

/**
 * Created by rongshen on 8/13/15.
 */
public class LongestSubString {

    public static void main(String[] args){
        System.out.println(lengthOfLongestSubstring("abcfafe"));
    }

    public static int lengthOfLongestSubstring(String s){
    	HashSet<Character> window = new HashSet<>();
    	int j = 0;
    	int max = 0;
    	for(int i = 0 ; i < s.length(); i++){
			if(!window.contains(s.charAt(j))){
					window.add(s.charAt(j));
					j++;
					max = Math.max(max, j - 1);
			}else{
				window.remove(s.charAt(i));
				i++;
			}
		}
		return max;
	}

	public static int findLongestSubString2(String a){
		int startIdx = 0, lastIdx = -1, max = 0;
		for( int i =  1; i < a.length(); i++){
			if(a.charAt(i) != a.charAt(i -1)){
				if(lastIdx >= 0 && a.charAt(i) != a.charAt(lastIdx)){
					max = Math.max(max, i - startIdx);	
					startIdx = lastIdx + 1;
				}
				lastIdx = i - 1;
			}
		}
		return Math.max(a.length() - startIdx, max);
	}

	public static void findLongestSubString(String a){
		char[] stringArr = a.toCharArray();
		int lastIdx = 0;
		for(int i = 0 ; i < stringArr.length -1; i++){
			char firstChar = stringArr[i];
			char secondChar = stringArr[i+1];
			for( int j = i + 2; j < stringArr.length; j++){
				char currChar = stringArr[j];
				lastIdx = j;
				if(currChar != firstChar && currChar != secondChar){
					break;
				}
			}
			System.out.printf(" start index %d and curr index %d \n", i, lastIdx);	
		}
	}
}
