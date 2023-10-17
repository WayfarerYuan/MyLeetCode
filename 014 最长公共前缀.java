class Main014{
    public static void main(String[] args) {
        Solution014 s = new Solution014();
        String[] strs = {"flower","flow","flight"};
        System.out.println(s.longestCommonPrefix(strs));
    }
}

class Solution014 {
    public String longestCommonPrefix(String[] strs) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i)) {
                    return buffer.toString();
                }
            }
            buffer.append(strs[0].charAt(i));
        }
        return buffer.toString();
    }
}