package main.problems;

import java.util.*;

public class Problem15 {

//    StringBuilder sb = new StringBuilder();
//    HashSet<String> checked = new HashSet<String>();
//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> answer = new ArrayList<>();
//
//        dfs(answer, new ArrayList<>(), nums, 0);
//        return answer;
//    }
//
//    public void dfs(List<List<Integer>> answer, List<Integer> tempAnswer, int[] nums, int curIndex) {
//        //String curHash  = getHash(tempAnswer);
//        if(tempAnswer.size() >= 3 || curIndex > nums.length){
//            int curSum = 0;
//            for(int i = 0; i < tempAnswer.size(); i++) {
//                curSum+=tempAnswer.get(i);
//            }
//
//            if(tempAnswer.size() == 3 && curSum == 0 && !checked.contains(curHash)) {
//                answer.add(new ArrayList(tempAnswer));
//                checked.add(curHash);
//                return;
//            }
//            checked.add(curHash);
//            return;
//        }
//
//        for(int i = curIndex; i < nums.length; i++) {
//            tempAnswer.add(nums[i]);
//            dfs(answer, tempAnswer, nums, i + 1);
//            tempAnswer.remove(new Integer(nums[i]));
//        }
//
//        checked.add(curHash);
//
//        return;
//    }
//
//    private String getHash(ArrayList<Integer> tempAnswer) {
//        Collections.sort(tempAnswer);
//        sb.setLength(0);
//        for(int i = 0; i < tempAnswer.size(); i++) {
//            sb.append(tempAnswer.get(i) + " ");
//        }
//
//        return sb.toString();
//    }
}
