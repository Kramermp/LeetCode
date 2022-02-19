package main.problems;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Problem37 {
    Cell[][] answer = null;
    int offset = 0;
    int[] possAnswers = new int[]{1,2,3,4,5,6,7,8,9};

    PriorityQueue<Cell> toBeSolved = new PriorityQueue<>();
    public void solveSudoku(char[][] board) {
        answer = new Cell[9][9];
        for(int i = 0; i < answer.length; i++)
            for(int j = 0; j < answer[i].length; j++)
                answer[i][j]=new Cell(new int[]{1,2,3,4,5,6,7,8,9});

        for(int i  = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] != '.') {
                    setAnswer(i, j, answer[i][j], board[i][j] - '0');
                } else {
                    // Do Nothing with Empty Cells
                }
            }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(!answer[i][j].solved) {
                    toBeSolved.add(answer[i][j]);
                }
            }
        }

        dfs();
    }

    private void dfs() {

    }


    private void updateRegion(int yPos, int xPos, int i1) {
        int yRegion = getRegion(yPos);
        int xRegion = getRegion(xPos);
        for(int i = 3 * (yRegion - 1); i < 3 * yRegion; i++) {
            for(int j = 3 *(xRegion - 1); j < 3 *xRegion; j++) {
                if(!answer[i][j].solved) {
                    answer[i][j].removeOption(i1);
                    if(answer[i][j].possAnswer.length == 1) {
                        isSolved(i, j, answer[i][j]);
                    }
                }
            }
        }
    }

    private void isSolved(int i, int j, Cell cell) {
        cell.solved();
        updateRow(i, cell.val);
        updateColumn(j, cell.val);
        updateRegion(i, j, cell.val);
    }

    private void setAnswer(int i, int j, Cell cell, int num) {
        cell.setAnswer(num);
        isSolved(i, j, cell);
    }

    private int getRegion(int i) {
        if(i < 3) {
            return 1;
        } else if (i < 6) {
            return 2;
        } else if ( i < 9) {
            return 3;
        } else  {
            return -1;
        }
    }


    private boolean updateRow(int rowNum, int num) {
        for(int i = 0; i < answer[rowNum].length; i++)
            if(!answer[rowNum][i].solved) {
                answer[rowNum][i].removeOption(num);
                if(answer[rowNum][i].possAnswer.length == 1) {
                    isSolved(rowNum, i, answer[rowNum][i]);
                }
            }

        return false;
    }

    private boolean updateColumn(int index, int num) {
        for(int i = 0; i < answer.length; i++) {
            if(!answer[i][index].solved) {
                answer[i][index].removeOption(num);
                if(answer[i][index].possAnswer.length == 0) {
                    isSolved(i, index, answer[i][index]);
                }
            }
        }
        return true;
    }

    private class Cell implements Comparable<Cell> {
        int[] possAnswer;
        int val = -1;
        boolean solved = false;

        public Cell(int[] possAnswer) {
            this.possAnswer = possAnswer;
        }

        public void solved() {
            this.val = possAnswer[0];
            this.solved = true;
        }

        @Override
        public int compareTo(Cell cell) {
            return Integer.compare(possAnswer.length, cell.possAnswer.length);
        }

        protected void removeOption(int num) {
            offset = 0;
            for(int i = 0; i < possAnswer.length; i++) {
                if(possAnswer[i] != num) {
                    possAnswer[i - offset] = possAnswer[i];
                } else {
                    offset++;
                }
            }
            this.possAnswer = Arrays.copyOfRange(possAnswer, 0, possAnswer.length - offset);
            if(this.possAnswer.length == 1) {
                this.val = possAnswer[0];
            }
        }

        public void setAnswer(int num) {
            this.possAnswer = new int[]{num};
            this.val = num;
        }
    }


}
