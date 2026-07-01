//https://leetcode.com/problems/reverse-integer/description/

/*Problem solving template

1. Did I understand the problem? yes or no

        If no ask the person to provide with more details with examples
        If yes go to the next step

        What is the input(s)?
        What is the expected output?
        Do I’ve constraints to solve the problem?
        Do Ive all the information to go to the next steps
        How big is your test data set will be?

2. Test data set
        Minimum  3 data set including positive, negative and edge
        Validate with the interviewer if the data set is fine by his/ her assumptions

3. Do I know to solve it?
        Yes- great is there an alternate ?
        No - can I break the problem into sub problems?

4. Ask for hint (if you don’t know how to solve this5.  Do I know alternate solutions as well
        Yes- what are those?
        No- that is still fine, proceed to solve by what you know

Simple technique brute force


Pseudo Code for Brutrforce Approach: x=123
------------------------------------
1.Declare long variable to store reverse int value
2.Using Math concept to Reverse given integer number
	while(x!=0)
		x=x/10;==>12 1
		int reminder=num%10; 3 2 1
		reversedVlaue=reversedVlaue+reminder; 3+2+1
3.reversedVlaue should in int -32 bit range 
		if(reversedVlaue<Integer.MinValue || reversedVlaue>Integer.MaxValue)
			return 0;
4.return (int)reversedVlaue;


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
Applied the problem solving template ->Yes
Solved the question using brute force and specific algoirthm ->Yes
Pushed the code to github - >Yes
Solved the question in leetcode and observed all TCs passed ->Yes */

package Week1.Assigments;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReverseOfDigits_2806_4 {

	@Test
	public void test1() {
		int x = -123;
		int expectedValue = -321;
		int actualValue = findReverseDigit(x);
		Assertions.assertEquals(expectedValue, actualValue);
	}

	public int findReverseDigit(int x) {
		if (x == 0)//O(1)
			return 0;
		boolean isNegative = x < 0;//O(1)
		long inputX = Math.abs((long) x);//O(1)
		String reversed = "";//O(1)
		while (inputX != 0) {//O(N)
			long reminder = inputX % 10;
			inputX = inputX / 10;
			reversed = reversed + reminder;//O(N)
		}
		if (isNegative) {//O(1)
			reversed = "-" + reversed;
		}
		long reversedNumber = Long.parseLong(reversed);//O(N)
		if (reversedNumber < Integer.MIN_VALUE || reversedNumber > Integer.MAX_VALUE)//O(1)
			return 0;
		return (int) reversedNumber;//O(1)
	}
//O(1)+O(1)+O(1)+O(1)+O(N)*O(N)+O(1)+O(N)+O(1)==>O(N^2)
	
	
	// Optimized Approach using Math
	public int findReverseDigit1(int x) {
		// Use a 64-bit long to accumulate the reversed number
		long reversedNumber = 0;

		while (x != 0) {
			// Java % and / handles -2147483648 perfectly without needing Math.abs()
			reversedNumber = (reversedNumber * 10) + (x % 10);
			x = x / 10;
		}

		// When reversing -2147483648, the result (-8463847412) safely fits in a long.
		// This check will now catch it and correctly return 0 as required!
		if (reversedNumber < Integer.MIN_VALUE || reversedNumber > Integer.MAX_VALUE) {
			return 0;
		}

		return (int) reversedNumber;
	}

}