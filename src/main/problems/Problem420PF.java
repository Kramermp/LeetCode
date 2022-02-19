package main.problems;

import jdk.nashorn.internal.ir.LexicalContext;
import jdk.nashorn.internal.ir.LexicalContextNode;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class Problem420PF {
    static final char VARIABLE_CHAR = 257;
    static final int MAX_REPEATS = 3;
    PriorityBlockingQueue<StringEntry> entries = new PriorityBlockingQueue<StringEntry>();
    ArrayList<StringEntry> checked = new ArrayList<>();
    private boolean responseWaiting = false;
    private StringEntry answer = null;

    public int strongPasswordChecker(String password) {
        Thread[] threads = new Thread[16];
        for(int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new CheckThread(this, password, i));
            threads[i].start();
        }

        waitForResponse();
        return answer.steps;
    }

    private void waitForResponse() {
        long lastCheck = System.currentTimeMillis();
        while(!responseWaiting) {
//            System.out.println(checked.size());
            if(System.currentTimeMillis() - lastCheck > 1000) {
                System.out.println(entries.peek().steps);
            }
        }
    }

    private void addToQueue(StringEntry stringEntry) {
        if(checked.contains(stringEntry)) {
            // Do nothing
        } else {
            entries.add(stringEntry);
            checked.add(stringEntry);
        }
    }

    private void generateInsertEntries(StringEntry curEntry, StringBuilder sb, int i) {
        sb.insert(i, " "); // Space Holder
        generateReplacementEntries(curEntry, sb, i);
    }

    private void generateReplacementEntries(StringEntry curEntry, StringBuilder sb, int i) {

        if(!curEntry.containsDigit()) {
            sb.replace(i, i + 1, "1");
            addToQueue(new StringEntry(sb.toString(), curEntry.steps + 1));
        }

        if(!curEntry.containsLowerCase()) {
            sb.replace(i, i + 1, "a");
            addToQueue(new StringEntry(sb.toString(), curEntry.steps + 1));
        }

        if(!curEntry.containsUpperCase()) {
            sb.replace(i, i + 1, "A");
            addToQueue(new StringEntry(sb.toString(), curEntry.steps + 1));
        }

        sb.replace(i, i + 1, String.valueOf(VARIABLE_CHAR));
        addToQueue(new StringEntry(sb.toString(), curEntry.steps + 1));
    }

    class StringEntry implements Comparable<StringEntry> {
        String string;
        int score = Integer.MIN_VALUE;
        int steps = Integer.MAX_VALUE;

        public StringEntry(String string, int steps) {
            this.string = string;
            this.steps = steps;
            calculateScore(); // Updates the Score
        }

        private void calculateScore() {
            score=(containsDigit() ? 10 : 0);
            score+=(containsUpperCase() ? 10 : 0);
            score+=(containsLowerCase() ? 10 : 0);
            score+=computeLengthScore();
            score-=(containsRepeatedChars() ? 10 : 0);
            score-=((repeatScore()) * 10);
//            score-=steps * 2;
        }

        int repeatScore() {
            char[] chars = string.toCharArray();
            int repeatScore = 0;

            if(string.length() < MAX_REPEATS) {
                return  0;
            } else {
                char curChar = chars[0];
                int runningCount = 0;

                for(int i = 0; i < chars.length; i++) {
                    if(curChar == chars[i]) {
                        runningCount++;
                    } else {
                        repeatScore+=Math.floor(runningCount / MAX_REPEATS);

                        runningCount = 1;
                        curChar = chars[i];
                    }
                }
                repeatScore+=Math.floor(runningCount / MAX_REPEATS);
            }


            return repeatScore;
        }

        int computeLengthScore() {
            return string.length() < 6 ? string.length() * 10: (string.length() <= 20 ? 70 : 70 - Math.abs((string.length() - 20) * -1));
        }

        @Override
        public int compareTo(StringEntry stringEntry) {

            return (score < stringEntry.score) ? 1 : (score == stringEntry.score) ? 0 : -1;
            //return Integer.compare(score, stringEntry.score) * -1; // Reverse Order here vs In Queue
        }

        @Override
        public boolean equals(Object object) {
            if(!(object instanceof  StringEntry)) {
                return  false;
            } else {
                StringEntry obj = (StringEntry) object;
                return obj.string.equals(string) && obj.steps == steps;
            }
        }

        private boolean isStrongPassword() {
            return string.length() >= 6 && string.length() <= 20 && containsDigit() && containsLowerCase()
                    && containsUpperCase() && !(containsRepeatedChars());

        }

        public boolean containsLowerCase() {
            for(int i = 0; i < string.length(); i++) {
                if(Character.isLowerCase(string.charAt(i))) {
                    return true;
                }
            }
            return false;
        }

        public boolean containsUpperCase() {
            for(int i = 0; i < string.length(); i++) {
                if(Character.isUpperCase(string.charAt(i))) {
                    return true;
                }
            }
            return false;
        }

        public boolean containsDigit() {
            for(int i = 0; i < string.length(); i++) {
                if(Character.isDigit(string.charAt(i))) {
                    return true;
                }
            }
            return false;
        }
        public boolean containsRepeatedChars() {
            if(string.length() < MAX_REPEATS) {
                return  false;
            } else {
                char curChar = string.charAt(0);
                int runningCount = 0;
                for(int i = 0; i < string.length(); i++) {
                    if(curChar == string.charAt(i)) {
                        runningCount++;
                        if(runningCount >= MAX_REPEATS && curChar != VARIABLE_CHAR) {
                            return true;
                        }
                    } else {
                        runningCount = 1;
                        curChar = string.charAt(i);
                    }
                }
            }

            return false;
        }
    }


    private class CheckThread implements Runnable {
        Problem420PF parent = null;
        String password = "";
        int id = 0;

        CheckThread(Problem420PF parent, String password, int id) {
            this.parent = parent;
            this.password = password;
            this.id = id;
        }

        @Override
        public void run() {

            int steps = 0;
            StringEntry init = new StringEntry (password, steps);
            addToQueue(init);

            StringEntry curEntry = init;
            StringBuilder sb = new StringBuilder();
            int counter = 0;
            int i = 0;
            while(!curEntry.isStrongPassword() && !responseWaiting) {
                counter++;
                if(curEntry.string.length() <= 6) {
                    if(!curEntry.containsDigit()) {
                        sb.setLength(0);
                        sb.append(curEntry.string + "1");
                        addToQueue(new StringEntry(sb.toString(), curEntry.steps + 1));
                    }

                    if(!curEntry.containsLowerCase() ) {

                        sb.setLength(0);
                        sb.append(curEntry.string + "a");
                        addToQueue(new StringEntry(sb.toString(), curEntry.steps + 1));
                    }

                    if(!curEntry.containsUpperCase() ) {
                        sb.setLength(0);
                        sb.append(curEntry.string + "A");
                        addToQueue(new StringEntry(sb.toString(), curEntry.steps + 1));
                    }

                    sb.setLength(0);
                    sb.append(curEntry.string + String.valueOf(VARIABLE_CHAR));
                    addToQueue(new StringEntry(sb.toString(), curEntry.steps + 1));
                }


                for(i = 0; i < curEntry.string.length(); i++) {
                    sb.setLength(0);
                    sb.append(curEntry.string);
                    //Generate Replacement Entries
                    generateReplacementEntries(curEntry, sb, i);

                    sb.setLength(0);
                    sb.append(curEntry.string);
                    generateInsertEntries(curEntry, sb, i);


                    sb.setLength(0);
                    sb.append(curEntry.string);
                    sb.replace(i, i + 1, String.valueOf(VARIABLE_CHAR));
                    addToQueue(new StringEntry(sb.toString(), curEntry.steps + 1));

                    sb.setLength(0);
                    sb.append(curEntry.string);
                    sb.deleteCharAt(i);
                    addToQueue(new StringEntry(sb.toString(), curEntry.steps + 1));
                }

                curEntry = entries.poll();
                //System.out.println(id + " : " + counter);
            }
            if(!responseWaiting) {
                parent.answer = curEntry;
                parent.responseWaiting = true;
            }
        }
    }

}


