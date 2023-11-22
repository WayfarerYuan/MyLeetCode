import java.util.HashMap;

class Main383 {}

class Solution383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> magaMap = new HashMap<>();
        if (magazine.length() < 1 || ransomNote.length() < 1) {
            return false;
        }
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            magaMap.put(c,magaMap.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            magaMap.put(c,magaMap.getOrDefault(c, 0) - 1);
            if (magaMap.get(c) < 0) {
                return false;
            }
        }
        return true;

    }
}