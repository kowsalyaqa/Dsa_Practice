//https://leetcode.com/problems/reverse-integer/description/

/*Problem solving template

1. Did I understand the problem? yes or no -->Yes

        If no ask the person to provide with more details with examples
        If yes go to the next step

        What is the input(s)?
        		a signed 32-bit integer x
        What is the expected output?
        		return x with its digits reversed
        Do I’ve constraints to solve the problem?
        		If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
        Do Ive all the information to go to the next steps 
        		1.Is the number contains only Positive or only Negative or both
        
        How big is your test data set will be?
        		-231 <= x <= 231 - 1

2. Test data set
        Minimum  3 data set including positive, negative and edge
        Positive
		Input: x = 123
		Output: 321

		negative
		Input: x = -123
		Output: -321

		Edge
		Input: x = 120
		Output: 21
		
		
		"123, 321",          // Regular positive
        "-123, -321",        // Regular negative
        "120, 21",           // Trailing zero
        "0, 0",              // Zero boundary
        "1534236469, 0",     // Positive overflow case
        "-2147483412, 0",    // Negative overflow case
        "-2147483648, 0"     // Integer.MIN_VALUE edge case
        
        Validate with the interviewer if the data set is fine by his/ her assumptions

3. Do I know to solve it? ->Yes Brute force
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
9. Test against different test data ->Yes
10. If it fails then debug to solve it ->Yes
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
//
//	@Test
//	public void test1() {
//		int x = 123;
//		int expectedValue = 321;
//		int actualValue = findReverseDigit(x);
//		Assertions.assertEquals(expectedValue, actualValue);
//	}
//
//	@Test
//	public void test2() {
//		int x = -123;
//		int expectedValue = -321;
//		int actualValue = findReverseDigit(x);
//		Assertions.assertEquals(expectedValue, actualValue);
//	}
//
//	@Test
//	public void test3() {
//		int x = 120;
//		int expectedValue = 21;
//		int actualValue = findReverseDigit(x);
//		Assertions.assertEquals(expectedValue, actualValue);
//	}
//
//	@Test
//	public void test5() {
//		int x = 0;
//		int expectedValue = 0;
//		int actualValue = findReverseDigit(x);
//		Assertions.assertEquals(expectedValue, actualValue);
//	}
//
//	@Test
//	public void test6() {
//		int x = -2147483412;
//		int expectedValue = -2143847412;
//		int actualValue = findReverseDigit(x);
//		Assertions.assertEquals(expectedValue, actualValue);
//	}
	
	@Test
	public void test7() {
		String inputStr = "2147483648";
		long inputLong = Long.parseLong(inputStr);
	    int input = (int) inputLong;
		int expectedValue = 0;
		int actualValue = findReverseDigit(input);
		Assertions.assertEquals(expectedValue, actualValue);
	}

	public int findReverseDigit(int x) {
		if (x == 0)// O(1)
			return 0;
		boolean isNegative = x < 0;// O(1)
		long inputX = Math.abs((long) x);// O(1)
		String reversed = "";// O(1)
		while (inputX != 0) {// O(N)
			long reminder = inputX % 10;
			inputX = inputX / 10;
			reversed = reversed + reminder;// O(N)
		}
		if (isNegative) {// O(1)
			reversed = "-" + reversed;
		}
		long reversedNumber = Long.parseLong(reversed);// O(N)
		if (reversedNumber < Integer.MIN_VALUE || reversedNumber > Integer.MAX_VALUE)// O(1)
			return 0;
		return (int) reversedNumber;// O(1)
	}

//Time complexity: O(1)+O(1)+O(1)+O(1)+O(N)*O(N)+O(1)+O(N)+O(1)==>O(N^2)

	// Optimized Approach using Math
	public int findReverseDigit1(int x) {
		long reversedNumber = 0;
		while (x != 0) {
			reversedNumber = (reversedNumber * 10) + (x % 10);
			x = x / 10;
		}

		if (reversedNumber < Integer.MIN_VALUE || reversedNumber > Integer.MAX_VALUE) {
			return 0;
		}

		return (int) reversedNumber;
	}

	//Time complexity:O(N)
	
	public int reverse(int n) {
		if (n >= 0 && n < 10)
			return n;
		boolean isNegative = false;
		int rev = 0;
		if (n < 0) {
			isNegative = true;
			n = n * -1;
		}
		while (n > 0) {
			int last = n % 10;
			if (rev > Integer.MAX_VALUE / 10 || rev == Integer.MAX_VALUE / 10 && last > 7)  //-2,147,483,648 =>-8463847412 to 2,147,483,647=>7463847412
				return 0;
			if (rev < Integer.MIN_VALUE / 10 || rev == Integer.MIN_VALUE / 10 && last < -8)
				return 0;
			rev = rev * 10 + last;
			n = n / 10;

		}
		return isNegative ? rev * -1 : rev;
	}
}