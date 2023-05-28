package globalCodingInterview.firstWeek;

public class MergeStringsAlternately1768 {
    public static void main (String[] args) {
        String result = mergeAlternately("abc", "pqr");
        System.out.println(result);
    }
    public static String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();

        int check = 0; //0 : same, 1 : word1 longer, 2 : word2 longer

        String[] firstWordArray = word1.split("");
        String[] secondWordArray = word2.split("");
        int firstLength = firstWordArray.length;
        int secondLength = secondWordArray.length;
        int minimumLength = firstLength > secondLength ? secondLength : firstLength;

        for (int i = 0; i < minimumLength; i++) {
            sb.append(firstWordArray[i]).append(secondWordArray[i]);
        }

        if (firstLength > secondLength) {
            for (int i = minimumLength; i < firstLength; i++) {
                sb.append(firstWordArray[i]);
            }
        } else if (firstLength < secondLength) {
            for (int i = minimumLength; i < secondLength; i++) {
                sb.append(secondWordArray[i]);
            }
        }

        return sb.toString();
    }
}
