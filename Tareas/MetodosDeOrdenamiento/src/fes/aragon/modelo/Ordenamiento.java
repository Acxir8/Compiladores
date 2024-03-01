package fes.aragon.modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Random;

import javax.swing.JOptionPane;

import fes.aragon.utilerias.dinamicas.listasimple.ListaSimple;

public class Ordenamiento {
	private BufferedReader lector;
	private Writer bw;
	private String linea;
	String[] palabras = new String[15];
	public ListaSimple<Persona> persona = new ListaSimple<>();
	public ListaSimple<Persona> lista11 = new ListaSimple<>();
	public ListaSimple<Persona> lista22 = new ListaSimple<>();
	public ListaSimple<Integer> datos = new ListaSimple<>();
	public ListaSimple<Integer> datosMitad = new ListaSimple<>();
	public ListaSimple<CodigosP> lista1 = new ListaSimple<>();
	public ListaSimple<CodigosP> lista2 = new ListaSimple<>();
	public ListaSimple<CodigosP> lista3 = new ListaSimple<>();
	public ListaSimple<CodigosP> lista4 = new ListaSimple<>();
	public ListaSimple<CodigosP> listaFinal1 = new ListaSimple<>();
	public ListaSimple<CodigosP> listaFinal2 = new ListaSimple<>();
	public ListaSimple<CodigosP> cp = new ListaSimple<>();
	public ListaSimple<String> cpAgregar = new ListaSimple<>();

	public void aleatorios(int numAleatorios) {
		Random rdRandom = new Random();
		for (int i = 0; i < numAleatorios; i++) {
			datos.agregarEnCola(rdRandom.nextInt(200));
		}
	}

	public void burbuja() {
		for (int i = 0; i < persona.getLongitud() - 1; i++) {
			for (int j = i + 1; j < persona.getLongitud(); j++) {
				if (persona.obtenerNodo(i).getEdad() >= persona.obtenerNodo(j).getEdad()) {
					Persona tmp = persona.obtenerNodo(i);
					persona.asignar(persona.obtenerNodo(j), i);
					persona.asignar(tmp, j);
				}
			}
		}
	}

	public void seleccion() {
		int min = 0;
		for (int i = 0; i < persona.getLongitud() - 1; i++) {
			min = i;
			for (int j = i + 1; j < persona.getLongitud(); j++) {
				if (persona.obtenerNodo(j).getEdad() <= persona.obtenerNodo(min).getEdad()) {
					min = j;
				}
			}
			if (i != min) {
				Persona tmp = persona.obtenerNodo(i);
				persona.asignar(persona.obtenerNodo(min), i);
				persona.asignar(tmp, min);
			}
		}
	}

	public void insercion() {
		for (int i = 1, j; i < persona.getLongitud(); i++) {
			Integer tmpInt = persona.obtenerNodo(i).getPeso();
			Persona tmp = persona.obtenerNodo(i);
			for (j = i; j > 0 && tmpInt < persona.obtenerNodo(j - 1).getPeso(); j--) {
				persona.asignar(persona.obtenerNodo(j - 1), j);
			}
			persona.asignar(tmp, j);
		}
	}

	public void mezcla() {
		int mitad = persona.getLongitud() / 2;
		for (int i = 0; i < mitad; i++) {
			this.lista11.agregarEnCola(persona.obtenerNodo(i));
		}
		for (int i = mitad; i < persona.getLongitud(); i++) {
			this.lista22.agregarEnCola(persona.obtenerNodo(i));
		}
		// Ordenando Lista1
		int min = 0;
		for (int i = 0; i < lista11.getLongitud() - 1; i++) {
			min = i;
			for (int j = i + 1; j < lista11.getLongitud(); j++) {
				if (lista11.obtenerNodo(j).getEdad() <= lista11.obtenerNodo(min).getEdad()) {
					min = j;
				}
			}
			if (i != min) {
				Persona tmp = lista11.obtenerNodo(i);
				lista11.asignar(lista11.obtenerNodo(min), i);
				lista11.asignar(tmp, min);
			}
		}
		// Ordenando lista2
		min = 0;
		for (int i = 0; i < lista22.getLongitud() - 1; i++) {
			min = i;
			for (int j = i + 1; j < lista22.getLongitud(); j++) {
				if (lista22.obtenerNodo(j).getEdad() <= lista22.obtenerNodo(min).getEdad()) {
					min = j;
				}
			}
			if (i != min) {
				Persona tmp = lista22.obtenerNodo(i);
				lista22.asignar(lista22.obtenerNodo(min), i);
				lista22.asignar(tmp, min);
			}
		}
		int indiceListas = 0, indiceFinal = 0;
		do {
			// Comprueba que elemento de la lista 1 o 2 es mayor y lo a�ade a la lista final
			if (lista11.obtenerNodo(indiceListas).getEdad() <= lista22.obtenerNodo(indiceListas).getEdad()) {
				persona.asignar(lista11.obtenerNodo(indiceListas), indiceFinal);
				lista11.eliminarEnIndice(indiceListas);
			} else if (lista22.obtenerNodo(indiceListas).getEdad() < lista11.obtenerNodo(indiceListas).getEdad()) {
				persona.asignar(lista22.obtenerNodo(indiceListas), indiceFinal);
				lista22.eliminarEnIndice(indiceListas);
			}
			indiceFinal++;
		} while (!lista11.esVacia() && !lista22.esVacia());

		// Si la lista 1 o 2 esta vacia agrega todo a la lista final
		if (lista11.esVacia()) {
			while (!lista22.esVacia()) {
				persona.asignar(lista22.obtenerNodo(indiceListas), indiceFinal);
				lista22.eliminarEnIndice(indiceListas);
				indiceFinal++;
			}
		} else if (lista22.esVacia()) {
			while (!lista11.esVacia()) {
				persona.asignar(lista11.obtenerNodo(indiceListas), indiceFinal);
				lista11.eliminarEnIndice(indiceListas);
				indiceFinal++;
			}
		}
	}

	public void mezclaCp() {
		int mitad = cp.getLongitud() / 2;

		for (int i = 0; i < mitad; i++) {
			this.lista1.agregarEnCola(cp.obtenerNodo(i));
		}
		for (int i = mitad; i < cp.getLongitud(); i++) {
			this.lista2.agregarEnCola(cp.obtenerNodo(i));
		}

		// Ordenando Lista1
		int min = 0;
		for (int i = 0; i < lista1.getLongitud() - 1; i++) {
			min = i;
			for (int j = i + 1; j < lista1.getLongitud(); j++) {
				if (lista1.obtenerNodo(j).getD_codigo().compareTo(lista1.obtenerNodo(min).getD_codigo()) > 0) {
					min = j;
				}
			}
			if (i != min) {
				CodigosP tmp = lista1.obtenerNodo(i);
				lista1.asignar(lista1.obtenerNodo(min), i);
				lista1.asignar(tmp, min);
			}
		}

		// Ordenando lista2
		min = 0;
		for (int i = 0; i < lista2.getLongitud() - 1; i++) {
			min = i;
			for (int j = i + 1; j < lista2.getLongitud(); j++) {
				if (lista2.obtenerNodo(j).getD_codigo().compareTo(lista2.obtenerNodo(min).getD_codigo()) > 0) {
					min = j;
				}
			}
			if (i != min) {
				CodigosP tmp = lista2.obtenerNodo(i);
				lista2.asignar(lista2.obtenerNodo(min), i);
				lista2.asignar(tmp, min);
			}
		}
		int indiceListas = 0, indiceFinal = 0;
		do {
			// Comprueba que elemento de la lista 1 o 2 es mayor y lo agreg a la lista final
			if (lista1.obtenerNodo(indiceListas).getD_codigo()
					.compareTo(lista2.obtenerNodo(indiceListas).getD_codigo()) <= 0) {
				cp.asignar(lista1.obtenerNodo(indiceListas), indiceFinal);
				lista1.eliminarEnIndice(indiceListas);

			} else if (lista2.obtenerNodo(indiceListas).getD_codigo()
					.compareTo(lista1.obtenerNodo(indiceListas).getD_codigo()) < 0) {
				// lista2.obtenerNodo(indiceListas) < lista1.obtenerNodo(indiceListas)
				cp.asignar(lista2.obtenerNodo(indiceListas), indiceFinal);
				lista2.eliminarEnIndice(indiceListas);

			}
			indiceFinal++;
		} while (!lista1.esVacia() && !lista2.esVacia());

		// Si la lista 1 o 2 esta vacia agrega todo a la lista final
		if (lista1.esVacia()) {
			while (!lista2.esVacia()) {
				cp.asignar(lista2.obtenerNodo(indiceListas), indiceFinal);
				lista2.eliminarEnIndice(indiceListas);
				indiceFinal++;
			}
		} else if (lista2.esVacia()) {
			while (!lista1.esVacia()) {
				cp.asignar(lista1.obtenerNodo(indiceListas), indiceFinal);
				lista1.eliminarEnIndice(indiceListas);
				indiceFinal++;
			}
		}
	}

	public void quicksort(boolean persona) {
		if (persona) {
			quicksortPersona(0, this.persona.getLongitud() - 1);
		} else {
			for (int i = 1; i <= 4; i++) {
				switch (i) {
				case 1:
					quicksortCp(0, lista1.getLongitud() - 1, i);
					break;

				case 2:
					quicksortCp(0, lista2.getLongitud() - 1, i);
					break;

				case 3:
					quicksortCp(0, lista3.getLongitud() - 1, i);
					break;

				case 4:
					quicksortCp(0, lista4.getLongitud() - 1, i);
					break;
				}
			}
			System.out.println("Se termino de ordenar");
		}
	}

	public void quicksortPersona(int izquierda, int derecha) {

		Integer pivoteInt = persona.obtenerNodo(izquierda).getEstatura(); // tomamos primer elemento como pivote
		Persona pivote = persona.obtenerNodo(izquierda);
		int i = izquierda; // i realiza la bÃºsqueda de izquierda a derecha
		int j = derecha; // j realiza la bÃºsqueda de derecha a izquierda
		Persona aux;

		while (i < j) { // mientras no se crucen las bÃºsquedas
			while (persona.obtenerNodo(i).getEstatura() <= pivoteInt && i < j)
				i++; // busca elemento mayor que pivote
			while (persona.obtenerNodo(j).getEstatura() > pivoteInt)
				j--; // busca elemento menor que pivote
			if (i < j) { // si no se han cruzado
				aux = persona.obtenerNodo(i); // los intercambia
				persona.asignar(persona.obtenerNodo(j), i);
				persona.asignar(aux, j);
			}
		}

		persona.asignar(persona.obtenerNodo(j), izquierda); // se coloca el pivote en su lugar de forma que tendremos
		persona.asignar(pivote, j); // los menores a su izquierda y los mayores a su derecha

		if (izquierda < j - 1)
			quicksortPersona(izquierda, j - 1); // ordenamos subarray izquierdo
		if (j + 1 < derecha)
			quicksortPersona(j + 1, derecha); // ordenamos subarray derecho
	}

	public void partirLista() {
		int mitadListaOriginal = cp.getLongitud() / 2;
		// Separa la lista original en 2 partes

		double parteEntera = (double) cp.getLongitud() / 2;
		if (parteEntera - Math.floor(parteEntera) == 0) {
			lista1.asignarDesdeOtroNodo(cp.obtenerNodo(0), cp.obtenerUbiNodo(0), cp.getLongitud() / 2);
			lista2.asignarDesdeOtroNodo(cp.obtenerNodo(mitadListaOriginal), cp.obtenerUbiNodo(mitadListaOriginal),
					cp.getLongitud() / 2);
			lista2.cambiariNodo(lista2.getLongitud() - 1, null);
			lista1.cambiariNodo(mitadListaOriginal, null);
		} else {
			lista1.asignarDesdeOtroNodo(cp.obtenerNodo(0), cp.obtenerUbiNodo(0), cp.getLongitud() / 2);
			lista2.asignarDesdeOtroNodo(cp.obtenerNodo(mitadListaOriginal), cp.obtenerUbiNodo(mitadListaOriginal),
					cp.getLongitud() / 2 + 1);
			lista2.cambiariNodo(lista2.getLongitud() - 1, null);
			lista1.cambiariNodo(mitadListaOriginal - 1, null);
		}

		// separa la lista original en 4 partes
		int mitadPrimerLista = lista1.getLongitud() / 2;

		parteEntera = (double) lista1.getLongitud() / 2;
		if (parteEntera - Math.floor(parteEntera) == 0) {
			lista3.asignarDesdeOtroNodo(lista1.obtenerNodo(mitadPrimerLista), lista1.obtenerUbiNodo(mitadPrimerLista),
					lista1.getLongitud() / 2);
			lista3.cambiariNodo(lista3.getLongitud() - 1, null);
			lista1.cambiariNodo(mitadPrimerLista, null);
			lista1.setLongitud(mitadPrimerLista);
		} else {
			lista3.asignarDesdeOtroNodo(lista1.obtenerNodo(mitadPrimerLista), lista1.obtenerUbiNodo(mitadPrimerLista),
					lista1.getLongitud() / 2 + 1);
			lista3.cambiariNodo(lista3.getLongitud() - 1, null);
			lista1.cambiariNodo(mitadPrimerLista - 1, null);
			lista1.setLongitud(mitadPrimerLista);
		}

		int mitadSegundaLista = lista2.getLongitud() / 2;

		parteEntera = (double) lista2.getLongitud() / 2;
		if (parteEntera - Math.floor(parteEntera) == 0) {
			lista4.asignarDesdeOtroNodo(lista2.obtenerNodo(mitadSegundaLista), lista2.obtenerUbiNodo(mitadSegundaLista),
					lista2.getLongitud() / 2);
			lista4.cambiariNodo(lista4.getLongitud() - 1, null);
			lista2.cambiariNodo(mitadSegundaLista, null);
			lista2.setLongitud(mitadSegundaLista);
		} else {
			lista4.asignarDesdeOtroNodo(lista2.obtenerNodo(mitadSegundaLista), lista2.obtenerUbiNodo(mitadSegundaLista),
					lista2.getLongitud() / 2 + 1);
			lista4.cambiariNodo(lista4.getLongitud() - 1, null);
			lista2.cambiariNodo(mitadSegundaLista - 1, null);
			lista2.setLongitud(mitadSegundaLista);
		}
	}

	public void unirListas() {
		// Uniendo listas 1 y 3
		int indiceListas = 0;
		do {
			// Comprueba que elemento de la lista 1 o 3 es menor y lo agrega la lista final1
			if (lista1.obtenerNodo(indiceListas).getD_asenta()
					.compareTo(lista3.obtenerNodo(indiceListas).getD_asenta()) <= 0) {
				listaFinal1.agregarEnCabeza(lista1.obtenerNodo(indiceListas));
				lista1.eliminarCabeza();
			} else if (lista3.obtenerNodo(indiceListas).getD_asenta()
					.compareTo(lista1.obtenerNodo(indiceListas).getD_asenta()) < 0) {
				listaFinal1.agregarEnCabeza(lista3.obtenerNodo(indiceListas));
				lista3.eliminarCabeza();
			}
		} while (!lista1.esVacia() && !lista3.esVacia());

		// Si la lista 1 o 3 esta vacia agrega todo a la lista final
		if (lista1.esVacia()) {
			while (!lista3.esVacia()) {
				listaFinal1.agregarEnCabeza(lista3.obtenerNodo(indiceListas));
				lista3.eliminarCabeza();
			}
		} else if (lista3.esVacia()) {
			while (!lista1.esVacia()) {
				listaFinal1.agregarEnCabeza(lista1.obtenerNodo(indiceListas));
				lista1.eliminarCabeza();
			}
		}
		// Fin de la union entre las listas 1 y 3

		// Comprueba que elemento de la lista 2 o 4 es menor y lo agrega la lista final2
		do {
			if (lista2.obtenerNodo(indiceListas).getD_asenta()
					.compareTo(lista4.obtenerNodo(indiceListas).getD_asenta()) <= 0) {
				listaFinal2.agregarEnCabeza(lista2.obtenerNodo(indiceListas));
				lista2.eliminarCabeza();

			} else if (lista4.obtenerNodo(indiceListas).getD_asenta()
					.compareTo(lista2.obtenerNodo(indiceListas).getD_asenta()) < 0) {
				listaFinal2.agregarEnCabeza(lista4.obtenerNodo(indiceListas));
				lista4.eliminarCabeza();

			}
		} while (!lista2.esVacia() && !lista4.esVacia());

		// Si la lista 1 o 3 esta vacia agrega todo a la lista final
		if (lista2.esVacia()) {
			while (!lista4.esVacia()) {
				listaFinal2.agregarEnCabeza(lista4.obtenerNodo(indiceListas));
				lista4.eliminarCabeza();
			}
		} else if (lista4.esVacia()) {
			while (!lista2.esVacia()) {
				listaFinal2.agregarEnCabeza(lista2.obtenerNodo(indiceListas));
				lista2.eliminarCabeza();
			}
		}
	}

	public void quicksortCp(int izquierda, int derecha, int numLista) {

		switch (numLista) {
		case 1:
			String pivote = lista1.obtenerNodo(izquierda).getD_asenta(); // tomamos primer elemento como pivote
			CodigosP pivoteUbi = lista1.obtenerNodo(izquierda);
			int i = izquierda; // i realiza la bÃºsqueda de izquierda a derecha
			int j = derecha; // j realiza la bÃºsqueda de derecha a izquierda
			CodigosP aux;

			while (i < j) { // mientras no se crucen las bÃºsquedas
				while (lista1.obtenerNodo(i).getD_asenta().compareTo(pivote) <= 0 && i < j)
					i++; // busca elemento mayor que pivote
				while (lista1.obtenerNodo(j).getD_asenta().compareTo(pivote) > 0)
					j--; // busca elemento menor que pivote
				if (i < j) { // si no se han cruzado
					aux = lista1.obtenerNodo(i); // los intercambia
					lista1.asignar(lista1.obtenerNodo(j), i);
					lista1.asignar(aux, j);
				}
			}

			lista1.asignar(lista1.obtenerNodo(j), izquierda); // se coloca el pivote en su lugar de forma que tendremos
			lista1.asignar(pivoteUbi, j); // los menores a su izquierda y los mayores a su derecha
			System.out.println("Fin del pivotaje, ordenando subarrays, lista: " + numLista);
			if (izquierda < j - 1)
				quicksortCp(izquierda, j - 1, numLista); // ordenamos subarray izquierdo
			if (j + 1 < derecha)
				quicksortCp(j + 1, derecha, numLista); // ordenamos subarray derecho
			break;

		case 2:
			pivote = lista2.obtenerNodo(izquierda).getD_asenta(); // tomamos primer elemento como pivote
			pivoteUbi = lista2.obtenerNodo(izquierda);
			i = izquierda; // i realiza la bÃºsqueda de izquierda a derecha
			j = derecha; // j realiza la bÃºsqueda de derecha a izquierda

			while (i < j) { // mientras no se crucen las bÃºsquedas
				while (lista2.obtenerNodo(i).getD_asenta().compareTo(pivote) <= 0 && i < j)
					i++; // busca elemento mayor que pivote
				while (lista2.obtenerNodo(j).getD_asenta().compareTo(pivote) > 0)
					j--; // busca elemento menor que pivote
				if (i < j) { // si no se han cruzado
					aux = lista2.obtenerNodo(i); // los intercambia
					lista2.asignar(lista2.obtenerNodo(j), i);
					lista2.asignar(aux, j);
				}
			}

			lista2.asignar(lista2.obtenerNodo(j), izquierda); // se coloca el pivote en su lugar de forma que tendremos
			lista2.asignar(pivoteUbi, j); // los menores a su izquierda y los mayores a su derecha
			System.out.println("Fin del pivotaje, ordenando subarrays lista:  " + numLista);
			if (izquierda < j - 1)
				quicksortCp(izquierda, j - 1, numLista); // ordenamos subarray izquierdo
			if (j + 1 < derecha)
				quicksortCp(j + 1, derecha, numLista); // ordenamos subarray derecho
			break;

		case 3:
			pivote = lista3.obtenerNodo(izquierda).getD_asenta(); // tomamos primer elemento como pivote
			pivoteUbi = lista3.obtenerNodo(izquierda);
			i = izquierda; // i realiza la bÃºsqueda de izquierda a derecha
			j = derecha; // j realiza la bÃºsqueda de derecha a izquierda

			while (i < j) { // mientras no se crucen las bÃºsquedas
				while (lista3.obtenerNodo(i).getD_asenta().compareTo(pivote) <= 0 && i < j)
					i++; // busca elemento mayor que pivote
				while (lista3.obtenerNodo(j).getD_asenta().compareTo(pivote) > 0)
					j--; // busca elemento menor que pivote
				if (i < j) { // si no se han cruzado
					aux = lista3.obtenerNodo(i); // los intercambia
					lista3.asignar(lista3.obtenerNodo(j), i);
					lista3.asignar(aux, j);
				}
			}

			lista3.asignar(lista3.obtenerNodo(j), izquierda); // se coloca el pivote en su lugar de forma que tendremos
			lista3.asignar(pivoteUbi, j); // los menores a su izquierda y los mayores a su derecha
			System.out.println("Fin del pivotaje, ordenando subarrays lista:  " + numLista);
			if (izquierda < j - 1)
				quicksortCp(izquierda, j - 1, numLista); // ordenamos subarray izquierdo
			if (j + 1 < derecha)
				quicksortCp(j + 1, derecha, numLista); // ordenamos subarray derecho
			break;

		case 4:
			pivote = lista4.obtenerNodo(izquierda).getD_asenta(); // tomamos primer elemento como pivote
			pivoteUbi = lista4.obtenerNodo(izquierda);
			i = izquierda; // i realiza la bÃºsqueda de izquierda a derecha
			j = derecha; // j realiza la bÃºsqueda de derecha a izquierda

			while (i < j) { // mientras no se crucen las bÃºsquedas
				while (lista4.obtenerNodo(i).getD_asenta().compareTo(pivote) <= 0 && i < j)
					i++; // busca elemento mayor que pivote
				while (lista4.obtenerNodo(j).getD_asenta().compareTo(pivote) > 0)
					j--; // busca elemento menor que pivote
				if (i < j) { // si no se han cruzado
					aux = lista4.obtenerNodo(i); // los intercambia
					lista4.asignar(lista4.obtenerNodo(j), i);
					lista4.asignar(aux, j);
				}
			}

			lista4.asignar(lista4.obtenerNodo(j), izquierda); // se coloca el pivote en su lugar de forma que tendremos
			lista4.asignar(pivoteUbi, j); // los menores a su izquierda y los mayores a su derecha
			System.out.println("Fin del pivotaje, ordenando subarrays  lista:  " + numLista);
			if (izquierda < j - 1)
				quicksortCp(izquierda, j - 1, numLista); // ordenamos subarray izquierdo
			if (j + 1 < derecha)
				quicksortCp(j + 1, derecha, numLista); // ordenamos subarray derecho
			break;
		}

	}

	public void leerArchivoCp(String nombreArchivo) {

		try {
			lector = new BufferedReader(new FileReader(nombreArchivo));
			while ((linea = lector.readLine()) != null) {
				// palabras = new String[1];
				palabras = linea.split("\\|");
				for (int i = 0; i < palabras.length; i++) {
					cpAgregar.agregarEnCabeza(palabras[i]);
				}
				if (palabras.length == 14) {
					cpAgregar.agregarEnCabeza("N/A");
				}
				cp.agregarEnCola(
						new CodigosP(cpAgregar.obtenerNodo(14), cpAgregar.obtenerNodo(13), cpAgregar.obtenerNodo(12),
								cpAgregar.obtenerNodo(11), cpAgregar.obtenerNodo(10), cpAgregar.obtenerNodo(9),
								cpAgregar.obtenerNodo(8), cpAgregar.obtenerNodo(7), cpAgregar.obtenerNodo(6),
								cpAgregar.obtenerNodo(5), cpAgregar.obtenerNodo(4), cpAgregar.obtenerNodo(3),
								cpAgregar.obtenerNodo(2), cpAgregar.obtenerNodo(1), cpAgregar.obtenerNodo(0)));
			}
			lector.close();
			linea = null;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	public void guardarArchivoCp() {
		try {
			String ruta = "C:\\Users\\EnriqueMV\\OneDrive\\Escritorio\\Uni 1 semestre\\Estructura de Datos\\Estructura_de_DatosGit\\Estructura de Datos\\MetodosDeOrdenamiento\\src\\fes\\aragon\\recursos\\CPprueba.txt";
			CodigosP tmp = null;
			String contenido = null;
			int contador = cp.getLongitud();

			File file = new File(ruta);
			// Si el archivo no existe es creado
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);

			while (contador != 0) {
				contador--;
				int indiceListas = 0;

				if (!listaFinal1.esVacia() && !listaFinal2.esVacia()) {
					if (listaFinal1.obtenerNodo(indiceListas).getD_asenta()
							.compareTo(listaFinal2.obtenerNodo(indiceListas).getD_asenta()) <= 0) {
						tmp = listaFinal1.obtenerNodo(indiceListas);
						listaFinal1.eliminarCabeza();

					} else if (listaFinal2.obtenerNodo(indiceListas).getD_asenta()
							.compareTo(listaFinal1.obtenerNodo(indiceListas).getD_asenta()) < 0) {
						tmp = listaFinal2.obtenerNodo(indiceListas);
						listaFinal2.eliminarCabeza();

					}
				} else {
					// Si la lista 1 o 3 esta vacia agrega todo a la lista final
					if (listaFinal1.esVacia()) {
						if (!listaFinal2.esVacia()) {
							tmp = listaFinal2.obtenerNodo(indiceListas);
							listaFinal2.eliminarCabeza();
						}
					} else if (listaFinal2.esVacia()) {
						if (!listaFinal1.esVacia()) {
							tmp = listaFinal1.obtenerNodo(indiceListas);
							listaFinal1.eliminarCabeza();
						}
					}
				}
				contenido = tmp.toString();
				bw.write(contenido + "\n");
			}
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void leerArchivoPersonas(String nombreArchivo) {
		try {
			lector = new BufferedReader(new InputStreamReader(new FileInputStream(nombreArchivo), "utf-8"));
			while ((linea = lector.readLine()) != null) {
				palabras = linea.split("\\|");
				persona.agregarEnCola(new Persona(palabras[0], Integer.parseInt(palabras[1]),
						Integer.parseInt(palabras[2]), Integer.parseInt(palabras[3])));
			}
			lector.close();
			linea = null;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	public void guardarPersonas() {
		try {
			// String ruta = ;
			Persona tmp = null;
			String contenido = null;
			int contador = persona.getLongitud();

			File file = new File(System.getProperty("user.dir") + "\\src\\fes\\aragon\\recursos\\Personas.txt");
			// Si el archivo no existe es creado
			if (!file.exists()) {
				file.createNewFile();
			}
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF8"));
			while (contador != 0) {
				contador--;
				tmp = persona.obtenerNodo(contador);
				contenido = tmp.toString();
				bw.write(contenido + "\n");
			}
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String busquedaSecuencial(int dato) {
		boolean encontro = false;
		String busqueda = null;
		for (int i = 0; i < persona.getLongitud(); i++) {
			if (persona.obtenerNodo(i).getEdad() == dato) {
				encontro = true;
				busqueda = "El dato está en la posicion: " + i + "\nY es: " + persona.obtenerNodo(i).toString();
			}
		}
		if (!encontro) {
			busqueda = "El dato no se encuentra en la lista";
		}
		return busqueda;
	}

	public String busquedaBinaria(int dato) {
		int indice = persona.getLongitud() / 2;
		String busqueda = null;

		if (dato <= persona.obtenerNodo(indice).getEdad()) {
			for (int i = 0; i < indice; i++) {
				if (persona.obtenerNodo(i).getEdad() == dato) {
					busqueda = "El dato está en la posicion: " + i + "\nY es: " + persona.obtenerNodo(i).toString();
				}
			}
		} else if (dato > persona.obtenerNodo(indice).getEdad()) {
			for (int i = indice; i < persona.getLongitud(); i++) {
				if (persona.obtenerNodo(i).getEdad() == dato) {
					busqueda = "El dato está en la posicion: " + i + "\nY es: " + persona.obtenerNodo(i).toString();
				}
			}
		} else {
			busqueda = "El dato no se encuentra en la lista";
		}
		return busqueda;
	}

}
