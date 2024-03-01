//package fes.aragon.inicio;
//
//import java.util.Scanner;
//
//import fes.aragon.utilerias.dinamicas.listasimple.ListaSimple;
//
//public class Pruebas {
//
//	private static int NUMLIST = 10000;
//
//	public static void main(String[] args) {
//
//		ListaSimple<Integer> numeros = new ListaSimple<>();
//		ListaSimple<Auxiliar> numRep = new ListaSimple<>();
//		int max = 200, min = 1;
//
//		for (int i = 0; i < NUMLIST; i++) {
//			Integer rd = (int) (Math.random() * (max - min + 1) + min);
//			numeros.agregarEnCabeza(rd);
//		}
//		for (int i = min; i <= max; i++) {
//			final Auxiliar aux = new Auxiliar(i);
//
//			for (int j = 0; j < numeros.getLongitud(); j++) {
//				if (numeros.obtenerNodo(j) == i) {
//					aux.inConta();
//				}
//			}
//			if (aux.getContador() != 0) {
//				numRep.agregarEnCabeza(aux);
//			}
//		}
//
//		numRep.imprimirElementos();
//
//		System.out.println(
//				"*******************************************************************************************************\n");
//
//		System.out.println("Desea eliminar un elemento de la lista? ");
//		System.out.println("Ingresa SI = 1  || Ingresar NO = 0 ");
//		@SuppressWarnings("resource")
//		Scanner valor= new Scanner(System.in);
//		Integer name = valor.nextInt();
//
//		while (name == 1) {
//			System.out.println("Teclee el número que desea eliminar: ");
//			Integer name2 = valor.nextInt();
//			for (int i = 0; i < numeros.getLongitud(); i++) {
//				@SuppressWarnings("unused")
//				boolean encontrada = false;
//				if (numeros.obtenerNodo(i) == (int) name2) {
//					numeros.eliminarEnIndice(i);
//					encontrada = true;
//					break;
//				}
//			}
//
//			for (int i = 0; i < numRep.getLongitud(); i++) {
//				@SuppressWarnings("unused")
//				boolean encontrada = false;
//				if (numRep.obtenerNodo(i).getNumero() == (int) name2) {
//					numRep.eliminarEnIndice(i);
//					encontrada = true;
//					break;
//
//				}
//			}
//			numRep.imprimirElementos();
//
//			System.out.println(
//					"*****************************************************************************************************************");
//			System.out.println("Desea eliminar otro elemento de la lista? ");
//			System.out.println("Ingresa SI = 1  || Ingresar NO = 0 ");
//			name = valor.nextInt();
//		}
//
//		while (name == 0 || name != 1) {
//			System.out.println("Por favor de terminar el proceso si no va a hacer nada :/ \n");
//			break;
//		}
//
//		System.out.println(
//				"||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
//
////		ListaSimple<Integer> lista = new ListaSimple<>();
////		ListaSimple<Auxiliar> aux = new ListaSimple<>();
////		int max = 20, min = 1;
////
////		for (int i = 0; i < NUMLIST; i++) {
////			lista.agregarEnCabeza((int) (Math.random() * (max - min) + 1 + min));
////		}
////
////		for (int i = 0; i < NUMLIST; i++) {
////			Integer valor = lista.obtenerNodo(i);
////			if (aux.esVacia()) {
////				Auxiliar au = new Auxiliar(valor);
////				aux.agregarEnCabeza(au);
////			} else {
////				boolean encontrada = false;
////				for (int j = 0; j < aux.getLongitud(); j++) {
////					if (valor == aux.obtenerNodo(j).getNumero()) {
////						aux.obtenerNodo(j).inConta();
////						encontrada = true;
////						break;
////					}
////				}
////				if (!encontrada) {
////					Auxiliar au = new Auxiliar(valor);
////					aux.agregarEnCabeza(au);
////				}
////			}
////
////		}
////		aux.imprimirElementos();
//
////		System.out.println("*******************************************************************************************************\n");
////		
////		System.out.println("Desea eliminar un elemento de la lista? ");
////		System.out.println("Ingresa SI = 1  || Ingresar NO = 0 ");
////		Scanner valor = new Scanner(System.in);
////		Integer name = valor.nextInt();
////
////		while (name == 1) {
////			System.out.println("Teclee el número que desea eliminar: ");
////			Integer name2 = valor.nextInt();
////			for (int i = 0; i < lista.getLongitud(); i++) {
////				if (lista.obtenerNodo(i) == (int) name2) {
////					lista.eliminarEnIndice(i);
////				}
////			}
////
////			for (int i = 0; i < aux.getLongitud(); i++) {
////				if (aux.obtenerNodo(i).getNumero() == (int) name2) {
////					aux.eliminarEnIndice(i);
////				}
////			}
////			aux.imprimirElementos();
////			System.out.println("*****************************************************************************************************************");
////			System.out.println("Desea eliminar otro elemento de la lista? ");
////			System.out.println("Ingresa SI = 1  || Ingresar NO = 0 ");
////			name = valor.nextInt();
////		}
////		
////		while (name == 0 || name != 1) {
////			System.out.println("Por favor de terminar el proceso si no va a hacer nada :/");
////			break;
////		}
////		
//
//	}
//}
package fes.aragon.inicio;

import fes.aragon.utilerias.dinamicas.arbolesBinarios.ArbolBinarioOrden;

public class Pruebas {
	public static void main(String[] args) {
		ArbolBinarioOrden<Integer> arbol = new ArbolBinarioOrden<>();
		arbol.insertar(45);
		arbol.insertar(3);
		arbol.insertar(200);
		arbol.insertar(20);
		arbol.insertar(100);
		arbol.insertar(50);
		arbol.insertar(15);
		arbol.insertar(30);
		try {
			// arbol.orden(arbol.getRaiz());
			arbol.noRecursivoOrden();
			arbol.eliminar(45);
			System.out.println("----");
			arbol.preorden(arbol.getRaiz());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
