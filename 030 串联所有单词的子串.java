import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Main030 {
    public static void main(String[] args) {
        Solution030 s = new Solution030();
        String s1 = "aaaaaa";
        String[] words1 = {"a","a"};
        List<Integer> res1 = s.findSubstring(s1, words1);
        for (Integer i : res1) {
            System.out.print(i + " ");
        }
        System.out.println();

        String s2 = "wordgoodgoodgoodbestword";
        String[] words2 = {"word","good","best","word"};
        List<Integer> res2 = s.findSubstring(s2, words2);
        for (Integer i : res2) {
            System.out.print(i + " ");
        }
        System.out.println();

        String s3 = "barfoofoobarthefoobarman";
        String[] words3 = {"bar","foo","the"};
        List<Integer> res3 = s.findSubstring(s3, words3);
        for (Integer i : res3) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

class Solution030 {
    public List<Integer> findSubstring(String s, String[] words) {
        int wordsLen = words.length;
        int wordLen = words[0].length();
        int windowLen = wordsLen * wordLen;

        if (s.length() < windowLen) {
            return new ArrayList<>();
        }

//        String[] matchedWords = new String[wordsLen];
        List<Integer> res = new ArrayList<>();
        List<String> ogWords = new ArrayList<>();
        for (String word : words) {
            ogWords.add(word);
        }

        // 最外层循环，用来每次向右移动一位
        for (int o = 0; o < wordLen; o++) {
            HashMap<String, Integer> map = new HashMap<>();
            for (String word : words) {
                map.put(word, 0);
            }
            for (int i = o; i + wordLen <= o + windowLen; i += wordLen) {
                String curWord = s.substring(i, i + wordLen);
                if (ogWords.contains(curWord)) {
                    map.put(curWord, map.get(curWord) + 1);
                }
            }
            // 如果map中的值全是1，那么就是一个匹配
            for (String key : map.keySet()) {
                if (map.get(key) != 1) {
                    break;
                }
                if (key.equals(words[wordsLen - 1])) {
                    res.add(o);
                }
            }
            System.out.println(" " + map);

            for (int i = o; i + windowLen + wordLen <= s.length(); i += wordLen) {
                String curWord = s.substring(i, i + wordLen);
                if (ogWords.contains(curWord)) {
                    map.put(curWord, map.getOrDefault(curWord, 0) - 1);
                }
                curWord = s.substring(i + windowLen, i + windowLen + wordLen);
                if (ogWords.contains(curWord)) {
                    map.put(curWord, map.getOrDefault(curWord, 0) + 1);
                }
                System.out.println(map);
                // 如果map中的值全是1，那么就是一个匹配
                for (String key : map.keySet()) {
                    if (map.get(key) != 1) {
                        break;
                    }
                    if (key.equals(words[wordsLen - 1])) {
                        res.add(i + wordLen);
                    }
                }
            }
        }
//        // 暴力解法，超时了
//        for (int i = 0; i + windowLen <= s.length() ; i++) {
//            String curWindow = s.substring(i, i + windowLen);
//            if (isMatched(curWindow, words)) {
//                res.add(i);
//            }
//        }
        return res;
    }


//    // 暴力搜的helper function，有用，但超时了
//    private Boolean isMatched(String s, String[] words) {
//        int wordsLen = words.length;
//        int wordLen = words[0].length();
//        int windowLen = wordsLen * wordLen;
//
//        List<String> wordsLeft = new ArrayList<>();
//        for (String word : words) {
//            wordsLeft.add(word);
//        }
//
//        for (int i = 0; i < windowLen; i += wordLen) {
//            String curWord = s.substring(i, i + wordLen);
//            if (wordsLeft.contains(curWord)) {
//                wordsLeft.remove(curWord);
//            } else {
//                return false;
//            }
//        }
//        return true;
//    }
}