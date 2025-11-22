package HackerRank;

import java.util.ArrayList;
import java.util.List;

public class DiagonalSum {
    static void main() {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();
        List<Integer> integerList1 = new ArrayList<>();
        List<Integer> integerList2 = new ArrayList<>();
        integerList.add(11);
        integerList.add(2);
        integerList.add(4);
        integerList1.add(4);
        integerList1.add(5);
        integerList1.add(6);
        integerList2.add(10);
        integerList2.add(8);
        integerList2.add(-12);
        list.add(integerList);
        list.add(integerList1);
        list.add(integerList2);

        System.out.println(diagonalDifference(list));
    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        int sum = 0;
        int otherSum = 0;
        int n = arr.size();
        for (int i = 0; i < n; i++) {
            sum += arr.get(i).get(i);
            otherSum += arr.get(i).get(n - 1 - i);
        }

        return Math.abs(sum - otherSum);

    }

}
