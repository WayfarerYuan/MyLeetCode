import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        Solution011 solution = new Solution011();
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(solution.maxArea(height));
    }
}

class Solution011 {
    public int maxArea(int[] height) {

        int areaMax = 0;
        int leftMax = 0, rightMax = 0;

        // 找出最大值
        int max = 0, maxIndex = 0;
        int[] heightIndex = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
                maxIndex = i;
            }
        }
        System.out.println("max=" + max + " maxIndex=" + maxIndex);
        // 左指针从0搜索到最大值
        for (int i = 0; i <= maxIndex; i++) {
            if (height[i] < leftMax) {
                continue;
            }
            leftMax = height[i];
            // 右指针从最后搜索到左指针，搜索过程中遇到比rightmax小的值就跳过
            rightMax = 0;
            for (int j = height.length - 1; j > i; j--) {
                if (height[j] < rightMax) {
                    continue;
                }
                rightMax = height[j];
                // 计算面积
                int area = (j - i) * Math.min(height[i], height[j]);
                System.out.println("i=" + i + " j=" + j + " area=" + area);
                if (area > areaMax) {
                    areaMax = area;
                }
            }
        }

        return areaMax;
    }
}