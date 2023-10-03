package greedy;

public class Leetcode605 {

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed == null) return false;

        int len = flowerbed.length;

        int count = 0;

        for(int i = 0; i < len; i++) {
            if(i == 0) {
                if(i+1 < len && flowerbed[i] == 0 && flowerbed[i+1] == 0) {
                    count++;
                    flowerbed[i] = 1;
                }
            } else if(i == len-1) {
                if(len -2 >= 0 && flowerbed[i] == 0 && flowerbed[i-1] == 0) {
                    count++;
                    flowerbed[i] = 1;
                }
            } else if(flowerbed[i-1] == 0 && flowerbed[i] == 0 && flowerbed[i+1] == 0) {
                count++;
                flowerbed[i] = 1;
            }

        }

        return count >= n;
    }

    public static void main(String[] args) {
        int[] flowerbed = {0,0,1,0,1};
        Leetcode605.canPlaceFlowers(flowerbed, 1);
    }
}
