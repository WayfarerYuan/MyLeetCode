class Solution027 {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j=0; j<nums.length; j++) {
            if (nums[j] != val) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }
}

class Main027 {
    
    public static void main(String[] args) {
        Solution027 solution = new Solution027();
        
        int[] nums = {3,2,2,3};
        int val = 3;
        int res = solution.removeElement(nums, val);
        System.out.println(res);
    }
}