//https://leetcode.com/problems/find-the-duplicate-number/description/

/*Problem solving template

1. Did I understand the problem? yes or no ->Yes

        If no ask the person to provide with more details with examples
        If yes go to the next step

        What is the input(s)?
        	signed 32-bit integer x
        What is the expected output?
        return signed 32-bit integer x
        Do I’ve constraints to solve the problem? 
        	If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 
        Do Ive all the information to go to the next steps
        	Yes
        How big is your test data set will be?
			signed 32-bit integer x , after revers may come 64 
				
2. Test data set
        Minimum  3 data set including positive, negative and edge
        Example 1:

		Input: nums = [1,3,4,2,2]
		Output: 2
		Example 2:

		Input: nums = [3,1,3,4,2]
		Output: 3
		Example 3:

		Input: nums = [3,3,3,3,3]
		Output: 3
 
 		Input: nums = [1,1]
		Output: 1
        
        Validate with the interviewer if the data set is fine by his/ her assumptions

3. Do I know to solve it? ->Brute Force Approach
        Yes- great is there an alternate ?
        	No
        No - can I break the problem into sub problems?

4. Ask for hint (if you don’t know how to solve this5.  Do I know alternate solutions as well
        Yes- what are those?
        No- that is still fine, proceed to solve by what you know

Simple technique brute force

Pseudo Code for Brutrforce Approach:

1.First Loop through from 0 to n-1
2.Second Looth through from i to n
	a)Compare nums[i] == nums[j] if match return nums[i]
	
6. If you know the alternate solution find out the O-notations (performance)
7. Then, explain either both are the best (depends on the time)
        Approach 1:- start with the worst-> improve (optimize) ->  End up with the best
        Approach 2: Write down the options and benefits and code the best
8. Start always with the Pseudo code (explain the pseudo code to the interviewer with some test data)
    -write the code
9. Test against different test data
10. If it fails then debug to solve it
11. Optimize the code and remove unnecessary code*/

/*completion_criteria
Applied the problem solving template 
Solved the question using brute force and specific algoirthm
Pushed the code to github
Solved the question in leetcode and observed all TCs passed*/

package Week1.Assigments;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindDuplicateNumber_2706_3 {

	@Test
	public void test1() {
		int[] nums = { 1, 3, 4, 2, 2 };
		int expectedOutput1 = 2;
		int actualOutput1 = findDuplicate1(nums);
		Assertions.assertEquals(expectedOutput1, actualOutput1);
		int expectedOutput2 = 2;
		int actualOutput2 = findDuplicate2(nums);
		Assertions.assertEquals(expectedOutput2, actualOutput2);
	}

	@Test
	public void test2() {
		int[] nums = { 3, 1, 3, 4, 2 };
		int expectedOutput = 3;
		int actualOutput = findDuplicate1(nums);
		Assertions.assertEquals(expectedOutput, actualOutput);
		int expectedOutput2 = 3;
		int actualOutput2 = findDuplicate2(nums);
		Assertions.assertEquals(expectedOutput2, actualOutput2);
	}

	@Test
	public void test3() {
		int[] nums = { 3, 3, 3, 3, 3 };
		int expectedOutput = 3;
		int actualOutput = findDuplicate1(nums);
		Assertions.assertEquals(expectedOutput, actualOutput);
		int expectedOutput2 = 3;
		int actualOutput2 = findDuplicate2(nums);
		Assertions.assertEquals(expectedOutput2, actualOutput2);
	}

	@Test
	public void test4() {
		int[] nums = { 1, 1 };
		int expectedOutput = 1;
		int actualOutput = findDuplicate1(nums);
		Assertions.assertEquals(expectedOutput, actualOutput);
		int expectedOutput2 = 1;
		int actualOutput2 = findDuplicate2(nums);
		Assertions.assertEquals(expectedOutput2, actualOutput2);
	}

	// Brute force Approach
	public int findDuplicate1(int[] nums) {
		int duplicateEle = 0;// O(1)
		for (int i = 0; i < nums.length - 1; i++) {// O(N)
			for (int j = i + 1; j < nums.length; j++) {// O(N)
				if (nums[i] == nums[j])
					duplicateEle = nums[i];
			}
		}
		return duplicateEle;
	}

	// O(1)+O(N)*O(N)
	// O(N^2)==>time complexity

	// Array Solution
	public int findDuplicate2(int[] nums) {
		boolean[] visited = new boolean[nums.length];
		for (int num : nums) {
			if (visited[num]) {
				return num;
			}
			visited[num] = true;
		}
		return -1;
	}

	// Time Complexity=>O(N)

}
