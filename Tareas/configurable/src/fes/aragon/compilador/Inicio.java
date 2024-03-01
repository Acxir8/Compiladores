package fes.aragon.compilador;

import fes.aragon.herramientas.Archivos;
import fes.aragon.herramientas.Herramienta;

public class Inicio {

	public static void main(String[] args) {
//		Lexico app = new Lexico();
//
//		app.setToken("Mike h");
//		try {
//			int verifica = app.inicio();
//			if (verifica == 1) {
//				System.out.println("Cadena valida");
//			}else {
//				System.out.println("Cadena invalida");
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			System.out.println(e);
//		}
		Archivos archivo = new Archivos();
		archivo.analizarPalabras();
		

		
		
	}

}
