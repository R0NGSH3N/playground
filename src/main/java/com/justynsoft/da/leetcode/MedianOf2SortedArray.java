package com.justynsoft.da.leetcode;

public class MedianOf2SortedArray{

	public static void main(String[] args){

	}

	/**
	public static int findMedianOf2SortedArray(int[] A, int[] B){
		int lengthA = A.length;
		int lengthB = B.length;
		int[] mediansIdx = new int[2];
		if( (A+B)%2 == 0){
			mediansIdx[0] = (A + B) /2;
			mdeiansIdx[1] = mediansIdx[0] + 1;
		}else{
			mediansIdx[0] = ((A + B )/2) + 1;
		}

		int i=0, j = 0,counter = 0;
		int median1 = 0, median2 = 0;
		for(int 
			if(lengthA[i] < length[j]){
				median1 = lengthA[i];
				median2 = lengthB[j];
				i++;	
			}else{
				median1 = lengthB[j];
				median2 = lengthA[i];
				j++;
			}

			if(counter = mediansIdx[0]){
				if(mediansIdx.length == 1){
					return median1;
				}else{
					return (median1 + median2) /2;
				}
				break;
			}
			counter++;
		}

		if(median1 == median2 == 0){
			if(lengthB > lengthA){
				
			}else{

			}
		}
    }
	 **/
}
