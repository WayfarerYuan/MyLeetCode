import static java.util.Arrays.sort;

class Main169 {
    public static void main(String[] args) {
        Solution169 s = new Solution169();
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(s.majorityElement(nums));
    }
}

class Solution169 {
    public int majorityElement(int[] nums) {
//        sort(nums);
//        return nums[nums.length / 2];
        int count = 0;
        int candidate = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (num == candidate) {
                count += 1;
            }
            else {
                count -= 1;
            }
        }
        return candidate;
    }
}