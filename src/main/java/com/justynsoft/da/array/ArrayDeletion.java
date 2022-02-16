package com.justynsoft.da.array;
import java.util.Arrays;

/**
 * Created by ronghen on 1/27/15.
 */
public class ArrayDeletion {
    public static void main(String[] args) {
        int[] originalArr = {1, 34, 56, 87, 5, 45, 4, 57, 87, 56};
        int[] targetArr = Arrays.copyOf(originalArr, 9);
        int deletePos = 4;

        System.out.println(" delete position: " + deletePos);
        for (int i = deletePos; i < targetArr.length - 1; i++) {
            targetArr[i - 1] = targetArr[i];
        }
        System.out.println(" Array after deletion : " + Arrays.toString(targetArr));
    }
}
