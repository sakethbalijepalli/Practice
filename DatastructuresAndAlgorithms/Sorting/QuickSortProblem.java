package DatastructuresAndAlgorithms.Sorting;

import DatastructuresAndAlgorithms.Utils.Pair;

import java.util.ArrayList;
import java.util.List;

public class QuickSortProblem {

    void main() {
        List<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair(5, "apple"));
        pairs.add(new Pair(9, "banana"));
        pairs.add(new Pair(9, "cherry"));
        pairs.add(new Pair(1, "date"));
        pairs.add(new Pair(9, "elderberry"));

        System.out.println(quickSort(pairs));
    }

    public List<Pair> quickSort(List<Pair> pairs) {
        return quickSortHelper(pairs,0,pairs.size() - 1);
    }

    public List<Pair> quickSortHelper(List<Pair> pairs,int start,int end){
        if(end - start + 1 <= 1){
            return pairs;
        }

        int pivot = pairs.get(end).key;
        int left = start;

        for(int i = start;i < pairs.size() - 1;i++){
            if(pairs.get(i).key < pivot){
                Pair tempPair = pairs.get(left);
                pairs.set(left,pairs.get(i));
                pairs.set(i,tempPair);
                left++;
            }
        }

        Pair tempPair = pairs.get(left);
        pairs.set(left,pairs.get(end));
        pairs.set(end,tempPair);

        quickSortHelper(pairs,start,left - 1);

        quickSortHelper(pairs,left + 1,end);

        return pairs;
    }
}
