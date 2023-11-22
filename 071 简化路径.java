import java.util.ArrayList;
import java.util.List;

class Main071 {
    public static void main(String[] args) {
        Solution071 solution = new Solution071();
        String path = "/a/./b/../../c/";
        System.out.println(solution.simplifyPath(path));
    }
}

class Solution071 {
    public String simplifyPath(String path) {
        if (path.length() < 1) {
            return null;
        }

        int strLen = path.length();
        int i = 0;
        StringBuffer buff = new StringBuffer();
        List<String> tokens = new ArrayList<>();
        while (i < strLen) {
            if (path.charAt(i) == '/') {
                if (!buff.isEmpty()) {
                    String s = buff.toString();
                    tokens.add(s);
                    buff.delete(0, buff.length());
                }
                i++;
                continue;
            }
            buff.append(path.charAt(i));
            i++;
        }
        if (!buff.isEmpty()) {
            String s = buff.toString();
            tokens.add(s);
        }

        StringBuilder sb = new StringBuilder();
        // int lastSlash = 0;
        for (String s: tokens) {
            if (s.equals(".")) {
                continue;
            }
            if (s.equals("..") ) {
                if (!sb.isEmpty()) {
                    while (sb.charAt(sb.length() - 1) != '/') {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    sb.deleteCharAt(sb.length() - 1);
                }
                continue;
            }

            sb.append('/');
            sb.append(s);
        }

        if (sb.isEmpty()) {
            sb.append("/");
        }

        return sb.toString();
    }
}