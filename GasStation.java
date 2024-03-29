package Greedy;

import java.util.Arrays;

/*
 * 134. Gas Station
 * https://leetcode.com/problems/gas-station/
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an
 * empty tank at one of the gas stations.
 * Return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1.
 * Note: If there exists a solution, it is guaranteed to be unique. Both input arrays are non-empty and have the same length. Each element in the input 
 * arrays is a non-negative integer.
 * Example 1: Input: gas  = [1,2,3,4,5] cost = [3,4,5,1,2]; Output: 3
 * Explanation: Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
	Travel to station 4. Your tank = 4 - 1 + 5 = 8
	Travel to station 0. Your tank = 8 - 2 + 1 = 7
	Travel to station 1. Your tank = 7 - 3 + 2 = 6
	Travel to station 2. Your tank = 6 - 4 + 3 = 5
	Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
	Therefore, return 3 as the starting index.
	Example 2:
	
	Input: 
	gas  = [2,3,4]
	cost = [3,4,3]
	
	Output: -1
	
	Explanation:
	You can't start at station 0 or 1, as there is not enough gas to travel to the next station.
	Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
	Travel to station 0. Your tank = 4 - 3 + 2 = 3
	Travel to station 1. Your tank = 3 - 3 + 3 = 3
	You cannot travel back to station 2, as it requires 4 unit of gas but you only have 3.
	Therefore, you can't travel around the circuit once no matter where you start.
	
 * Explanation and Code from: https://leetcode.com/articles/gas-station/
 * Time complexity : O(N) since there is only one loop over all stations here.
 * Space complexity : O(1) since it's a constant space solution.
 */

public class GasStation {

	public static int canCompleteCircuit(int[] gas, int[] cost) {
	    int sumGas = 0;
	    int sumCost = 0;
	    int start = 0;
	    int tank = 0;
	    
	    for(int i=0; i<gas.length; i++) {
	        System.out.println("i: "+i+" gas[i]: "+gas[i]+" cost[i]: "+cost[i]+" sumGas: "+sumGas+" sumCost: "+sumCost+" tank: "+tank);
	    	
	    	sumGas = sumGas + gas[i];
	        sumCost = sumCost + cost[i];
	        tank = tank + gas[i] - cost[i];
	        
	        System.out.println("i: "+i+" tank: "+tank+" start: "+start);
	        
	        if (tank < 0) {
	            start = i + 1;
	            tank = 0;
	        }
	    }
	    System.out.println("sumGas: "+sumGas+" sumCost: "+sumCost+" tank: "+tank+" start: "+start);
	    
	    if (sumGas < sumCost) {
	        return -1;
	    } 
	    else {
	        return start;
	    }
	}
	
	//Refer this: https://leetcode.com/articles/gas-station/
	public static int canCompleteCircuit1(int[] gas, int[] cost) {
	    int n = gas.length;

	    int total_tank = 0;
	    int curr_tank = 0;
	    int starting_station = 0;
	    
	    for(int i=0; i<n; i++) {
	      System.out.println("i: "+i+" gas[i]: "+gas[i]+" cost[i]: "+cost[i]+" total_tank: "+total_tank+" curr_tank: "+curr_tank+" starting_station: "+starting_station);
	    	
	      total_tank = total_tank + gas[i] - cost[i];
	      curr_tank = curr_tank + gas[i] - cost[i];

	      System.out.println("total_tank: "+total_tank+" curr_tank: "+curr_tank);
	      
	      // If one couldn't get here,
	      if (curr_tank < 0) {
	      
	    	 // Pick up the next station as the starting one.
	        starting_station = i + 1;
	        
	        // Start with an empty tank.
	        curr_tank = 0;
	      }
	    }
	    System.out.println("total_tank: "+total_tank+" curr_tank: "+curr_tank+" starting_station: "+starting_station);
	    
	    return total_tank >= 0 ? starting_station : -1;
	  }
	
	public static void main(String[] args) {
		int[] gas = {1,2,3,4,5};
		int[] cost = {3,4,5,1,2};
		
		System.out.println("gas: "+Arrays.toString(gas));
		System.out.println("cost: "+Arrays.toString(cost));
		
		System.out.println(canCompleteCircuit1(gas, cost));
	}
}