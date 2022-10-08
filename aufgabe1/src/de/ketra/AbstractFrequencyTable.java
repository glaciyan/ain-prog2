package de.ketra;

/**
 *
 * @author oliverbittel
 * @since 22.2.2019
 */
public abstract class AbstractFrequencyTable implements FrequencyTable {
	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}

	@Override
    public void add(String w) {
        add(w, 1);
    }

	@Override
	public void addAll(FrequencyTable fq) {
		for (int i = 0; i < fq.size(); i++) {
			Word word = fq.get(i);
			this.add(word.getWord(), word.getFrequency());
		}
	}

	@Override
	public void collectMostFrequent(FrequencyTable fq) {
		if (this.isEmpty()) return;
		int highest = this.get(0).getFrequency();

		fq.clear();
		for (int i = 0; i < this.size(); i++) {
			Word word = this.get(i);
			if (word.getFrequency() < highest) break;

			fq.add(word.getWord(), word.getFrequency());
		}
	}

	@Override
	public void collectLeastFrequent(FrequencyTable fq) {
		if (this.isEmpty()) return;

		fq.clear();
		for (int i = this.size() - 1; i >= 0; i--) {
			Word word = this.get(i);
			if (word.getFrequency() > 1) break;

			fq.add(word.getWord(), word.getFrequency());
		}
	}

	/**
	 * Liefert eine String-Darstellung zur&uuml;ck.
	 * @return String-Darstellung.
	 */
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();

		s.append("{");

		for (int i = 0; i < this.size(); i++) {
			s.append(this.get(i)).append(", ");
		}

		s.append("}");

		s.append(" size = ").append(this.size());

		return s.toString();
	}
}
