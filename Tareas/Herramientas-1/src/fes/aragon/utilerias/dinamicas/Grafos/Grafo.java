package fes.aragon.utilerias.dinamicas.Grafos;

public class Grafo {
	public static int MAX_VERTICES = 20;
	public static int INFINITO = 100;
	// Numero total de vertices
	private int numVerts;
	// Vector de vertices
	private Vertice[] verts;
	// Matriz de adyacencia
	private int[][] matdAd;

	// Constructor por defecto
	public Grafo() {
		this(MAX_VERTICES);
	}

	/*
	 * Inicializa en cero la matriz de adyacencia
	 * 
	 * @param tot total de vertices del grafo
	 */
	public Grafo(int tot) {
		this.matdAd = new int[tot][tot];
		verts = new Vertice[tot];
		// Se recorre la matriz e inicializa en ceros
		for (int i = 0; i < tot; i++) {
			for (int j = 0; j < tot; j++) {
				this.matdAd[i][j] = 0;
			}
		}
		this.numVerts = 0;
	}

	/*
	 * Inicializa con INFINITO la matriz de pesos
	 * 
	 */
	public void inicializarMatrizPesos() {
		for (int i = 0; i < numVerts; i++) {
			for (int j = 0; j < numVerts; j++) {
				this.matdAd[i][j] = INFINITO;
			}
		}
	}

	/*
	 * Devuelve la matriz de adyacencia o de pesos
	 * 
	 * @return
	 */
	public int[][] getMatriz() {
		return this.matdAd;
	}

	/*
	 * Crea un nuevo vertice. Veritica que no este en el vector
	 * 
	 * @param nom: nombre del vertice
	 */
	public void nuevoVertice(String nom) {
		boolean esta = numVertice(nom) >= 0;
		if (!esta) {
			Vertice v = new Vertice(nom);
			verts[numVerts++] = v;
		}
	}

	/*
	 * Busca el numero de vertice en el vector a partir del nombre, devuelve -1 si
	 * no lo encuentra
	 * 
	 * @param nom: nombre del vertice
	 */
	public int numVertice(String nom) {
		int i = 0;
		while (i < numVerts) {
			if (verts[i].getNombre().equals(nom))
				return i;
			i++;
		}
		return -1;
	}

	/*
	 * Devuelve el nombre del vertice dado el numero o posicion del vector
	 * 
	 * @param v vertice
	 * 
	 * @return nombre del vertice
	 */
	public String nombreVertice(int v) {
		return verts[v].getNombre();
	}

	/*
	 * Crea un nuevo arco. Recibe el nombre de cada vertice del arco, busca el
	 * numero de vertice asignado a cada uno de ellos y marca la matriz de
	 * adyacencia
	 * 
	 * @param a nombre del primer vertice
	 * 
	 * @param b nombre del segundo vertice
	 * 
	 * @throws Exception
	 */
	public void nuevoArco(String a, String b) throws Exception {
		int va, vb;
		va = numVertice(a);
		vb = numVertice(b);
		if (va < 0 || vb < 0) {
			throw new Exception("Vertice no existe");
		}
		matdAd[va][vb] = 1;
	}

	/*
	 * Crear un nuevo arco valorado. Recibe el nombre de cada vertice del arco,
	 * busca el numero de vertice asignado a cada uno de ellos y marca la matriz de
	 * adyacencia con el peso
	 * 
	 * @param a nombre del primer vertice
	 * 
	 * @param b nombre del segundo vertice
	 * 
	 * @throws Exception
	 */
	public void nuevoArco(String a, String b, int peso) throws Exception {
		int va, vb;
		va = numVertice(a);
		vb = numVertice(b);
		if (va < 0 || vb < 0) {
			throw new Exception("vertice no existe");
		}
		matdAd[va][vb] = peso;
	}

	/*
	 * Determinan si dos vertices v1 y v2, forman un arco, es decir, si el elemento
	 * de la matriz de adyacencidad es 1
	 * 
	 * @param a nombre del primer vertice
	 * 
	 * @param b nombre del segundo vertice
	 * 
	 * @return true si forman un arco, false en caso contrario
	 * 
	 * @throws Exception
	 */
	public boolean adyacente(String a, String b) throws Exception {
		int va, vb;
		va = numVertice(a);
		vb = numVertice(b);
		if (va < 0 || vb < 0) {
			throw new Exception("vertice no existe");
		}
		return matdAd[va][vb] == 1;
	}

	/*
	 * Determina si dos vertices 1 y 2, forman un arco
	 * 
	 * @param a numero del primer vertice
	 * 
	 * @param b numero del segundo vertice
	 * 
	 * @return true si forman un arco, false en caso contrario
	 * 
	 * @throws Exception
	 */
	public boolean adyacente(int a, int b) throws Exception {
		if (a < 0 || b < 0) {
			throw new Exception("vertice no existe");
		}
		return matdAd[a][b] == 1;
	}

	/*
	 * Imprime la matriz de adyacencia
	 * 
	 * @return cadena con la matriz de unos y ceros
	 */
	public String imprimirMatriz() {
		String res = "";
		for (int i = 0; i < numVerts; i++) {
			for (int j = 0; j < numVerts; j++) {
				res = res + matdAd[i][j] + " ";
			}
			res = res + "\n";
		}
		return res;
	}

	/*
	 * Imprime los nombres de los vertices
	 * 
	 * @return Cadena con los nombres de los vertices
	 */
	public String imprimirVertices() {
		String res = "";
		for (int i = 0; i < numVerts; i++) {
			res = res + verts[i].getNombre();
		}
		return res;
	}

	/*
	 * Devuelve el total de vertices del grafo
	 * 
	 * @return total de vertices
	 */
	public int numeroDeVertices() {
		return numVerts;
	}
}
