package de.ketra.aufgabe6;

public class Main {
    public static void main(String[] args) {
        Activity a1 = new ParallelActivity();
        a1.add(new ElementaryActivity("Linke Seitenwand montieren", 5.0));
        a1.add(new ElementaryActivity("Rechte Seitenwand montieren", 5.0));

        Activity a2 = new ParallelActivity();
        a2.add(new ElementaryActivity("Linke Türe montieren", 7.0));
        a2.add(new ElementaryActivity("Rechte Türe mit Griff montieren", 9.0));

        Activity schrankMontage = new SerialActivity();
        schrankMontage.add(new ElementaryActivity("Füße an Boden montieren", 6.0));
        schrankMontage.add(a1);
        schrankMontage.add(new ElementaryActivity("Decke montieren", 8.0));
        schrankMontage.add(a2);
        System.out.println(schrankMontage.getTime() + " min"); // 28.0 min
        System.out.println(schrankMontage.getAmount()); // 6
    }
}
