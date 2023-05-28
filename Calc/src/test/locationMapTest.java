package test;

import java.util.ArrayList;
import java.util.List;

public class locationMapTest {
    public static void main (String[] args) {
        int answer = solution(7, 4, new int[]{2,3,6});
//        int answer = solution(4, 1, new int[]{1,2,3,4});
        System.out.println(answer);
    }

    public static int solution(int n, int m, int[] section) {
        /**
         목표 : 예산을 최소한으로 흉한 벽을 덧칠하자! -> 한번에 최대한 많은 벽을 칠하여 롤러 채색 횟수를 최소화한다.
         벽 길이 : n
         롤러 길이 : m미터
         section : 오름차순으로 정렬 (원자성 보장)
         **/
        int answer = 1;
        //처음 위치 + 롤러로 색칠한 뒤 마지막 index 2였으면 현재는 4;
        int indexAfterRoll = 0;
        if (m == 1) {
            indexAfterRoll = section[0] + m;
        } else {
            indexAfterRoll = section[0] + m - 1;
        }

        if (indexAfterRoll >= section[section.length-1]) {
            return answer;
        }

        for (int i = 1; i < section.length; i++) {
            if (indexAfterRoll <= section[i]) {
                int fixedIndexAfterRoll = indexAfterRoll;
                if (m == 1) {
                    indexAfterRoll = indexAfterRoll + m;
                } else {
                    indexAfterRoll = indexAfterRoll + m -1;
                }
                if (indexAfterRoll <= n) {
                    answer++;
                } else {
                    //범위를 넘어가면...
                    indexAfterRoll = fixedIndexAfterRoll - 1;
                    i--;
                }

            }
        }

        return answer;
    }
}
