import generateGoogleDriveLink.GenerateGoogleFiles;
import generateQuery.CreateQuery;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
//        long sales = Math.round(1.15 * 50_000);
//        long sales = (long)(0.69 * 21_000);
//        findLeastNumOfUniqueInts(new int[]{4,3,1,1,3,3,2}, 3);
        System.out.println(minDays(new int[]{1,10,3,10,2}, 3, 1));
        System.out.println(minDays(new int[]{1,10,3,10,2}, 3, 2));
        System.out.println(minDays(new int[]{7,7,7,7,12,7,7}, 2, 3));

//        CreateQuery query = new CreateQuery();
//        query.createProductOptionQuery();

//        GenerateGoogleFiles googleFiles = new GenerateGoogleFiles();
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] inputList = br.readLine().split(",");
//        for (String input : inputList) {
//            googleFiles.make(input);
//        }
//        BufferedReader br;
//        while (true) {
//            br = new BufferedReader(new InputStreamReader(System.in));
//            String input = br.readLine();
//            googleFiles.make(input);
//        }

    }
    public static int minDays(int[] bloomDay, int m, int k) {
        // m : bounquetList.size
        // k : 정원에 가장 인접한 꽃
        // n : number of flower
        // bloomDay에 인덱스별로 꽃 순서를 나열 . -> 꽃은 반드시 1개의 부케에만 사용될 수 있다.
        // 가장 최단기간동안 기다려서 부케를 만드는 방법을 구해야하고, 불가능할 경우 -1을 return한다.

        // 즉,,,, m = 3개의 부케를 만들기 위해
        // k개의 꽃을 이용해 1개의 부케를 만들 수 있고, m = 3개의 부케를 만드는데 필요한 최소 일수를 구하여라.

        //최대 일수 구하기
        int maxDay = 0;
        for (int bloom : bloomDay) {
            if (bloom > maxDay) {
                maxDay = bloom;
            }
        }

        int day = 1;
        while(maxDay >= day) {
            int cnt = k;
            int startIdx = 0;
            boolean set = false;
            for (int i = 0; i < bloomDay.length; i++) {

                if (day >= bloomDay[i]) {
                    if (!set) {
                        startIdx = i;
                        set = true;
                    }
                    cnt--;
                } else {
                    cnt = k;
                }
                if (cnt == 0) {
                    bloomDay = creatNewArray(bloomDay, startIdx, i);
                    m--;
                    i = 0;
                    cnt = k;
                    set = false;
                    if (m == 0) {
                        return day;
                    }
                }
            }
            day++;
        }
        return -1;
    }

    private static int[] creatNewArray(int[] bloomDay, int startIdx, int i) {
        //from startIdx to i을 제외한 array 생성하기.
        int[] result = new int[bloomDay.length - (i - startIdx + 1)];
        System.arraycopy(bloomDay, 0, result, 0, startIdx);
        System.arraycopy(bloomDay, i + 1, result, startIdx, bloomDay.length - i - 1);

        return result;
    }

    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int a : arr){
            freq.put(a, 1 + freq.getOrDefault(a, 0));
        }
        int len = freq.size(); //몇가지 데이터가 있는지?
        TreeMap<Integer, Integer> occ = new TreeMap<>();
        for (int v : freq.values()){
            /**
             * key : 2, value : 1 같은 숫자가 2개인 element가 1개 있음.
             */
            occ.put(v, 1 + occ.getOrDefault(v, 0));
        }
        while(k>0){
            Map.Entry<Integer,Integer> entry = occ.pollFirstEntry(); // occ에 있는거 하나씩 빼서 계산하는데 뭘...계산할까
            /**
             * [4,3,1,1,3,3,2], k = 3
             * 1: 2 / 2 : 1 / 3 : 3 / 4 : 1
             * Len = 4
             * k = 3
             * 빈도 1의 element -> 2 (2,4)
             * 빈도 2의 element -> 1 (1)
             * 빈도 3의 element -> 1 (3)
             *
             * 3 - 1 * 2 = 1
             * k = 3 - (1 * 2) -> k = 1
             * len = 4 - 2 -> len = 2
             *
             * if ( 1 - 2 * 1 -> wrong
             * 2 - 1 / 1 = 1
             */
            if (k - entry.getKey() * entry.getValue() >= 0){
                k -= entry.getKey() * entry.getValue();
                len -= entry.getValue();
            }
            else {
                return len - k / entry.getKey();
            }
        }
        return len;
    }
}

