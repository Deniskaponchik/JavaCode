package Sorts.Merge;
import java.util.Arrays;
public class MergeInt {

    //https://javarush.com/quests/lectures/questharvardcs50.level03.lecture11
    //Тимур Шамилов Уровень 35
    //Возвращает новый массив
    public static int[] sort(int[] result, boolean sortType) {
    //public static void sort(int[] result, boolean sortType) {
        if (result.length < 2) {
            return result;
            ///result;
        } else {
            int[] left = sort(Arrays.copyOfRange(result,0, result.length/2), sortType);
            int[] right = sort(Arrays.copyOfRange(result,result.length / 2, result.length), sortType);
            return merge(left ,right, sortType);
            //merge(left ,right, sortType);
        }
    }
    private static int[] merge(int[] left, int[] right, boolean sortType) {
        int i = 0, j = 0, k = 0;
        int[] result = new int[left.length + right.length];

        while (i < left.length && j < right.length) {
            if (sortType) {
                if (left[i] < right[j]) {   //для прямой сортировки
                    result[k] = left[i];
                    i++;
                } else {
                    result[k] = right[j];
                    j++;
                }
            } else {
                if (left[i] > right[j]) {  // для обратной сортировки
                    result[k] = left[i];
                    i++;
                } else {
                    result[k] = right[j];
                    j++;
                }
            }
            k++;
        }

        if (i == left.length) {
            while (j < right.length) {
                result[k] = right[j];
                j++;k++;
            }
        }
        if (j == right.length) {
            while (i < left.length) {
                result[k] = left[i];
                i++;k++;
            }
        }
        return result;
    }




    /*
    //https://javarush.com/groups/posts/1997-algoritmih-sortirovki-v-teorii-i-na-praktike
    //Как-то не правильно сортирует
    //рекурсивный вызов метода сортировки:
    public static void mergeSort(int[] source, int left, int right) {
        // Выберем разделитель, т.е. разделим пополам входной массив
        int delimiter = left + ((right - left) / 2) + 1;
        // Выполним рекурсивно данную функцию для двух половинок (если сможем разбить(
        if (delimiter > 0 && right > (left + 1)) {
            mergeSort(source, left, delimiter - 1);
            mergeSort(source, delimiter, right);
        }
        // Создаём временный массив с нужным размером
        int[] buffer = new int[right - left + 1];
        // Начиная от указанной левой границы идём по каждому элементу
        int cursor = left;
        for (int i = 0; i < buffer.length; i++) {
            // Мы используем delimeter чтобы указывать на элемент из правой части
            // Если delimeter > right, значит в правой части не осталось недобавленных элементов
            if (delimiter > right || source[cursor] > source[delimiter]) {
                buffer[i] = source[cursor];
                cursor++;
            } else {
                buffer[i] = source[delimiter];
                delimiter++;
            }
        }
        System.arraycopy(buffer, 0, source, left, buffer.length);
    } */







}
