import java.util.ArrayList;
import java.util.List;

class Main068{
    public static void main(String[] args) {
        Solution068 s = new Solution068();
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        List<String> res = s.fullJustify(words, maxWidth);
        for (String str : res) {
            System.out.println("/" + str + "/");
        }
        words = new String[]{"What","must","be","acknowledgment","shall","be"};
        maxWidth = 16;
        res = s.fullJustify(words, maxWidth);
        for (String str : res) {
            System.out.println("/" + str + "/");
        }
        words = new String[]{"Science","is","what","we","understand","well","enough","to","explain",
                "to","a","computer.","Art","is","everything","else","we","do"};
        maxWidth = 20;
        res = s.fullJustify(words, maxWidth);
        for (String str : res) {
            System.out.println("/" + str + "/");
        }
    }
}

class Solution068 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        StringBuilder thisLine = new StringBuilder();
        List<String> wordsInThisLine = new ArrayList<>();
        int wordLen = 0;
        int wordCount = 0;
        int usedWidth = 0;
        int spaceLen = 0;
        int extraSpaceCount = 0;
        List<String> res = new ArrayList<>();
        for (String word : words) {
            wordLen = word.length();
            if (usedWidth + wordLen + wordCount > maxWidth) {
                // 如果加上这个单词就超过了最大宽度，那么就要把这一行的单词拼接起来
                if (wordCount == 1) {
                    // 如果这一行只有一个单词，那么就左对齐，后面补空格
                    thisLine.append(wordsInThisLine.get(0));
                    for (int i = 0; i < maxWidth - usedWidth; i++) {
                        thisLine.append(" ");
                    }
                } else {
                    // 如果这一行有多个单词，那么就要计算空格的长度
                    spaceLen = maxWidth - usedWidth;
                    extraSpaceCount = spaceLen % (wordCount - 1);
                    spaceLen /= (wordCount - 1);
                    for (int i = 0; i < wordCount; i++) {
                        if (i != wordCount - 1) {
                            thisLine.append(wordsInThisLine.get(i));
                            for (int j = 0; j < spaceLen; j++) {
                                thisLine.append(" ");
                            }
                            if (extraSpaceCount > 0) {
                                thisLine.append(" ");
                                extraSpaceCount--;
                            }
                        } else {
                            thisLine.append(wordsInThisLine.get(i));
                        }
                    }
                }
                // add this line to res
                res.add(thisLine.toString());
                // reset the variables
                thisLine = new StringBuilder();
                wordsInThisLine = new ArrayList<>();
                wordCount = 1;
                usedWidth = wordLen;
                wordsInThisLine.add(word);

            } else {
                wordCount++;
                usedWidth += wordLen;
                wordsInThisLine.add(word);
            }
        }
        // 最后一行的左对齐且不加额外的空格
        for (int i = 0; i < wordCount; i++) {
            if (i != wordCount - 1) {
                thisLine.append(wordsInThisLine.get(i));
                thisLine.append(" ");
            } else {
                thisLine.append(wordsInThisLine.get(i));
            }
        }
        for (int i = 0; i < maxWidth - usedWidth - wordCount + 1; i++) {
            thisLine.append(" ");
        }
        res.add(thisLine.toString());
        return res;
    }
}