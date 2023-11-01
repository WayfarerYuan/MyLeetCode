class Main003 {
    public static void main(String[] args) {
        Solution003 solution = new Solution003();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
        System.out.println(solution.lengthOfLongestSubstring(""));
    }
}

class Solution003 {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int left = 0, right = 0;
        int res = 0;

        while (right < len) {
            // 如果right + 1的字符在[left, right]中出现过，那么left右移直至不重复
            if (s.substring(left, right).contains(s.substring(right, right + 1))) {
                left++;
            } else {
                right++;
                res = Math.max(res, right - left);
            }
        }
        return res;
    }
}