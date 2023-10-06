class Main045 {
    public static void main(String[] args) {
        Solution045 solution = new Solution045();
        int[] nums = {1,2,3};
        System.out.println(solution.jump(nums));
    }
}

class Solution045 {
    public int jump(int[] nums) {
        // 整体思路： 从nums[0]开始，每次跳到能跳到的最远的位置，直到跳到最后一个位置
        // 每次能跳到的最远位置需要遍历当前范围，找到max（i+nums[i]）
        int currentStep = 0;
        int searchStart = 0;
        int searchEnd = nums[0];
        int nextStart = searchEnd, nextEnd = searchEnd;
        while (searchEnd < nums.length - 1) {
            for (int i = searchStart; i <= searchEnd; i++) {
                if (i + nums[i] >= nextStart + nums[nextStart]) {
                    nextStart = i;
                    nextEnd = i + nums[i];
                }
            }
            currentStep++;
            searchStart = nextStart;
            searchEnd = nextEnd;
        }
        return currentStep + 1;
    }

//    private int findFarestIndex(int[] nums, int start, int end) {
//        int farestIndex = start;
//        for (int i = start; i <= end; i++) {
//            if (i + nums[i] > farestIndex + nums[farestIndex]) {
//                farestIndex = i;
//            }
//        }
//        return farestIndex;
//    }
}