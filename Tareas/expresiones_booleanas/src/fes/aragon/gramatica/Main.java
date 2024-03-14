package fes.aragon.gramatica;

import java.io.*;

public class Main {
	private Lexico lexico;
	private Tokens token;

	public static void main(String[] args) {
		Main app = new Main();

		try {
			Reader rd = new BufferedReader(new FileReader(
					System.getProperty("user.dir") + File.separator + "fuente.txt"));
			app.lexico = new Lexico(rd);
			app.token = app.lexico.yylex();
			app.S();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void S() throws IOException {
		System.out.println("S");
		E();
		if (token != Tokens.PUNTOYCOMA) {
			System.out.println("Error, se esperaba ;");
		}
		return;
	}

	private void E() throws IOException {
		System.out.println("E");
		T();
		Ep();
		return;
	}

	private void Ep() throws IOException {
		System.out.println("Ep");
		if (token == Tokens.OR) {
			token = lexico.yylex();
			T();
			Ep();
		} else if (token != Tokens.AND) {
			System.out.println("Error, caracter no valido");
		} else {
			return;
		}
	}

	private void T() throws IOException {
		System.out.println("T");
		F();
		Tp();
	}

	private void Tp() throws IOException {
		System.out.println("Tp");
		if (token == Tokens.AND) {
			F();
			Tp();
		} else if (token != Tokens.OR) {
			System.out.println("Error, caracter no valido");
		} else {
			return;
		}
	}

	private void F() throws IOException {
		System.out.println("F");

		if (token == Tokens.NOT) {
			token = lexico.yylex();
			F();
		} else if (token == Tokens.TRUE || token == Tokens.FALSE) {
			token = lexico.yylex();
			return;
		} else if (token == Tokens.ABREPARENTESIS) {
			token = lexico.yylex();
			E();
			if (token == Tokens.CIERREPARENTESIS) {
				token = lexico.yylex();
				return;
			}
		} else {
			System.out.println("Error, caracter no esperado");
		}
	}

}