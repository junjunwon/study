package test;

import java.util.ArrayList;
import java.util.List;

public class MakeGoalByCards {
    public static void main(String[] args){
        //["i", "drink", "water"]	["want", "to"]	["i", "want", "to", "drink", "water"]
        solution(new String[]{"i", "drink", "water"}, new String[]{"want", "to"},
                new String[]{"i", "want", "to", "drink", "water"});

    }

    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
//        List<String> compare = new ArrayList<>();

        int firstCardIndex = 0;
        int secondCardIndex = 0;
        for (int g = 0; g < goal.length; g++) {
            boolean success = false;
            if (firstCardIndex < cards1.length && goal[g].equals(cards1[firstCardIndex])) {
//                compare.add(cards1[firstCardIndex]);
                firstCardIndex++;
                success = true;
            }
            if (secondCardIndex < cards2.length && goal[g].equals(cards2[secondCardIndex])) {
//                compare.add(cards2[secondCardIndex]);
                secondCardIndex++;
                success = true;
            }
            if (!success) {
                answer = "NO";
            }
        }

        return answer == "NO" ? answer : "YES";
    }
}
