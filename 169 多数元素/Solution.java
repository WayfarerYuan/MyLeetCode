import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
//    public int majorityElement(int[] nums) {
//        int count = 0;
//        int candidate = 0;
//        for (int num : nums) {
//            if (count == 0) candidate = num;
//            count += (num == candidate) ? 1 : -1;
//        }
//        return candidate;
//    }
    public int majorityElement(int[] nums) {
        // Pass in a array of numbers, and return the majority element.
        Log log = new Log();
        for (int num : nums) {
            log.addNum(num);
        }
        return log.getMajority();
    }
}

class Log {
    HashMap<Integer, Integer> numsCnt;
    public Log() {
        //HashMap<Integer, Integer> numsCnt = new HashMap<>();
        //this.numsCnt = numsCnt;
        numsCnt = new HashMap<>();
    }
    public void addNum(int num) {
        if (numsCnt.containsKey(num)) {
            numsCnt.put(num, numsCnt.get(num) + 1);
        } else {
            numsCnt.put(num, 1);
        }
    }

    public int getMajority() {
        int maxCnt = 0;
        int maxNum = 0;
        for (int num : numsCnt.keySet()) {
            if (numsCnt.get(num) > maxCnt) {
                maxCnt = numsCnt.get(num);
                maxNum = num;
            }
        }
        return maxNum;
    }
}