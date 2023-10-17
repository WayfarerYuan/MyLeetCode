class Main058 {
    public static void main(String[] args) {
        Solution058 solution = new Solution058();
        System.out.println(solution.lengthOfLastWord("Hello World"));
        System.out.println(solution.lengthOfLastWord(" "));
        System.out.println(solution.lengthOfLastWord("   fly me   to   the moon  "));
    }
}

class Solution058 {
    public int lengthOfLastWord(String s) {
        int res = 0;
        int i = s.length() - 1;
        // 从后往前找到第一个不是空格的字符
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        // 从后往前找到第一个是空格的字符
        while (i >= 0 && s.charAt(i) != ' ') {
            res++;
            i--;
        }
        return res;
    }
}