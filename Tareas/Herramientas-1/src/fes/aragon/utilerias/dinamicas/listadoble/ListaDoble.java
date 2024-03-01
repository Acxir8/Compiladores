package fes.aragon.utilerias.dinamicas.listadoble;

public class ListaDoble<E> {
	protected Nodo<E> cabeza, cola;
	protected int longitud = 0;

	/**
	 * Inicia la lista con cabeza y cola = null
	 */
	public ListaDoble() {
		cabeza = cola = null;
	}

	/**
	 * Agrega un dato en la cabeza
	 * 
	 * @param dato el valor de tipo @param <E> a arrimar en cabeza
	 */
	public void agregarEnCabeza(E dato) {
		cabeza = new Nodo<E>(dato, null, cabeza);
		if (cola == null) {
			cola = cabeza;
		} else {
			cabeza.getSiguiente().setAnterior(cabeza);
		}
		longitud++;
	}

	/**
	 * Agrega un dato en la cola
	 * 
	 * @param dato el valor de tipo @param <E> a arrimar en cola
	 */
	public void agregarEnCola(E dato) {
		if (longitud != 0) {
			cola = new Nodo<E>(dato, cola, null);
			cola.getAnterior().setSiguiente(cola);
		} else {
			cabeza = cola = new Nodo<E>(dato);
		}
		longitud++;
	}

	/**
	 * Muestra en consola todos los elementos de la lista en formato horizontal
	 */
	public void imprimirElementosLD() {
		for (Nodo<E> tmp = cabeza; tmp != null; tmp = tmp.getSiguiente()) {
			System.out.print(tmp.getDato() + " ");
		}
	}

	/**
	 * Borra el nodo que se encuentra en la cabeza
	 */
	public void eliminarEnCabeza() {
		if (cabeza != null) {
			if (cabeza == cola) {
				cabeza = cola = null;
				longitud--;
			} else {
				cabeza = cabeza.getSiguiente();
				cabeza.setAnterior(null);
				;
				longitud--;
			}
		}
	}

	/**
	 * Elimina el nodo que se encuentra en la cola
	 */
	public void eliminarEnCola() {
		if (cabeza != null) {
			if (cabeza == cola) {
				cabeza = cola = null;
				longitud--;
			} else {
				cola = cola.getAnterior();
				cola.setSiguiente(null);
				longitud--;
			}
		}
	}

	/**
	 * Busca y elimina el valor en la lista
	 * 
	 * @param dato valor de tipo @param <E> a eliminar
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
	 * Elimina el nodo de acuerdo al índice, devuelve un true si lo
	 * eliminó y false en caso contrario
     * 
     * @see getRange para un índice siempre defindo
	 * 
	 * @param indice indice a eliminar
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
	 * Longitud de la lista
	 * 
	 * @return retorna la longitud de la lista
	 */
	public int getlongitud() {
		if (longitud < 0)
			longitud = 0;
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

	/**
     * Obtiene el valor del indice @param indice
     * 
     * @param Indice indice del valor a obtener, negativos es para leer la lista
     * alrevés. Fuera de rango obtiene el valor dando la veulta a la lista
     * @return retorna el dato de tipo @param <E> ubicado en @param indice
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
	 * Cambia el dato en el índice indicado
     * @see getRange para un índice siempre defindo
	 * 
	 * @param dato   valor de tipo @param <T> a asignar
	 * @param indice índice a reemplazar
	 * @return devuelve true si se cambio el dato, en caso contrario un false
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
	 * Cambia en la primera coincidencia el dato con el nuevo dato, si retorna
	 * true, cambia todos los datos de la lista simple, si retorna false
	 * solo cambia el primero que se encuentre
	 * 
	 * @param dato es el parametro de la lista que se va a cambiar por un dato
	 *                  nuevo
	 * @param nuevodato es el Nuevo dato que se va a cambiar por el dato actual en
	 *                  la lista
	 * @param todos si true cambia en todas las coincidencias, si es falso
     *              solo cambia en 1
	 */
	public void asignar(E dato, E nuevodato, boolean todos) {
		Nodo<E> tmp = null;
		if (!todos) {
			for (tmp = cabeza; tmp != null; tmp = tmp.getSiguiente()) {
				if (tmp.getDato().equals(dato)) {
					tmp.setDato(nuevodato);
					return;
				}
			}
		} else {
			for (tmp = cabeza; tmp != null; tmp = tmp.getSiguiente()) {
				if (tmp.getDato().equals(dato)) {
					tmp.setDato(nuevodato);

				}

			}

		}

	}

	/**
	 * Inserta el valor en el índice @param indice
     * 
	 * @param dato valor a insertar
	 * @param indice índice en la lista
	 * @return retorna true si lo insertó, false si no
	 */
	public boolean insertarEnIndice(E dato, int indice) {
		boolean setInserto = false;
		if (indice >= 0 && indice <= longitud - 1) {
			if (indice == 0) {
				this.agregarEnCabeza(dato);
				setInserto = true;
			} else {
				Nodo<E> prv, tmp = null;
				int contador = 0;
				for (prv = null, tmp = cabeza; contador < indice; contador++, prv = tmp, tmp = tmp.getSiguiente())
					;

				prv.setSiguiente(new Nodo<E>(dato, prv, tmp));
				longitud++;
				setInserto = true;
			}
		}
		return setInserto;
	}

	/**
	 * Devuelve el índice si esta el elemento en la lista en dato x, en
	 * caso contrario retorna null
	 * 
	 * @param dato es el parametro que se quiere encontrar
	 * @return devuelve el devuelve el índice si esta el elemento en la lista en
	 *         dato x, si no se encuentre en la lista retorna null
	 */
	public Integer estaEnlaLista(E dato) {
		int indice = 0;
		Nodo<E> tmp = null;
		tmp = cabeza;
		do {
			if (tmp.getDato() == dato) {
				break;
			}
			tmp = tmp.getSiguiente();
			indice++; 
			
		} while (tmp != null);
		if (tmp == null) {
			return null;
		} else {
			return indice;
		}
	}

}
