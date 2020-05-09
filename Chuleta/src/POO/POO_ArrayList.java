package POO;
import java.util.ArrayList;
import java.util.Iterator;

public class POO_ArrayList {

	public static void main(String[] args) {
		ArrayList a = new ArrayList();
		ArrayList<ArrayList<Integer>> aa = new ArrayList();
		a.add("una frase");
		a.add(25);
		a.add('c');
		a.add(33.33333);
		a.add("Torrente");
		System.out.println(a);
		aa.get(0).add(1);
		System.out.println(aa);
		ArrayList<Integer> b = new ArrayList();

		System.out.println("Longitud: " + a.size());

		System.out.println("Mostrar posicion especifica: " + a.get(1));

		a.remove(1);
		System.out.println(a);

		a.set(1, "posicion 1");
		System.out.println(a);

		a.add(2, "nepe");
		System.out.println(a);

		System.out.print(a.contains("nepe"));
		System.out.println(" " + a.indexOf("nepe"));
		System.out.println(a.contains(30));

		System.out.println("\nArray: ");
//		for (int i = 0; i < a.size(); i++) {
//			System.out.println(a.get(i));
//		}
//		for (Object i : a) {
//			System.out.println(i);
//		}
		Iterator it = a.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
		a.clear();
		System.out.println("\n" + a);
	}

}
