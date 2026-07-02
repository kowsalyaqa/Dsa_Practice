//https://leetcode.com/problems/majority-element/description/

/*Problem solving template

1. Did I understand the problem? yes or no-->Yes

        If no ask the person to provide with more details with examples
        If yes go to the next step

        What is the input(s)?
        		an array nums of size n
        What is the expected output?
        		return the majority element. -->Return array Element int type
        Do I’ve constraints to solve the problem?
        		yes
        Do Ive all the information to go to the next steps
        		yes
        How big is your test data set will be?4
        n == nums.length
		1 <= n <= 5 * 104
		-109 <= nums[i] <= 109

2. Test data set
        Minimum  3 data set including positive, negative and edge
        Positive:
        Example 1:
		Input: nums = [3,2,3]
		Output: 3
		
		Example 2:
		Input: nums = [2,2,1,1,1,2,2]
		Output: 2
		
		Negative:
		Input: nums = [1]
		Output: 1
		
		Edge case:
		Input: nums = [3,3,4]
		Output: 3
		
		Input: nums = [4,3,3]
		Output: 3
		
        Validate with the interviewer if the data set is fine by his/ her assumptions

3. Do I know to solve it? ->Brute force
        Yes- great is there an alternate ?
        		
        No - can I break the problem into sub problems?

4. Ask for hint (if you don’t know how to solve this5.  Do I know alternate solutions as well
        Yes- what are those?
        No- that is still fine, proceed to solve by what you know

Simple technique brute force

Pseudo Code for Brute Force Approach:
1.Declare majorityElement=0, maxcount=0
2.Outer Loop starts from 0 to nums.length
	0) suppose nums.length==1 ,then return nums[0]
	a) Declare count=0
	b)Inner loop starts from i-1  to nums.length
		d)Compare nums[i]==nums[j]
			count++;
	c)Once complete inner loop, check count value is greater than maxCount
			if(maxcount<count)
				maxXount=count
				majorityElement=nums[i]
	d)return major Element


6. If you know the alternate solution find out the O-notations (performance)
7. Then, explain either both are the best (depends on the time)
        Approach 1:- start with the worst-> improve (optimize) ->  End up with the best
        Approach 2: Write down the options and benefits and code the best
8. Start always with the Pseudo code (explain the pseudo code to the interviewer with some test data)
    -write the code
9. Test against different test data
10. If it fails then debug to solve it
11. Optimize the code and remove unnecessary code*/

/*
completion_criteria
Applied the problem solving template 
Solved the question using brute force and specific algoirthm
Pushed the code to github
Solved the question in leetcode and observed all TCs passed*/

package Week1.Assigments;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MajorityElement_2906_6 {

	@Test
	public void test1() {
		int[] arr = { 3, 2, 3 };
		int expectedIndexCount = 3;
		//int actualIndexCount = majorityElement(arr);
		int actualIndexCount = majorityElement2(arr);
		Assertions.assertEquals(expectedIndexCount, actualIndexCount, "Output mismatch");
	}

	@Test
	public void test2() {
		int[] arr = { 2, 2, 1, 1, 1, 2, 2 };
		int expectedIndexCount = 2;
		//int actualIndexCount = majorityElement(arr);
		int actualIndexCount = majorityElement2(arr);
		Assertions.assertEquals(expectedIndexCount, actualIndexCount, "Output mismatch");
	}

	@Test
	public void test3() {
		int[] arr = { 1 };
		int expectedIndexCount = 1;
		//int actualIndexCount = majorityElement(arr);
		int actualIndexCount = majorityElement2(arr);
		Assertions.assertEquals(expectedIndexCount, actualIndexCount, "Output mismatch");
	}

	@Test
	public void test4() {
		int[] arr = { 3, 3, 4 };
		int expectedIndexCount = 3;
		//int actualIndexCount = majorityElement(arr);
		int actualIndexCount = majorityElement2(arr);
		Assertions.assertEquals(expectedIndexCount, actualIndexCount, "Output mismatch");
	}

	@Test
	public void test5() {
		int[] arr = { 4, 3, 3 };
		int expectedIndexCount = 3;
		//int actualIndexCount = majorityElement(arr);
		int actualIndexCount = majorityElement2(arr);
		Assertions.assertEquals(expectedIndexCount, actualIndexCount, "Output mismatch");
	}

	// Brute Force Approach
	private int majorityElement(int[] nums) { //3,3,2
		if (nums.length == 1)//O(1)
			return nums[0];
		int maxCount = 0, majorElement = 0;//O(1)
		for (int i = 0; i < nums.length; i++) {//O(N)
			int count = 0;
			for (int j = i + 1; j < nums.length; j++) {//Each time 1 will reduce (n-0)+(n-1)+(n-2)+---=> (3-0)+(3-1)+(3-0)=>2+1+0==>(n-1) - n/2
				if (nums[i] == nums[j])//O(n-1)
					count++;//O(n-1)
			}
			if (maxCount < count) {//O(n)
				maxCount = count;//O(1)
				majorElement = nums[i];//O(1)
			}
		}
		return majorElement;
	}
	
	//Maximum Worst Time Complexity=>O(n^2)

	//Boyer-Moore Voting Algorithm for O(N) Time Complexity
	public int majorityElement2(int[] nums) {//3,3,2
	    int count = 0; //O(1)
	    int candidate = 0;//O(1)
	    for (int num : nums) {//O(N)
	        if (count == 0) {//O(1)+O(1)
	            candidate = num;//O(1)+O(1)
	        }
	        count += (num == candidate) ? 1 : -1;//O(1)+O(1)+O(1)
	    }
	    return candidate;//O(1)
	}
	
	//Time Complexity : O(N)
	
}
