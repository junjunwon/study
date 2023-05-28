package test;

import java.util.*;

public class CellPhoneKeyboard {
    public static void main(String[] args) {
        //["AGZ", "BSSS"], ["ASA", "BGZ"]
        System.out.println(solution(new String[]{"BC"}, new String[]{"AC","BC"}));
    }
    public static List<Integer> solution(String[] keymap, String[] targets) {
        List<Integer> answer = new ArrayList<>();

        Map<String, Integer> hashMap = new HashMap<>();

        for (String key : keymap) {
            String[] chars = key.split("");
            for (int i = 0; i < chars.length; i++) {
                if (hashMap.containsKey(chars[i]) && hashMap.get(chars[i]) <= i) {
                    continue;
                }
                hashMap.put(chars[i], i+1);
            }
        }

        for (String target : targets) {
            int result = 0;
            String[] letters = target.split("");
            for (String letter : letters) {
                if (!hashMap.containsKey(letter)) {
                    result = -1;
                    break;
                }
                result += hashMap.get(letter);

            }
            answer.add(result);
        }
        return answer;
    }
}
