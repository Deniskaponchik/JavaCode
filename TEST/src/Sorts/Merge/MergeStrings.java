package Sorts.Merge;
import java.util.Arrays;
public class MergeStrings {

    //Вносит изменения в текущем массиве
    public static void mergeSort(String[] a, int from, int to, boolean sortType) {
        if (from == to) {
            return;
        }
        int mid = (from + to) / 2;
        // сортировка первой и второй половины
        mergeSort(a, from, mid, sortType);
        mergeSort(a, mid + 1, to, sortType);
        merge(a, from, mid, to, sortType);
    }
    public static void merge(String[] a, int from, int mid, int to, boolean sortType) {
        int n = to - from + 1;       // размер диапазона для объединения
        String[] b = new String[n];  // объединить обе половины во временный массив b
        int i1 = from;               // следующий элемент для рассмотрения в первом диапазоне
        int i2 = mid + 1;            // следующий элемент для рассмотрения во втором диапазоне
        int j = 0;                   // следующая открытая позиция в b

        // пока ни i1, ни i2 не дошли до конца, перемещаем меньший в b
        while (i1 <= mid && i2 <= to) {

            if (sortType) {
                if (a[i1].compareTo(a[i2]) < 0) {   //для прямой сортировки
                    //if (a[i2].compareTo(a[i1]) < 0) {
                    b[j] = a[i1];
                    i1++;
                } else {
                    b[j] = a[i2];
                    i2++;
                }
            } else {

                //if (a[i1].compareTo(a[i2]) < 0) {   //для прямой сортировки
                if (a[i2].compareTo(a[i1]) < 0) {    //для обратной сортировки
                    b[j] = a[i1];
                    i1++;
                } else {
                    b[j] = a[i2];
                    i2++;
                }
            }
            j++;

        }
        //выполняется только один из двух циклов while ниже.
        // копируем все оставшиеся записи первой половины
        while (i1 <= mid) {
            b[j] = a[i1];
            i1++;
            j++;
        }
        // копируем любые оставшиеся записи второй половины
        while (i2 <= to) {
            b[j] = a[i2];
            i2++;
            j++;
        }
        //копируем обратно из временного массива
        for (j = 0; j < n; j++) {
            a[from + j] = b[j];
        }
    }




    /*
    public static void mergeSort(String[] a, int from, int to) {
        if (from == to) {
            return;
        }
        int mid = (from + to) / 2;
        // sort the first and the second half
        mergeSort(a, from, mid);
        mergeSort(a, mid + 1, to);
        merge(a, from, mid, to);
    }// end mergeSort

    //
    public static void merge(String[] a, int from, int mid, int to) {
        int n = to - from + 1;       // size of the range to be merged
        String[] b = new String[n];   // merge both halves into a temporary array b
        int i1 = from;               // next element to consider in the first range
        int i2 = mid + 1;            // next element to consider in the second range
        int j = 0;                   // next open position in b

        // as long as neither i1 nor i2 past the end, move the smaller into b
        while (i1 <= mid && i2 <= to) {
            if (a[i1].compareTo(a[i2]) < 0) {
                b[j] = a[i1];
                i1++;
            } else {
                b[j] = a[i2];
                i2++;
            }
            j++;
        }
        // note that only one of the two while loops below is executed
        // copy any remaining entries of the first half
        while (i1 <= mid) {
            b[j] = a[i1];
            i1++;
            j++;
        }
        // copy any remaining entries of the second half
        while (i2 <= to) {
            b[j] = a[i2];
            i2++;
            j++;
        }
        // copy back from the temporary array
        for (j = 0; j < n; j++) {
            a[from + j] = b[j];
        }
    }*/






    //https://stackoverflow.com/questions/23064247/java-mergesort-with-strings









}
