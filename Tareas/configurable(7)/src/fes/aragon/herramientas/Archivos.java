package fes.aragon.herramientas;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.JOptionPane;


public class Archivos {

	// Variables para la lectura y escritura
	private BufferedReader lector;
	private String linea;
	private int indiceFilas = 0;
	private boolean lenguajeRegistrado = false;

	// Creamos una lista simple
	String[] token = new String[15];
	public ArrayList<String> documento = new ArrayList<String>(); //ArrayList donde guardaremos las palabras
	int[][] matriz; //Declaramos la matriz sin inicializar
	String[] lenguaje; //Declaramos el lenguaje sin inicializar


	public int[][] leerMatriz(String nombreArchivo) {
		try {
			lector = new BufferedReader(new InputStreamReader(new FileInputStream(nombreArchivo), "utf-8"));
			linea = lector.readLine();
			token = linea.split(" ");
			int[][] matriz = new int[Integer.parseInt(token[0])][Integer.parseInt(token[1]) + 1]; //Inicializamos la matriz y Se suma una columna para fin de cadena
			while ((linea = lector.readLine()) != null) {
				token = linea.split(" ");
				if (!lenguajeRegistrado) { // Registra la segunda línea del documento en el array lenguaje
					int indiceLenguaje = 0;
					String[] lenguaje = new String[token.length + 1]; //Inicializamos el lenguaje
					for (indiceLenguaje = 0; indiceLenguaje < token.length; indiceLenguaje++) {
						lenguaje[indiceLenguaje] = token[indiceLenguaje]; //Guarda todos los simbolos del lenguaje
					}
					lenguaje[indiceLenguaje] = ";"; //Añade fin de cadena ";"
					lenguajeRegistrado = true; //Activa la bandera de que ya fue registrado el lenguaje
					this.lenguaje = lenguaje; //Lleva el lenguaje de variable local a variable de clase
					
				} else {// Registra el resto de lineas del documento o estados en la matriz
					for (int indiceColumna = 0; indiceColumna < token.length; indiceColumna++) {
						matriz[indiceFilas][indiceColumna] = Integer.parseInt(token[indiceColumna]);
					}
				indiceFilas++;
				}

			}
			lector.close();
			linea = null;
			this.matriz = matriz; //Lleva la matriz de variable local a variable de clase
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return matriz;

	}

	private void leerPalabras(String nombreArchivo) {
		try {
			lector = new BufferedReader(new InputStreamReader(new FileInputStream(nombreArchivo), "utf-8"));
			while ((linea = lector.readLine()) != null) {
//				palabras = linea.split(" "); // Lectura de palabras individuales en una linea
//				for (int i = 0; i < palabras.length; i++) {
//					documento.add(palabras[i]);
				documento.add(linea); //Lectura de una linea completa
//				}
			}
			lector.close();
			linea = null;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}





}
