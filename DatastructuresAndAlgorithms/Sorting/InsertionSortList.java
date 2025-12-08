package DatastructuresAndAlgorithms.Sorting;

import DatastructuresAndAlgorithms.Utils.Pair;

import java.util.ArrayList;
import java.util.List;

public class InsertionSortList {

    void main() {

        List<Pair> arr = new ArrayList<>();
        Pair pair1 = new Pair(5,"apple");
        Pair pair2 = new Pair(2,"banana");
        Pair pair3 = new Pair(9,"cherry");
        arr.add(pair1); arr.add(pair2); arr.add(pair3);
        System.out.println(insertionSort(arr));
    }

    public List<List<Pair>> insertionSort(List<Pair> pairs) {
        int n = pairs.size();
        List<List<Pair>> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int j = i - 1;
            while (j >= 0 && pairs.get(j).key > pairs.get(j + 1).key) {
                Pair temp = pairs.get(j);
                pairs.set(j, pairs.get(j + 1));
                pairs.set(j + 1, temp);
                j--;
            }

            List<Pair> cloneList = new ArrayList<>(pairs);
            res.add(cloneList);
        }
        return res;
    }
}
