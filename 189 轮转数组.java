import java.util.Arrays;

class Main189 {
    public static void main(String[] args) {
        Solution189 s = new Solution189();
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        s.rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}

class Solution189 {
//    public void rotate(int[] nums, int k) {
//        int realK = k % nums.length;
//        // store the last k elements
//        int[] lastK = new int[realK];
//        for (int i = 0; i < realK; i++) {
//            lastK[i] = nums[nums.length - realK + i];
//        }
//        // move the first len-realK elements to the end
//        for (int i = 0; i < nums.length - realK; i++) {
//            nums[nums.length - 1 - i] = nums[nums.length - realK - 1 - i];
//        }
//        // restore the last k elements to the beginning
//        for (int i = 0; i < realK; i++) {
//            nums[i] = lastK[i];
//        }
//    }

    public void rotate(int[] nums, int k) {
        int realK = k % nums.length;
        if (realK == 0) return;
        // calulate how many times a num needs to jump until it returns to its original position
        int a = 1;
        while (a * nums.length % realK != 0) {
            a++;
        }
        System.out.println("a: " + a);
        int jumpTimes = a * nums.length / realK;
        int rotateRounds = nums.length / jumpTimes;
        System.out.println("jumpTimes: " + jumpTimes + ", rotateRounds: " + rotateRounds);
        for (int i = 0; i < rotateRounds; i++) {
            // Rotate the nums until return to its orginal position
            int index = i;
            int nextIndex = i + realK;
            int last, next;
            last = nums[index];
            while(nextIndex % nums.length != i) {
                next = nums[nextIndex];
                nums[nextIndex] = last;
                last = next;
                nextIndex = (nextIndex + realK) % nums.length;
                System.out.println(Arrays.toString(nums));
            }
            nums[nextIndex] = last;
        }
    }
}