import java.util.Arrays;

class Solution274 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations[i] > h) {
                h++;
            } else {
                break;
            }
        }
        return h;
    }
}

class Main274 {
    public static void main(String[] args) {
        Solution274 s = new Solution274();
        int[] citations = {3,0,6,1,5};
        System.out.println(s.hIndex(citations));
    }
}

// 3,0,6,1,5
// 1,1,0,1,0,2
