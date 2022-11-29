import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        var sorted = Helper.RANDOM_NUMBERS.clone();
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
        System.out.println(Arrays.toString(kafka));
    }

    private static <T extends Comparable<T>> boolean isSorted(T[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(a[i-1]) < 0) return false;
        }

        return true;
    }
}
