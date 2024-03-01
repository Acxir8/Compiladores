package fes.aragon.postfija;

import fes.aragon.utilerias.dinamicas.pila.Pila;

public class Postfija {
	Pila<String> pila = new Pila<>();
	Pila<Double> pilaNum = new Pila<>();

	private String salida = "";
	private String simboloArriba = "";
	private int indice;
	private Double result;

	public String intAPostfija(String operacion) {
		// Int a postfija
		this.salida = "";
		String[] cadena = operacion.split(" ");
		indice = 0;
		while (indice < cadena.length) {
			if (!cadena[indice].equals("(") && !cadena[indice].equals(")") && !cadena[indice].equals("^")
					&& !cadena[indice].equals("*") && !cadena[indice].equals("/") && !cadena[indice].equals("+")
					&& !cadena[indice].equals("-")) {
				salida += " " + cadena[indice];
			} else {
				try {
					if (!cadena[indice].equals("(")) {
						while (!pila.estaVacia() && precedencia(pila.elementoSuperior(), cadena[indice])) {
							if (pila.elementoSuperior().equals("(")) {
								simboloArriba = pila.extraer();
								break;
							} else {
								simboloArriba = pila.extraer();
								salida += " " + simboloArriba;
							}
						}
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				if (!cadena[indice].equals(")"))
					pila.insertar(cadena[indice]);
			}
			indice++;
		}
		// operadoras restantes
		while (!pila.estaVacia()) {
			try {
				if (pila.elementoSuperior().equals("(")) {
					simboloArriba = pila.extraer();
				} else {
					simboloArriba = pila.extraer();
					salida += " " + simboloArriba;
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return salida;
	}

	public Double evaluarPostfija(String salida) {
		String[] cadena2 = salida.split(" ");
		indice = 1;
		while (indice < cadena2.length) {
			String simbolo = cadena2[indice];
			if (!simbolo.equalsIgnoreCase("^") && !simbolo.equalsIgnoreCase("+") && !simbolo.equalsIgnoreCase("-")
					&& !simbolo.equalsIgnoreCase("/") && !simbolo.equalsIgnoreCase("*")) {
				pilaNum.insertar(Double.parseDouble(simbolo));
			} else {
				try {
					double op1 = pilaNum.extraer();
					double op2 = pilaNum.extraer();
					if (simbolo.equals("+")) {
						pilaNum.insertar(op2 + op1);
					} else if (simbolo.equals("-")) {
						pilaNum.insertar(op2 - op1);
					} else if (simbolo.equals("*")) {
						pilaNum.insertar(op2 * op1);
					} else if (simbolo.equals("/")) {
						pilaNum.insertar(op2 / op1);
					} else if (simbolo.equals("^")) {
						pilaNum.insertar(Math.pow(op2, op1));
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

			}
			indice++;
		}
		try {
			this.result = pilaNum.extraer();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;

	}

	public boolean precedencia(String dato, String dato2) {
		boolean sePuede = false;
		boolean parentesis = false;
		int a = 0;
		if (dato.equals("^")) {
			sePuede = true;
		} else if (dato.equals("*") && dato2.equals("/") || dato.equals("/") && dato2.equals("*")) {
			sePuede = true;
		} else if (dato.equals("+") && dato2.equals("-") || dato.equals("-") && dato2.equals("+")) {
			sePuede = true;
		} else if (dato.equals("+") && dato2.equals("+") || dato.equals("-") && dato2.equals("-")) {
			sePuede = true;
		} else if (dato.equals("*") && dato2.equals("+") || dato.equals("*") && dato2.equals("-")) {
			sePuede = true;
		} else if (dato.equals("/") && dato2.equals("+") || dato.equals("/") && dato2.equals("-")) {
			sePuede = true;
		} else if (dato.equals("*") && dato2.equals("*") || dato.equals("/") && dato2.equals("/")) {
			sePuede = true;
		} else if (!dato.equals("(") && dato2.equals(")")) {
			sePuede = true;
		} else if (dato.equals("(") && dato2.equals(")")) {
			parentesis = true;
			a = 1;
		}
		if (a == 1) {
			return parentesis;
		} else {
			return sePuede;
		}
	}

}
