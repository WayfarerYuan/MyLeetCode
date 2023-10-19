class Main125 {
    public static void main(String[] args) {
        Solution125 s = new Solution125();
        String str = "A man, a plan, a canal: Panama";
        System.out.println(s.isPalindrome(str));
        str = "./";
        System.out.println(s.isPalindrome(str));
    }
}

class Solution125 {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (!Character.isLetter(s.charAt(left)) && !Character.isDigit(s.charAt(left))) {
                left++;
                if (left >= right) {
                    return true;
                }
            }
            while (!Character.isLetter(s.charAt(right)) && !Character.isDigit(s.charAt(right))) {
                right--;
                if (left >= right) {
                    return true;
                }
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }
}