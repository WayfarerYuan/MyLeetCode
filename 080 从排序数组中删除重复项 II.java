//Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.
//Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
//Return k after placing the final result in the first k slots of nums.
//Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.

class Solution080 {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        int i = 0;
        for (int j = i; j < nums.length; j++) {
            if (i < 2 || nums[j] != nums[i-2]) {
                nums[i] = nums[j];
                i++;
            }
        }
        System.out.println("i: " + i);
        return i;
    }
}

class Main080 {
    public static void main(String[] args) {
        // Input
        int[] nums = {1,1,1,2,2,3};
        // Output
        Solution080 solution = new Solution080();
        int ret = solution.removeDuplicates(nums);
    }
}