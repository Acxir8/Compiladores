package fes.aragon.palabras;

import java.io.*;
import java.util.ArrayList;
public class Automata2C {

    private int indice=0;
    private String cadena="";
    private final int error=-1;
    private final int aceptado=1;


    public static void main(String[] args) {
        Automata2C app=new Automata2C();

        // Leer Archivos
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Buscar Nombre del Archivo: ");
//		String archivo = scanner.nextLine();

        ArrayList<String> palabras = new ArrayList<>();
        String nombreArchivo = System.getProperty("user.dir") + "\\src\\fes\\aragon\\recursos\\cadenasA2.fes";
        File f = new File(nombreArchivo);
        if (f.exists()) {
            System.out.println("Archivo encontrado");
            System.out.println("Contenido: ");

            try {
                BufferedReader obj = new BufferedReader(new FileReader(f));
                String palabra;
                while ((palabra = obj.readLine()) != null){
                    if (!palabra.trim().isEmpty()) {
                        palabras.add(palabra);
                    }
                }
                System.out.println(palabras);
            }
            catch(FileNotFoundException e){
                e.printStackTrace();
            }
            catch (IOException e1){
                e1.printStackTrace();
            }
        }
        else{
            System.out.println("No se encontro el archivo");
        }

        for (String palabra : palabras) {
            app.cadena = palabra;
            int valor = app.estado_A();
            if (valor == app.aceptado) {
                System.out.println(palabra + ": Cadena Valida");
                app.reinicioIndice();
            } else {
                System.out.println(palabra + ": Cadena Invalida");
                app.reinicioIndice();
            }
        }
    }
    private char siguienteCaracter() {
        char caracter=' ';
        if(indice<cadena.length()) {
            caracter = cadena.charAt(indice);
            indice++;
        }
        return caracter;
    }

    private int estado_A() {
        char c=siguienteCaracter();
        switch(c){
            case '0': return estado_B();
            case '1': return estado_C();
            default: return error;
        }
    }

    private int estado_B() {
        char c=siguienteCaracter();
        switch(c){
            case '0': return estado_B();
            case '1': return estado_B();
            default: return error;
        }
    }

    private int estado_C() {
        char c=siguienteCaracter();
        switch(c){
            case '0': return estado_D();
            case '1': return estado_C();
            default: return error;
        }
    }

    private int estado_D() {
        char c=siguienteCaracter();
        switch(c){
            case '0': return estado_D();
            case '1': return estado_C();
            case ' ': return aceptado;
            default: return error;
        }
    }
    
    private void reinicioIndice() {
    	indice = 0;
    }
}