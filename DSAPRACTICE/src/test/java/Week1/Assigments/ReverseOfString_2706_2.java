//https://leetcode.com/problems/reverse-string/description/


/*Problem:
Given a string return the reversed string

Eg:
input: hello world
output:
dlrow olleh
*/

/*Problem solving template

1. Did I understand the problem? yes or no--->Yes

        If no ask the person to provide with more details with examples
        If yes go to the next step

        What is the input(s)?
        	String
        What is the expected output?
        	String
        Do I’ve constraints to solve the problem?
       		No
        Do Ive all the information to go to the next steps
        	Yes
        How big is your test data set will be?
        Simple String
        1 <= s.length <= 105
		[i] is a printable ascii character.

2. Test data set
        Minimum  3 data set including positive, negative and edge
        	Positive 
        	input: hello world
			output:dlrow olleh
			
			input: hello123
			output:321olleh
			
			input: hello11@#
			output:#@l1olleh
			
			negative
			input: h
			output:h
			
			Edge 
			input: Empty or null
			output:Throw Exception
			
        Validate with the interviewer if the data set is fine by his/ her assumptions
        
        	1.Do we have to reverse only alphabets or other char as well?
        	2.Do we have reverse whole sentence from last to first or each word reverse?
        	3.Can we new string store char and print or In-place need to reverse?
        
3. Do I know to solve it?-->
        Yes- great is there an alternate ?
        		1.Two Pointer Approach
        No - can I break the problem into sub problems?

4. Ask for hint (if you don’t know how to solve this5.  Do I know alternate solutions as well
        Yes- what are those?
        No- that is still fine, proceed to solve by what you know

Simple technique brute force


Simple technique brute force
	
Pseudo Code for Brute Force Approach:
====================================
1.Declare new String with Empty value to store char from last index to first index
2.Loop through from  s.length()-1 to 0
	a)Store each char on new string
3.Return new String


Pseudo Code for Two Pointer Approach:
====================================
1.Declare new String with Empty value to store char from last index to first index
2.Loop through from  s.length()-1 to 0
	a)Store each char on new string
3.Return new String

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
Solved the question in leetcode and observed all TCs passed
*/
package Week1.Assigments;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReverseOfString_2706_2 {

	
	@Test 
	public void test1() {
		String s="hello world";
		String expectedOutput="dlrow olleh";
		//String actualOutput=findReverseString(s);
		//String actualOutput=findReverseString2(s);
		String actualOutput=findReverseString3(s);
		Assertions.assertEquals(expectedOutput, actualOutput);
	}
	
	@Test 
	public void test2() {
		String s="hello123";
		String expectedOutput="321olleh";
		//String actualOutput=findReverseString(s);
		//String actualOutput=findReverseString2(s);
		String actualOutput=findReverseString3(s);
		Assertions.assertEquals(expectedOutput, actualOutput);
	}
	
	@Test 
	public void test3() {
		String s="hello11@#";
		String expectedOutput="#@11olleh";
		//String actualOutput=findReverseString(s);
		//String actualOutput=findReverseString2(s);
		String actualOutput=findReverseString3(s);
		Assertions.assertEquals(expectedOutput, actualOutput);
	}
	
	@Test 
	public void test4() {
		String s="h";
		String expectedOutput="h";
		//String actualOutput=findReverseString(s);
		//String actualOutput=findReverseString2(s);
		String actualOutput=findReverseString3(s);
		Assertions.assertEquals(expectedOutput, actualOutput);
	}
	
	@Test 
	public void test5() {
		String s="";
		String expectedOutput="";
		//String actualOutput=findReverseString(s);
		//String actualOutput=findReverseString2(s);
		String actualOutput=findReverseString3(s);
		Assertions.assertEquals(expectedOutput, actualOutput);
	}

	@Test 
	public void test6() {
		String s=null;
		//findReverseString(s);
		findReverseString2(s);
		findReverseString3(s);
	}
	
	//Brute Force Approach
	private String findReverseString(String s) {
		if(s==null)//O(1)
			throw new RuntimeException("String Input should not be null ");
		if(s.length()==1)//O(1)
			return s;
		String str="";//O(1)
		for(int i=s.length()-1;i>=0;i--)//O(N)
			str=str+s.charAt(i);//O(N) -->This will create new String each time when do conctenate
		return str;//O(1)
	}
	
	//O(1)+O(1)+O(1)+O(N)*O(N)+O(1)
	//O(4)+O(N^2)
	//O(N^2)
	
	//Two Pointer Approach (in-place Swap)
	private String findReverseString2(String s) {
		if(s==null)//O(1)
			throw new IllegalArgumentException("String Input should not be null ");
		if(s.length()==1)//O(1)
			return s;
		int left=0,right=s.length()-1; //O(1)
		char[] charArray = s.toCharArray(); //O(N)
		while(left<right) {//O(N)
			char temp=charArray[left];
			charArray[left++]=charArray[right];
			charArray[right--]=temp;
		}
		//return String.valueOf(charArray); //O(N)
		return new String(charArray); //O(N)
	}
	
	//O(1)+O(1)+O(1)+O(N)+O(N)+O(N)
	//O(1)+O(3N)
	//O(N)
	

	//Using a mutable buffer (StringBuilder).
	private String findReverseString3(String s) {
		if(s==null)//O(1)
			throw new RuntimeException("String Input should not be null ");
		if(s.length()==1)//O(1)
			return s;
		StringBuilder sb = new StringBuilder(); //O(1)
		for (int i = s.length() - 1; i >= 0; i--) {//O(N)
		    sb.append(s.charAt(i));
		}
		return sb.toString();//;O(N)
	}
	//O(1)+O(1)+O(N)+O(N)
	//O(2)+O(2N)
	//O(N)
	
}
