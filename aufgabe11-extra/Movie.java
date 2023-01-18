import java.util.Arrays;
import java.util.List;

public record Movie(String title, List<String> actors, int year) {
    public Movie(String s) {
        this(parseTitle(s),parseActors(s),parseYear(s));
    }

    private static String parseTitle(String s) {
        // ...
        return "";
    }

    private static int parseYear(String s) {
        // ..
        return 0;
    }

    private static List<String> parseActors(String s) {
        // ..
        return Arrays.asList();
    }
}
