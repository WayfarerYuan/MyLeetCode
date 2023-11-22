import java.util.HashMap;

class Main205{
    public static void main(String[] args) {
        Solution205 s = new Solution205();
        String s1 = "dad";
        String t1 = "add";
        System.out.println(s.isIsomorphic(s1, t1));
        String s2 = "foo";
        String t2 = "bar";
        System.out.println(s.isIsomorphic(s2, t2));
        String s3 = "paper";
        String t3 = "title";
        System.out.println(s.isIsomorphic(s3, t3));
        String s4 = "ab";
        String t4 = "aa";
        System.out.println(s.isIsomorphic(s4, t4));
    }
}

class Solution205 {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length() || s.length() == 0 || t.length() == 0) {
            return false;
        }
        HashMap<Character, Character> sMap = new HashMap<>();
        HashMap<Character, Character> tMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (!sMap.containsKey(sc)) {
                sMap.put(sc, tc);
            } else if (sMap.get(sc) != tc) {
                return false;
            }

            if (!tMap.containsKey(tc)) {
                tMap.put(tc, sc);
            } else if (tMap.get(tc) != sc) {
                return false;
            }
        }
        return true;
    }
}