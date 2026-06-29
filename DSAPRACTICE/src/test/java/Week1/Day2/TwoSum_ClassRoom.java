package Week1.Day2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TwoSum_ClassRoom {

    @Test
    public void test() {
        int[] nums = {2, 3, 5, 7}; // input array
        int target = 9; // input target//
        int[] actualOutput = twoSum(nums, target); // method call
        int[] expectedOutput = {0,3};
        Assertions.assertArrayEquals(expectedOutput, actualOutput);
    }

    @org.testng.annotations.Test
    public void test1() {
        int[] nums = {2, 4, 6, 7}; // input array
        int target = 10; // input target//
        Assertions.assertArrayEquals(new int[]{-1,-1}, twoSum(nums, target));
    }

    public int[] twoSum(int[] nums, int target) {

        if (nums == null) throw new RuntimeException("input Array can't be null"); // O(1)
        if (nums.length < 2) throw new RuntimeException("input array size must be greater than or equals to 2");//O(1)

        for (int i = 0; i < nums.length; i++) { //O(N+1)
            int sum = nums[i]; // O(1)
            for (int j = 0; j < nums.length; j++) { // O(N)
                if (i == j) continue; // O(1)
                if (sum + nums[j] == target)  //O(1)
                    return new int[]{i, j};  //O(1)
            }
        }
        return new int[]{-1, -1}; //O(1)
    }
}
