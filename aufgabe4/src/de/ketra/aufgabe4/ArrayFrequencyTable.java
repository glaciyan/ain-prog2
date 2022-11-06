package de.ketra.aufgabe4;

import java.util.Arrays;

/**
 * @author oliverbittel
 * @since 25.03.2021
 */
public class ArrayFrequencyTable<T> extends AbstractFrequencyTable<T> {
    private int size;
    private Element<T>[] fqTable;
    private static final int DEFAULT_SIZE = 100;

    public ArrayFrequencyTable() {
        clear();
    }

    @Override
    public int size() {
        return size;
    }

    @SuppressWarnings({"unchecked", "ConstantConditions"})
    @Override
    public final void clear() {
        size = 0;
        fqTable = (Element<T>[]) new Object[DEFAULT_SIZE];
    }

    @Override
    public void add(T w, int f) {
        if (f < 0) throw new IllegalArgumentException("f darf nicht kleiner als 0 sein");
        int i;
        for (i = 0; i < size; i++) {
            Element<T> element = fqTable[i];
            if (element.getValue().equals(w)) {
                element.addFrequency(f);

                sortedAdd(i, element);

                return;
            }
        }

        if (fqTable.length == size) {
            fqTable = Arrays.copyOf(fqTable, fqTable.length * 2);
        }

        sortedAdd(size, new Element<T>(w, f));
        size++;
    }

    /**
     * @param i    index wo das Wort hinein sollte, von dem index wird nach links sortiert
     * @param element das word
     */
    private void sortedAdd(int i, Element<T> element) {
        int j = i - 1;
        // wenn es ein word links gibt und die freq kleiner ist
        if (j >= 0 && fqTable[j].getFrequency() < element.getFrequency()) {
            for (; j >= 0; j--) {
                // verschiebe alle, welche kleiner sind
                if (fqTable[j].getFrequency() < element.getFrequency()) {
                    fqTable[j + 1] = fqTable[j];
                } else break;
            }
        }

        // j ist der index von dem word, welcher größer ist
        // (also dem index wo wir break gemacht haben) deswegen + 1
        fqTable[j + 1] = element;
    }


    @Override
    public Element<T> get(int pos) {
        if (pos >= size) {
            throw new IndexOutOfBoundsException("Can't access index %d for size %d".formatted(pos, size()));
        }

        return fqTable[pos];
    }

    @Override
    public int get(T w) {
        for (int i = 0; i < size; i++) {
            Element<T> element = fqTable[i];
            if (element.getValue().equals(w)) {
                return element.getFrequency();
            }
        }

        return -1;
    }
}
