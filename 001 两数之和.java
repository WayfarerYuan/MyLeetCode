import java.util.Arrays;

class Main001 {
    public static void main(String[] args) {
        Solution001 sol = new Solution001();
        int[] nums = {2, 71, 7, 15};
        int target = 9;
        System.out.println(Arrays.toString(sol.twoSum(nums, target)));
    }
}

class Solution001 {
    public int[] twoSum(int[] nums, int target) {
        int[] ogNums = nums.clone();
        int[] ans = new int[2];
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if(nums[left] + nums[right] == target) {
                for (int i = 0; i < ogNums.length; i++) {
                    if (ogNums[i] == nums[left]) {
                        ans[0] = i;
                        break;
                    }
                }
                for (int i = ogNums.length - 1; i >= 0; i--) {
                    if (ogNums[i] == nums[right]) {
                        ans[1] = i;
                        break;
                    }
                }
                return ans;
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}