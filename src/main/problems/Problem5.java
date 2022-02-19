package main.problems;

public class Problem5 {

    public String longestPalindrome(String s) {
        String longestPalindrome = s.substring(0,1);

        StringBuilder curPalindrome = new StringBuilder();
        for(int i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i) == s.charAt(i + 1)) {
                int j = 1;
                while(checkChars(s, i, j - 1, j)) {
                    curPalindrome.append(s.charAt(i+j));
                    curPalindrome.insert(0, s.charAt(i+j));
                    j++;
                }
                if (curPalindrome.length() > longestPalindrome.length()) {
                    longestPalindrome = curPalindrome.toString();
                }
                curPalindrome.setLength(0);
            }

            int j = 1;
            curPalindrome.setLength(0);
            curPalindrome.append(s.charAt(i));
            while(checkChars(s, i, j, j)) {
                curPalindrome.append(s.charAt(i+j));
                curPalindrome.insert(0, s.charAt(i+j));
                j++;
            }
            if (curPalindrome.length() > longestPalindrome.length()) {
                longestPalindrome = curPalindrome.toString();
            }
            curPalindrome.setLength(0);

        }

        return longestPalindrome;
    }

    public boolean checkChars(String sourceString, int source, int leftDistance, int rightDistance){
        if(source + rightDistance >= sourceString.length() || source - leftDistance < 0) {
            return false;
        }

        return sourceString.charAt(source + rightDistance) == sourceString.charAt(source - leftDistance);
    }


//    boolean completedSearch = false;
//    int j = 1;
//            curPalindrome.append(s.charAt(i));
//            while(!completedSearch) {
//        if(!checkChars(s, i, j)) {
//            completedSearch = true;
//        } else {
//            curPalindrome.append(s.charAt(i + j));
//            curPalindrome.insert(0, s.charAt(i - j));
//        }
//        j++;
//    }
//            if(curPalindrome.length() > longestPalindrome.length()) {
//        longestPalindrome = curPalindrome.toString();
//    }
//
//            curPalindrome.setLength(0);
//
}
