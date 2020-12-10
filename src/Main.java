import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        // generating random array of ints
        int[] A = IntStream.generate(()
                -> new Random().nextInt(1000)).limit(5000).toArray();

        // Convert to Integer[]
        Integer[] Ai = Arrays.stream(A).boxed().toArray(Integer[]::new);

        System.out.printf("Unsorted and Randomized Array: \n");

        // show unsorted, random array
        for (Integer i : Ai) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println();

        // Prep for HeapSort, (add unused 0)
        Ai = add2BeginningOfArray(Ai, 0);

        // stopwatch for heapSort
        Stopwatch heapWatch = new Stopwatch();
        HeapSort.sort(Ai);
        double heapElapsedTime = heapWatch.elapsedTime();
        System.out.printf("The HeapSort function took %f seconds to execute.\n\n", heapElapsedTime);

        // stopwatch for selectionSort
        Stopwatch selectionWatch = new Stopwatch();
        SelectionSort.sort(Ai);
        double selectionElaspedTime = selectionWatch.elapsedTime();
        System.out.printf("The SelectionSort function took %f seconds to execute.\n\n", selectionElaspedTime);


        System.out.printf("Sorted Array: \n");

        // sorted array
        for (Integer i : Ai) {
            System.out.print(i + " ");
        }
        System.out.println();

    }

    public static <T> T[] add2BeginningOfArray(T[] elements, T element) {
        T[] newArray = Arrays.copyOf(elements, elements.length + 1);
        newArray[0] = element;
        System.arraycopy(elements, 0, newArray, 1, elements.length);

        return newArray;
    }

}