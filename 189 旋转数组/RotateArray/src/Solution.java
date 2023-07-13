public class Solution {
    public void rotate(int[] nums, int k) {
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i = i + 1) {
            System.out.println("i:" + i);
            temp[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = temp[i];
        }
    }
}


