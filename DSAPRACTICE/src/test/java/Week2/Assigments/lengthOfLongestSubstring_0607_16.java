//https://leetcode.com/problems/longest-substring-without-repeating-characters/
/*Problem solving template

1. Did I understand the problem? yes or no ->Yes

        If no ask the person to provide with more details with examples
        If yes go to the next step

        What is the input(s)?
        	integer array
        What is the expected output?
        	integer array with relative order not changed
        Do I’ve constraints to solve the problem? 
        	Solve in-place without making a copy of the array.
 
        Do Ive all the information to go to the next steps
        	Yes
        How big is your test data set will be?
			1 <= nums.length <= 104
			-2^31 <= nums[i] <= 2^31 - 1
				
2. Test data set
        Minimum  3 data set including positive, negative and edge

			Input: nums = [0,1,0,3,12]
			Output: [1,3,12,0,0]

			Input: nums = [0]
			Output: [0]
		
			Input: nums = [1,0,1]
			Output: [1,1,0]
	 
	 		Input: nums = [0,1]
			Output: [1,0]
			
			Input: nums = [0,1,-1,-2]
			Output: [1,-1,-2,0]
        
        Validate with the interviewer if the data set is fine by his/ her assumptions

3. Do I know to solve it? 
        Yes- great is there an alternate ?
        	Two Pointer
        No - can I break the problem into sub problems?

4. Ask for hint (if you don’t know how to solve this5.  Do I know alternate solutions as well
        Yes- what are those?
        No- that is still fine, proceed to solve by what you know

Simple technique brute force
 
 * Sliding Window technique pseudocode:
 * 1.Create an empty set
 * 2.Initialize left=0 and max=0
 * 3.For every character
 * 		while the current character is already in set
 * 			Remove the left character
 * 			Move left forward
 * 		Add the current character to set
 * 		calculate the current window size
 * 		Update the maximum window size
 * return the maximum window size
 * 
 * 
 * 
 * 
 */


/*completion_criteria
Applied the problem solving template - yes
Solved the question using brute force and specific algoirthm - yes
Pushed the code to github - yes
Solved the question in leetcode and observed all TCs passed - yes
*/

package Week2.Assigments;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class lengthOfLongestSubstring_0607_16 {
//
//	@Test
//	public void test1() {
//		String s = "abcabcbb";
//		Assertions.assertEquals("abc", lengthOfLongestSubstring(s));
//	}
//
//	@Test
//	public void test2() {
//		String s = "a";
//		Assertions.assertEquals("a", lengthOfLongestSubstring(s));
//	}
//
//	@Test
//	public void test3() {
//		String s = "aaaaa";
//		Assertions.assertEquals("a", lengthOfLongestSubstring(s));
//	}

	@Test
	public void test4() {
		String s = "pwwkew";
		//Assertions.assertEquals("wke", lengthOfLongestSubstring(s));
		Assertions.assertEquals("wke", lengthOfLongestSubstring1(s));
	}

	// Brute force Solution
	public String lengthOfLongestSubstring(String s) {
		if (s.length() == 0)
			return "";
		List<String> longestSubstringList = new ArrayList<>(); // O(N)
		int maxLengthOfLongestSubstring = Integer.MIN_VALUE, k = 0;// O(1)
		for (int i = 0; i < s.length(); i++) {// O(N)
			for (int j = i; j < s.length(); j++) {// O(N)
				String currentSubString = s.substring(i, j + 1);
				boolean isDuplicate = IsCurrentSubStringHasDuplicate(currentSubString);// O(N^2)
				if (isDuplicate == false) {
					if (currentSubString.length() > maxLengthOfLongestSubstring) {
						maxLengthOfLongestSubstring = currentSubString.length();
						longestSubstringList.clear();
						longestSubstringList.add(currentSubString);
					}
				}
			}
		}
		return longestSubstringList.get(0);
	}

	// TC: O(N^4)

	public boolean IsCurrentSubStringHasDuplicate(String subString) {
		// Assuming standard ASCII characters (128 possible characters)
		boolean[] characterSeen = new boolean[128];
		for (int i = 0; i < subString.length(); i++) {
			char currentChar = subString.charAt(i);
			// If we've already marked this character as true, it's a duplicate!
			if (characterSeen[currentChar]) {
				return true;
			}
			// Mark this character as seen
			characterSeen[currentChar] = true;
		}
		return false;
	}

	// Time Limit Succeed Error
	public boolean IsCurrentSubStringHasDuplicate1(String subString) {
		int count = 1;
		for (int i = 0; i < subString.length(); i++) {
			for (int j = i + 1; j < subString.length(); j++) {
				if (subString.charAt(i) == subString.charAt(j)) {
					count++;
					if (count > 1) {
						return true;
					}
				}
			}
		}
		return false;
	}

	// Optimized Solution
	public int lengthOfLongestSubstring1(String s) {
		Set<Character> set = new HashSet<>();
		int left = 0;
		int max = 0;
		for (int right = 0; right < s.length(); right++) {
			while (set.contains(s.charAt(right))) {
				set.remove(s.charAt(left));
				left++;
			}
			set.add(s.charAt(right));
			max = Math.max(max, right - left + 1);
		}
		return max;
	}

	// Optimized Solution
	public int lengthOfLongestSubstringa2(String s) {
		// Array to track character frequency in current window (ASCII characters)
		int[] charFrequency = new int[128];

		// Initialize variables
		int maxLength = 0;
		int stringLength = s.length();
		int left = 0;

		// Iterate through string with right pointer
		for (int right = 0; right < stringLength; right++) {
			// Get current character at right pointer
			char currentChar = s.charAt(right);

			// Increment frequency of current character
			charFrequency[currentChar]++;

			// Shrink window from left while we have duplicate characters
			while (charFrequency[currentChar] > 1) {
				// Decrement frequency of character at left pointer and move left pointer
				charFrequency[s.charAt(left)]--;
				left++;
			}

			// Update maximum length of substring without repeating characters
			maxLength = Math.max(maxLength, right - left + 1);
		}

		return maxLength;
	}

}
