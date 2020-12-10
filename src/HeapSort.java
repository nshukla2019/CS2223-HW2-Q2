public class HeapSort {

    public static void sort(Comparable[] a) {
        int N = a.length-1;
        for (int k = N / 2; k >= 1; k--)
            sink(a, k, N);
        while (N > 1) {
            exch(a, 1, N--);
            sink(a, 1, N);
        }
    }

    // if a node's key becomes smaller than one or both of the node's children's
    // keys, then we exchange the node with the larger of its two children
    // this might cause a violation at the child after the switch,
    // so this repeats until the heap order is back
    // node's children are at 2k and 2k+1 positions
    private static void sink(Comparable[] a, int k, int N) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(a, j, j + 1))
                j++;
            if (!less(a, k, j))
                break;
            exch(a, k, j);
            k = j;
        }
    }

    // if a node's key becomes larger than that of the node's parents' key,
    // exchange node with its parents
    // the node may still be larger than it's parents causing the order of the heap
    // to not be in order, so this repeats until heap order is restores
    // the parent of the node at position k is at position k/2
    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static boolean less(Comparable[] a, int i, int j) {
        return a[i].compareTo(a[j]) < 0;
    }


}
