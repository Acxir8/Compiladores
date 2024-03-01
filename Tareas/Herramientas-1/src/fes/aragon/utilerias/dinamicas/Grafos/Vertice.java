package fes.aragon.utilerias.dinamicas.Grafos;

public class Vertice {

	private String nombre;
	
	public Vertice(String nombre) {
		// TODO Auto-generated constructor stub
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return nombre;
	}
	
	
	
}
