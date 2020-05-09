package buscaminas;

import java.util.LinkedList;

import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

public class BotonesDegradados {

	public BotonesDegradados() {
		LinkedList<Object> lista = new LinkedList<Object>();// Crear una lista.
		lista.add(0.9);// Numero para la difuminacion entre el primero color con el segundo, cuando mayor el numero mayor la difuminacion y lo aniadimos a la lista.
		lista.add(0.3);// Numero para la difuminacion entre el segundo color con el tercero, cuando mayor el numero mayor la difuminacion y lo aniadimos a la lista.

		lista.add(new ColorUIResource(85, 85, 85));// Poner el primer color.

		lista.add(new ColorUIResource(180, 180, 180));// Poner el segundo color.

		lista.add(new ColorUIResource(0, 0, 0));// Poner el tercer color.

		UIManager.put("Button.gradient", lista);// Aniadir todo al manager.

	}

}
