package fes.aragon.afnd_afd;

import fes.aragon.herramientas.Gestor;

public class afnd_afd {

	public static void main(String[] args) {

		for (String palabra : Gestor.leer("fuente.txt")) {
			int indice = 0;
			int estado = 0;
			String mensajeError = "";
			int columna = 1;

			while (indice <= palabra.length() - 1) {
				char c = palabra.charAt(indice);

				if (c != '0' && c != '1') {
					mensajeError = "contiene el Caracter no valido: " + c + " en la columna " + columna;
					break;
				}

				switch (estado) {
				case 0:
					if (c == '0') {
						estado = 1;
					} else if (c == '1') {
						estado = 2;
					}
					break;

				case 1:
					if (c == '0') {
						estado = 1;
					} else if (c == '1') {
						estado = 2;
					}
					break;

				case 2:
					if (c == '0') {
						estado = 1;
					} else if (c == '1') {
						estado = 3;
					}
					break;

				case 3:
					if (c == '0') {
						estado = 4;
					} else if (c == '1') {
						estado = 3;
					}
					break;
				case 4:
					if (c == '0') {
						estado = 4;
					} else if (c == '1') {
						estado = 2;
					}
					break;
				}
				indice++;
				columna++;
			}

			if (mensajeError.isEmpty()) {
				if (estado == 3 || estado == 4) {
					System.out.println(palabra + ":" + " Cadena Valida");
				} else {
					System.out.println(palabra + ":" + " Cadena Invalida");
				}
			} else {
				System.out.println("La Palabra \"" + palabra + "\": " + mensajeError);
			}
		}
	}
}
