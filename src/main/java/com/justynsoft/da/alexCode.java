package com.justynsoft.da;

import java.util.*;

public class alexCode {

    public int[][] find(int numDest, int[][] allocation, int numDeliver){
        Map<Integer, int[]> map = new HashMap<>();
        for(int i = 0 ; i <= numDest ;  i++){
           map.put(allocation[i][0] ^ 2 + allocation[i][1] ^ 2, allocation[i]) ;
        }

        List<Integer> sortedKey = new ArrayList(map.keySet());
        Collections.sort(sortedKey);

        int[][] returnArrary = new int[numDeliver][2];
        for(int i= 0; i <= numDeliver; i++){
           returnArrary[i] = map.get(sortedKey.get(i)) ;
        }


        return returnArrary;

    }
}
