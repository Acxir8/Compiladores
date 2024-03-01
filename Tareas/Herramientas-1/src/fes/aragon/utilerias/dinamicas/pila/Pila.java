package fes.aragon.utilerias.dinamicas.pila;

import fes.aragon.utilerias.dinamicas.listasimple.ListaSimple;

public class Pila<E> {
	private ListaSimple<E> pila = new ListaSimple<>();

	public void borrar() {
		pila = new ListaSimple<>();
	}

	public boolean estaVacia() {
		return pila.esVacia();
	}

	public void insertar(E dato) {
		pila.agregarEnCola(dato);
	}

	public void imprimirElementos() {
		pila.imprimirElementos();
	}

	public E extraer() throws Exception {
		E tmp = null;
		if (!estaVacia() || pila.getLongitud() > 0) {
			tmp = pila.obtenerCola();
			pila.eliminarCola();
		} else {
			throw new Exception("Cola vacia");
		}
		return tmp;
	}

	public E elementoSuperior() throws Exception {
		E tmp = null;
		if (!estaVacia()) {
			tmp = pila.obtenerCola();
		} else {
			throw new Exception("Cola vacia");
		}
		return tmp;
	}

}
