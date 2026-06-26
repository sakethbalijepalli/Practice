package Neetcode.neetcode150.stacks;

import java.util.Arrays;
import java.util.Stack;

public class CarFleet {

    void main() {
        System.out.println(carFleet(17,new int[]{8,12,16,11,7},new int[]{6,9,10,9,7}));
    }
    //    16 - 10 - 1 fleet
    //    12 - 9 - 2 fleet
    //    11 - 9 - 3 fleet
    //    8 - 6  - 4 fleet
    //    7 - 7  - 4 fleet

    public int carFleet(int target, int[] position, int[] speed) {
        if(target == 0 || position.length == 0 || speed.length == 0) return 0;

//        Sort the position array and get absolute leader of the pack/fleet
        int n = position.length;
        int[][] cars = new int[n][2];

        for(int i = 0;i < position.length;i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars,(a,b) -> Integer.compare(b[0],a[0]));

//        If currentCarTime > stack.peek then we push to the stack, then we find a new leader and that car will lead the fleet.
        double prevTime = 0;
        int fleets = 0;
        for(int i = 0;i < position.length;i++){
            int positionOfCar = cars[i][0];
            int speedOfCar = cars[i][1];
            double currentCarTime = (target - (double) positionOfCar) / speedOfCar;
            if(currentCarTime > prevTime){
                fleets++;
                prevTime = currentCarTime;
            }
        }
        return fleets;
    }
}
