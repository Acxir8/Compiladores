package fes.aragon.utilerias.dinamicas.listasimple;

public class ListaSimple<E> {
	protected Nodo<E> cabeza, cola;
	protected int longitud = 0;

	/**
	 * Constructor | Inicia cabeza y cola en null
	 */
	public ListaSimple() {
		cabeza = cola = null;
	}

	/*
	 * 
	 * Metodo que borra toda la lista simple
	 */
	public void eliminarLista() {
		cabeza = cola = null;
		longitud = 0;
	}

	/**
	 * Método que agrega un nodo a la cabeza de la lista y aumenta la longitud.
	 * 
	 * @param dato guarda el dato creado en la cabeza
	 */
	public void agregarEnCabeza(E dato) {
		cabeza = new Nodo<E>(dato, cabeza);
		if (cola == null) {
			cola = cabeza;
		}
		longitud++;
	}

	/**
	 * Método que agrega un elemento a la cola de la lista. Aumenta la longitud
	 * 
	 * @param dato
	 */
	public void agregarEnCola(E dato) {
		if (cabeza == null) {
			cabeza = cola = new Nodo<E>(dato);
		} else {
			cola.setSiguiente(new Nodo<E>(dato));
			cola = cola.getSiguiente();
		}
		longitud++;
	}

	public void asignarDesdeOtroNodo(E dato, Nodo<E> posicion, int nuevaLongitud) {
		cabeza = new Nodo<E>(dato, posicion);
		longitud = nuevaLongitud;
	}

	public Nodo<E> obtenerUbiNodo(int indice) {
		Nodo<E> tmp = null;
		if (indice <= longitud) {
			tmp = cabeza;
			for (int contador = 0; contador < indice && tmp != null; contador++, tmp = tmp.getSiguiente())
				;
		}
		if (tmp != null) {
			return tmp.getSiguiente();
		} else {
			return null;
		}
	}

	public void cambiariNodo(int indice, Nodo<E> datoNodo) {
		Nodo<E> tmp = null;
		if (indice <= longitud) {
			tmp = cabeza;
			for (int contador = 0; contador < indice && tmp != null; contador++, tmp = tmp.getSiguiente())
				;
		}
		cola = tmp;
		tmp.setSiguiente(datoNodo);
	}

	/**
	 * Método que imprime los elementos de la lista
	 */
	public void imprimirElementos() {
		for (Nodo<E> tmp = cabeza; tmp != null; tmp = tmp.getSiguiente()) {
			System.out.println(tmp.getDato());
		}
	}

	public void imprimeToString() {
		for (Nodo<E> tmp = cabeza; tmp != null; tmp = tmp.getSiguiente()) {
			System.out.println(tmp.getDato().toString());
		}
	}

	/**
	 * Busca y elimina el valor en la lista
	 * 
	 * @param dato valor del tipo @param <E> a eliminar
	 * @return retorna un true si se borro el dato
	 */
	public boolean eliminar(E dato) {
		boolean borrado = false;
		if (cabeza != null) {
			if (cabeza == cola && dato.equals(cabeza.getDato())) {
				cabeza = cola = null;
				borrado = true;
				longitud--;
			} else if (dato == cabeza.getDato()) {
				cabeza = cabeza.getSiguiente();
				borrado = true;
				longitud--;
			} else {
				Nodo<E> prd, tmp;
				for (prd = cabeza, tmp = cabeza.getSiguiente(); tmp != null
						&& !tmp.getDato().equals(dato); prd = prd.getSiguiente(), tmp = tmp.getSiguiente())
					;
				if (tmp != null) {
					borrado = true;
					longitud--;
					prd.setSiguiente(tmp.getSiguiente());
					if (tmp == cola) {
						cola = prd;
					}
				}
			}
		}
		return borrado;
	}

	/**
	 * Borra el nodo que se encuentra en la cabeza
	 */
	public void eliminarCabeza() {
		if (cabeza != null) {

			if (cabeza == cola) {
				cabeza = cola = null;
				longitud--;
			} else {
				cabeza = cabeza.getSiguiente();
				longitud--;
			}
		}
	}

	/**
	 * Elimina el nodo que se encuentra en la cola
	 */
	public void eliminarCola() {
		if (cabeza != null) {
			if (cabeza == cola) {
				cabeza = cola = null;
				longitud--;
			} else {
				Nodo<E> tmp;
				for (tmp = cabeza; tmp.getSiguiente() != cola; tmp = tmp.getSiguiente())
					;
				tmp.setSiguiente(null);
				cola = tmp;
				longitud--;
			}
		}
	}

	/**
	 * @return retorna la longitud de la lista
	 */
	public int getLongitud() {
		if (longitud < 0) {
			longitud = 0;
		}
		return longitud;
	}

	/**
	 * Lista vacia
	 * 
	 * @return lista vacia
	 */
	public boolean esVacia() {
		return cabeza == null;
	}

	/**
	 * Metodo para obtener el dato del nodo a indicar
	 * 
	 * @param indice posicion del nodo a obtener el dato
	 * @return retorna el dato del nodo especificado, retorna null si el indice esta
	 *         fuera de rango
	 */
	public E obtenerNodo(int indice) {
		Nodo<E> tmp = null;
		if (indice <= longitud) {
			tmp = cabeza;
			for (int contador = 0; contador < indice && tmp != null; contador++, tmp = tmp.getSiguiente())
				;
		}
		if (tmp != null) {
			return tmp.getDato();
		} else {
			return null;
		}
	}

	/**
	 * Devuelve el índice si esta el elemento en la lista en dato x, en caso
	 * contrario retorna null
	 * 
	 * @param dato es el parametro que se quiere encontrar
	 * @return devuelve el índice si esta el elemento en la lista en dato x, si no
	 *         se encuentre en la lista devuelve un -1
	 */
	public int estaEnLista(E dato) {
		int indice;
		Nodo<E> tmp = null;
		tmp = cabeza;
		for (indice = 0; indice < longitud - 1 && tmp != null
				&& tmp.getDato().equals(dato); indice++, tmp = tmp.getSiguiente())
			;
		if (tmp != null) {
			return indice;
		} else {
			return -1;
		}
	}

	/**
	 * Método que busca en la lista el dato a especificar
	 * 
	 * @param dato Dato a buscar en la lista
	 * @return retorna la posicion del nodo del dato a buscar, retorna -1 si no lo
	 *         encuentra
	 */
	public int buscar(E dato) { /* Buscar en lista no es oficial */
		int indice;
		boolean encontrado = false;
		Nodo<E> tmp = null;
		tmp = cabeza;
		if (longitud == 0) {
			return -1;
		}
		for (indice = 0; tmp != null; indice++, tmp = tmp.getSiguiente()) {
			if (tmp.getDato().equals(dato)) {
				encontrado = true;
				break;
			}
		}

		if (encontrado == true) {
			return indice;
		} else {
			return -1;
		}
	}

	/**
	 * Elimina el nodo de acuerdo al @param indice devuelve un true si lo eliminó en
	 * caso contrario devuelve un falso
	 * 
	 * @see getRange para un valor siempre defindo
	 * 
	 * @param Indice, indice a eliminar
	 * @return devuelve un true si lo elimino en caso contrario, si no lo encuentra
	 *         retorna un falso
	 */
	public boolean eliminarEnIndice(int indice) {
		boolean borrado = false;
		if (indice >= 0 && indice <= longitud - 1) {
			if (cabeza != null) {
				if (cabeza == cola && indice == 0) {
					cabeza = cola = null;
					borrado = true;
					longitud--;
				} else if (indice == 0) {
					cabeza = cabeza.getSiguiente();
					borrado = true;
					longitud--;
				} else {
					Nodo<E> prd, tmp;
					int contador = 1;
					for (prd = cabeza, tmp = cabeza.getSiguiente(); contador < indice; prd = prd
							.getSiguiente(), tmp = tmp.getSiguiente(), contador++)
						;
					if (tmp != null) {
						borrado = true;
						longitud--;
						prd.setSiguiente(tmp.getSiguiente());
						if (tmp == cola) {
							cola = prd;
						}
					}
				}
			}
		}
		return borrado;
	}

	/**
	 * Inserta el dato en el índice indicado
	 * 
	 * @param val   valor de timpo @param <T> a asignar
	 * @param index índice a reemplazar
	 * @return true si lo asignó; false si NO lo asignó
	 */
	public boolean insertarEnIndice(E dato, int indice) {
		boolean seinserto = false;
		if (indice >= 0 && indice <= longitud - 1) {
			if (indice == 0) {
				this.agregarEnCabeza(dato);
				seinserto = true;
			} else {
				Nodo<E> prv, tmp = null;
				int contador = 0;
				for (prv = null, tmp = cabeza; contador < indice; contador++, prv = tmp, tmp = tmp.getSiguiente())
					;
				prv.setSiguiente(new Nodo<E>(dato, tmp));
				longitud++;
				seinserto = true;
			}
		}
		return seinserto;
	}

	/**
	 * Metodo que asigna un dato en el indice indicado
	 * 
	 * @param dato   dato a asignar
	 * @param indice posicion del nodo
	 * @return false: Indice fuera de rango; true: dato asignado;
	 */
	public boolean asignar(E dato, int indice) {
		Nodo<E> tmp = null;
		if (indice <= longitud - 1) {
			tmp = cabeza;
			for (int contador = 0; contador < indice && tmp != null; contador++, tmp = tmp.getSiguiente())
				;
		}
		if (tmp != null) {
			tmp.setDato(dato);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Metodo que asigna un nuevo dato, en todos los nodos que contengan un dato a
	 * especificar
	 * 
	 * @param dato      Dato a buscar en los nodos
	 * @param nuevoDato nuevo Dato a Asignar en los nodos
	 * @param todos     True: para asignar el nuevo dato en todos los nodos que
	 *                  encuentre el dato a especificar; False: para solo cambiar el
	 *                  dato en el primer Nodo que encuentre con el dato a
	 *                  especificar
	 */
	public void asignar(E dato, E nuevoDato, boolean todos) {
		Nodo<E> tmp = null;
		if (!todos) {
			for (tmp = cabeza; tmp != null; tmp = tmp.getSiguiente()) {
				if (tmp.getDato().equals(dato)) {
					tmp.setDato(nuevoDato);
					return;
				}
			}

		} else {
			for (tmp = cabeza; tmp != null; tmp = tmp.getSiguiente()) {
				if (tmp.getSiguiente().equals(dato)) {
					tmp.setDato(nuevoDato);
					return;
				}
			}
		}
	}

	/**
	 * Valor en cabeza
	 * 
	 * @return retorna el valor de tipo @param <E> en cabeza
	 */
	public E obtenerCabeza() {
		return cabeza.getDato();
	}

	/**
	 * Valor en cola
	 * 
	 * @return retorna el valor de tipo @param <E> en cola
	 */
	public E obtenerCola() {
		return cola.getDato();
	}

	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}

}
