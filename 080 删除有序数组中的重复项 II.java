import java.util.Arrays;

class Solution080_2 {
    public int removeDuplicates(int[] nums) {
        //使用双指针解决这个问题，第一个指针用来遍历数组，第二个指针用来找重复超过2次的元素
//        int i = 0;
//        for(int n : nums){
//            if(i < 2 || n > nums[i - 2]){
//                nums[i] = n;
//                i++;
//            }
//        }
//        System.out.println(Arrays.toString(nums));
//        return i;
        if (nums.length <= 2) {
            return nums.length;
        }
        int newLength = nums.length;
        for (int i = 0; i < newLength - 2; i++) {
            if (nums[i] == nums[i+1] && nums[i] == nums[i+2]) {
                // 从i+1开始，找到第一个不等于nums[i]的元素
                int j = i + 1;
                while (j < newLength && nums[j] == nums[i]) {
                    j++;
                }
                // 移除从i+2到j-1的元素
                removeFromArray(nums, i+2, j-1);
                System.out.println(Arrays.toString(nums));
                // 更新newLength (j-1)-(i+2)+1
                newLength -= (j - i - 2);
            }
        }
//        System.out.println(Arrays.toString(nums));
        return newLength;
    }

    private void removeFromArray(int[] nums, int start, int end) {
        System.out.println("Removing from " + start + " to " + end);
        int i = start;
        while (i + end - start + 1< nums.length) {
            nums[i] = nums[i + end - start + 1];
            i++;
        }
    }
}

class Main080_2 {
    public static void main(String[] args) {
        Solution080_2 s = new Solution080_2();
        int[] nums = {0,1,2,2,2,2,2,3,4,4,4};
        System.out.println(s.removeDuplicates(nums));
    }
}