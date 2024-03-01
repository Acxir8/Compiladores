package fes.aragon.metodos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

import javax.swing.JOptionPane;

import fes.aragon.modelo.Documento;
import fes.aragon.utilerias.dinamicas.listasimple.ListaSimple;

public class Archivos {

	// Variables para la lectura y escritura
	private BufferedReader lector;
	private String linea;
	private Writer w;
	// private String filtro = "";

	// Creamos una lista simple
	String[] palabras = new String[15];
	public ListaSimple<Documento> documento = new ListaSimple<>();

	public void leerArchivo(String nombreArchivo) {
		try {
			lector = new BufferedReader(new InputStreamReader(new FileInputStream(nombreArchivo), "utf-8"));
			while ((linea = lector.readLine()) != null) {
				palabras = linea.split(" ");
				for (int i = 0; i < palabras.length; i++) {
					// if(!palabras[i].equals(filtro)) {
					documento.agregarEnCabeza(new Documento(palabras[i]));
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
		for (int i = documento.getLongitud()-1; i > 0 ; i--) {
			System.out.println(documento.obtenerNodo(i).getPalabra());
		}
	}

	public void guardarArchivo(String nombreArchivo) {
		try {
			// String ruta = ;
			String contenido = null;
			int contador = documento.getLongitud();

			File file = new File(System.getProperty("user.dir") + "\\src\\fes\\aragon\\recursos\\" + nombreArchivo);
			// Si el archivo no existe es creado
			if (!file.exists()) {
				file.createNewFile();
			}
			w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF8"));
			while (contador != 0) {
				contador--;
				//tmp = documento.obtenerNodo(contador).getPalabra();
				contenido = documento.obtenerNodo(contador).getPalabra();
				w.write(contenido + "\n");
			}
			w.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
