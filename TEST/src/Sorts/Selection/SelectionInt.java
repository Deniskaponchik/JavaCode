package Sorts.Selection;
import java.util.Arrays;

public class SelectionInt {

    /*https://javarush.com/tasks/com.javarush.task.task08.task0826#discussion
    //package com.javarush.task.task08.task0826;
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }
        sort(array);
        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
        System.out.println(array[3]);
        System.out.println(array[4]);
    }

    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i] < array[j]) {  //swap
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    } */

    //https://javarush.com/groups/posts/1997-algoritmih-sortirovki-v-teorii-i-na-praktike
    public static void main(String[] args) throws Exception {
        int[] array = {10, 2, 10, 3, 1, 2, 5};
        System.out.println(Arrays.toString(array));
        for (int left = 0; left < array.length; left++) {
            int minInd = left;
            for (int i = left; i < array.length; i++) {
                if (array[i] < array[minInd]) {
                    minInd = i;
                }
            }
            swap(array, left, minInd);
        }
        System.out.println(Arrays.toString(array));
    }

        private static void swap ( int[] array, int ind1, int ind2){
            int tmp = array[ind1];
            array[ind1] = array[ind2];
            array[ind2] = tmp;
        }



}
