package fes.aragon.palabras;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Archivos {

	// Variables para la lectura y escritura
	private BufferedReader lector;
	private String linea;
	// private String filtro = "";

	// Creamos una lista simple
	String[] palabras = new String[15];
//	public ListaSimple<Documento> documento = new ListaSimple<>();
	public ArrayList<String> documento = new ArrayList<String>();

	public void leerArchivo(String nombreArchivo) {
		try {
			lector = new BufferedReader(new InputStreamReader(new FileInputStream(nombreArchivo), "utf-8"));
			while ((linea = lector.readLine()) != null) {
				palabras = linea.split(" ");
				for (int i = 0; i < palabras.length; i++) {
					// if(!palabras[i].equals(filtro)) {
					documento.add(palabras[i]);
					// }
				}
			}
			lector.close();
			linea = null;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}

	public void imprimirArchivo() {
		for (int i = 0; i < documento.size() - 1; i++) {
			System.out.println(documento.get(i));
		}
	}
}
