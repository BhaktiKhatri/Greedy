package Greedy;

import java.util.ArrayList;
import java.util.List;

/*
 * 763. Partition Labels
 * https://leetcode.com/problems/partition-labels/description/
 * A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.
 * Example 1: Input: S = "ababcbacadefegdehijhklij"; Output: [9,7,8]; 
 * Explanation:The partition is "ababcbaca", "defegde", "hijhklij". This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 * Note:S will have length in range [1, 500]. S will consist of lowercase letters ('a' to 'z') only.
 * Explanation and Code from: @samuel.y.t.ji https://leetcode.com/problems/partition-labels/discuss/113259/Java-2-pass-O(n)-time-O(1)-space-extending-end-pointer-solution
 * https://leetcode.com/problems/partition-labels/solution/
 * Time Complexity: O(N), where N is the length of S; Space Complexity: O(N)
 * Amazon
 * Medium
 */

public class PartitionLabels {

	/*
	 * 1. traverse the string record the last index of each char
	 * 2. using pointer to record end of the current sub string
	 */
	public static List<Integer> partitionLabels(String S) {
        int[] map = new int[26];
        
        System.out.println("S: "+S);
        
        for(int i=0; i < S.length(); i++) {
        	System.out.println("i: "+i+" S.charAt(i): "+S.charAt(i));
            map[S.charAt(i) - 'a'] = i;
        }
        
        int last = 0;
        int start = 0;
        List<Integer> ans = new ArrayList<Integer>();
        
        for(int i=0; i<S.length(); i++) {
        	System.out.println("i: "+i+" last: "+last+" S.charAt(i): "+S.charAt(i)+" (S.charAt(i) - 'a'): "+(S.charAt(i) - 'a')+" map[S.charAt(i) - 'a']: "+map[S.charAt(i) - 'a']);
            last = Math.max(last, map[S.charAt(i) - 'a']);
            
            System.out.println("i: "+i+" last: "+last+" start: "+start);
            
            if(last == i) {
                ans.add(last - start + 1);
                start = i + 1;
            }
        }
        
        System.out.println("start: "+start+" ans: "+ans);
        return ans;
    }
	
	public static void main(String[] args) {
		String S = "ababcbacadefegdehijhklij";
		System.out.println(partitionLabels(S));
	}

}
