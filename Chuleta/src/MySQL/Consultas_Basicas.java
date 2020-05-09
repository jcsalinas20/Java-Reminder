package MySQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;

public class Consultas_Basicas {
	static Statement stmnt = null;
	static ResultSet rset = null;
	static String valorOrdenacion;
	static ArrayList<Granjero> granjeros = new ArrayList<Granjero>();

	public static void mostrarBasesDeDatos(Connection con) {
		try {
			stmnt = con.createStatement();
			rset = stmnt.executeQuery("show databases;");

			System.out.println("\nBases de Datos");
			while (rset.next()) {
				System.out.println(rset.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void mostrarTablas(Connection con) {
		try {
			stmnt = con.createStatement();
			rset = stmnt.executeQuery("show tables;");

			System.out.println("Tablas");
			while (rset.next()) {
				System.out.println(rset.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void ordenarDinero(Connection con) {
		Granjero g = new Granjero(0, null, null, 0, 0, 0);
		try {
			stmnt = con.createStatement();
			// rset = stmnt.executeQuery("select * from granjeros order by dinero;");
			rset = stmnt.executeQuery("select * from granjeros;");
			valorOrdenacion = "dinero";

			if (granjeros.size() == 0) {
				g = llenarArray(g);
			}

			for (int i = 0; i < granjeros.size(); i++) {
				g.compareTo(granjeros.get(i));
			}

			Collections.sort(granjeros);

			for (int i = 0; i < granjeros.size(); i++) {
				System.out.println((granjeros.get(i)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

	private static Granjero llenarArray(Granjero g) {
		try {
			granjeros.clear();
			while (rset.next()) {
				g = new Granjero(rset.getInt("id"), rset.getString("nombre"), rset.getString("descripcion"),
						rset.getFloat("dinero"), rset.getInt("puntos"), rset.getInt("nivel"));
				granjeros.add(g);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return g;
	}

	public static void ordenacionMultiple(Connection con, String ordenarPor) {
		valorOrdenacion = ordenarPor;

		try {
			Granjero g = new Granjero(0, null, null, 0, 0, 0);
			stmnt = con.createStatement();
			rset = stmnt.executeQuery("select * from granjeros;");

			g = llenarArray(g);

			for (int i = 0; i < granjeros.size(); i++) {
				g.compareTo(granjeros.get(i));
			}

			Collections.sort(granjeros);

			for (int i = 0; i < granjeros.size(); i++) {
				System.out.println(granjeros.get(i));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
