import java.util.Arrays;

class Main209{
    public static void main(String[] args) {
        Solution209 s = new Solution209();
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        System.out.println(s.minSubArrayLen(target, nums));
    }
}

class Solution209 {
    public int minSubArrayLen(int target, int[] nums) {
        // 可行但超时了
//        for (int len = 1; len <= nums.length; len++) {
//            int sum = 0;
//            for (int i = 0; i < len; i++) {
//                sum += nums[i];
//            }
//            if (sum >= target) {
//                return len;
//            }
//            for (int start = 1; start + len - 1 < nums.length; start++) {
//                sum = sum - nums[start - 1] + nums[start + len - 1];
//                if (sum >= target) {
//                    return len;
//                }
//            }
//        }
//        return 0;
        // 真正的滑动窗口法
        int len = nums.length;
        int res = 0;
        int left = 0, right = 0;
        int sum = nums[0];
        while (right < len) {
            // 如果当前sum < target, 右边界向右
            if (sum < target) {
                right++;
                if (right == len) {break;}
                sum += nums[right];
            } else {
                if (res == 0) {
                    res = right - left + 1;
                } else {
                    res = Math.min((right - left + 1), res);
                }
                System.out.println("left:"+left+"right:"+right+"res:"+res);
                sum -= nums[left];
                left++;
            }
//            if (right == left) {return 1;}
            System.out.println("left:"+left+"right:"+right);
        }
        return res;
    }
}