package main.assessments;

import java.util.Arrays;

public class StringShuffle {

    char[] chars;

    public String restoreString(String s, int[] indices) {
        chars = new char[s.length()];
        for(int i = 0; i < s.length(); i++) {
            chars[indices[i]] = s.charAt(i);
        }

        StringBuilder sb = new StringBuilder();
        for( char curChar : chars) {
            sb.append(curChar);
        }
        return sb.toString();
    }
}
