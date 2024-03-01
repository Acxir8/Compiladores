package fes.aragon.compilador;

import fes.aragon.herramientas.Herramienta;

public class Prueba {

//    public static void main(String[] args){
////        la primera linea y la matriz
//        int [][] tabla = {{3,1, -1}, {3, 2, -1}, {2, 2, -1}, {3, 3, 1}};
////        la segunda linea
//        char [] columnas = {'0','1', ';' };
//        char c = '0';
//        int estado = 0;
//        int entrada = -1;
////        lectura
//        for (int indice = 0; indice < columnas.length; indice++){
//            if (c == columnas[indice]){
//                entrada = indice;
//                break;
//            }
//        }
//
//        estado = tabla[estado][entrada];
//        System.out.println(estado);
//    }

    public static void main(String[] args){
//        la primera linea y la matriz
        int [][] tabla = {{2,1, -1}, {1, 1, -1}, {2, 2, 1}};
//        la segunda linea
        char [] columnas = {'L','D', ';' };
        char c = 'a';
        int estado = 0;
        int entrada = -1;
//        lectura
        if (Herramienta.letra(c)){
            c = 'L';
        } else if(Herramienta.numero(c)){
            c ='D';
        }
        for (int indice = 0; indice < columnas.length; indice++){
            if (c == columnas[indice]){
                entrada = indice;
                break;
            }
        }
        System.out.println(estado + " " + entrada);

        estado = tabla[estado][entrada];
        System.out.println(estado);
    }
}
