import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        var sorted = Helper.RANDOM_NUMBERS.clone();
        Arrays.sort(sorted);
        System.out.println(Arrays.toString(sorted));
        System.out.println(isSorted(sorted));

        var target = Helper.RANDOM_NUMBERS.clone();
        HybridSort.hybridQuickSort(target);
        System.out.println(Arrays.toString(target));
        System.out.println(isSorted(target));
    }

    private static <T extends Comparable<T>> boolean isSorted(T[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(a[i-1]) < 0) return false;
        }

        return true;
    }
}
