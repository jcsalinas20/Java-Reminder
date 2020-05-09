package Recursividad;
//Recursividad: llamar dentro de la funcion a su misma funcion.
public class Recursividad {
	
	public static String funcionA(){
		String a = "Soy el string de funcionA";
		System.out.println(a);
		return a;
	}

	public static void main(String[] args) {
		System.out.println("frase1");
		System.out.println("frase2");
		System.out.println(funcionA());
		System.out.println("frase2");
	}

}
