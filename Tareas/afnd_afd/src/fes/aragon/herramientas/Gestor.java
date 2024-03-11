package fes.aragon.herramientas;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Gestor {

    public static void crear(String archivo){

        Scanner scanner = new Scanner(System.in);
        String cadena = "";
        System.out.println("Ingresa las cadenas que quieres guardar (termina con una cadena vacia): ");
        while (true) {
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                break;
            }
            cadena += input + System.lineSeparator();
        }

        try {
            FileWriter crear = new FileWriter(System.getProperty("user.dir") + File.separator + archivo);
            BufferedWriter buffer = new BufferedWriter(crear);
            buffer.write(cadena);
            buffer.close();
            System.out.println("Archivo creado con exito.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static ArrayList<String> leer(String buscar) {

        File f = new File(System.getProperty("user.dir") + File.separator + buscar);

        if (f.exists()) {
            System.out.println("Archivo encontrado");
        } else {
            System.out.println("No se encontro el archivo");
        }

        ArrayList<String> palabras = new ArrayList<>();
        try {
            BufferedReader obj = new BufferedReader(new FileReader(f));
            String palabra;
            while ((palabra = obj.readLine()) != null){
                if (!palabra.trim().isEmpty()) {
                    palabras.add(palabra);
                }
            }
            obj.close(); // Cierra el archivo al terminar la lectura
        } catch (IOException e) {
            e.printStackTrace();
        }

        return palabras;
    }
}
