import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Aufgabe11 {
    private static final String BLUE = "\u001B[34m";
    private static final String BLACK = "\u001B[30m";

    public static void main(String[] args) throws IOException {
        System.out.println("60% (39 von 65 Punkte) der Teile müssen fehlerfrei laufen!");
        teil5(); // 36 Punkte
    }

    public static void teil5() throws IOException {
        // Kino-Filme und Stromoperationen
        System.out.println(BLUE + "\nTeil 5: Kinofilme");
        System.out.println(BLACK);
        BufferedReader in = new BufferedReader(new FileReader("movies-top-grossing.txt"));

        // d) (2 Punkte)
        // Speichern Sie alle Kinofilme in eine Movie-Liste.
        in = new BufferedReader(new FileReader("movies-top-grossing.txt"));
        System.out.println("\n5 d)");
        List<Movie> movies = in.lines()
                .map(Movie::new).toList();

        // k) (5 Punkte) ***
        // Erstellen Sie eine Map, die jeder Schauspielerin bzw. jedem Schauspieler die Filme zuordnet, wo sie bzw. er mitgespielt hat.
        System.out.println("\n5 k)");
        Map<String, Set<String>> actorForMovies = movies.stream().map(m -> m.actors()
                .stream()
                .reduce(
                        new TreeMap<String, Set<String>>(),
                        (map, a) -> putIn(map, a, m.title()),
                        Aufgabe11::mergeMap
                )
        ).reduce(new TreeMap<>(), Aufgabe11::mergeMap, Aufgabe11::mergeMap);

        System.out.println(actorForMovies);
    }

    private static <T extends Comparable<T>, K> TreeMap<K, Set<T>> putIn(TreeMap<K, Set<T>> map, K key, T value) {
        var set = map.getOrDefault(key, new TreeSet<>());
        set.add(value);
        map.put(key, set);
        return map;
    }

    private static <T extends Comparable<T>, K> TreeMap<K, Set<T>> mergeMap(TreeMap<K, Set<T>> map1, TreeMap<K, Set<T>> map2) {
        return Stream.concat(map1.entrySet().stream(), map2.entrySet().stream()).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, Aufgabe11::mergeSet, TreeMap::new));
    }

    private static <T extends Comparable<T>> Set<T> mergeSet(Set<T> set1, Set<T> set2) {
//        set1.addAll(set2);
//        return set1;
        var resultSet = new TreeSet<T>();
        resultSet.addAll(set1);
        resultSet.addAll(set2);
        return resultSet;
    }
}