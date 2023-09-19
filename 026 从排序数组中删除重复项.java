// 给定一个按非降序排序nums的整数数组，就地删除重复项，以便每个唯一元素仅出现一次。元素的相对顺序应保持相同。然后返回中唯一元素的数量。nums

// nums考虑to be的独特元素的数量k，要被接受，您需要执行以下操作：

// 更改数组nums，以便第一个k元素nums按照它们最初出现的顺序包含唯一元素nums。的其余元素nums以及 的大小并不重要nums。
// 返回k。

import java.util.ArrayList;
import java.util.Arrays;

class Solution026 {
    public int removeDuplicates(int[] nums) {
        if(nums.length < 1) {
            return 0;
        }
        ArrayList<Integer> uniqueList = new ArrayList<>();
        uniqueList.add(nums[0]);
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != uniqueList.get(uniqueList.size()-1)) {
                uniqueList.add(nums[i]);
            }
        }
        for(int i = 0; i < uniqueList.size(); i++) {
            nums[i] = uniqueList.get(i);
        }
        return uniqueList.size();
    }
    // public int removeDuplicates(int[] nums) {
    //     if (nums.length == 0) return 0;
    //     int i = 0;
    //     for (int j = 1; j < nums.length; j++) {
    //         if (nums[j] != nums[i]) {
    //             i++;
    //             nums[i] = nums[j];
    //         }
    //     }
    //     return i + 1;
    // }
    public int removeDuplicates2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int numOfUniqueNums = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (j >= nums.length) {
                    return numOfUniqueNums;
                }
                if (nums[j] != nums[i]) {
                    numOfUniqueNums += 1;
                    replaceElements(nums, i, j);
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
        return numOfUniqueNums;
    }

    private void replaceElements(int[] nums, int start, int end) {
        System.out.println("Replacing " + Arrays.toString(nums) + " from " + start + " to " + end);
        if (start == end || end - start == 1) return;
        for (int i = start + 1; i < end; i++) {
            nums[i] = nums[end];
        }
    }

}

class Main026 {
    
    public static void main(String[] args) {
        Solution026 solution = new Solution026();
        
        int[] nums = {0,1,1,2,3,3,4,5,5,5};
        int res = solution.removeDuplicates2(nums);
        System.out.println(res);
    }
}
