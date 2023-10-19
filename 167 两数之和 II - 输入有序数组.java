class Main167 {
    public static void main(String[] args) {
        Solution167 s = new Solution167();
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] result = s.twoSum(numbers, target);
        System.out.println(result[0] + " " + result[1]);
    }
}

class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] > target) {
                right--;
            } else if (numbers[left] + numbers[right] < target) {
                left++;
            } else {
                ans[0] = left;
                ans[1] = right;
                break;
            }
        }
        return ans;
    }
}