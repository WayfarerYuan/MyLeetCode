import jdk.jfr.Unsigned;

class Solution121 {
    public int maxProfit(int[] prices) {
        int minCandidate = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minCandidate) {
                minCandidate = price;
            } else if (price - minCandidate > maxProfit) {
                maxProfit = price - minCandidate;
            }
        }
        return maxProfit;
    }
}

class Main121 {
    public static void main(String[] args) {
        Solution121 s = new Solution121();
        int[] prices = {7,1,5,3,6,4};
        System.out.println(s.maxProfit(prices));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}