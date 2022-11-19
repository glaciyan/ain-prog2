package de.ketra.aufgabe6;

public final class SerialActivity extends CompositeActivity {
    @Override
    public double getTime() {
        double sum = .0;

        for (var activity: this.myActivities) {
            sum += activity.getTime();
        }

        return sum;
    }
}
