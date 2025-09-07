public class GfG {
    public static boolean isMatchRec(String t, String p, int n, int m) {
      
        // If pattern is empty, then text must also be
        // empty
        if (m == 0) {
            return n == 0;
        }

        // If text is empty, then pattern can have characters
        // followed by *s
        if (n == 0) {
            return (m >= 2 && p.charAt(m - 1) == '*') && 
                     isMatchRec(t, p, n, m - 2);
        }

        // If last characters of both string and pattern
        // match, or pattern has '.'
        if (t.charAt(n - 1) == p.charAt(m - 1) || p.charAt(m - 1) == '.') {
            return isMatchRec(t, p, n - 1, m - 1);
        }

        // Handle '*' in the pattern
        if (p.charAt(m - 1) == '*' && m > 1) {
          
            // Check if '*' can represent zero occurrences
            // of the preceding character
            boolean zero = isMatchRec(t, p, n, m - 2);

            // Check if '*' can represent one or more occurrences
            // of the preceding character
            boolean oneOrMore = (p.charAt(m - 2) == t.charAt(n - 1) || p.charAt(m - 2) == '.') &&
                                   isMatchRec(t, p, n - 1, m);

            return zero || oneOrMore;
        }

        // If no match
        return false;
    }

    // Wrapper function
    public static boolean isMatch(String t, String p) {
        return isMatchRec(t, p, t.length(), p.length());
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aab", "a.*"));
        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("ab", ".*");
        System.out.println(isMatch("mississippi", "mis*is*p*."));
    }
}
