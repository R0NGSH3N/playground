package com.justynsoft.da.leetcode;

public class StringMatch1{
	public static void main(String[] args){
		String source="we jump over a stack.";
		String target="stack";
		findString(source, target);
	}

	public static int findString(String source, String target){
		int N = source.length();
		int M = target.length();
		for(int i = 0 ;  i < N - M;  i++){
			int j = 0;
			for(j = 0 ;  j < M ; j++){
				if(source.charAt(i+j) != target.charAt(j)){
					break;
				}
			}
			if(j == M) { return i;}
		}
		return -1;

	}

	public static int findString2(String source, String target){
		int N = source.length();
		int M = source.length();
		
		for( int i = 0 ;  i  < N - M;  i+=M){
			if(source.substring(i, i+M).equals(target)){
				return i;
			}
		}

		return -1;
	}
}
