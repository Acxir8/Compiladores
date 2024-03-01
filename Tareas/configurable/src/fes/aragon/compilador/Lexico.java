package fes.aragon.compilador;

import fes.aragon.herramientas.Herramienta;

public class Lexico {
	private int indice = 0;
	private int error = -1;

	// Variables del AFD
	private int estado = 0;
	private int columna = 0;

	private int[][] matrix = { { 2, 1, -1 }, { 1, 1, -1 }, { 2, 2, 1 } };
	private String token = "";

	public Lexico() {
		super();
	}

	private void reinicio() {
		indice = 0;
		estado = 0;
		columna = 0;

	}

	public void setToken(String token) {
		this.token = token;
	}

	private char siguienteCaracter() throws Exception {
		char caracter = ' ';
		if (indice < token.length()) {
			caracter = token.charAt(indice);
			if (caracter == ' ' && indice < token.length()) {
				reinicio();
				throw new Exception("Cadena Invalida ---> Espacio entre palabras encontrado");
			}
			indice++;
		}
		return caracter;
	}

	public int inicio() throws Exception {
		char c = ' ';
		reinicio();
		do {
			c = siguienteCaracter();
			if (Herramienta.letra(c)) {
				columna = 0;
			} else if (Herramienta.numero(c)) {
				columna = 1;
			} else if (Herramienta.finCadena(c)) {
				columna = 2;
			} else {
				error = 0;
			}
			if (error != 0) {
				estado = matrix[estado][columna];
			} else {
				reinicio();
				throw new Exception("Caracter invalido");
			}

		} while (!Herramienta.finCadena(c));
		return estado;
	}

}