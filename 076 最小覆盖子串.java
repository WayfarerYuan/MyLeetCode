import java.util.HashMap;

class Main076 {
    public static void main(String[] args) {
        Solution076 sol = new Solution076();
        String s = "cabwefgewcwaefgcf";
        String t = "cae";
        System.out.println(sol.minWindow(s, t));
        s = "a";
        t = "a";
        System.out.println(sol.minWindow(s, t));
        s = "a";
        t = "aa";
        System.out.println(sol.minWindow(s, t));
    }
}

class Solution076 {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        HashMap<Character, Integer> tMap = new HashMap<>();
        HashMap<Character, Integer> sMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int required = tMap.size();
        int formed = 0;
        int[] ans = {-1, 0, 0};  // {length of substring, left, right}

        while (right < s.length()) {
            char c = s.charAt(right);
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);

            if (tMap.containsKey(c) && sMap.get(c).intValue() == tMap.get(c).intValue()) {
                formed++;
            }

            while (left <= right && formed == required) {
                c = s.charAt(left);
                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }

                sMap.put(c, sMap.get(c) - 1);
                if (tMap.containsKey(c) && sMap.get(c).intValue() < tMap.get(c).intValue()) {
                    formed--;
                }

                left++;
            }

            right++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}