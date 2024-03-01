package fes.aragon.compilador;
import java.io.*;

public class Inicio {
	public static void main(String[] args) {
		try {
			Reader rd = new BufferedReader(new FileReader ("fuente.txt"));
			Lexico lexico  = new Lexico(rd);
			Tokens resultado;
			do {
				resultado = lexico.yylex();
				System.out.println(resultado);
			}while(resultado != null);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
