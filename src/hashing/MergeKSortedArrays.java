package hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeKSortedArrays {
/**
 * 1. You are given a list of lists, where each list is sorted.
 * 2. You are required to complete the body of mergeKSortedLists function.
 * The function is expected to merge k sorted lists to create one sorted list.
 * */
    public static void main(String[] args) {
        List<List<Integer>> kSortedArrays = new ArrayList<>();

        List<Integer> list1 = new ArrayList<>();
        list1 = Arrays.asList(20,30,40,50);
        List<Integer> list2 = new ArrayList<>();
        list2 = Arrays.asList(5,7,9,11,19,55,57);
        List<Integer> list3 = new ArrayList<>();
        list3 = new ArrayList<>();
        list3 = Arrays.asList(1,2,3);
        List<Integer> list4 = new ArrayList<>();
        list4 = Arrays.asList(32, 39);

        kSortedArrays.add(list1);
        kSortedArrays.add(list2);
        kSortedArrays.add(list3);
        kSortedArrays.add(list4);

        int k = 4;

        mergeKSortedArrays(kSortedArrays, 4);
    }

    private static void mergeKSortedArrays(List<List<Integer>> kSortedArrays, int k) {


    }

    class Pair{
        int li;
        int di;
        int val;

        Pair(int li, int di, int val){
            this.li = li;
            this.di = di;
            this.val = val;
        }
    }
}
