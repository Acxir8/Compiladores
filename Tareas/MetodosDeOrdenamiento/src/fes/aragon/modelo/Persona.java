package fes.aragon.modelo;

public class Persona {
	private String nombre;
	private Integer edad;
	private Integer peso;
	private Integer estatura;
	public Persona(String nombre, Integer edad, Integer peso, Integer estatura) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
		this.estatura = estatura;
	}
	public String getNombre() {
		return nombre;
	}
	public Integer getEdad() {
		return edad;
	}
	public Integer getPeso() {
		return peso;
	}
	public Integer getEstatura() {
		return estatura;
	}
	@Override
	public String toString() {
		return "nombre=" + nombre + ", edad=" + edad + ", peso=" + peso +"kg" +  ", estatura=" + estatura + "cm";
	}
	
	
}
