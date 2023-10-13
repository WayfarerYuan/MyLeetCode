import java.util.Arrays;

class Main134 {
    public static void main(String[] args) {
        Solution134 s = new Solution134();
        int[] gas = {3,1,1};
        int[] cost = {1,2,2};
        //           2,-1,-1
        System.out.println(s.canCompleteCircuit(gas, cost));
    }
}

class Solution134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int[] realCost = new int[len];
        for (int i = 0; i < len; i++) {
            realCost[i] = gas[i] - cost[i];
        }
        int sum = 0, min = 0, res = 0;
        for (int i = 0; i < len; i++) {
            sum += realCost[i];
            if (sum < min) {
                min = sum;
                res = i + 1;
            }
        }
        return sum < 0 ? -1 : res;
    }
}