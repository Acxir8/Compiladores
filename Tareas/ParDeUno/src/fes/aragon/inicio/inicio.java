package fes.aragon.inicio;

import fes.aragon.pruebas.ImparCero;
import fes.aragon.pruebas.ParUno;

public class inicio {
	public static void main(String[] args) {
		ImparCero imparCero = new ImparCero();
		ParUno parUno = new ParUno();
		
		System.out.println("Impares de Cero:");
		imparCero.revisarImparCero();
		System.out.println("--------------------------");
		System.out.println("Impares de Uno:");
		parUno.revisarParUno();
	}
}
