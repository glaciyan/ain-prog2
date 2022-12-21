// O. Bittel
// 10.03.2017

package de.ketra.aufgabe10;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TelefonBuch {

    private final TreeMap<String, String> telBuch = new TreeMap<>();

    private static void print(List<String> strList) {
        for (String s : strList)
            System.out.println(s);
    }

    public static void main(String[] args) {

        TelefonBuch telBuch = new TelefonBuch();
        telBuch.read(new File("TelBuchMit420Namen.txt"));

        System.out.println(telBuch.exactSearch("Oliver", ""));
        System.out.println();

        print(telBuch.prefixSearch("H"));
        System.out.println();

        print(telBuch.prefixSearch(""));
        System.out.println();

        telBuch.insert("Oliver", "1", "33245");
        telBuch.insert("Oliver", "2", "23423");
        telBuch.insert("Oliver", "3", "87655");
        telBuch.remove("Oliver", "2");

        print(telBuch.prefixSearch("Ol"));
        System.out.println();

        telBuch.save(new File("test.txt"));
    }

    private static String makeKey(String name, String zusatz) {
        return (name + " " + zusatz).trim();
    }

    private static ArrayList<String> getArrayList(NavigableMap<String, String> view) {
        var list = new ArrayList<String>();
        view.forEach((k, v) -> list.add(k + " " + v));
        return list;
    }

    public boolean insert(String name, String zusatz, String telNr) {
        String key = makeKey(name, zusatz);
        if (telBuch.containsKey(key)) return false;

        telBuch.put(key, telNr);
        return true;
    }

    public boolean remove(String name, String zusatz) {
        var out = telBuch.remove(makeKey(name, zusatz));
        return out != null;
    }

    public String exactSearch(String name, String zusatz) {
        return telBuch.get(makeKey(name, zusatz));
    }

    public List<String> prefixSearch(String s) {
        if (s.length() == 0) return getArrayList(telBuch);

        // next string to s where the last char is one greater
        var next = s.substring(0, s.length() - 1) + (char) (s.charAt(s.length() - 1) + 1);
        var view = telBuch.subMap(s, true, next, false);

        return getArrayList(view);
    }

    public void read(File f) {
        LineNumberReader in;
        try {
            telBuch.clear();
            in = new LineNumberReader(new FileReader(f));
            String line;
            while ((line = in.readLine()) != null) {
                String[] sf = line.split(" ");
                if (sf.length == 2) {
                    insert(sf[0], "", sf[1]); // leerer Zusatz
                } else if (sf.length == 3) {
                    insert(sf[0], sf[1], sf[2]);
                }
            }
            in.close();
        } catch (IOException ex) {
            Logger.getLogger(TelefonBuch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void save(File f) {
        PrintWriter out;
        try {
            out = new PrintWriter(f);
            for (Entry<String, String> eintrag : telBuch.entrySet()) {
                String s = eintrag.getKey().replace('#', ' ') + " " + eintrag.getValue();
                out.println(s);
            }
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(TelefonBuch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
