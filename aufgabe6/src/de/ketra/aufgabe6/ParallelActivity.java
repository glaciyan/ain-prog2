package de.ketra.aufgabe6;

public final class ParallelActivity extends CompositeActivity {
    @Override
    public double getTime() {
        double max = .0;
        for (var activity :
                this.myActivities) {
            max = Math.max(activity.getTime(), max);
        }

        return max;
    }
}
