package de.ketra.aufgabe4;

/**
 * Klasse f&uuml;r W&ouml;rter mit ihren H&auml;ufigkeiten.
 * @author oliverbittel
 * @since 22.3.2019
 */
public class Element<T> {
	final private T value;
	private int freqency;

	/**
	 * Konstruktor.
	 * @param value Wort
	 * @param f H&auml;ufgkeit
	 */
	public Element(T value, int f) {
		this.value = value;
		this.freqency = f;
	}

	/**
	 * Liefert Wort zur&uuml;ck.
	 * @return Wort
	 */
	public T getValue() {
		return value;
	}

	/**
	 * Liefert H&auml;ufgkeit zur&uuml;ck.
	 * @return H&auml;ufgkeit
	 */
	public int getFrequency() {
		return freqency;
	}

	/**
	 * Addiert zur H&auml;ufgkeit f dazu.
	 * @param f H&auml;ufgkeits&auml;nderung.
	 */
	public void addFrequency(int f) {
		freqency += f;
	}

	/**
	 * Liefert eine String-Darstellung zur&uuml;ck.
	 * @return String-Darstellung.
	 */
	@Override
	public String toString() {
		return value.toString() + ":" + freqency;
	}
}
