package Greedy;

import java.util.Arrays;
import java.util.Comparator;

/*
 * 252. Meeting Rooms
 * https://leetcode.com/problems/meeting-rooms/
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
 * Example 1: Input: [[0,30],[5,10],[15,20]]; Output: false
 * Example 2: Input: [[7,10],[2,4]]; Output: true
 * Explanation and Code from: @jeantimex https://leetcode.com/problems/meeting-rooms/discuss/67786/AC-clean-Java-solution
 * In the above implementation, you use the sort method to get all objects sorted - O(nlogn) time complexity.
 * After sorting you go through each object comparing it with the previous object to find if there is an overlap - O(n) time complexity.
 */

public class MeetingRooms {

	public static boolean canAttendMeetings(Interval[] intervals) {
		if(intervals.length == 0 || intervals == null)
            return true;

		  // Sort the intervals by start time
		  Arrays.sort(intervals, new Comparator<Interval>() {
		    public int compare(Interval a, Interval b) { return a.start - b.start; }
		  });
		  
		  for(int i=0; i<intervals.length-1; i++) {
			    if(intervals[i].end > intervals[i+1].start) {	//if overlap then return false
			      return false;
			    }
		  }
		  
		  return true;
	}

	
	public static void main(String[] args) {

	}

}
