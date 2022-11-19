package de.ketra.aufgabe6;

import java.util.ArrayList;
import java.util.List;

public abstract class CompositeActivity implements Activity {
    protected final List<Activity> myActivities = new ArrayList<>();

    @Override
    public void add(Activity activity) {
        myActivities.add(activity);
    }

    @Override
    public void remove(Activity activity) {
        myActivities.remove(activity);
    }

    @Override
    public int getAmount() {
        int sum = 0;

        for (var activity : myActivities) {
            sum += activity.getAmount();
        }

        return sum;
    }
}
