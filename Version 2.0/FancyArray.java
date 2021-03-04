package eins;

/*
 * Array sind doof,
 * FancyArray macht alles besser:
 * - keine feste Größe
 * - keine eckigen Klammer
 * - Objekte im Array
 * - keine Angabe von Indices beim Zugriff nötig
 */

public class FancyArray {
	/*
	 * Um mehrere Werte in einer Klasse abzulegen
	 * brauchen wir ein Feld, in dem mehrere Werte abgelegt werden
	 * können... da kennen wir aktuell nur Arrays.
	 * Also nehmen wir die erstmal
	 * 
	 * Damit das niemand merkt machen wir das private:
	 */
	private Object[] geheim;
	/*
	 * Damit wir Objekte ablegen können, muss unser geheim-Array
	 * vom Typ Object sein
	 */
	public FancyArray() {
		/*
		 * Am Anfang soll unser FancyArray die Größe 0 haben,
		 * damit wir keine null-Elemente in darin haben
		 */
		geheim = new Object[0];
	}
	/*
	 * Wie kommen neue Elemente in unser FancyArray?
	 * Es soll eine Methode add() geben, die ein Element
	 * hinten an das FancyArray anfügt
	 * -> die Elemente im FancyArray sind geordnet
	 * 
	 * Wie kann ich in ein Array einer Größe n ein zusätzliches
	 * Element einbauen?
	 * -> ich brauche ein neues Array, das um eins größer ist 
	 * 
	 * Das passiert oft, also schreibe ich eine Methode, die das
	 * macht: resize(int diff)
	 * 
	 * Damit mein Endnutzer damit keinen Unsinn machen kann,
	 * mache ich die Methode private
	 */
	private void resize(int diff) {
		//Reicht das? Einfach das Array zu vergrößern?
		Object[] neu = new Object[geheim.length+diff];
		//Nein, ich muss die bestehenden Inhalte übertragen
		for(int i=0; i < (diff<0?neu.length:geheim.length);i++) {
			neu[i] = geheim[i];
		}
		//Jetzt kann ich alles ersetzen
		geheim = neu;
	}
	
	/*
	 * add() soll ein neues Element hinten hinzufügen
	 */
	public void add(Object el) {
		//1. Array um 1 vergrößern
		resize(1);
		//2. Neues Element in das neue Feld hinten eintragen:
		geheim[geheim.length-1] = el;
	}
	
	/*
	 * Um einzelne Elemente aus unserem Array auslesen zu können
	 * (ohne eckige Klammern), schreibe ich eine Methode get()
	 */
	public Object get(int i) {
		Object rueckgabe = geheim[i];
		return rueckgabe;
	}
	
	/*
	 * Um zu wissen, wie viele Elemente unser FancyArray hat
	 * wollen wir eine Methode schreiben size()
	 */
	public int size() {
		return geheim.length;
	}
	
	/*
	 * Analog zu unserer Methode get() soll es set() geben:
	 */
	public void set(int index, Object wert) {
		// Das Element an der Stelle index 
		//soll auf den Wert wert gesetzt werden
		geheim[index] = wert;
	}
	
	/*
	 * Zum Entfernen eines Elements an einem gegebenen Index
	 * 
	 * |0|1|2|
	 * ------
	 * |a|b|c|
	 * Das Element am Index 1 soll weg (b streichen):
	 * |0|1|
	 * -----
	 * |a|c|
	 * 
	 */
	public void remove(int index) {
		//Das Element am Index soll weg:
		//1. Alle Elemente davor sollen erhalten bleiben
		//2. Alle Elemente dahinter sollen erhalten bleiben
		//und der Index 1 kleiner werden
		for(int i=index+1;i < geheim.length; i++) {
			geheim[i-1] = geheim[i];
		}
		//3. Das Array soll um eins kleiner sein
		resize(-1);
	}
	
	/*
	 * Eine remove()-Methode soll existieren, die ein
	 * übergebenes Objekt aus dem FancyArray entfernt:
	 */
	public void remove(Object o) {
		/*
		 * Um bestehenden Code wiederzuverwenden
		 * könnte ich
		 */
		 // 1) Den Index des Objekts feststellen
		int index = indexOf(o);
		// 2) Das Objekt an dem Index löschen :)
		//(nur wenn es tatsächlich existiert)
		if(index >= 0) {
			remove(index);
		}
	}
	
	public int indexOf(Object o) {
		/*
		 * Wie finde ich raus, welchen Index das Object o hat?
		 * 
		 * Ich vergleiche das Objekt mit jedem Objekt aus dem
		 * FancyArray
		 */
		for(int i=0; i < size();i++) {
			if(get(i).equals(o)) {
				return i;
			}
		}
		return -1;
		/*
		 * Der Rückgabewert -1 bedeutet, dass das Object o nicht
		 * im FancyArray enthalten ist :(
		 */
	}
	
	/*
	 * Um FancyArray einfacher bedienen zu können, wollen wir
	 * noch ein paar Utility-Methoden schreiben:
	 * - eine Methode, mit der ich mein FancyArray leichter initialisieren kann
	 * - eine Methode um einen Wert komplett zu entfernen
	 * - eine Methode, die prüft ob ein bestimmter Wert in FancyArray enthalten ist
	 * vielleicht noch 
	 * - eine Methode zum Sortieren
	 */
	
	/*
	 * Werte aus einem klassischen Array ins FancyArray übernehmen
	 */
	public void addAll(Object[] arr) {
		//Das machen wir mit einer Schleife :)
		for(int i=0;i < arr.length; i++) {
			add(arr[i]);
		}
	}
	
	/*
	 * Das war so kurz, wir schreiben einen Konstruktor :)
	 */
	public FancyArray(Object[] arr) {
		/*
		 * Statt eines Konstruktors der Oberklasse kann ich auch
		 * einen anderen Konstruktor der Klasse selbst aufrufen!
		 * 
		 * Auch dazu benutzen wir das Schlüsselwort this,
		 * so rufen wir den parameterlosen Konstruktor auf -
		 * so kann ich auch Konstruktoren der gleichen Klasse verketten
		 */
		this();
		//nach dem Aufruf wird dieser Konstruktor weiter ausgeführt:
		addAll(arr);
	}
	
	/*
	 * Alle Vorkommnisse sollen entfernt werden:
	 */
	public void removeAll(Object o) {
		//so lange das Objekt entfernen bis es nicht mehr drin ist
		while(contains(o)) {
			remove(o);
		}
	}
	
	public boolean contains(Object o) {
		//Wir prüfen der Reihe nach ob das Objekt gleich ist
//		for(int i=0; i < size(); i++) {
//			if(get(i).equals(o)) {
//				return true;
//			}
//		}
//		return false;
		//oder kürzer
		return indexOf(o) != -1;
	}
	
	/*
	 * toArray() soll ein klassisches Array zurückgeben, das den Inhalt
	 * unseres FancyArray beinhaltet
	 */
	public Object[] toArray() {
		//Am einfachsten unser bestehendes Array zurückgeben
//		return geheim;
		/*
		 * Damit zerstören wir aber die Kapselung, weil dann jeder an unser
		 * Array gehen darf :(
		 * 
		 * Lassen Sie uns eine Kopie davon machen und rausgeben
		 */
		Object[] kopie = new Object[size()];
		for(int i=0; i < size(); i++) {
			kopie[i] = get(i);
		}
		return kopie;
		
	}
	
	public void sort() {
		/*
		 * sort() soll unser bestehendes Array durchsortieren,
		 * dazu müssen alle Elemente des Arrays Comparable implementieren
		 * 
		 * z.B. mit BubbleSort können wir dann unser Array sortieren
		 * 
		 * in mehreren Durchläufen
		 * paarweise vergleichen bis zum Ende des Arrays
		 */
		for(int j = 0; j < size();j++) {
			for(int i = 0; i < size()-1; i++) {
				//Vergleichen
				if(((Comparable)get(i)).compareTo(get(i+1)) > 0) {
					//Paartausch
					Object o = get(i);	//Wert von der Stelle i in o speichern
					set(i,get(i+1));	//Wert von der Stelle i+1 an i speichern
					set(i+1,o);			//Wert aus o an der Stelle i+1 speichern
				}
			}
		}
	}
	
	/*
	 * Damit wir den Inhalt von FancyArray anzeigen können
	 * machen wir sofort eine toString()-Methode
	 */
	public String toString() {
		String rueckgabe = "";
		for(int i=0;i<geheim.length;i++) {
			if(i ==geheim.length-1){
				rueckgabe +=geheim[i];
			} else {
				rueckgabe +=geheim[i] + ",";
			}
		}
		return rueckgabe;
	}
	
}
