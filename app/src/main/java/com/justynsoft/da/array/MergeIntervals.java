package com.justynsoft.da.array;

import java.util.*;

public class MergeIntervals {
    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        public String toString() {
            return "start: " + start + " end: " + end;
        }
    }

    public static List<Interval> mergeSorted(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        //first sort based on the start
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        Interval inProgressInterval = null;
        int count = 0;
        while (count < intervals.size()) {

            //if we don't have inProgressInterval (1. first item, 2. get reset)
            if (inProgressInterval == null) {
                //compare current interval with next, if can merge, create inProgressInterval, store the start and end, then jump to next.next
                if (count < intervals.size() - 1 && ((inProgressInterval = shouldMerge(intervals.get(count),intervals.get(count + 1)))) != null){
                    count = count + 2;
                } else {
                    //if we can not merge current item and next item, and we just put current item into the unresolved result;
                    result.add(new Interval(intervals.get(count).start, intervals.get(count).end));
                    count = count + 1;
                }
            } else {
                //if we can not merge current item, we save the in progress interval into result
                if ((shouldMerge(inProgressInterval, intervals.get(count))) == null) {
                    result.add(new Interval(inProgressInterval.start, inProgressInterval.end));
                    //reset inProgressInterval
                    inProgressInterval = null;
                } else { //if we can merge, then we continue to merge the current item
                    inProgressInterval = shouldMerge(inProgressInterval, intervals.get(count));
                    //in this case, we need to jump to next.next
                    count = count + 1;
                }
            }
        }

        //last one is not added in the result yet
        if (inProgressInterval != null) {
            result.add(new Interval(inProgressInterval.start, inProgressInterval.end));
        }


        return result;
    }

    public static void main(String[] args) {
        // [[1,2],[2,6],[8,10],[15,18]]
        List<Interval> arry = new ArrayList<>();
        Interval i1 = new Interval(2, 3);
        arry.add(i1);
        Interval i2 = new Interval(2, 2);
        arry.add(i2);
        Interval i3 = new Interval(3, 3);
        arry.add(i3);
        Interval i4 = new Interval(1, 3);
        arry.add(i4);
        Interval i5 = new Interval(5, 7);
        arry.add(i5);
        Interval i6 = new Interval(2, 2);
        arry.add(i6);
        Interval i7 = new Interval(4, 6);
        arry.add(i7);
        List<Interval> result = mergeSorted(arry);
        System.out.println(result);
    }

    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        List<Interval> unresolved = new ArrayList<>();

        if (intervals == null || intervals.size() == 0) {
            return result;
        }
        Interval inProgressInterval = null;
        int count = 0;
        while (count < intervals.size()) {

            //if we don't have inProgressInterval (1. first item, 2. get reset)
            if (inProgressInterval == null) {
                //compare current interval with next, if can merge, create inProgressInterval, store the start and end, then jump to next.next
                if (count < intervals.size() - 1 && ((inProgressInterval = shouldMerge(intervals.get(count),intervals.get(count + 1)))) != null){
                    count = count + 2;
                } else {
                    //if we can not merge current item and next item, and we just put current item into the unresolved result;
                    unresolved.add(new Interval(intervals.get(count).start, intervals.get(count).end));
                    count = count + 1;
                }
            } else {
                //if we can not merge current item, we save the in progress interval into result
                if ((shouldMerge(inProgressInterval, intervals.get(count))) == null) {
                    result.add(new Interval(inProgressInterval.start, inProgressInterval.end));
                    //reset inProgressInterval
                    inProgressInterval = null;
                } else { //if we can merge, then we continue to merge the current item
                    inProgressInterval = shouldMerge(inProgressInterval, intervals.get(count));
                    //in this case, we need to jump to next.next
                    count = count + 2;
                }
            }
        }

        //last one is not added in the result yet
        if (inProgressInterval != null) {
            result.add(new Interval(inProgressInterval.start, inProgressInterval.end));
        }

        //need to merge the inProgressInterval with unresolved result
        List<Interval> found = new ArrayList<>();
        for( int i  =  0; i <result.size() ; i++){
            for(Interval unresolvedInterval: unresolved){
                if(shouldMerge(result.get(i), unresolvedInterval) != null){
                    result.set(i, shouldMerge(result.get(i), unresolvedInterval));
                    found.add(unresolvedInterval);
                }
            }
        }

        unresolved.removeAll(found);

        result.addAll(unresolved);

        return result;
    }

    public static Interval shouldMerge(Interval start, Interval end) {
        if(start.start <= end.start && start.end <= end.end){
            if(start.end >= end.start){
                return new Interval(start.start, end.end);
            }else{
                return null;
            }
        }else if(end.start <= start.start && end.end <= start.end){
            if(start.start <= end.end){
                return new Interval(end.start, start.end);
            }else{
                return null;
            }
        }else if(end.start >= start.start && end.end <= start.end){
            return start;
        }else if(start.start >= end.start && start.end <= end.end){
            return end;
        }else{
            return null;
        }
    }
}
