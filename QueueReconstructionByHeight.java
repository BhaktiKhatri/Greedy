package Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/*
 * 406. Queue Reconstruction by Height
 * https://leetcode.com/problems/queue-reconstruction-by-height/description/
 * Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and 
 * k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.
 * Note: The number of people is less than 1,100
 * Example Input: [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * Output: [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 * Explanation and Code from: @zeller2 https://leetcode.com/problems/queue-reconstruction-by-height/discuss/89345/Easy-concept-with-PythonC++Java-Solution
 * https://translate.google.com/translate?hl=en&sl=zh-CN&u=http://hongzheng.me/leetcode/leetcode-406-queue-reconstruction-by-height/&prev=search
 * https://www.youtube.com/watch?v=QjBlSqGEfw4
 * Google
 * Medium
 * Time Complexity: Sorting takes O(nlogn) and insertion takes O(n^2) so total complexity is O(n^2); Space complexity: O(n)
 * As for the Java version, the time complexity should be O(nlogn) + O(n^2) = O(n^2), and the space complexity should be O(n), where n denotes the number of people.
 */

public class QueueReconstructionByHeight {

	//Refer https://www.youtube.com/watch?v=SzzSwvQfKyk for Arrays.sort(comparator);
	public static int[][] reconstructQueue(int[][] people) {
        //pick up the tallest guy first when insert the next tall guy, just need to insert him into kth position repeat until all 
		//people are inserted into list
        Arrays.sort(people,new Comparator<int[]>() {
           @Override
           public int compare(int[] o1, int[] o2) {
        	   System.out.println("o1: "+Arrays.toString(o1)+" o2: "+Arrays.toString(o2)+" o1[0]: "+o1[0]+" o2[0]: "+o2[0]+" o2[0] - o1[0]: "+(o2[0] - o1[0]));
        	   
               if (o1[0] != o2[0]) 			//o1 < o2 = -1; o1 > o2 = 1; o1 = o2 = 0
            	   return o2[0] - o1[0];	//descending order based on h height of people
               else 
            	   return o1[1] - o2[1];	//ascending order based on k 
           }
        });
        
        /*
         * suppose h1=o1[0], h2=o2[0], k1=o1[1], k2=o2[1]
			if h1 != h2, bigger one comes first
			if h1 == h2, one with small k comes first
         */
        
        System.out.println();
        
        for(int i=0; i<people.length; i++) {
			System.out.print(Arrays.toString(people[i]));
		}
        
        System.out.println();
        System.out.println();
        
        List<int[]> res = new LinkedList<>();
        
        for(int[] cur : people) {
        	System.out.println("cur: "+Arrays.toString(cur)+" cur[1]: "+cur[1]);
            res.add(cur[1], cur);       
            //System.out.println("res: "+Arrays.toString(res.toArray()));
        }
        //System.out.println("res: "+res);
        
        return res.toArray(new int[people.length][]);
    }
	
	public static void main(String[] args) {
		int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
		
		for(int i=0; i<people.length; i++) {
			System.out.print(Arrays.toString(people[i]));
		}
		
		System.out.println();
		System.out.println();
		
		people = reconstructQueue(people);
		
		System.out.println();
		
		for(int i=0; i<people.length; i++) {
			System.out.print(Arrays.toString(people[i]));
		}
	}

}
