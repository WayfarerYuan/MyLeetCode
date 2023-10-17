import java.util.*;

class Main151 {
    public static void main(String[] args) {
        Solution151 s = new Solution151();
        String str = "  hello world  ";
        System.out.println(s.reverseWords(str));
    }
}

class Solution151 {
    public String reverseWords(String s) {
        // 这一行似乎很好用，“\\s+”正则表示一个或多个空格，再加上trim()去掉首尾空格，这样一步就完成了去除多余空格的操作并将字符串分割成单词的List
        List<String> list = Arrays.asList(s.trim().split("\\s+"));
        Collections.reverse(list);
        return String.join(" ", list);
    }
}