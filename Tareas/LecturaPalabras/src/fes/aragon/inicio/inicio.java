package fes.aragon.inicio;

import fes.aragon.palabras.Archivos;
import fes.aragon.pruebas.ImparCero;
import fes.aragon.pruebas.ParUno;

public class inicio {
	public static void main(String[] args) {
		ImparCero imparCero = new ImparCero();
		ParUno parUno = new ParUno();
		Archivos archivos = new Archivos();
		archivos.imprimirArchivo();
		System.out.println("--------------------------");

		System.out.println("Impares de Cero:");
		imparCero.revisarImparCero();
		System.out.println("--------------------------");
		System.out.println("Pares de Uno:");
		parUno.revisarParUno();

	}
}
