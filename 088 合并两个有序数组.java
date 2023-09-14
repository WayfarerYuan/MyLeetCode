//class Main088 {
//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        int[] nums = new int[m + n];
//        int i = 0, j = 0, k = 0;
//        while (i < m && j < n)
//            nums[k++] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
//        while (i < m)
//            nums[k++] = nums1[i++];
//        while (j < n)
//            nums[k++] = nums2[j++];
//        for (int l = 0; l < m + n; l++)
//            nums1[l] = nums[l];
//    }
//}

import java.util.Arrays;

class Solution088 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] merged = new int[m + n];
        int index1 = 0, index2 = 0, index = 0;
        while(index1 < m && index2 < n) {
            if (nums1[index1] < nums2[index2]) {
                merged[index] = nums1[index1];
                index1 += 1;
            }
            else {
                merged[index] = nums2[index2];
                index2 += 1;
            }
            index += 1;
        }
        if (index1 == m) {
            while(index2 < n) {
                merged[index] = nums2[index2];
                index2 += 1;
                index += 1;
            }
        }
        if (index2 == n) {
            while(index1 < m) {
                merged[index] = nums1[index1];
                index1 += 1;
                index += 1;
            }
        }
        for (int i = 0; i < m + n; i++) {
            nums1[i] = merged[i];
        }
        System.out.println("nums1: " + Arrays.toString(nums1));
    }
}

class Main088 {
    public static void main(String[] args) {
        // Input
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        // Output
        Solution088 solution = new Solution088();
        solution.merge(nums1, m, nums2, n);
    }
}