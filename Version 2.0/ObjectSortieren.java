package eins;

public class ObjectSortieren implements Comparable{

	/*
	 * Bei Zahlen oder bei Strings ist es uns klar, wie sie sortiert werden
	 * müssen
	 * 
	 * Wie ist es bei z.B. Mitarbeitern oder Fahrzeugen?
	 * Um solche Objekte vergleichen zu können müssen sie das
	 * Comparable-Interface implementieren.
	 * 
	 * Das Interface hat eine Methode:
	 */
	@Override
	public int compareTo(Object other) {
		/*
		 * compareTo
		 * - gibt 0 zurück, wenn beide Objekte gleich sind
		 * - gibt einen Wert größer 0 zurück, wenn dieses Objekt 
		 * 	 weiter hinten einsortiert werden soll (größer ist)
		 * - gibt einen Wert kleiner 0 zurück, wenn dieses Objekt kleiner ist
		 * 
		 * Den genauen Vergleichsmechanismus enthält die compareTo()-Methode
		 */
		
		return 0;
	}
}
