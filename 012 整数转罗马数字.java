import java.util.List;

class Main012{
    public static void main(String[] args) {
        Solution012 s = new Solution012();
        System.out.println(s.intToRoman(3));
        System.out.println(s.intToRoman(4));
        System.out.println(s.intToRoman(9));
        System.out.println(s.intToRoman(58));
        System.out.println(s.intToRoman(1994));
    }
}

class Solution012 {
    public String intToRoman(int num) {
        List<String> list = List.of("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I");
        List<Integer> nums = List.of(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1);
        StringBuffer roman = new StringBuffer();
        for (int i = 0; i < nums.size(); i++) {
            while (num >= nums.get(i)) {
                roman.append(list.get(i));
                num -= nums.get(i);
            }
        }
        return roman.toString();
    }
}