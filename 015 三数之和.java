import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Main015{
public static void main(String[] args) {
        Solution015 s = new Solution015();
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> res = s.threeSum(nums);
        for (List<Integer> list : res) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}

class Solution015 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int target = 0;
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            target = -nums[i];
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = len - 1;
            while (left < right) {
                if (nums[left] + nums[right] > target) {
                    right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                    // 去重
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    // 继续搜索
                    left++;
                    right--;
                }
            }
        }
        return res;
    }
}