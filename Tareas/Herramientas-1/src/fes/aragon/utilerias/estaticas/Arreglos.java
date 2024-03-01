package fes.aragon.utilerias.estaticas;

import fes.aragon.excep.IndiceFueraDeRango;

/**
 * Clase que tiene funciones para ocupar arreglos de tipo Integer
 *
 * @author mash
 *
 */
public class Arreglos<E> {
	private int indice = 0;
	private int indiceSiguiente = 0;
	private final Object[] l;

	public Arreglos(int numeroElementos) {
		this.l = new Object[numeroElementos];
	}

	/**
	 * Método que inserta un valor de tipo Integer consecutivo
	 *
	 * @param x es el parámetro que se recibe para agregar a la lista
	 * @throws IndiceFueraDeRango exepción que pasa cuando nos salimos fuera del
	 *                            índice
	 */
	public void insertar(E x) throws IndiceFueraDeRango {
		if (indice < l.length) {
			l[indice] = x;
			indice++;
		} else {
			throw new IndiceFueraDeRango("Indice fuera de rango");
		}
	}

	/**
	 * Método que localiza un valor en la lista, retornan el indice
	 *
	 * @param x valor Integer que se busca en la lista
	 * @return se retorna -1 si no esta el valor de la lista, en caso contrario se
	 *         retorna el indice
	 */
	public Integer localiza(E x) {

		for (int i = 0; i < l.length; i++) {
			if (l[i].equals(x)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Método que recupera un elemento en el indice indicado
	 *
	 * @param p entero que indica el indice del elemento a devolver
	 * @return E que se retorna, tomando la posición siguiente que se da como
	 *         parametro
	 * @throws IndiceFueraDeRango excepción que se arroja cuando el indice p esta
	 *                            fuera de los rangos del arreglo
	 */
	public E recupera(int p) throws IndiceFueraDeRango {
		if (p > l.length || p < 0) {
			throw new IndiceFueraDeRango("Indice fuera de rango");
		} else {
			@SuppressWarnings("unchecked")
			final E e = (E) l[p];
			return e;
		}
	}

	/**
	 * Método que alimina un elemento en el indice indicado
	 *
	 * @param p entero que indica el indice del elemento a eliminar
	 * @throws IndiceFueraDeRango excepción que se arroja cuando el indice p esta
	 *                            fuera de los rangos del arreglo
	 */
	public void suprime(int p) throws IndiceFueraDeRango {
		if (p > l.length || p < 0) {
			throw new IndiceFueraDeRango("Indice fuera de rango");
		} else {
			l[p] = null;
		}
	}

	/**
	 * Método que da el elemento siguiente de la posición que nos indica
	 *
	 * @param p entero que indica el indice del elemento a devolver
	 * @return E que se retorna, tomando la posición siguiente que se da como
	 *         parametro
	 * @throws IndiceFueraDeRango excepción que se arroja cuando el indice p esta
	 *                            fuera de los rangos del arreglo
	 */
	public E siguiente(int p) throws IndiceFueraDeRango {
		if (p == l.length || p < -1) {
			throw new IndiceFueraDeRango("Indice fuera de rango");
		}
		@SuppressWarnings("unchecked")
		final E e = (E) l[p + 1];
		return e;
	}

	public E siguiente() throws IndiceFueraDeRango {
		this.indiceSiguiente += 1;
		if (this.indiceSiguiente == l.length) {
			throw new IndiceFueraDeRango("Ya no hay elementos");
		}
		@SuppressWarnings("unchecked")
		final E e = (E) l[this.indiceSiguiente];
		return e;
	}

	/**
	 * Método que da el elemento anterior de la posición que nos indica
	 *
	 * 
	 * @param p entero que indica el indice del elemento a devolver
	 * @return Integer que se retorna Integer tomando la posición anterior que se da
	 *         como parametro
	 * @throws IndiceFueraDeRango excepción que se arroja cuando el indice p esta
	 *                            fuera de los rangos del arreglo
	 */
	public E anterior(int p) throws IndiceFueraDeRango {
		if (p == l.length - 1 || p < -1) {
			throw new IndiceFueraDeRango("Indice fuera de rango");
		}
		@SuppressWarnings("unchecked")
		final E e = (E) l[p - 1];
		return e;
	}

	/**
	 * Méotodo que limpia el arreglo de Enteros
	 *
	 */
	public void limpiar() {
		for (int i = 0; i < l.length; i++) {
			l[i] = null;
		}
	}

	/**
	 * Método que regresa el primer elemento del arreglo, si no existe regresa un
	 * null
	 * 
	 * @return retorna E o null del primer elemento del arreglo
	 */
	public E primero() {
		@SuppressWarnings("unchecked")
		final E e = (E) l[0];
		return e;
	}

	/**
	 * Método que devuelve la longitud del arreglo
	 * 
	 * @return un entero que es la longitud del arreglo
	 */
	public Integer longitud() {
		return l.length;
	}

	/**
	 * Método que imprime todos los valores del arreglo
	 */
	public void imprime() {
		for (int i = 0; i < l.length; i++) {
			System.out.print(l[i] + "\n");
		}
		System.out.println();
	}

	/**
	 * Método que asignara un valor en la posición indicada
	 * 
	 * @param p entero que indica la posición donde se inserta el valor en el
	 *          arreglo
	 * @param x valor que se insertara en la posicion que se indica en p
	 * @throws IndiceFueraDeRango exepción que sucede cuando no estamos en el rango
	 *                            del arreglo
	 */
	public void asignar(int p, E x) throws IndiceFueraDeRango {
		if (p > l.length || p < 0) {
			throw new IndiceFueraDeRango("Indice fuera de rango");
		} else {
			l[p] = x;
		}
	}

	/**
	 * Método que calcula el invervalo entre 2 valores del arreglo
	 * 
	 * @param a entero que indica la posición de inicio
	 * @param b entero que indica la posición final
	 * @throws IndiceFueraDeRango
	 */
	public void intervalo(int a, int b) throws IndiceFueraDeRango {
		if (a > b) {
			int aux;
			aux = b;
			b = a;
			a = aux;
		}
		if (a <= 0 || b >= l.length || a == b) {
			throw new IndiceFueraDeRango("Indice fuera de rango");
		} else {
			for (int i = a; i < b; i++) {
				System.out.print(l[i] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * Método que calcula el promedio del arreglo
	 */
	public double promedio() {
		double total = 0;
		double res = 0;
		for (int i = 0; i < l.length; i++) {
			total += (int) l[i];
		}
		res = total / l.length;
		return res;
	}

//	/**
//	 * Método que ordena de menor a mayor el arreglo y devuelve la posición deseada
//	 * 
//	 * @param p la posición que indica el usuario que quiere que se le regrese
//	 */
//	public void ordenamiento(int p) {
//
//		for (int i = 0; i < l.length - 1; i++) {
//			for (int j = 0; j < l.length - 1; j++) {
//				if ((int) l[j] > (int) l[j + 1]) {
//					int aux = (int) l[j];
//					l[j] = l[j + 1];
//					l[j + 1] = aux;
//				}
//			}
//		}
//		System.out.println((int) l[p - 1]);
//	}

	/**
	 * Método que calcula el máximo del arreglo
	 * 
	 * @return
	 */
	public Integer max() {
		Integer tmp = null;
		Integer aux = 0;
		for (int i = 0; i < l.length; i++) {
			tmp = (Integer) l[i];
			if (tmp > aux) {
				aux = tmp;
			}
		}
		return aux;
	}

	/**
	 * Metodo que imprime el valor anterior al máximo
	 * 
	 * @return
	 */
	public Integer segundoMax() {
		Integer tmp = null;
		Integer aux = 0;
		Integer aux2 = 0;
		for (int i = 0; i < l.length; i++) {
			tmp = (Integer) l[i];
			if (tmp > aux) {
				aux2 = aux;
				aux = tmp;
			}
		}
		return aux2;
	}

	/**
	 * Método que calcula el mínimo del intervalo
	 * 
	 * @return
	 */
	public Integer min() {
		Integer tmp = null;
		Integer aux = 99;
		for (int i = 0; i < l.length; i++) {
			tmp = (Integer) l[i];
			if (tmp < aux) {
				aux = tmp;
			}
		}
		return aux;
	}

	/**
	 * Método que imprime una composición
	 */
	public void imprimeComposicion() {
		for (int i = 0; i < l.length; i++) {
			System.out.print(i + 1 + "° " + l[i] + "\n");
		}
		System.out.println();
	}

	/**
	 * Método que imprime el valor medio o mediana Para números pares se toma en
	 * cuenta el elemento a la derecha antes de llegar al medio
	 */
	public Object mediana() {
		return l[(l.length / 2)];
	}

}