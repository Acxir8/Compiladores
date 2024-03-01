package fes.aragon.postfija;

import fes.aragon.utilerias.dinamicas.pila.Pila;

public class Problemas {
	Pila<Object> intercambiar = new Pila<>();
	Pila<String> pila = new Pila<String>();

	private char[] ccadena;
	private boolean parentesis = false, rep = false;
	private int inicio = 0, cierre = 0, nParentesis = 0;

	public String palindromo(String input) {
		// String input = "34 + 35 + 34 * 46 * 37 + 35 + 34";
		String result;
		String dInput[] = input.split("");
		boolean palindromo = true;

		for (int i = 0; i < dInput.length; i++) {
			pila.insertar(dInput[i]);
		}

		for (int i = 0; i < dInput.length; i++) {
			try {
				if (!(dInput[i].equals(pila.extraer()))) {
					palindromo = false;
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		if (palindromo == true) {
			result = "Es un palindromo";
		} else {
			result = "No es un palindromo";
		}
		return result;
	}

	public String encriptacion(String scadena) {
		ccadena = scadena.toCharArray();

		for (int i = 0; i < ccadena.length; i++) {
			if (ccadena[i] == '(' || parentesis == true) {

				if (ccadena[i] == '(') {
					if (nParentesis > 0) {
						intercambiar.insertar(')');
						nParentesis++;
					} else {
						inicio = i;
						parentesis = true;
						nParentesis++;
					}

				} else if (ccadena[i] == ')' && nParentesis > 0) {

					if (nParentesis == 1) {
						parentesis = false;
						cierre = i;

						for (int ii = inicio + 1; ii < cierre; ii++) {
							try {
								ccadena[ii] = (char) intercambiar.extraer();
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
						}
						nParentesis--;
						if (rep == true) {
							i = inicio + 1;
						}
					} else {
						nParentesis--;
						rep = true;
						intercambiar.insertar('(');
					}
				} else {

					intercambiar.insertar(ccadena[i]);
				}
			}
		}
		// Pasar de char[] a strings
		scadena = String.valueOf(ccadena);
		return scadena;
	}

	public String desEncriptar(String scadena) {
		for (int i = 0; i < ccadena.length; i++) {
			if (ccadena[i] == '(' || parentesis == true) {

				if (ccadena[i] == '(') {
					if (nParentesis > 0) {
						intercambiar.insertar(')');
						nParentesis++;
					} else {
						inicio = i;
						parentesis = true;
						nParentesis++;
					}

				} else if (ccadena[i] == ')' && nParentesis > 0) {

					if (nParentesis == 1) {
						parentesis = false;
						cierre = i;

						for (int ii = inicio + 1; ii < cierre; ii++) {
							try {
								ccadena[ii] = (char) intercambiar.extraer();
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
						}
						nParentesis--;
						if (rep == true) {
							i = inicio + 1;
						}
					} else {
						nParentesis--;
						rep = true;
						intercambiar.insertar('(');
					}
				} else {

					intercambiar.insertar(ccadena[i]);
				}
			}
		}

		// Pasar de char[] a strings
		scadena = String.valueOf(ccadena);

		return scadena;
	}

}
