package fes.aragon.main;

import fes.aragon.metodos.*;

public class Inicio {
	public static void main(String[] args) {
		Archivos archivos = new Archivos();
		String nombreArchivo = System.getProperty("user.dir") + "\\src\\fes\\aragon\\recursos\\marianela.fes";
		//String nombreArchivo = System.getProperty("user.dir") + "\\src\\fes\\aragon\\recursos\\LaBibliaPortugues.fes";
		String nombreArchivoEscritura = "Escrito.fes";

		//Lecturas
		archivos.leerArchivo(nombreArchivo);
		archivos.imprimirArchivo();

		// Escritura
		archivos.guardarArchivo(nombreArchivoEscritura);
		archivos.leerArchivo(System.getProperty("user.dir") + "\\src\\fes\\aragon\\recursos\\" + nombreArchivoEscritura);
		archivos.imprimirArchivo();

	}
}
