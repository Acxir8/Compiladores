package fes.aragon;

import fes.aragon.modelo.Ordenamiento;

public class Busqueda {

	public static void main(String[] args) {
		Ordenamiento ordenamiento = new Ordenamiento();
		
		
		ordenamiento.leerArchivoPersonas(System.getProperty("user.dir") + "\\src\\fes\\aragon\\recursos\\Personas.txt");
		ordenamiento.burbuja();
		
		//Busqueda secuencial
		System.out.println(ordenamiento.busquedaSecuencial(1));
		//Busqueda binaria
		System.out.println(ordenamiento.busquedaBinaria(60));


		//Se realiza el procesamiento y el orden de todos los códigos postales del pais
//ordenamiento.leerArchivoCp( System.getProperty("user.dir")+ "\\src\\fes\\aragon\\recursos\\CPdescarga.txt");
//	ordenamiento.partirLista();
//	ordenamiento.quicksort();
//    System.out.println("La lista original tiene: " + ordenamiento.cp.getLongitud());
//	System.out.println("La lista1 tiene: " + ordenamiento.lista1.getLongitud());
//	System.out.println("La lista2 tiene: " + ordenamiento.lista2.getLongitud());
//	System.out.println("La lista3 tiene: " + ordenamiento.lista3.getLongitud());
//	System.out.println("La lista4 tiene: " + ordenamiento.lista4.getLongitud());
//	ordenamiento.unirListas();
//    System.out.println("La lista original tiene: " + ordenamiento.cp.getLongitud());
//	System.out.println("La lista1 tiene: " + ordenamiento.lista1.getLongitud());
//	System.out.println("La lista2 tiene: " + ordenamiento.lista2.getLongitud());
//	System.out.println("La lista3 tiene: " + ordenamiento.lista3.getLongitud());
//	System.out.println("La lista4 tiene: " + ordenamiento.lista4.getLongitud());
//	System.out.println("La listaFinal1 tiene: " + ordenamiento.listaFinal1.getLongitud());
//	System.out.println("La listaFinal2 tiene: " + ordenamiento.listaFinal2.getLongitud());
//	ordenamiento.guardarArchivo();

	}
}
