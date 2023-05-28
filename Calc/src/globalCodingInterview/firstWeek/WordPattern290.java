package globalCodingInterview.firstWeek;

import java.util.HashMap;
import java.util.Map;

public class WordPattern290 {

    public static void main (String[] args) {
        boolean result = wordPattern("abba", "dog cat cat dog");
        System.out.println(result);
    }

    public static boolean wordPattern(String pattern, String s) {
        Map<String, String> map = new HashMap<String, String>();

        String[] patternLetters = pattern.split("");
        String[] sWords = s.split(" ");

        if (patternLetters.length > sWords.length || patternLetters.length < sWords.length) {
            return false;
        }
        for (int i = 0; i < patternLetters.length; i++) {
            if (map.containsKey(patternLetters[i])) {
                if (!map.get(patternLetters[i]).equals(sWords[i])) {
                    return false;
                }
            } else {
                if (map.containsValue(sWords[i])) {
                    return false;
                } else {
                    map.put(patternLetters[i], sWords[i]);
                }
            }
        }
        return true;
    }
}
