/**
 *  Class that implements static methods used in todays laboratory.
 */
public class lab04string {
    private lab04string() {}

    /**
     * Returns length of the passed string
     * @param s string to operate on
     * @return int length of param s
     */
    public static int dlugosc(String s) {
        return s.length();
    }

    /**
     * Counts occurences of character c in passed string
     * @param s string to operate on
     * @param c character to be counted
     * @return int count of occurences
     */
    public static int ile_razy_literka_wystepuje(String s, char c) {
        int i = -1;
        int count = 0;
        while((i = s.indexOf(c, i + 1)) != -1) {
            count ++;
        }
        return count;
    }

    /**
     * Checks if passed strings are equal
     * @param s1 first string for comparision
     * @param s2 second string for comparision
     * @return boolean logic value of the result
     */
    public static boolean czy_takie_same(String s1, String s2) {
        return s1.equals(s2);
    }

    /**
     * Inverts passed string
     * @param s string to operate on
     * @return String resulting reversed string
     */
    public static String wspak(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

    /**
     * Checks if passed string is a palindrome
     * (which means it's equal to its inversion)
     * @param s string to operate on
     * @return boolean logic value of the result
     */
    public static boolean czy_plaindrom(String s) {
        return s.equals(wspak(s));
    }

    /**
     * Checks if strings characters are in alphabetical order
     * @param s string to operate on
     * @return boolean logic value of the result
     */
    public static boolean czy_abecadlowe(String s) {
        String sUpper = s.toUpperCase();
        for (int i = 0; i < s.length() - 1; i++) {
            if (sUpper.charAt(i) > sUpper.charAt(i+1)) {return false;}
        }
        return true;
    }

    /**
     * Encodes/decodes passed string using ROT13 code
     * @param s string to operate on
     * @return String new encoded/decoded string
     */
    public static String rot13(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            if (c >= 'A' && c <= 'M') { c += 13; }
            else if (c >= 'N' && c <= 'Z') { c -= 13; }
            else if (c >= 'a' && c <= 'm') { c += 13; }
            else if (c >= 'n' && c <= 'z') { c -= 13; }
            result.append((char)c);
        }
        return result.toString();
    }
}