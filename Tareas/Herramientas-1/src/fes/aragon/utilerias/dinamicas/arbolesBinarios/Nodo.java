package fes.aragon.utilerias.dinamicas.arbolesBinarios;

import java.util.Objects;

public class Nodo<E> {
	protected E dato;
	protected Nodo<E> izquierdo, derecho;
	protected String etiqueta;

	public Nodo() {
		izquierdo = derecho = null;
	}

	public Nodo(E dato, String etiqueta) {
		this(dato, null, null, etiqueta);
	}

	public Nodo(E dato, Nodo<E> izquierdo, Nodo<E> derecho, String etiqueta) {
		this.dato = dato;
		this.izquierdo = izquierdo;
		this.derecho = derecho;
		this.etiqueta = etiqueta;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dato);
	}

	public boolean mayor(Object obj) {
		boolean resultado = false;
		if (obj instanceof Integer && this.dato instanceof Integer) {
			Integer dato1 = (Integer) this.dato;
			Integer dato2 = (Integer) obj;
			if (dato1 < dato2) {
				return true;
			}
		}
		return resultado;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Integer && this.dato instanceof Integer) {
			Integer dato1 = (Integer) this.dato;
			Integer dato2 = (Integer) obj;
			if (dato1.equals(dato2)) {
				return true;
			} else {
				return false;
			}
		}
		Nodo other = (Nodo) obj;
		return Objects.equals(dato, other.dato);
	}
}