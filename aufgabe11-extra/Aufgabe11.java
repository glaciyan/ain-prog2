import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Aufgabe11 {
    private static final String BLUE = "\u001B[34m";
    private static final String BLACK = "\u001B[30m";

    public static void main(String[] args) throws IOException {
        System.out.println("60% (39 von 65 Punkte) der Teile müssen fehlerfrei laufen!");
        teil1(); // 6 Punkte
        teil2(); // 4 Punkte
        teil3(); // 6 Punkte
        teil4(); // 13 Punkte
        teil5(); // 36 Punkte
    }

    public static void teil1() {
        /* Bestimme die Anzahl der Zeichen in myString ohne das Zeichen 'a'.
         */

        String myString = "Bestimme die Anzahl der Zeichen in einem String ohne das Zeichen 'a'";
        System.out.println(BLUE + "\nTeil 1: " + myString);

        // a) (1 Punkt) Imperativ (mit einer Schleife):
        // ...
        long imperativeAnzahl = 0;
        for (int i = 0; i < myString.length(); i++) {
            char c = myString.charAt(i);
            if (c != 'a') imperativeAnzahl++;
        }
        System.out.println(BLACK + "Imperativ: ... " + imperativeAnzahl);

        // b) (3 Punkte) Funktional (Lambda-Ausdruck ohne Schleife mit Benutzung von String-Methoden):
        // ...
        Function<String, Integer> nbOfChar = s -> s.replaceAll("a", "").length();
        System.out.println("Funktional: ..." + nbOfChar.apply(myString));

        // c) (2 Punkte) Mit Streams:
        // ...
        long count = myString.chars().filter(i -> i != (char) 'a').count();
        System.out.println("Streams: ... " + count);
    }

    public static void teil2() {
        // (4 Punkte)
        /* Erzeugen Sie einen Integer-Strom mit iterate nach folgender Vorschrift:
         * Beginne mit irgendeiner natürlichen Zahl n = s > 0.
         * Ist n gerade, so wähle als nächste Zahl  n/2.
         * Ist n ungerade, so wähle als nächste Zahl 3*n+1.
         * Wiederhole die Vorgehensweise.
         * Breche ab, falls n == 1 ist.
         * Es wird vermutet (Collatz-Vermutung), dass die Zahlenfolge immer bei 1 endet,
         * unabhängig vom Startwert n.
         */

        System.out.println(BLUE + "\nTeil 2: " + "Collatz-Folge" + BLACK);
        int s = 973;

        IntStream.iterate(s, n -> n % 2 == 0 ? n / 2 : 3 * n + 1).
                peek(System.out::println).anyMatch(i -> i == 1);
    }

    public static void teil3() {
        // Bestimme die Haeufigkeit des Strings myString in der String-Liste myList.
        System.out.println(BLUE + "\nTeil 3: Häufigkeit eines Strings in einer String-Liste");
        List<String> myList = List.of("das", "der", "die", "der", "der", "die", "der", "das", "die", "der");
        String myString = "der";

        // a) (1 Punkt) Externe Iteration mit einer for-each-Schleife:
        // ...
        int s = 0;
        for (int i = 0; i < myList.size(); i++) {
            if (myList.get(i).equals(myString)) s++;
        }
        System.out.println(BLACK + "Externe Iteration: ..." + s);

        // b) (3 Punkte) Interne Iteration mit forEach() (s.a. AtomicInteger):
        // ...
        AtomicInteger s2 = new AtomicInteger();
        myList.forEach(str -> {
            if (str.equals(myString)) {
                s2.incrementAndGet();
            }
        });
        System.out.println("Interne Iteration: ..." + s2.get());

        // c) (2 Punkte) Mit einem Stream:
        // ...
        System.out.println("Streams: ..." + myList.stream().filter(str -> str.equals(myString)).count());
    }

    public static void teil4() {
        // Liste von Städte und Strom-Operationen
        System.out.println(BLUE + "\nTeil 4: " + "Liste von Städte und Strom-Operationen");
        List<Stadt> sLst = new LinkedList<>();
        sLst.add(new Stadt("Muenchen", "Deutschland", 1_484_226));
        sLst.add(new Stadt("Paris", "Frankreich", 2_175_601));
        sLst.add(new Stadt("Valencia", "Spanien", 794_288));
        sLst.add(new Stadt("Porto", "Portugal", 238_000));
        sLst.add(new Stadt("Berlin", "Deutschland", 3_669_491));
        sLst.add(new Stadt("Mailand", "Italien", 1_396_059));
        sLst.add(new Stadt("Toulouse", "Frankreich", 493_465));
        sLst.add(new Stadt("Konstanz", "Deutschland", 84_911));
        sLst.add(new Stadt("Frankfurt", "Deutschland", 759_224));
        sLst.add(new Stadt("Marseille", "Frankreich", 919_305));
        sLst.add(new Stadt("Stuttgart", "Deutschland", 626_275));
        sLst.add(new Stadt("Lyon", "Frankreich", 522_969));
        sLst.add(new Stadt("Rom", "Italien", 4_333_274));
        sLst.add(new Stadt("Turin", "Italien", 870_952));
        sLst.add(new Stadt("Madrid", "Spanien", 3_266_126));
        sLst.add(new Stadt("Barcelona", "Spanien", 1_636_762));
        sLst.add(new Stadt("Lissabon", "Portugal", 2_963_272));

        // a) (4 Punkte)
        // Sortieren Sie die Liste von Städten alphabetisch nach dem Land und bei gleichem Land
        // absteigend nach der Einwohnerzahl. Geben Sie die sortierten Städte aus.
        // Implementieren Sie eine Variante mit zwei sorted-Aufrufe und eine Variante mit genau einem sorted-Aufruf.
        // Versuchen Sie Comparator.comparing einzusetzen.
        System.out.println(BLACK);
        System.out.println("Staedte alphabetisch nach dem Land sortiert und bei gleichem Land absteigend nach der Einwohnerzahl\n");
//        sLst.stream()
//                .sorted((s1, s2) -> Integer.compare(s2.ewz(), s1.ewz()))
//                .sorted(Comparator.comparing(Stadt::land))
//                .forEachOrdered(System.out::println);
        sLst.stream().sorted(Comparator.comparing(Stadt::land).thenComparing((e1, e2) -> Integer.compare(e2.ewz(), e1.ewz()))).forEachOrdered(System.out::println);

        // b) (2 Punkte) Geben Sie alle Millionenstädte alphabetisch aus:
        System.out.println(BLACK);
        System.out.println("Millionenstädte alphabetisch sortiert\n");
        sLst.stream()
                .filter(s -> s.ewz() >= 1_000_000)
                .sorted(Comparator.comparing(Stadt::name))
                .forEachOrdered(System.out::println);

        // c) (2 Punkte) Bestimmen Sie die Stadt mit der groessten Einwohnerzahl und geben Sie sie aus.
        System.out.println(BLACK);
        System.out.println("Stadt mit der groessten Einwohnerzahl");
        Stadt groesste = sLst.stream().max(Comparator.comparing(Stadt::ewz)).get();
        System.out.println(groesste);

        // d) (2 Punkte) Erstellen Sie eine Statistik ueber die Einwohnerzahl (Anzahl, Summe, Minimum, Maximum und Mittelwert)
        System.out.println(BLACK);
        System.out.println("Statistik ueber die Einwohnerzahl");
        var stats = sLst.stream().mapToInt(Stadt::ewz).summaryStatistics();
        System.out.println(stats);

        // e) (3 Punkte) Sammeln Sie alle Staedte in einer Map. Die Map speichert für jedes Land eine Liste aller Städte des Landes.
        // Geben Sie die Map aus.
        System.out.println(BLACK);
        System.out.println("Alle Staedte in einer Map sammeln");
        var map = sLst.stream().collect(Collectors.groupingBy(Stadt::land));
        map.forEach((k, v) -> {
            System.out.println(k);
            v.forEach(System.out::println);
        });
    }

    public static void teil5() throws IOException {
        // Kino-Filme und Stromoperationen
        System.out.println(BLUE + "\nTeil 5: Kinofilme");
        System.out.println(BLACK);
        BufferedReader in = new BufferedReader(new FileReader("movies-top-grossing.txt"));


        // a) (2 Punkte)
        // Geben Sie alle Kinofilme (komplette Zeilen) aus der Datei movies-top-grossing.txt aus
        // und bestimmen Sie die Anzahl der Filme
        System.out.println("\n5 a)");
        long count = in.lines().peek(System.out::println).count();
        System.out.println("Count: " + count);

        in = new BufferedReader(new FileReader("movies-top-grossing.txt"));
        // b) (3 Punkte)
        // wie a), jedoch sollen nur die Titel der Kinofilme ausgegeben werden.
        System.out.println("\n5 b)");
        long count1 = in.lines().map(m -> m.substring(0, m.indexOf("/"))).peek(System.out::println).count();
        System.out.println("Count: " + count1);


        // c) (3 Punkte)
        // Erweitern Sie Movie um einen Konstruktor
        System.out.println("\n5 c)");
        Movie m1 = new Movie("101 Dalmatians", List.of("Benfield, John", "Braid, Hilda", "Capron, Brian"), 1996);
        String s = "101 Dalmatians (1996)/Benfield, John/Braid, Hilda/Capron, Brian";
        Movie m2 = new Movie(s);
        // Ausgabe von m1 und m2 sollte identisch sein
        System.out.println(m1);
        System.out.println(m2);


        // d) (2 Punkte)
        // Speichern Sie alle Kinofilme in eine Movie-Liste.
        in = new BufferedReader(new FileReader("movies-top-grossing.txt"));
        System.out.println("\n5 d)");
        List<Movie> movies = in.lines()
                .map(Movie::new).toList();

        // e) (2 Punkte)
        // Geben Sie alle Filmtitel aus, in denen der Schauspieler Morgan Freeman mitgespielt hat.
        // Hinweis: Verwenden Sie für diese und alle folgenden Teilaufgaben die Movie-Liste aus d)
        System.out.println("\n5 e)");
        String s1 = "Freeman, Morgan";
        movies.stream().filter(m -> m.actors().contains(s1)).forEach(System.out::println);


        // f) (4 Punkte) **
        // Geben Sie alle Filme aus, in denen ein/e Schauspieler/in spielt, in dessen/deren Name "Free" vorkommt.
        System.out.println("\n5 f)");
        String s2 = "Free";
        movies.stream().filter(m -> m.actors().stream().anyMatch(n -> n.contains(s2))).forEach(System.out::println);


        // g) (3 Punkte) *
        // Wieviel verschiedene Schauspielerinnen und Schauspieler enthält die Filmdatei?
        System.out.println("\n5 g)");
        long people = movies.stream().flatMap(m -> m.actors().stream()).distinct().count();
        System.out.println(people);


        // h) (3 Punkte) *
        // Erstellen Sie eine Map, die für jede Jahreszahl die entsprechende Liste von Filme abspeichert.
        System.out.println("\n5 h)");
        var yearGrouped = movies.stream().collect(Collectors.groupingBy(Movie::year));


        // i) (4 Punkte) **
        // Erstellen Sie eine Map, die für jede Jahreszahl die entsprechende Anzahl von Filmtiteln abspeichert.
        System.out.println("\n5 i)");
        var yearAmount = movies.stream().collect(Collectors.toMap(Movie::year, m -> 1, (x, y) -> x + y));


        // j) (5 Punkte) ***
        // Erstellen Sie eine TreeMap, die für jede Jahreszahl die entsprechende Liste von Filmtiteln abspeichert.
        // Siehe Beispiel in der Java API zu Collectors.groupingBy(classifier,mapFactory,downstream)
        System.out.println("\n5 j)");
        Map<Integer, Set<String>> yearMovies = movies.stream()
                .collect(Collectors.groupingBy(Movie::year, TreeMap::new, Collectors.mapping(Movie::title, Collectors.toSet())));


        // k) (5 Punkte) ***
        // Erstellen Sie eine Map, die jeder Schauspielerin bzw. jedem Schauspieler die Filme zuordnet, wo sie bzw. er mitgespielt hat.
        System.out.println("\n5 k)");
        // record ActorTitlePair köennte hilfreich sein
        record ActorTitlePair(String actor, String title) {
        }
        List<ActorTitlePair> actorTitlePairs = movies.stream().flatMap(m -> m.actors().stream().map(a -> new ActorTitlePair(a, m.title()))).toList();
        Map<String, Set<String>> actorForTitle = actorTitlePairs.stream().collect(Collectors.groupingBy(ActorTitlePair::actor, Collectors.mapping(ActorTitlePair::title, Collectors.toSet())));
    }
}