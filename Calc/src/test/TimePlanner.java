package test;

import java.util.Arrays;

public class TimePlanner {

    static int[] meetingPlanner(int[][] slotsA, int[][] slotsB, int dur) {
        int[] result = new int[2];
        for (int i = 0; i < slotsA.length; i++) {
            int eachDurA = slotsA[i][1] - slotsA[i][0];
            if (eachDurA < dur) {
                continue;
            }
            for (int  j = 0; j < slotsB.length; j++) {
                int eachDurB = slotsB[j][1] - slotsB[j][0];
                if (eachDurB < dur) {
                    continue;
                }
                if (slotsA[i][0] > slotsB[j][0]) {
                    if (slotsB[j][1] - dur >= slotsA[i][0]) {
                        result[0] = slotsB[j][0];
                        result[1] = result[0] + dur;
                        return result;
                    }
                } else if (slotsA[i][0] <= slotsB[j][0]) {
                    if (slotsA[i][1] - dur >= slotsB[j][1]) {
                        result[0] = slotsA[i][0];
                        result[1] = result[0] + dur;
                        return result;
                    }
                }
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
//        int[][] slotA = {{10, 50}, {60, 120}, {140, 210}};
        int[][] slotA = {{6, 12}};
//        int[][] slotB = {{0,15}, {60,70}};
        int[][] slotB = {{2, 11}};
        int[] result = meetingPlanner(slotA, new int[0][0], 5);
        System.out.println(Arrays.toString(result));
    }
}
