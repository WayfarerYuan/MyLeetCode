class Main392 {
    public static void main(String[] args) {
        Solution392 solution = new Solution392();
        System.out.println(solution.isSubsequence("abc", "ahbgdc"));
        System.out.println(solution.isSubsequence("axc", "ahbgdc"));
    }
}

class Solution392 {
    public boolean isSubsequence(String s, String t) {
        int si = 0;
        int ti = 0;
        int slen = s.length();
        int tlen = t.length();
        while (si < slen && ti < tlen) {
            if (s.charAt(si) == t.charAt(ti)) {
                si++;
            }
            ti++;
        }
        return si == s.length();
    }
}