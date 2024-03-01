package fes.aragon.utilerias.dinamicas.cola;

import fes.aragon.utilerias.dinamicas.listasimple.ListaSimple;

public class Cola<E> {
	private ListaSimple<E> cola = new ListaSimple<>();

	public void borrar() {
		cola = new ListaSimple<>();
	}

	public boolean estaVacia() {
		return cola.esVacia();
	}

	public ListaSimple<E> getCola() {
		return cola;
	}

	public void setCola(ListaSimple<E> cola) {
		this.cola = cola;
	}

	public void insertar(E dato) {
		cola.agregarEnCola(dato);
	}

	public E extraer() throws Exception {
		E tmp = null;
		if (!estaVacia()) {
			tmp = cola.obtenerCabeza();
			cola.eliminarCabeza();
		} else {
			throw new Exception("Cola vacia");
		}
		return tmp;
	}
	
	public E elementoSuperior() throws Exception{
		E tmp = null;
		if (!estaVacia()) {
			tmp = cola.obtenerCabeza();
			cola.agregarEnCabeza(tmp);
		}else {
			throw new Exception("Cola vacia");
		}
		return tmp;
	}

}
