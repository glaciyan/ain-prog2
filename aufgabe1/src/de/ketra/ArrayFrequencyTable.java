package de.ketra;

import java.util.Arrays;

/**
 * @author oliverbittel
 * @since 25.03.2021
 */
public class ArrayFrequencyTable extends AbstractFrequencyTable {
    private int size;
    private Word[] fqTable;
    private static final int DEFAULT_SIZE = 100;

    public ArrayFrequencyTable() {
        clear();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public final void clear() {
        size = 0;
        fqTable = new Word[DEFAULT_SIZE];
    }

    @Override
    public void add(String w, int f) {
        int i;
        for (i = 0; i < size; i++) {
            Word word = fqTable[i];
            if (word.getWord().equals(w)) {
                word.addFrequency(f);

                sortedAdd(i, word);

                return;
            }
        }

        if (fqTable.length == size) {
            fqTable = Arrays.copyOf(fqTable, fqTable.length * 2);
        }

        sortedAdd(size, new Word(w, f));
        size++;
    }

    /**
     * @param i    index wo das Wort hinein sollte, von dem index wird nach links sortiert
     * @param word das word
     */
    private void sortedAdd(int i, Word word) {
        int j = i - 1;
        // wenn es ein word links gibt und die freq kleiner ist
        if (j >= 0 && fqTable[j].getFrequency() < word.getFrequency()) {
            for (; j >= 0; j--) {
                // verschiebe alle, welche kleiner sind
                if (fqTable[j].getFrequency() < word.getFrequency()) {
                    fqTable[j + 1] = fqTable[j];
                } else break;
            }
        }

        // j ist der index von dem word, welcher größer ist
        // (also dem index wo wir break gemacht haben) deswegen + 1
        fqTable[j + 1] = word;
    }


    @Override
    public Word get(int pos) {
        if (pos >= size) {
            throw new IndexOutOfBoundsException("Can't access index %d for size %d".formatted(pos, size()));
        }

        return fqTable[pos];
    }

    @Override
    public int get(String w) {
        for (int i = 0; i < size; i++) {
            Word word = fqTable[i];
            if (word.getWord().equals(w)) {
                return word.getFrequency();
            }
        }

        return 0;
    }
}
