// Selection Sort
//  - sorts an array by repeatedly finding the minimum element
//    from the unsorted part and placing it at the beginning of the array
//  - maintains 2 subarrays given an array
//      1) subarray which is sorted
//      2) subarray which is unsorted
//  - every iteration, the minimum element from the unsorted subarray is picked and moved to the sorted sub

public class SelectionSort {

    public static void sort(Comparable[] a) {

        int N = a.length;

        for (int i = 0; i < N; i++) {

            int minIndex = i;
            for (int j = i + 1; j < N; j++)
                if (a[j].compareTo(a[minIndex]) < 0)
                    minIndex = j;

            if (minIndex != i) {
                Comparable temp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = temp;
            }
        }

    }
}
