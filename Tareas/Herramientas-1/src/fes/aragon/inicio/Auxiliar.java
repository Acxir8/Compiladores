package fes.aragon.inicio;

public class Auxiliar {
	
	private Integer numero;
	private Integer contador = 1;
	
	public Auxiliar(Integer numero) {
		this.numero = numero;
	}

	public Integer getNumero() {
		return numero;
	}

	public Integer getContador() {
		return contador;
	}

	public void setContador(Integer contador) {
		this.contador = contador;
	}

	@Override
	public String toString() {
		return numero + " = " + contador;
	}
	
	public void inConta() {
		this.contador++;
	}

}
