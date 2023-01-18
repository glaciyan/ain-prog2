import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Aufgabe11 {
    private static final String BLUE = "\u001B[34m";
    private static final String DEFAULT = "\u001B[0m";

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
        System.out.println(DEFAULT + "Imperativ: ... ");

        // b) (3 Punkte) Funktional (Lambda-Ausdruck ohne Schleife mit Benutzung von String-Methoden):
        // ...
        System.out.println("Funktional: ...");

        // c) (2 Punkte) Mit Streams:
        // ...
        System.out.println("Streams: ... ");
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

        System.out.println(BLUE + "\nTeil 2: " + "Collatz-Folge" + DEFAULT);
        int s = 973;

        // ...
    }

    public static void teil3() {
        // Bestimme die Haeufigkeit des Strings myString in der String-Liste myList.
        System.out.println(BLUE + "\nTeil 3: Häufigkeit eines Strings in einer String-Liste");
        List<String> myList = List.of("das", "der", "die", "der", "der", "die", "der", "das", "die", "der");
        String myString = "der";

        // a) (1 Punkt) Externe Iteration mit einer for-each-Schleife:
        // ...
        System.out.println(DEFAULT + "Externe Iteration: ...");

        // b) (3 Punkte) Interne Iteration mit forEach() (s.a. AtomicInteger):
        // ...
        System.out.println("Interne Iteration: ...");

        // c) (2 Punkte) Mit einem Stream:
        // ...
        System.out.println("Streams: ...");
    }

    public static void teil4() {
        // Liste von Städte und Strom-Operationen
        System.out.println(BLUE + "\nTeil 4: " + "Liste von Städte und Strom-Operationen");
        List<Stadt> sLst = new LinkedList<>();
        sLst.add(new Stadt("Muenchen","Deutschland",1_484_226 ));
        sLst.add(new Stadt("Paris","Frankreich",2_175_601));
        sLst.add(new Stadt("Valencia","Spanien",794_288  ));
        sLst.add(new Stadt("Porto","Portugal",238_000 ));
        sLst.add(new Stadt("Berlin","Deutschland",3_669_491));
        sLst.add(new Stadt("Mailand","Italien",1_396_059));
        sLst.add(new Stadt("Toulouse","Frankreich",493_465 ));
        sLst.add(new Stadt("Konstanz","Deutschland",84_911));
        sLst.add(new Stadt("Frankfurt","Deutschland",759_224));
        sLst.add(new Stadt("Marseille","Frankreich",919_305));
        sLst.add(new Stadt("Stuttgart","Deutschland",626_275));
        sLst.add(new Stadt("Lyon","Frankreich",522_969 ));
        sLst.add(new Stadt("Rom","Italien",4_333_274));
        sLst.add(new Stadt("Turin","Italien",870_952 ));
        sLst.add(new Stadt("Madrid","Spanien",3_266_126 ));
        sLst.add(new Stadt("Barcelona","Spanien",1_636_762 ));
        sLst.add(new Stadt("Lissabon","Portugal",2_963_272 ));

        // a) (4 Punkte)
        // Sortieren Sie die Liste von Städten alphabetisch nach dem Land und bei gleichem Land
        // absteigend nach der Einwohnerzahl. Geben Sie die sortierten Städte aus.
        // Implementieren Sie eine Variante mit zwei sorted-Aufrufe und eine Variante mit genau einem sorted-Aufruf.
        // Versuchen Sie Comparator.comparing einzusetzen.
        System.out.println(DEFAULT);
        System.out.println("Staedte alphabetisch nach dem Land sortiert und bei gleichem Land absteigend nach der Einwohnerzahl\n");
        // ...

        // b) (2 Punkte) Geben Sie alle Millionenstädte alphabetisch aus:
        System.out.println(DEFAULT);
        System.out.println("Millionenstädte alphabetisch sortiert\n");
        // ...

        // c) (2 Punkte) Bestimmen Sie die Stadt mit der groessten Einwohnerzahl und geben Sie sie aus.
        System.out.println(DEFAULT);
        System.out.println("Stadt mit der groessten Einwohnerzahl");
        // ...

        // d) (2 Punkte) Erstellen Sie eine Statistik ueber die Einwohnerzahl (Anzahl, Summe, Minimum, Maximum und Mittelwert)
        System.out.println(DEFAULT);
        System.out.println("Statistik ueber die Einwohnerzahl");
        // ...

        // e) (3 Punkte) Sammeln Sie alle Staedte in einer Map. Die Map speichert für jedes Land eine Liste aller Städte des Landes.
        // Geben Sie die Map aus.
        System.out.println(DEFAULT);
        System.out.println("Alle Staedte in einer Map sammeln");
        // ...
    }

    public static void teil5() throws IOException {
        // Kino-Filme und Stromoperationen
        System.out.println(BLUE + "\nTeil 5: Kinofilme");
        System.out.println(DEFAULT);
        BufferedReader in = new BufferedReader(new FileReader("movies-top-grossing.txt"));


        // a) (2 Punkte)
        // Geben Sie alle Kinofilme (komplette Zeilen) aus der Datei movies-top-grossing.txt aus
        // und bestimmen Sie die Anzahl der Filme
        System.out.println("\n5 a)");
        // ...


        // b) (3 Punkte)
        // wie a), jedoch sollen nur die Titel der Kinofilme ausgegeben werden.
        System.out.println("\n5 b)");
        // ...


        // c) (3 Punkte)
        // Erweitern Sie Movie um einen Konstruktor
        System.out.println("\n5 c)");
        Movie m1 = new Movie("101 Dalmatians", List.of("Benfield, John", "Braid, Hilda", "Capron, Brian"),1996);
        String s = "101 Dalmatians (1996)/Benfield, John/Braid, Hilda/Capron, Brian";
        Movie m2 = new Movie(s);
        // Ausgabe von m1 und m2 sollte identisch sein
        System.out.println(m1);
        System.out.println(m2);


        // d) (2 Punkte)
        // Speichern Sie alle Kinofilme in eine Movie-Liste.
        System.out.println("\n5 d)");
        // ...


        // e) (2 Punkte)
        // Geben Sie alle Filmtitel aus, in denen der Schauspieler Morgan Freeman mitgespielt hat.
        // Hinweis: Verwenden Sie für diese und alle folgenden Teilaufgaben die Movie-Liste aus d)
        System.out.println("\n5 e)");
        String s1 = "Freeman, Morgan";
        // ...


        // f) (4 Punkte) **
        // Geben Sie alle Filme aus, in denen ein/e Schauspieler/in spielt, in dessen/deren Name "Free" vorkommt.
        System.out.println("\n5 f)");
        String s2 = "Free";
        // ...

        
        // g) (3 Punkte) *
        // Wieviel verschiedene Schauspielerinnen und Schauspieler enthält die Filmdatei?
        System.out.println("\n5 g)");
        // ...


        // h) (3 Punkte) *
        // Erstellen Sie eine Map, die für jede Jahreszahl die entsprechende Liste von Filme abspeichert.
        System.out.println("\n5 h)");
        // ...


        // i) (4 Punkte) **
        // Erstellen Sie eine Map, die für jede Jahreszahl die entsprechende Anzahl von Filmtiteln abspeichert.
        System.out.println("\n5 i)");
        // ...


        // j) (5 Punkte) ***
        // Erstellen Sie eine TreeMap, die für jede Jahreszahl die entsprechende Liste von Filmtiteln abspeichert.
        // Siehe Beispiel in der Java API zu Collectors.groupingBy(classifier,mapFactory,downstream)
        System.out.println("\n5 j)");
        // ...


        // k) (5 Punkte) ***
        // Erstellen Sie eine Map, die jeder Schauspielerin bzw. jedem Schauspieler die Filme zuordnet, wo sie bzw. er mitgespielt hat.
        System.out.println("\n5 k)");
        // record ActorTitlePair köennte hilfreich sein
        record ActorTitlePair(String actor, String title) {}
        // ...
    }
}