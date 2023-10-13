import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Main042 {
    public static void main(String[] args) {
        Solution042 sol = new Solution042();
        int[] height = {9,6,8,8,5,6,3};
        System.out.println(sol.trap(height));
    }
}

class Solution042 {
    public int trap(int[] height) {
        // 双指针法
        int res = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    res += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    res += rightMax - height[right];
                }
                right--;
            }
        }
        return res;
//        int res = 0;
//        int left = 0;
//        int right = 0;
//        int i = 0;
//        while (i < height.length - 1) {
//            // 找到开始下降的点
//            while (i < height.length - 1 && height[i] <= height[i + 1]) {
//                i++;
//            }
//            left = i;
//            // 从下降点开始找一个开始上升的点
//            while (i < height.length - 1 && height[i] >= height[i + 1]) {
//                i++;
//            }
//            // 如果没有找到开始上升的点，说明已经到了最后一个点，直接返回
//            if (i == height.length - 1) {
//                return res;
//            }
//            int temp = height[i];
//            // 找到开始上升的点，继续向右搜索找到最高点
//            while (i < height.length) {
//                if (height[i] >= temp) {
//                    temp = height[i];
//                    right = i;
//                }
//                if (temp >= height[left]) {
//                    break;
//                }
//                i++;
//            }
//            i = right;
//            // 计算中间可以接水的面积
//            int waterHeight = Math.min(height[left], height[right]);
//            int area = 0;
//            for (int j = left + 1; j < right; j++) {
//                if (waterHeight > height[j]) {
//                    area += waterHeight - height[j];
//                }
//            }
//            System.out.println("Left: " + left + " Right: " + right + " Area: " + area);
//            res += area;
//        }
//        return res;

//        // 先建立一个表，存放每个高度的柱子的x值
//        HashMap<Integer, List<Integer>> yMap = new HashMap<>();
//        for (int i = 0; i < height.length; i++) {
//            for (int j = 0; j <= height[i]; j++) {
//                if (yMap.containsKey(j)) {
//                    yMap.get(j).add(i);
//                } else {
//                    List<Integer> list = new ArrayList<>();
//                    list.add(i);
//                    yMap.put(j, list);
//                }
//            }
//        }
//        int res = 0;
//        // 从高度为1开始，计算每两个x值之间的面积
//        for (int i = 1; i < yMap.size(); i++) {
//            List<Integer> list = yMap.get(i);
//            System.out.println(list);
//            for (int j = 0; j < list.size() - 1; j++) {
//                int left = list.get(j);
//                int right = list.get(j + 1);
//                int area = right - left - 1;
//                System.out.println("area: " + area);
//                res += area;
//            }
//        }
//        return res;
    }
}