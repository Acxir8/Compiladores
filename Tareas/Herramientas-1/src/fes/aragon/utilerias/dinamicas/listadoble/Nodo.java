package fes.aragon.utilerias.dinamicas.listadoble;

public class Nodo<E> {
    private E dato;
    private Nodo<E> anterior;
    private Nodo<E> siguiente;

	public Nodo(E dato) {
		this(dato, null, null);
	}

	public Nodo(E dato, Nodo<E> anterior, Nodo<E> siguiente) {
		this.dato=dato;
		this.setAnterior(anterior);
		this.siguiente=siguiente;
	}

	public E getDato() {
		return dato;
	}
	public void setDato(E dato) {
		this.dato = dato;
	}

	public Nodo<E> getAnterior() {
		return anterior;
	}

	public void setAnterior(Nodo<E> anterior) {
		this.anterior = anterior;
	}
	
	public Nodo<E> getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Nodo<E> siguiente) {
		this.siguiente = siguiente;
	}

	
}
