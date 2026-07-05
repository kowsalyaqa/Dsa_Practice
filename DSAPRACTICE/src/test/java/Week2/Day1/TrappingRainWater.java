//https://leetcode.com/problems/trapping-rain-water/description/

/*
 * Initialize two variables leftMaxHeight=Integer.MIN_VALUE, rightMaxHeight=Interger.MIN_VALUE,save=0
 * Iterate the array from start index till end
 * 	-for every index i, compute the leftMaxHeight,rightMaxHeight
 * 	-Take a minimum between the left and right max Heights(i-e water stored till the wall that has the minimum height)
 * 	- to compute units of the water stored subtract the building height from from the minHeight(value at current index)
 * 			- if the answer is less than zero, do a MATH.max() with 0, since the water can't be saved in -ve units
 * 	- Accumulate the results into save variable and proceed
 * 
 */
package Week2.Day1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TrappingRainWater {
	
	@Test
	public void testData1() {
		int[] heights= {0,1,0,2,1,0,1,3,2,1,2,1};
		Assertions.assertEquals(6, trapWater(heights));
	}
	
	@Test
	public void testData2() {
		int[] height= {4,2,0,3,2,5};
		Assertions.assertEquals(9, trapWater(height));
	}
	
	public int trapWater(int[] height) {
		int save=0;//O(1)
		for(int i=1;i<height.length-1;i++) {//O(N)
			int lMaxHeight=findMax(height,i,"left");//O(N)
			int rMaxHeight=findMax(height,i,"right");//O(N)
			int units=Math.max(0, Math.min(lMaxHeight,rMaxHeight)-height[i]);//O(1)
			save+=units;//O(1)
		}
		return save;//O(1)
	}
	
	//O(1)+O(N)*(O2N)+O(1)+O(1)+O(1)
	//Time complexity: O(N^2)
	//Space Complexity: O(1)
	
	public int findMax(int[] height, int curretntIndex,String direction){
		int maxHeight=Integer.MIN_VALUE;
		if(direction.equals("left")) {
			for(int i=0;i<curretntIndex;i++) {
				maxHeight=Math.max(maxHeight, height[i]);
			}
		}else {
			for(int i=curretntIndex+1;i<height.length;i++) {
				maxHeight=Math.max(maxHeight, height[i]);
			}
		}
		return maxHeight;
	}

}
