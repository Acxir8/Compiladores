package fes.aragon.inicio;

import fes.aragon.herramientas.Archivos;


public class Inicio {

	public static void main(String[] args) {
		Archivos archivo = new Archivos();
		String nombreArchivoM = System.getProperty("user.dir") + "\\src\\fes\\aragon\\recursos\\matrizVariables";
		archivo.leerMatriz(nombreArchivoM);
		
		
	}

}
