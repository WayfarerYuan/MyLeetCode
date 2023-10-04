class Solution055 {
    public boolean canJump(int[] nums) {
        for (int i = 0; i < nums.length -1 ; i++) {
            if (nums[i] == 0) {
                // 从i-1开始往前找，看看是否有元素可以跳过0
                int j = i - 1;
                while (j >= 0) {
                    if (nums[j] > i - j) {
                        break;
                    }
                    j--;
                }
                if (j < 0) return false;
            }
        }
        return true;
    }
}

class Main055 {
    public static void main(String[] args) {
        Solution055 s = new Solution055();
        int[] nums = {2,0,0};
        System.out.println(s.canJump(nums));
    }
}