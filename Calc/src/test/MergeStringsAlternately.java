package test;

public class MergeStringsAlternately {
    public static void main(String[] args) {
        firstMergeAlternately("abc", "pqr");
    }
//    public static String secondMergeAlternately(String word1, String word2) {
//
//    }
    public static String firstMergeAlternately(String word1, String word2) {
        String[] firstWordArray = word1.split("");
        String[] secondWordArray = word2.split("");
        int firstLength = firstWordArray.length;
        int secondLength = secondWordArray.length;
        int equalLength = firstLength;
        int check = 0; //0 : same, 1 : word1 longer, 2 : word2 longer
        if (firstLength > secondLength) {
            equalLength = secondLength;
            check = 1;
        } else if (firstLength < secondLength){
            equalLength = firstLength;
            check = 2;
        } else {
            check = 0;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < equalLength; i++) {
            sb
                .append(firstWordArray[i])
                .append(secondWordArray[i]);
        }

        if (check == 1) {
            for (int i = equalLength; i < firstLength; i++) {
                sb.append(firstWordArray[i]);
            }
        } else if (check == 2) {
            for (int i = equalLength; i < secondLength; i++) {
                sb.append(secondWordArray[i]);
            }
        }

        return sb.toString();
    }
}
