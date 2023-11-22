import java.util.HashMap;

class Main290 {
    public static void main(String[] args) {
        Solution290 sol = new Solution290();
        String pattern = "abba";
        String s = "dog cat cat dog";
        System.out.println(sol.wordPattern(pattern, s));
        pattern = "abba";
        s = "dog cat cat fish";
        System.out.println(sol.wordPattern(pattern, s));
        pattern = "aaaa";
        s = "dog cat cat dog";
        System.out.println(sol.wordPattern(pattern, s));
        pattern = "abba";
        s = "dog dog dog dog";
        System.out.println(sol.wordPattern(pattern, s));
    }
}

class Solution290 {
    public boolean wordPattern(String pattern, String s) {
        if (pattern.length() < 1 || s.length() < 1) {
            return false;
        }
        s = s.trim();
        String[] sArray = s.split(" ");
        int pLen = pattern.length();
        int sLen = sArray.length;
        if (sLen != pLen) {
            return false;
        }

        HashMap<Character, String> patternMap = new HashMap<>();
        for (int i = 0; i < pLen; i++) {
            char c = pattern.charAt(i);
            if (!patternMap.containsKey(c)) {
                patternMap.put(c, sArray[i]);
            } else if (!patternMap.get(c).equals(sArray[i])) {
                return false;
            }
        }
        return true;
    }
}