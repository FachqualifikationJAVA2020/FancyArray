package eins;

public class Wrapper {
	/*
	 * Warum kommen primitive Datentyen in ein Array vom Typ Object
	 * Das sind doch gar keine Objekte!
	 * 
	 * Zu jedem primitiven Datentypen gibt es eine sogenannte 
	 * Wrapper-Klasse. Deren Job ist es einen Wert eines
	 * primitiven Typen in ein Objekt einzupacken
	 * 
	 * 
	 * double	heiﬂt	Double
	 * float	heiﬂt	Float
	 * boolean	heiﬂt	Boolean
	 * short	heiﬂt	Short
	 * byte		heiﬂt	Byte
	 * long		heiﬂt	Long
	 * 
	 * int		heiﬂt	Integer
	 * char		heiﬂt	Character
	 * 
	 */
	
	public static void main(String[] args) {
		/*
		 * Also
		 */
		Integer i = 5;
		/*
		 * Der int-Wert auf der rechten Seite wird automatisch
		 * in ein Integer-Objekt umgewandelt
		 * (Auto-Boxing)
		 */
		int j = i + 6;
		/*
		 * Hier passiert das Gegenteil, das i wird ausgepackt
		 * um damit zu rechnen (Auto-Unboxing)
		 */
		
		/*
		 * Integer ist tats‰chlich eine Klasse, die auch verschiedene
		 * Methoden hat, z.B. intValue ist im Prinzip ein getter,
		 * der Zugriff auf den enthaltenen int-Wert erlaubt
		 */
		System.out.println(i.intValue());

	}

}
