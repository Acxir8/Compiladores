package fes.aragon.herramientas;

public class Herramienta {
	public static boolean letra(char c) {
		boolean letra = false;
		if ((c >= 97 && c <= 122) || (c >= 65 && c <= 90)) {
			letra = true;
		}
		return letra;
	}

	public static boolean numero(char c) {
		boolean numero = false;
		if (c >= 48 && c <= 57) {
			numero = true;
		}
		return numero;
	}

	public static boolean finCadena(char c){
		boolean fc = false;
		if (c == 32) {
			fc = true;
		}
		return fc;
	}
}
