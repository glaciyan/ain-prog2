import card.Card;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        /*var sorted = Helper.RANDOM_NUMBERS.clone();
        Arrays.sort(sorted);
        System.out.println(Arrays.toString(sorted));
        System.out.println(isSorted(sorted));

        var target = Helper.RANDOM_NUMBERS.clone();
        HybridSort.hybridQuickSort(target);
        System.out.println(Arrays.toString(target));
        System.out.println(isSorted(target));

        ArrayList<String> words = new ArrayList<>();
        LineNumberReader in;
        in = new LineNumberReader(new FileReader("Kafka_Der_Prozess.txt"));
        String line;

        // Text einlesen und Häfigkeiten aller Wörter bestimmen:
        while ((line = in.readLine()) != null) {
            String[] wf = line.split("[^a-z^A-Z^ß^ä^ö^ü^Ä^Ö^Ü]+");
            for (String w: wf) {
                if (w.length() == 0 || w.length() == 1)
                    continue;
                //System.out.println(w);
                words.add(w);
            }
        }

        var kafka = new String[words.size()];
        for (int i = 0; i < words.size(); i++) {
            kafka[i] = words.get(i);
        }

        HybridSort.hybridQuickSort(kafka);
        System.out.println(Arrays.toString(kafka));*/

        System.out.println("100_000 Karten");
        final int CARDS = 200_000;

        Card[] cards = new Card[CARDS];
        for (int i = 0; i < CARDS; i++) {
            cards[i] = Card.random();
        }

        var hybridTarget = cards.clone();
        System.out.println("Hybrid Quicksort");
        long start = startTimer();

        HybridSort.hybridQuickSort(hybridTarget);

        endTimer(start);

        var hybrid3MedianTarget = cards.clone();
        System.out.println("Hybrid Quicksort 3-Median");
        start = startTimer();

        HybridSort.hybridQuickSort3Median(hybrid3MedianTarget);

        endTimer(start);

        var arraySortTarget = cards.clone();
        System.out.println("Arrays.sort");
        start = startTimer();

        Arrays.sort(arraySortTarget);

        endTimer(start);
        System.out.println();

        System.out.println("Hybrid Quicksort Sortiert");
        start = startTimer();

        HybridSort.hybridQuickSort(hybridTarget);

        endTimer(start);

        System.out.println("Hybrid Quicksort 3-Median Sortiert");
        start = startTimer();

        HybridSort.hybridQuickSort3Median(hybrid3MedianTarget);

        endTimer(start);

        System.out.println("Arrays.sort Sortiert");
        start = startTimer();

        Arrays.sort(arraySortTarget);

        endTimer(start);

    }

    private static long startTimer() {
        return System.nanoTime();
    }

    private static void endTimer(long start) {
        long end = System.nanoTime();
        double elapsedTime = (double) (end - start) / 1.0e06;
        System.out.println("Benötigte Zeit in msec: " + elapsedTime);
        System.out.println();
    }

    private static <T extends Comparable<T>> boolean isSorted(T[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(a[i - 1]) < 0) return false;
        }

        return true;
    }
}
