package POO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*Enunciado: Hola
 * 1. Nombre de especialistas para cada una de las clases que heredan de especialista.
 * 2. Interfaz con las armas especiales.
 * 3. Matriz con ID, Nombre Especialista, Arma Especial.
 * 4. Busqueda de especialistas.
 * 5. Matriz con ID, Username, Bajas, Muertes, PBM, %Utilizacion Especialistas.*/

interface ArmasEspecialistas {
	String Ruin = "Puas Gravitatorias";
	String Crash = "Tak-5";
	String Torque = "Barricada";
	String Battery = "Maquina de Guerra";
	String Recon = "Pulso Visual";
	String Firebreak = "Purificador";
	String Nomad = "Perro de Presa";
	String Seraph = "Aniquilador";
	String Ajax = "Escudo Balistico";
	String Prophet = "Tempestad";
}

class Especilistas implements ArmasEspecialistas, Comparable<Especilistas> {
	protected ArrayList<Especilistas> especilistas = new ArrayList<Especilistas>();
	protected int id;
	protected String nombre;
	protected String armaEspecial;

	public Especilistas nombresEspecilistas(Especilistas esp) {
		for (int i = 0; i < 10; i++) {
			switch (i) {
			case 0:
				especilistas.add(new Ruin(i + 1, "Ruin", Ruin));
				break;
			case 1:
				especilistas.add(new Crash(i + 1, "Crash", Crash));
				break;
			case 2:
				especilistas.add(new Torque(i + 1, "Torque", Torque));
				break;
			case 3:
				especilistas.add(new Battery(i + 1, "Battery", Battery));
				break;
			case 4:
				especilistas.add(new Recon(i + 1, "Recon", Recon));
				break;
			case 5:
				especilistas.add(new Firebreak(i + 1, "Firebreak", Firebreak));
				break;
			case 6:
				especilistas.add(new Nomad(i + 1, "Nomad", Nomad));
				break;
			case 7:
				especilistas.add(new Seraph(i + 1, "Seraph", Seraph));
				break;
			case 8:
				especilistas.add(new Ajax(i + 1, "Ajax", Ajax));
				break;
			case 9:
				esp = new Prophet(i + 1, "Prophet", Prophet);
				especilistas.add(esp);
				break;
			default:
				System.out.println("Error.");
			}
		}
		return esp;
	}

	public void busquedaEspecialista() {
		boolean fi = false;
		System.out.println("\tEspecialistas");
		System.out.println("      -----------------");
		System.out.println("Introduce \"fi\" para terminar.");
		while (!fi) {
			int cont = 0;
			System.out.print("Introduce el nombre del especialista: ");
			String nombre = EjercicioCOD.lector.next();
			for (Object i : especilistas) {
				if (nombre.equalsIgnoreCase("fi")) {
					fi = true;
				}
				if (especilistas.get(cont).getNombre().equalsIgnoreCase(nombre)) {
					System.out.print(especilistas.get(cont).getId() + ", ");
					System.out.print(especilistas.get(cont).getNombre() + ", ");
					System.out.println(especilistas.get(cont).getArmaEspecial());
				}
				cont++;
			}
			System.out.println();
		}
	}

	@Override
	public int compareTo(Especilistas o) {
//		return o.id - this.id;
//		return this.nombre.compareTo(o.nombre);
		return this.armaEspecial.compareTo(o.armaEspecial);
	}

	public Especilistas(int id, String nombre, String armaEspecial) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.armaEspecial = armaEspecial;
	}

	public Especilistas() {
		super();
	}

	public ArrayList<Especilistas> getEspecilistas() {
		return especilistas;
	}

	public void getNombreEspecilistas(ArrayList<Especilistas> especilistas) {
		this.especilistas = especilistas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getArmaEspecial() {
		return armaEspecial;
	}

	public void setArmaEspecial(String armaEspecial) {
		this.armaEspecial = armaEspecial;
	}

}

class Ruin extends Especilistas {

	public Ruin(int id, String nombre, String armaEspecial) {
		super(id, nombre, armaEspecial);
	}

	public Ruin(Especilistas especilistas) {
	}

	public Ruin() {
	}

}

class Crash extends Especilistas {

	public Crash(int id, String nombre, String armaEspecial) {
		super(id, nombre, armaEspecial);
	}

}

class Torque extends Especilistas {

	public Torque(int id, String nombre, String armaEspecial) {
		super(id, nombre, armaEspecial);
	}

}

class Battery extends Especilistas {

	public Battery(int id, String nombre, String armaEspecial) {
		super(id, nombre, armaEspecial);
	}

}

class Recon extends Especilistas {

	public Recon(int id, String nombre, String armaEspecial) {
		super(id, nombre, armaEspecial);
	}

}

class Firebreak extends Especilistas {

	public Firebreak(int id, String nombre, String armaEspecial) {
		super(id, nombre, armaEspecial);
	}

}

class Nomad extends Especilistas {

	public Nomad(int id, String nombre, String armaEspecial) {
		super(id, nombre, armaEspecial);
	}

}

class Seraph extends Especilistas {

	public Seraph(int id, String nombre, String armaEspecial) {
		super(id, nombre, armaEspecial);
	}

}

class Ajax extends Especilistas {

	public Ajax(int id, String nombre, String armaEspecial) {
		super(id, nombre, armaEspecial);
	}

}

class Prophet extends Especilistas {

	public Prophet(int id, String nombre, String armaEspecial) {
		super(id, nombre, armaEspecial);
	}

}

public class EjercicioCOD {
	static Scanner lector = new Scanner(System.in);

	public static void main(String[] args) {
		Especilistas esp = new Especilistas();
		Especilistas esp2 = esp.nombresEspecilistas(esp);

//		esp.busquedaEspecialista();

		System.out.print("Ordenar por Id, Nombre, ArmaEspecial? ");
		String opcion = lector.next();
		System.out.println(esp.especilistas.size());
		System.out.println(esp.especilistas.size());
		if (opcion.equalsIgnoreCase("si")) {
		for (int i = 0; i < 10; i++) {
			esp2.compareTo(esp.especilistas.get(i));
		}
		Collections.sort(esp.especilistas);
		int cont1 = 0;
		System.out.println("\tEspecialistas");
		System.out.println("      -----------------");
		for (Object i : esp.especilistas) {
			System.out.print(esp.especilistas.get(cont1).getId() + ", ");
			System.out.print(esp.especilistas.get(cont1).getNombre() + ", ");
			System.out.println(esp.especilistas.get(cont1).getArmaEspecial());
			cont1++;
			}
		}
	}

}
