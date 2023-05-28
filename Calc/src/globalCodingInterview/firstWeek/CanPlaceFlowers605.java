package globalCodingInterview.firstWeek;

public class CanPlaceFlowers605 {
    public static void main (String[] args) {
        boolean result = canPlaceFlowers(new int[]{1,0,0,0,1}, 1);
        System.out.println(result);

    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }
        //flower 1개
        if (flowerbed.length == 1 && flowerbed[0] == 0 && (n == 0 || n == 1)) {
            return true;
        } else if (flowerbed.length == 1 && flowerbed[0] == 1 && n == 0) {
            return true;
        } else if (flowerbed.length == 1) {
            return false;
        }
        for (int i = 0; i < flowerbed.length; i++) {

            if (flowerbed[i] == 0) {
                if (i == 0) {
                    int right = flowerbed[i + 1];
                    if (right == 0) {
                        flowerbed[i] = 1;
                        n--;
                    }
                } else if (i == flowerbed.length -1) {
                    int left = flowerbed[i - 1];
                    if (left == 0) {
                        flowerbed[i] = 1;
                        n--;
                    }
                } else {
                    int right = flowerbed[i + 1];
                    int left = flowerbed[i - 1];
                    if (right == 0 && left == 0) {
                        flowerbed[i] = 1;
                        n--;
                    }
                }
            }
            if (n == 0) {
                return true;
            }
        }
        for (int i = 0; i < flowerbed.length; i++) {
            System.out.print(flowerbed[i] + " ");
        }
        System.out.println();
        return false;
    }
}
