package fes.aragon.pruebas;

import fes.aragon.palabras.Archivos;

public class ImparCero {

	Archivos archivos = new Archivos();

	public void revisarImparCero() {
		// ArrayList<String> archivos.documento = palabras.getPalabras();
		String nombreArchivo = System.getProperty("user.dir") + "\\src\\fes\\aragon\\recursos\\palabras";
		archivos.leerArchivo(nombreArchivo);

		int indiceDelArray = 0;
		int indiceDeLaPalabra = 0;
		int estado = 0;
		boolean error = false;
		while (indiceDelArray <= archivos.documento.size() - 1) {
			while (indiceDeLaPalabra <= archivos.documento.get(indiceDelArray).length() - 1) {
				char c = archivos.documento.get(indiceDelArray).charAt(indiceDeLaPalabra);
				switch (estado) {
				case 0:
					if (c == '1') {
						estado = 0;
					} else if (c == '0') {
						estado = 1;
					} else {
						error = true;
						indiceDeLaPalabra = archivos.documento.size() + 1;
					}
					break;
				case 1:
					if (c == '1') {
						estado = 1;
					} else if (c == '0') {
						estado = 0;
					} else {
						error = true;
						indiceDeLaPalabra = archivos.documento.size() + 1;
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
			estado = 0;
			indiceDelArray++;
		}
	}

}
