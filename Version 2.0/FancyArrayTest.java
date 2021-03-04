package eins;

public class FancyArrayTest {

	public static void main(String[] args) {
		/*
		 * Hier probieren wir die Klasse aus:
		 */
		FancyArray test = new FancyArray();
		System.out.println(test.size());
		//add
		test.add("Neu");
		System.out.println(test);
		
		test.add("zwei");
		test.add("drei");
		
		//toString()
		System.out.println(test);
		
		/*
		 * Jetzt einzelne Objekte
		 */
		System.out.println(test.get(2));
		/*
		 * Auch hier sehen wir, das "erste" Element hat den Index 0
		 */
		System.out.println(test.size());
		
		test.set(0, "eins");
		System.out.println(test);
		System.out.println(test.size());
		/*
		 * remove()
		 */
		test.remove(1);
		System.out.println(test);
		test.remove(1);
		System.out.println(test);
		test.remove(0);
		System.out.println(test);
		
		//Hier werden die float-Literale umgewandelt in Float
		//(die zugehörige Wrapperklasse)
		test.add(1.5);
		test.add(1.2);
		test.add(2.5);
		System.out.println(test);
		/*
		 * Ich möchte, dass so etwas geht:
		 * ich gebe den Wert an, der entfernt werden soll
		 * nicht den Index
		 */
		test.remove(1.2);
		System.out.println(test);
		
		/*
		 * Ab jetzt ein parametrisierter Konstruktoraufruf
		 */
		Object[] eingabe = {"Einkauf","Verwaltung","IT"};
		FancyArray test2 = new FancyArray(eingabe);
		System.out.println(test2);
		
		test2.add("Verwaltung");
		test2.removeAll("Verwaltung");
		System.out.println(test2);
		
		Object[] bla = test2.toArray();
		bla[1] = "Blödsinn";
		System.out.println(test2);
		//So soll es nicht sein, dass in test2 Blödsinn steht
		//Also haben wir das gefixt :)
		
		test2.add("Buchhaltung");
		System.out.println(test2);
		//Sortieren:
		test2.sort();
		System.out.println(test2);
		
		//Mal Zahlen
		Integer[] zahlen = {4,5,2,3,1};//Objekttyp!
		FancyArray test3 = new FancyArray(zahlen);
		System.out.println(test3);
		test3.sort();
		System.out.println(test3);
	}

}
