//No leetcode link 

//Problem
/* Given an integer array find the index of the largest number?
 * arr={1,2,3,4,5};
 * Output: 4
 * 
 * 
 */

/*Problem solving template

1. Did I understand the problem? yes or no====>Yes

        If no ask the person to provide with more details with examples
        If yes go to the next step

        What is the input(s)?
        	Integer elements
        What is the expected output?
        	integer value 
        Do I’ve constraints to solve the problem?
        	No
        Do Ive all the information to go to the next steps
        	Yes
        How big is your test data set will be?
        	Not given 

2. Test data set
        Minimum  3 data set including positive, negative and edge
        positive
        	1.arr={1,2,3,4,5}, Output: 4
        	2.arr={1,2,3,4,5,5} Output: 4 or 5
        	
        	negative
        	3.arr={1,-1,2,-2} Output: 2
        	edge
        	4.arr={} output: throw Exception
        	5.arr=null output throw Exception
        	
        Validate with the interviewer if the data set is fine by his/ her assumptions
        	1.What is the minimum array Size, because need to identify max Element?
        	2.Does array elements has negative and positive Elements?
        	3.Suppose more than one max Element in array, which occurrence max Element index to return?
        	4.Suppose arr is Empty or null, what should return?
        	

3. Do I know to solve it?  --->Yes
        Yes- great is there an alternate ? 
        	a)Brutr Force Approach
        	B)Two Pointer Approach
        No - can I break the problem into sub problems?

4. Ask for hint (if you don’t know how to solve this5.  Do I know alternate solutions as well
        Yes- what are those?
        No- that is still fine, proceed to solve by what you know

Simple technique brute force
	
Pseudo Code for Brute Force Approch:
====================================
1.Declare MaxElementIndex as 0 and MinIntegerValue as MIN.INTEGERVALUE
2.If arr is null or Empty throw Exception
3.Loop through from 0 to array.length
	a)Compare MinIntegerValue>currentIterationIndexValue
		Yes->MinIntegerValue=currentIterationIndexValue and MaxElementIndex=currentIterationIndexValue
		No->Keep MinIntegerValue as it is
4.return MaxElementIndex

Pseudo Code for Two Pointer Approach:
====================================
1.Declare maxElement=arr[length-1] and maxIndex=rightPointer, leftPointer=0, rightPointer=arr.length-1
2.Loop through using While(leftPointer<rightPointer) 
		a)Compare left Pointer and rightPointer Array Element
			if(arr[leftPointer)<arr[rightPointer])
				leftPointer++;
				maxElement=arr[rightPointer]
				maxIndex=rightPointer
			else
				rightPointer--;
				maxElement=arr[leftPointer]
				maxIndex=leftPointer

3.return maxIndex

6. If you know the alternate solution find out the O-notations (performance)
		2.Two Pointer Approach

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
Applied the problem solving template --->Yes
Solved the question using brute force and specific algoirthm-->Yes
Pushed the code to github-->Yes
Solved the question in leetcode and observed all TCs passed-->Yes
*/

/*Completion Time - 50 mins*/


package Week1.Assigments;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindIndexOfLargestElement_2706_1 {

	@Test
	public void test1() {
		int[] arr = { 1, 2, 3, 4, 5 };
		int expectedIndex = 4;
		//int actualIndex = findLargestElementIndex(arr);
		//int actualIndex=findLargestElementIndex2(arr);
		int actualIndex=findLargestElementIndex3(arr);
		Assertions.assertEquals(expectedIndex, actualIndex, "Output mismatch");
	}

	@Test
	public void test2() {
		int[] arr = { 5, 1, 2, 3, 4, 5 };
		int expectedIndex = 0;
		//int actualIndex = findLargestElementIndex(arr);
		//int actualIndex=findLargestElementIndex2(arr);
		int actualIndex=findLargestElementIndex3(arr);
		Assertions.assertEquals(expectedIndex, actualIndex, "Output mismatch");
	}

	@Test
	public void test3() {
		int[] arr = { -5, 1, 2, 3, 4, 5 };
		int expectedIndex = 5;
		//int actualIndex = findLargestElementIndex(arr);
		//int actualIndex=findLargestElementIndex2(arr);
		int actualIndex=findLargestElementIndex3(arr);
		Assertions.assertEquals(expectedIndex, actualIndex, "Output mismatch");
	}

	@Test
	public void test4() {
		int[] arr = {};
		//findLargestElementIndex(arr);
		//findLargestElementIndex2(arr);
		findLargestElementIndex3(arr);
	}

	@Test
	public void test5() {
		int[] arr = null;
		//findLargestElementIndex(arr);
		//findLargestElementIndex2(arr);
		findLargestElementIndex3(arr);
	}

	//Brute Force Approach
	private int findLargestElementIndex(int[] arr) {
		if (arr == null || arr.length == 0) //No Execution 
			throw new RuntimeException("Array Input should not be Empty or null ");
		int maxElementIndex = -1, MaxIntegerValue = Integer.MIN_VALUE;// O(1)
		for (int i = 0; i < arr.length; i++) {// O(1)+O(N)+O(N)
			if (MaxIntegerValue < arr[i]) { 
				MaxIntegerValue = arr[i]; //O(N)
				maxElementIndex = i;//O(N)
			}
		}
		return maxElementIndex;
	}
	
	//O(1)+O(1)+O(N)+O(N)+O(N)+O(N)
	//O(3)+o(4N)
	//O(N)
	
	
	//Two Pointer Approach
	private int findLargestElementIndex2(int[] arr) {
		if (arr == null || arr.length == 0) //No Execution 
			throw new RuntimeException("Array Input should not be Empty or null ");
		int maxElement=arr[arr.length-1],maxIndex=arr.length-1,leftPointer=0,rightPointer=arr.length-1;//O(1)
		while(leftPointer<rightPointer) {//O(N/2)
			if(arr[leftPointer]<arr[rightPointer]) {//O(N/2)
				leftPointer++;
				maxElement=arr[rightPointer];
				maxIndex=rightPointer;
			}else {//O(N/2)
				rightPointer--;
				maxElement=arr[leftPointer];
				maxIndex=leftPointer;
			}
		}
		return maxIndex;
	}
	
	//O(1)+O(N/2)+O(N/2)+O(N/2)==>O(1)+O(3N/2)==>O(N)
	
	//Optimized Two Pointer Approach Code
	private int findLargestElementIndex3(int[] arr) {
		if (arr == null || arr.length == 0) //No Execution 
			throw new RuntimeException("Array Input should not be Empty or null ");
		int maxIndex=0,left=0,right=arr.length-1; //O(1)
		while(left<=right) {//O(N/2)
			if(arr[left]>arr[maxIndex]) //O(N/2)
				maxIndex=left;
			else if(arr[right]>arr[maxIndex])//O(N/2)
				maxIndex=right;
			left++; //O(N/2)
			right--; //O(N/2)
		}
		
		return maxIndex;
	}
	
	//O(1)+O(N/2)+O(N/2)+O(N/2)+O(N/2)+O(N/2)
	//O(1)+5(O(N/2)
	//O(N)
}



