class Main028{
    public static void main(String[] args) {
        Solution028 s = new Solution028();
//        System.out.println(s.strStr("hello", "ll"));
//        System.out.println(s.strStr("aaaaa", "bba"));
//        System.out.println(s.strStr("", ""));
//        System.out.println(s.strStr("a", ""));
        System.out.println(s.strStr("mississippi", "pi"));
    }
}

class Solution028 {
    public int strStr(String haystack, String needle) {
        int lenOfHaystack = haystack.length();
        int lenOfNeedle = needle.length();
        if (lenOfNeedle == 0) {
            return 0;
        }
        if (lenOfHaystack < lenOfNeedle) {
            return -1;
        }
        int i = 0;
        int j = 0;
        while (i < lenOfHaystack) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            } else if (j > 0) {
                i = i - j;
                j = 0;
            }
            System.out.println("i=" + i + "j=" + j);
            if (j == lenOfNeedle) {
                return i - lenOfNeedle + 1;
            }
            i++;
        }
        return -1;
    }
}