package MySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Consultas_Avanzadas {
	static PreparedStatement pstmnt = null;
	static ResultSet rset = null;

	public static void registrarFila(Connection con) {
		String insert = "insert into granjeros(`nombre`, descripcion) values (?, 'Nombre:' ?)";
		try {
			pstmnt = con.prepareStatement(insert);
			System.out.print("Introduce el nombre del granjero:");
//			String nombre = Main.lector.next();
//			pstmnt.setString(1, nombre);
//			pstmnt.setString(2, nombre);
			int resultado = pstmnt.executeUpdate();
			if (resultado == 0) {
				System.out.println("No se ha podido aumentar el nivel.");
			} else {
				System.out.println("Se ha aumentado el nivel.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void buscar(Connection con, String buscarPor) {
		try {
			if (buscarPor.equalsIgnoreCase("nombre")) {
				pstmnt = con.prepareStatement("select * from granjeros where nombre like ?");
				System.out.print("Introduce el nombre: ");
//				Main.lector.nextLine();
//				String nombre = Main.lector.nextLine();
//				pstmnt.setString(1, "%" + nombre + "%");
			} else if (buscarPor.equalsIgnoreCase("descripcion")) {
				pstmnt = con.prepareStatement("select * from granjeros where descripcion like ?");
				System.out.print("Introduce la descripcion: ");
//				Main.lector.nextLine();
//				String desc = Main.lector.nextLine();
//				pstmnt.setString(1, "%" + desc + "%");
			}
			rset = pstmnt.executeQuery();
			boolean ningunResutado = true;
			while (rset.next()) {
				ningunResutado = false;
				System.out.print(rset.getInt(1) + "  -  ");
				System.out.print(rset.getString(2) + "  -  ");
				System.out.print(rset.getString(3) + "  -  ");
				System.out.print(rset.getInt(4) + "  -  ");
				System.out.print(rset.getInt(5) + "  -  ");
				System.out.println(rset.getInt(6));
			}
			if (ningunResutado == true) {
				System.out.println("No se ha encontrado ninguna fila.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void incrementarNivel(Connection con, String nombre) {
		try {
			pstmnt = con.prepareStatement("update granjeros set nivel = nivel + 1 where nombre = ?");
			pstmnt.setString(1, nombre);
			int resultado = pstmnt.executeUpdate();
			if (resultado == 0) {
				System.out.println("No se ha podido aumentar el nivel.");
			} else {
				System.out.println("Se ha aumentado el nivel.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void eliminar(Connection con, int id) {
		try {
			pstmnt = con.prepareStatement("DELETE FROM granjeros WHERE id = ?");
			pstmnt.setInt(1, id);
			int resultado = pstmnt.executeUpdate();
			if (resultado == 0) {
				System.out.println("No existe el granjero " + id +".");
			} else {
				System.out.println("Se ha eliminado correctamente.");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
