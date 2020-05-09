package MySQL;

public class Granjero implements Comparable<Granjero> {
	protected int id;
	public String nombre;
	protected String descripcion;
	protected float dinero;
	protected int puntos;
	protected int nivel;

	public Granjero(int id, String nombre, String descripcion, float dinero, int puntos, int nivel) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.dinero = dinero;
		this.puntos = puntos;
		this.nivel = nivel;
	}

	public Granjero() {
		super();
	}

	@Override
	public String toString() {
		return "Granjero [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", dinero=" + dinero
				+ ", puntos=" + puntos + ", nivel=" + nivel + "]";
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getDinero() {
		return dinero;
	}

	public void setDinero(float dinero) {
		this.dinero = dinero;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	@Override
	public int compareTo(Granjero o) {
		int resultado = 0;
//		if (Datos.valorOrdenacion.equalsIgnoreCase("dinero")) {
//			resultado = (int) (o.dinero - this.dinero);
//		} else if (Datos.valorOrdenacion.equalsIgnoreCase("nombre")) {
//			resultado = this.nombre.compareTo(o.nombre);
//		} else if (Datos.valorOrdenacion.equalsIgnoreCase("puntos")) {
//			resultado = o.puntos - this.puntos;
//		}
		return resultado;
	}
}