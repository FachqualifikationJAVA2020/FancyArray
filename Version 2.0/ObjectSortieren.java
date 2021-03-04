package eins;

public class ObjectSortieren implements Comparable{

	/*
	 * Bei Zahlen oder bei Strings ist es uns klar, wie sie sortiert werden
	 * m�ssen
	 * 
	 * Wie ist es bei z.B. Mitarbeitern oder Fahrzeugen?
	 * Um solche Objekte vergleichen zu k�nnen m�ssen sie das
	 * Comparable-Interface implementieren.
	 * 
	 * Das Interface hat eine Methode:
	 */
	@Override
	public int compareTo(Object other) {
		/*
		 * compareTo
		 * - gibt 0 zur�ck, wenn beide Objekte gleich sind
		 * - gibt einen Wert gr��er 0 zur�ck, wenn dieses Objekt 
		 * 	 weiter hinten einsortiert werden soll (gr��er ist)
		 * - gibt einen Wert kleiner 0 zur�ck, wenn dieses Objekt kleiner ist
		 * 
		 * Den genauen Vergleichsmechanismus enth�lt die compareTo()-Methode
		 */
		
		return 0;
	}
}
