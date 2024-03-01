package fes.aragon.herramientas;

public class Matriz {
	private int columna1;
	private int columna2;
	private int caracterEspeciales;
	private int finCadena;

	public Matriz(int columna1, int columna2, int finCadena) {
		super();
		this.columna1 = columna1;
		this.columna2 = columna2;
		this.finCadena = finCadena;
	}

	public Matriz(int columna1, int columna2, int caracterEspeciales, int finCadena) {
		super();
		this.columna1 = columna1;
		this.columna2 = columna2;
		this.caracterEspeciales = caracterEspeciales;
		this.finCadena = finCadena;
	}

	public int getColumna1() {
		return columna1;
	}

	public int getColumna2() {
		return columna2;
	}

	public int getCaracterEspeciales() {
		return caracterEspeciales;
	}

	public int getFinCadena() {
		return finCadena;
	}

}
