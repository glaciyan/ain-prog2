import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public record Movie(String title, List<String> actors, int year) {
    public Movie(String s) {
        this(parseTitle(s), parseActors(s), parseYear(s));
    }

    private static String parseTitle(String s) {
        return s.substring(0, s.indexOf(" ("));
    }

    private static int parseYear(String s) {
        return Integer.parseInt(s.substring(s.indexOf("(") + 1, s.indexOf(")")));
    }

    private static List<String> parseActors(String s) {
        // ..
        return Arrays.asList(s.substring(s.indexOf("/") + 1).split("/"));
    }
}
