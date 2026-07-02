//https://leetcode.com/problems/missing-number/description/

/*Problem solving template

1. Did I understand the problem? yes or no

        If no ask the person to provide with more details with examples
        If yes go to the next step

        What is the input(s)?
        		an array nums containing n distinct numbers in the range [0, n]
        What is the expected output?
        		return the only number in the range that is missing from the array.
        Do I’ve constraints to solve the problem?
        			n == nums.length
				1 <= n <= 104
				0 <= nums[i] <= n
				All the numbers of nums are unique.
        Do Ive all the information to go to the next steps
        			Yes
        How big is your test data set will be?
        		1 <= n <= 104

2. Test data set
        Minimum  3 data set including positive, negative and edge
        Positive:
        Example 1:
		Input: nums = [3,0,1]
		Output: 2
		Explanation:
		n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.

		Example 2:
		Input: nums = [0,1]
		Output: 2
		Explanation:
		n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
		
		Example 3:
		Input: nums = [9,6,4,2,3,5,7,0,1]
		Output: 8
		Explanation:
		n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
        
       Edge Case:
		Input: nums = [0]
		Output: 1
		
		Input: nums = [1]
		Output: 0
		
        Validate with the interviewer if the data set is fine by his/ her assumptions

3. Do I know to solve it? --->Yes 
        Yes- great is there an alternate ?
        		Frequency Array  and Math
        No - can I break the problem into sub problems?

4. Ask for hint (if you don’t know how to solve this5.  Do I know alternate solutions as well
        Yes- what are those?
        No- that is still fine, proceed to solve by what you know

Simple technique brute force

Pseudo Code for Brute Force Approach:
1.Declare int totalelemSum = 0, i = 0, j = 0, sum = 0
2.First Sum 0+nums.length and store in totalelemSum
3.Sum given elements then store in sum
4.Difference between totalelemSum- sum, return missing element

Pseudo Code for Frequency Array Approach:
1.Declare new int array with length+1 Size to cover range properly
2.Loop through new array for given array length 0 to length-1
		a)Store 1 on tracker array index if index and array value matches 
3.Iterate while (i<nums.length) 
		if(i!==nums[i]) return i

6. If you know the alternate solution find out the O-notations (performance)
7. Then, explain either both are the best (depends on the time)
        Approach 1:- start with the worst-> improve (optimize) ->  End up with the best
        Approach 2: Write down the options and benefits and code the best
8. Start always with the Pseudo code (explain the pseudo code to the interviewer with some test data)
    -write the code
9. Test against different test data -->Yes
10. If it fails then debug to solve it -->Yes
11. Optimize the code and remove unnecessary code*/

/*
completion_criteria
Applied the problem solving template  ->Yes
Solved the question using brute force and specific algoirthm ->Yes
Pushed the code to github ->Yes
Solved the question in leetcode and observed all TCs passed  ->Yes*/

package Week1.Assigments;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MissingNumber_2906_7 {
	@Test
	public void test1() {
		int[] arr = { 3, 0, 1 };
		int expectedIndexCount = 2;
		int actualIndexCount = missingNumber(arr);
		Assertions.assertEquals(expectedIndexCount, actualIndexCount, "Output mismatch");
		int actualIndexCount1 = missingNumber1(arr);
		Assertions.assertEquals(expectedIndexCount, actualIndexCount1, "Output mismatch");
		int actualIndexCount2 = missingNumber2(arr);
		Assertions.assertEquals(expectedIndexCount, actualIndexCount2, "Output mismatch");
		int actualIndexCount3 = missingNumber3(arr);
		Assertions.assertEquals(expectedIndexCount, actualIndexCount3, "Output mismatch");
		int actualIndexCount4 = missingNumber4(arr);
		Assertions.assertEquals(expectedIndexCount, actualIndexCount4, "Output mismatch");
		int actualIndexCount5 = missingNumber5(arr);
		Assertions.assertEquals(expectedIndexCount, actualIndexCount5, "Output mismatch");
	}

	@Test
	public void test2() {
		int[] arr = { 0, 1 };
		int expectedIndexCount = 2;
		int actualIndexCount = missingNumber(arr);
		Assertions.assertEquals(expectedIndexCount, actualIndexCount, "Output mismatch");
		int actualIndexCount1 = missingNumber1(arr);
		Assertions.assertEquals(expectedIndexCount, actualIndexCount1, "Output mismatch");
		int actualIndexCount2 = missingNumber2(arr);
		Assertions.assertEquals(expectedIndexCount, actualIndexCount2, "Output mismatch");
		int actualIndexCount3 = missingNumber3(arr);
		Assertions.assertEquals(expectedIndexCount, actualIndexCount3, "Output mismatch");
		int actualIndexCount4 = missingNumber4(arr);
		Assertions.assertEquals(expectedIndexCount, actualIndexCount4, "Output mismatch");
		int actualIndexCount5 = missingNumber5(arr);
		Assertions.assertEquals(expectedIndexCount, actualIndexCount5, "Output mismatch");
	}

	@Test
	public void test3() {
		int[] arr = { 9, 6, 4, 2, 3, 5, 7, 0, 1 };
		int expectedIndexCount = 8;
		int actualIndexCount = missingNumber(arr);
		Assertions.assertEquals(expectedIndexCount, actualIndexCount, "Output mismatch");
		int actualIndexCount1 = missingNumber1(arr);
		Assertions.assertEquals(expectedIndexCount, actualIndexCount1, "Output mismatch");
		int actualIndexCount2 = missingNumber2(arr);
		Assertions.assertEquals(expectedIndexCount, actualIndexCount2, "Output mismatch");
		int actualIndexCount3 = missingNumber3(arr);
		Assertions.assertEquals(expectedIndexCount, actualIndexCount3, "Output mismatch");
		int actualIndexCount4 = missingNumber4(arr);
		Assertions.assertEquals(expectedIndexCount, actualIndexCount4, "Output mismatch");
		int actualIndexCount5 = missingNumber5(arr);
		Assertions.assertEquals(expectedIndexCount, actualIndexCount5, "Output mismatch");
	}
	
	@Test
	public void test4() {
		int[] arr = { 1 };
		int expectedIndexCount = 0;
		int actualIndexCount = missingNumber(arr);
		Assertions.assertEquals(expectedIndexCount, actualIndexCount, "Output mismatch");
		int actualIndexCount1 = missingNumber1(arr);
		Assertions.assertEquals(expectedIndexCount, actualIndexCount1, "Output mismatch");
		int actualIndexCount2 = missingNumber2(arr);
		Assertions.assertEquals(expectedIndexCount, actualIndexCount2, "Output mismatch");
		int actualIndexCount3 = missingNumber3(arr);
		Assertions.assertEquals(expectedIndexCount, actualIndexCount3, "Output mismatch");
		int actualIndexCount4 = missingNumber4(arr);
		Assertions.assertEquals(expectedIndexCount, actualIndexCount4, "Output mismatch");
		int actualIndexCount5 = missingNumber5(arr);
		Assertions.assertEquals(expectedIndexCount, actualIndexCount5, "Output mismatch");
	}

	@Test
	public void test5() {
		int[] arr = { 0 };
		int expectedIndexCount = 1;
		int actualIndexCount = missingNumber(arr);
		Assertions.assertEquals(expectedIndexCount, actualIndexCount, "Output mismatch");
		int actualIndexCount1 = missingNumber1(arr);
		Assertions.assertEquals(expectedIndexCount, actualIndexCount1, "Output mismatch");
		int actualIndexCount2 = missingNumber2(arr);
		Assertions.assertEquals(expectedIndexCount, actualIndexCount2, "Output mismatch");
		int actualIndexCount3 = missingNumber3(arr);
		Assertions.assertEquals(expectedIndexCount, actualIndexCount3, "Output mismatch");
		int actualIndexCount4 = missingNumber4(arr);
		Assertions.assertEquals(expectedIndexCount, actualIndexCount4, "Output mismatch");
		int actualIndexCount5 = missingNumber5(arr);
		Assertions.assertEquals(expectedIndexCount, actualIndexCount5, "Output mismatch");
	}
	
	// Brute Force Approach->Math Solution
	private int missingNumber(int[] nums) {
		int totalelemSum = 0, i = 0, j = 0, sum = 0;
		for (j = 0; j < (nums.length + 1); j++) {
			totalelemSum = totalelemSum + j;
		}
		while (i < nums.length) {
			sum = sum + nums[i];
			i++;
		}
		return totalelemSum - sum;
	}

	// Time Complexity: O(N)

	// Brute Force Approach->Frequency Array or Bucket Array method.
	private int missingNumber1(int[] nums) {
		int[] arrayTracker = new int[nums.length + 1];// added n+1 range cover
		for (int i = 0; i < nums.length; i++) {
			int val = nums[i];
			arrayTracker[val] = 1;
		}
		for (int j = 0; j < arrayTracker.length; j++) {
			if (arrayTracker[j] == 0) {
				return j;
			}
		}
		return -1;
	}
	// Time Complexity: O(N)

	// Sorting Alogorithm
	private int missingNumber2(int[] nums) {
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i) {
				return i;
			}
		}
		return nums.length;
	}
	// Time Complexity: O(N)

	// Using HashSet
	private int missingNumber3(int[] nums) {
		HashSet<Integer> set = new HashSet<>();
		for (int num : nums) {
			set.add(num);
		}

		for (int i = 0; i <= nums.length; i++) {
			if (!set.contains(i)) {
				return i;
			}
		}

		return -1;
	}
	// Time Complexity: O(N)

	// Using Binary search 
	private int missingNumber4(int[] nums) {
		Arrays.sort(nums);//O(logn)
		int left = 0;
		int right = nums.length; 
		while (left < right) {//O(n)
			int mid = left + (right - left) / 2;
			if (nums[mid] == mid) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return left;
	}
	// Time Complexity: O(nlogn)
	
	// Using XOR Opearation (Otimized Solution) - A^A->0, A^0->A(XOR Operation)
		private int missingNumber5(int[] nums) {
			int xorSum = 0;
		    for (int i = 0; i <= nums.length; i++) { //O(N) 
		        xorSum ^= i;
		    }
		    
		    for (int num : nums) {//O(N)
		        xorSum ^= num;
		    }
		  return xorSum;
		}
		// Time Complexity: O(N)
}
