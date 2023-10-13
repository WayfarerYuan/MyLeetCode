import java.util.Arrays;

class Main135 {
    public static void main(String[] args) {
        Solution135 s = new Solution135();
        int[] ratings = {1, 0, 2};
        System.out.println(s.candy(ratings));
        ratings = new int[]{1, 2, 2};
        System.out.println(s.candy(ratings));
        ratings = new int[]{3,2,5,6,8,7,6,7,2,1}; // 2,1,2,3,4,2,1,3,2,1 // + - - - + + - + + //
        System.out.println(s.candy(ratings));
    }
}

class Solution135 {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] candies = new int[len];
        for (int i = 0; i < len; i++) {
            // 向左搜索，连续大于多少个元素？
            int index = i;
            int l_addup = 0;
            while (index > 0 && ratings[index] > ratings[index - 1]) {
                l_addup ++;
                index --;
            }
            // 向右搜索，连续大于多少个元素？
            index = i;
            int r_addup = 0;
            while (index < len - 1 && ratings[index] > ratings[index + 1]) {
                r_addup ++;
                index ++;
            }
            // 比较左右结果，得出当前元素值
            candies[i] = Math.max(l_addup, r_addup) + 1;
        }
        System.out.println(Arrays.toString(candies));
        return Arrays.stream(candies).sum();
    }
}