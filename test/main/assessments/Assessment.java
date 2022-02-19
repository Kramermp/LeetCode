package main.assessments;

import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Assessment {


    int[][] cachedResult = null;
    int faces = 0;
    public static final int MOD = (int)(1e9 + 7);
    public int numRollsToTarget(int dies, int faces, int target) {
        if(target > dies * faces || dies > faces) {
            return 0;
        } else if( dies == 1) {
            return 1;
        }
         this.faces = faces;
        cachedResult = new int[dies + 1][ target + 1];
        for(int i = 0; i < cachedResult.length; i++) {
            Arrays.fill(cachedResult[i], -1);
        }

        return tabulateResults(target, dies);
    }

    private int tabulateResults(int target, int dieLeft) {
        System.out.println("Target " + target);
        System.out.println("DieLeft " + dieLeft);
        if(target == 0 && dieLeft == 0) return 1;
        if (target > 0 && dieLeft > 0 && target < dieLeft) {
            //Check Cache
            if(cachedResult[dieLeft][target] == -1) {
                long answer = 0;
                for(int i = 1; i <= faces; i++) {
                    answer+=tabulateResults(target - i, dieLeft - 1);
                }
                answer = answer % MOD;
                System.out.println("Here");
                cachedResult[dieLeft][target] = (int)answer;
                return (int)answer;
            } else {
                return cachedResult[dieLeft][target];
            }
        } else {
            return  0;
        }
    }

}
