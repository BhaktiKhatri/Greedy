package Greedy;

import java.util.Arrays;
import java.util.Comparator;

/*
 * 435. Non-overlapping Intervals
 * https://leetcode.com/problems/non-overlapping-intervals/
 * Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
 * Note: You may assume the interval's end point is always bigger than its start point.
 * Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
 * Example 1: Input: [ [1,2], [2,3], [3,4], [1,3] ]; Output: 1
 * Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
 * Example 2: Input: [ [1,2], [1,2], [1,2] ]; Output: 2
 * Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
 * Example 3: Input: [ [1,2], [2,3] ]; Output: 0
 * Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 * Explanation and Code from: @crickey180 https://leetcode.com/problems/non-overlapping-intervals/discuss/91713/Java%3A-Least-is-Most
 * Sorting Interval.end in ascending order is O(nlogn), then traverse intervals array to get the maximum number of non-overlapping intervals is O(n). Total is O(nlogn).
 */

class Interval {
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
}

public class NonOverlappingInterval {

    public static int eraseOverlapIntervals(Interval[] intervals) {
        if(intervals.length == 0) {  
        	return 0;
        }
        
        for(int i=0; i<intervals.length; i++) {
        	System.out.println("["+intervals[i].start+","+intervals[i].end+"]");
        }
        
        Arrays.sort(intervals, new myComparator());
        for(int i=0; i<intervals.length; i++) {
        	System.out.println("["+intervals[i].start+","+intervals[i].end+"]");
        }
        
        int end = intervals[0].end;
        int count = 1; 	//count of non-overlapping interval
        
        System.out.println("end: "+end+" count: "+count);

        for(int i=1; i<intervals.length; i++) {
        	System.out.println("i: "+i+" intervals[i].start: "+intervals[i].start+" intervals[i].end: "+intervals[i].end+" end: "+end);
        	
            if(intervals[i].start >= end) {	//non-overlapping interval
                end = intervals[i].end;		//increase count of non-overlapping interval
                count++;
                System.out.println("end: "+end+" count: "+count);
            }
        }
        System.out.println("intervals.length: "+intervals.length+" count: "+count);
        
        return intervals.length - count;	//count of overlapping interval = total length - count of non-overlapping interval
    }
    
    /*
     * Sort intervals by end because:
     * e.g. [ [1,4], [2,3], [3,4] ], the interval with early start might be very long and incompatible with many intervals. 
     * But if we choose the interval that ends early, we'll have more space left to accommodate more intervals.
     */
    static class myComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
        	System.out.println("a.start: "+a.start+" a.end: "+a.end+" b.start: "+b.start+" b.end: "+b.end+" a.end - b.end: "+(a.end - b.end));
            return a.end - b.end;
        }
    }
	
	public static void main(String[] args) {
		Interval interval1 = new Interval(1,2);
		Interval interval2 = new Interval(2,3);
		Interval interval3 = new Interval(3,4);
		Interval interval4 = new Interval(1,3);
		
		Interval[] intervals = {interval1, interval2, interval3, interval4};
		System.out.println(eraseOverlapIntervals(intervals));
	}
}