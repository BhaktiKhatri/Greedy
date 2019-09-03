package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Leetcode 56. Merge Intervals
 * https://leetcode.com/problems/merge-intervals/description/
 * Given a collection of intervals, merge all overlapping intervals.
 * For example, Given [1,3],[2,6],[8,10],[15,18], return [1,6],[8,10],[15,18].
 * Explanation and code https://leetcode.com/problems/merge-intervals/solution/ https://leetcode.com/problems/merge-intervals/discuss/21222
 * @author NisuBhakti
 * Time complexity : O(nlgn), Other than the sort invocation, we do a simple linear scan of the list, so the runtime is dominated by the O(nlgn) complexity of sorting.
 * Space complexity : O(1) or O(n), If we can sort intervals in place, we do not need more than constant additional space. Otherwise, we must allocate linear space to store a copy of intervals and sort that.
 * Explanation and Code from: @kevinhsu https://leetcode.com/problems/merge-intervals/discuss/21276/A-clean-java-solution
 * Medium
 * Microsoft, Google, Facebook, Bloomberg, LinkedIn, Twitter, Yelp
 */

class Intervall {
	int start;
	int end;
	
	Intervall() {
		start = 0; end = 0; 
	}
	
	Intervall(int s, int e) {
		start = s; 
		end = e; 
	}
}

public class MergeIntervals {
	
    public static List<Intervall> merge(List<Intervall> intervals) {
        if(intervals.size() <= 1) 
        	return intervals;
        
        Collections.sort(intervals, new Comparator<Intervall>() {
            public int compare(Intervall i1, Intervall i2) {
                return i1.start - i2.start;
            }
        });
        
        for(int i=0; i<intervals.size()-1; i++) {
        	System.out.println(i);
            if(intervals.get(i).end >= intervals.get(i+1).start) {
                intervals.get(i).end = Math.max(intervals.get(i).end,intervals.get(i+1).end);
                intervals.remove(i+1);
                i--;
            }
        }
        //System.out.println(intervals.get(0).start+" "+intervals.get(0).end);
        
        return intervals;
    }
    
	//0,2; 1,4; 3,5
	public static void main(String[] args) {
		Intervall interval1 = new Intervall(1,4);
		Intervall interval2 = new Intervall(0,2);
		Intervall interval3 = new Intervall(3,5);
		
		List<Intervall> intervals = new ArrayList<>();
		intervals.add(interval1);
		intervals.add(interval2);
		intervals.add(interval3);
		
//		intervals.add(interval1);
//		intervals.add(interval2);
//		intervals.add(interval3);
//		intervals.add(interval4);

		System.out.println(merge(intervals));
		
	}

}
