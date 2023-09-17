class Main027_2 {
    public static void main(String[] args) {
        Solution027_2 s = new Solution027_2();
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        System.out.println(s.removeElement(nums, val));
    }
}

class Solution027_2 {
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        for (int i = 0; i < length; i++){
            if (nums[i] == val){
                length -= 1;
                shiftArray(nums, i);
                i--; // 此处需要将index回调1格，因为已经移除了一个元素
            }
        }
        return length;
    }

    private void shiftArray(int[] nums, int index) {
        // Shift all the elements after nums[index] one cell forward
        for(int i = index; i < nums.length - 1; i++){
            nums[i] = nums[i + 1];
        }
    }
}