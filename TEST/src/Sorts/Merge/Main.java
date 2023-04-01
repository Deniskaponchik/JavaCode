package Sorts.Merge;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {



        MergeStrings ms = new MergeStrings();
        //String[] values = {"foo", "bar", "alice", "bob", "celine", "david"};
        String[] strings = {"Петя", "Маша", "Катя", "Женя", "Саня", "Алишер"};
        //ms.mergeSort(strings, 0, strings.length - 1);
        ms.mergeSort(strings, 0, strings.length - 1, false);
        System.out.println(Arrays.toString(strings));



        MergeInt mi = new MergeInt();
        int[] numbers = {67, 987, 234, 3465, 2133, 44, 876, 533, 4322, 1234, 865};
        //mi.mergeSort(numbers, 0, numbers.length - 1);
        int[]result = mi.sort(numbers, false);
        System.out.println(Arrays.toString(result));



    }





}
