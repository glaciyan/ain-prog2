package de.ketra.aufgabe6;

public final class ElementaryActivity implements Activity {
    private final String desc;
    private final double time;

    public ElementaryActivity(String desc, double time) {
        this.desc = desc;
        this.time = time;
    }

    @Override
    public double getTime() {
        return time;
    }

    @Override
    public void add(Activity activity) {

    }

    @Override
    public void remove(Activity activity) {

    }

    @Override
    public int getAmount() {
        return 1;
    }
}
