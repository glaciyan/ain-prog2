package de.ketra.aufgabe4;

/**
 *
 * @author oliverbittel
 * @since 22.2.2019
 */
public abstract class AbstractFrequencyTable<T> implements FrequencyTable<T> {
	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}

	@Override
    public void add(T w) {
        add(w, 1);
    }

	@Override
	public void addAll(FrequencyTable<? extends T> fq) {
		for (Element<? extends T> element : fq) {
			this.add(element.getValue(), element.getFrequency());
		}
	}

	@Override
	public void collectMostFrequent(FrequencyTable<? super T> fq) {
		if (this.isEmpty()) return;
		int highest = this.get(0).getFrequency();

		fq.clear();
		for (Element<T> element : this) {
			if (element.getFrequency() < highest) break;

			fq.add(element.getValue(), element.getFrequency());
		}
	}

	@Override
	public void collectLeastFrequent(FrequencyTable<? super T> fq) {
		if (this.isEmpty()) return;

		fq.clear();
		for (Element<T> element : this) {
			if (element.getFrequency() > 1) break;

			fq.add(element.getValue(), element.getFrequency());
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

		for (Element<T> element : this) {
			s.append(element).append(", ");
		}

		s.append("}");

		s.append(" size = ").append(this.size());

		return s.toString();
	}
}
