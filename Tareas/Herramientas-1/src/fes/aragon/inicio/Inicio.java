package fes.aragon.inicio;

import fes.aragon.postfija.Postfija;
import fes.aragon.postfija.Problemas;

public class Inicio {

	public static void main(String[] args) {

		Postfija operar = new Postfija();
		Problemas problemas = new Problemas();
		String dato = "( ( 24 * 3 + 8 / 2 ) + ( 2 + 3 / 5 ^ 7 + 6 + 2 ) ) / 2 / 2";
		String scadena = "Una cierta molécula orgán(ica (en sus) núcleo(s de dos( Átomos de) ca)rbono) están sep(ara(dos a un)a dist)ancia";
		String cadena = "oso";
		String cadena2 = "osa";
		
		System.out.println(operar.intAPostfija(dato));
		System.out.println(operar.evaluarPostfija(operar.intAPostfija(dato)));
		
		System.out.println("La palabra: " + cadena + " " + problemas.palindromo(cadena));
		System.out.println("La palabra: " + cadena2 + " " + problemas.palindromo(cadena2));
		System.out.println(problemas.encriptacion(scadena));
		System.out.println(problemas.desEncriptar(problemas.encriptacion(scadena)));
		
		
	}
}
