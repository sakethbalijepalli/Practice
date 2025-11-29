package LeetcodePractice.LeetCode75;

public class Flowers {

    static void main() {
//        int[] arr = {1,0,0,0,0,0,1};
//        int n = 2;
        int[] arr = {1,0,0,0,0,0,1};
        int n = 2;
        System.out.println(canPlaceFlowers(arr,n));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {

        if(n == 0) return true;

        for(int i = 0;i < flowerbed.length;i++){
            if(flowerbed[i] == 0){
                boolean emptyLeft = (i == 0) || flowerbed[i - 1] == 0;
                boolean emptyRight = i == flowerbed.length - 1 || flowerbed[i + 1] == 0;

                if(emptyLeft && emptyRight){
                    flowerbed[i] = 1;
                    n--;
                    if(n == 0) return true;
                }
            }
        }
        return false;
    }
}
