class Main238 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3,4};
        int[] result = solution.productExceptSelf(nums);
        for (int i : result) {
            System.out.println(i);
        }
    }
}

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        int leftProduct = 1;
        result[len - 1] = 1;
        // 临时将右侧乘积存放在result中
        for (int i = len - 2; i >= 0; i--) {
            result[i] = result[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < len; i++) {
            // 总乘积 = 左侧乘积 * 右侧乘积
            result[i] *= leftProduct;
            leftProduct *= nums[i];
        }
        return result;
    }
}