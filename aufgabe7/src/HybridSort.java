public final class HybridSort {
    public static <T extends Comparable<T>> void hybridQuickSort(T[] a) {
        hybridSort(a, 0, a.length - 1);
    }

    private static <T extends Comparable<T>> void hybridSort(T[] a, int li, int re) {
        while (re > li) {
            // Teileschritt
            int i;
            if (re - li + 1 <= 100) {
                insertionSort(a, li, re);
                i = re;
            } else {
                i = partition(a, li, re);
                // Herrscheschritt
                hybridSort(a, li, i - 1);
            }

            li = i + 1;
        }
    }

    private static <T extends Comparable<T>> void insertionSort(T[] a, int li, int re) {
        for (int i = li + 1; i < re + 1; i++) {
            T v = a[i];
            int j = i - 1;
            while (j >= 0 && a[j].compareTo(v) > 0) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = v;
        }
    }

    private static <T extends Comparable<T>> int partition(T[] a, int li, int re) {
        T v = a[re];
        int i = li - 1;
        int j = re;

        while (true) {
            do i++; while (a[i].compareTo(v) < 0); // --->
            do j--; while (j >= li && a[j].compareTo(v) > 0); // <---
            if (i >= j) {
                break;
            }
            swap(a, i, j);
        }

        a[re] = a[i];
        a[i] = v;

        return i;
    }

    private static <T> void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
