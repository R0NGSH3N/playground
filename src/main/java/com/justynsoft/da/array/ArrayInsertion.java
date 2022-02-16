package com.justynsoft.da.array;

import java.util.Arrays;

/**
 * Created by rongshen on 1/27/15.
 */
public class ArrayInsertion {
    public static void main(String[] args) {
        int[] originalArr = {1, 34, 56, 87, 5, 45, 4, 57, 87, 56};
        int[] targetArr = Arrays.copyOf(originalArr, 11);
        int insertionPos = 4;
        int insertionInt = 9999;

        System.out.println(" insert position: " + insertionPos );
        System.out.println(" insert value: " + insertionInt);
        for (int i = originalArr.length - 1; i >= insertionPos -1 ; i--) {
            System.out.println(" i:: " + i + "; originArr[i]:: " + originalArr[i]);
            targetArr[i + 1] = targetArr[i];
            if (i == insertionPos -1 ) {
                System.out.println(" insert pos:" + insertionPos + " insert value: " + insertionInt);
                targetArr[i] = insertionInt;
            }
        }

        System.out.println(" Array after Insert: " + Arrays.toString(targetArr));
    }
}
