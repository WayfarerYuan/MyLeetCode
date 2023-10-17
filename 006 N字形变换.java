class Main006{
    public static void main(String[] args) {
        Solution006 s = new Solution006();
        System.out.println(s.convert("LEETCODEISHIRING", 3));
    }
}

class Solution006 {
    public String convert(String s, int numRows) {
        // Create numRows of StringBuilder
        StringBuilder[] rows = new StringBuilder[numRows];
        int len = s.length();
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        int groupLen = numRows * 2 - 2 > 0 ? numRows * 2 - 2 : 1;
        for (int i = 0; i < len; i++) {
            int indexInGroup = i % groupLen;
            if (indexInGroup < numRows) {
                rows[indexInGroup].append(s.charAt(i));
            } else {
                rows[groupLen - indexInGroup].append(s.charAt(i));
            }
        }
        // Combine all the rows
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            res.append(rows[i]);
        }
        return res.toString();
    }
}