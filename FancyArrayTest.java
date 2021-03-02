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
	}

}
