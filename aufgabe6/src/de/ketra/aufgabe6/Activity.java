package de.ketra.aufgabe6;

public interface Activity {
    double getTime();
    void add(Activity activity);
    void remove(Activity activity);
    int getAmount();
}
