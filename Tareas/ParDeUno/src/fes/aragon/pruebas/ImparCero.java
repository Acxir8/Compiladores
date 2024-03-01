package fes.aragon.pruebas;

import fes.aragon.palabras.Palabras;

import java.util.ArrayList;

public class ImparCero {
	Palabras palabras = new Palabras();

	public void revisarImparCero() {
		ArrayList<String> palabrasGuardadas = palabras.getPalabras();

		int indiceDelArray = 0;
		int indiceDeLaPalabra = 0;
		int estado = 0;
		boolean error = false;
		while (indiceDelArray <= palabrasGuardadas.size() - 1) {
			while (indiceDeLaPalabra <= palabrasGuardadas.get(indiceDelArray).length() - 1) {
				char c = palabrasGuardadas.get(indiceDelArray).charAt(indiceDeLaPalabra);
				switch (estado) {
				case 0:
					if (c == '1') {
						estado = 0;
					} else if (c == '0') {
						estado = 1;
					} else {
						error = true;
						indiceDeLaPalabra = palabrasGuardadas.size() + 1;
					}
					break;
				case 1:
					if (c == '1') {
						estado = 1;
					} else if (c == '0') {
						estado = 0;
					} else {
						error = true;
						indiceDeLaPalabra = palabrasGuardadas.size() + 1;
					}
					break;
				}
				indiceDeLaPalabra++;
			}
			if (!error) {

				if (estado == 1) {
					System.out.println("Valida");
				} else {
					System.out.println("Invalido");
				}
			} else {
				System.out.println("Caracter invalido");

			}
			indiceDeLaPalabra = 0;
			indiceDelArray++;
		}
	}

}
