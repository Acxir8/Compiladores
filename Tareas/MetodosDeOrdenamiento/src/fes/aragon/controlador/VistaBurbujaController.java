package fes.aragon.controlador;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import fes.aragon.modelo.Ordenamiento;
import fes.aragon.modelo.Persona;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;

public class VistaBurbujaController implements Initializable {
	@FXML
	private BarChart<String, Number> area;
	@FXML
	private Button btnAleatorio;
	@FXML
	private Button sinOrdenar;
	@FXML
	private Button btnSalir;
	@FXML
	private Button burbuja;

	@FXML
	private Button insercion;

	@FXML
	private Button mezcla;

	@FXML
	private Button quicksort;

	@FXML
	private Button seleccion;

	final CategoryAxis xAxis = new CategoryAxis();
	final NumberAxis yAxis = new NumberAxis();
	private XYChart.Series<String, Number> series;
	final String[] color = { "-fx-bar-fill: green", "-fx-bar-fill: red", "-fx-bar-fill: blue", "-fx-bar-fill: yellow" };
	private ScheduledExecutorService scheduledExecutorService;

	private int min = 0;
	Ordenamiento ordenamiento = new Ordenamiento();

	@FXML
	public void burbuja(ActionEvent event) {
		// area.setTitle("Metodo de burbuja");
		scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
		scheduledExecutorService.scheduleAtFixedRate(() -> {
			Platform.runLater(() -> {
				for (int i = 0; i < ordenamiento.persona.getLongitud(); i++) {
					for (int j = ordenamiento.persona.getLongitud() - 1; j > i; j--) {
						if (ordenamiento.persona.obtenerNodo(j - 1).getEdad() > ordenamiento.persona.obtenerNodo(j)
								.getEdad()) {
							Persona aux = ordenamiento.persona.obtenerNodo(j - 1);
							ordenamiento.persona.asignar(ordenamiento.persona.obtenerNodo(j), j - 1);
							ordenamiento.persona.asignar(aux, j);
							String tmpEstilo = series.getData().get(j).getNode().getStyle();
							String tmpEstiloDos = series.getData().get(j - 1).getNode().getStyle();
							series.getData().get(j).getNode().setStyle(tmpEstiloDos);
							series.getData().get(j - 1).getNode().setStyle(tmpEstilo);
							series.getData().get(j).setYValue(ordenamiento.persona.obtenerNodo(j).getEdad());
							series.getData().get(j - 1).setYValue(ordenamiento.persona.obtenerNodo(j - 1).getEdad());

							break;
						}
					}
				}
			});
		}, 0, 1, TimeUnit.SECONDS);
	}

	@SuppressWarnings("unused")
	@FXML
	void insercion(ActionEvent event) {
		// area.setTitle("Metodo de insercion");
		scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
		scheduledExecutorService.scheduleAtFixedRate(() -> {
			Platform.runLater(() -> {

				for (int i = 1, j; i < ordenamiento.persona.getLongitud(); i++) {
					Persona tmp = ordenamiento.persona.obtenerNodo(i);
					String tmpEstilo = series.getData().get(i).getNode().getStyle();
					for (j = i - 1; j >= 0 && tmp.getEdad() < ordenamiento.persona.obtenerNodo(j).getEdad(); j--) {
						ordenamiento.persona.asignar(ordenamiento.persona.obtenerNodo(j), j + 1);
						ordenamiento.persona.asignar(tmp, j);

						String tmpEstiloDos = series.getData().get(j).getNode().getStyle();
						series.getData().get(j + 1).getNode().setStyle(tmpEstiloDos);
						series.getData().get(j).getNode().setStyle(tmpEstilo);

						series.getData().get(j + 1).setYValue(ordenamiento.persona.obtenerNodo(j + 1).getEdad());
						series.getData().get(j).setYValue(ordenamiento.persona.obtenerNodo(j).getEdad());
						break;
					}

				}
			});
		}, 0, 1, TimeUnit.SECONDS);
	}

	@FXML
	void mezcla(ActionEvent event) {
		scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
		scheduledExecutorService.scheduleAtFixedRate(() -> {
			Platform.runLater(() -> {
				int mitad = ordenamiento.persona.getLongitud() / 2;
				boolean bandera = false;
				for (int i = 0; i < mitad; i++) {
					for (int j = i + 1; j < mitad; j++) {
						if (ordenamiento.persona.obtenerNodo(i).getEdad() > ordenamiento.persona.obtenerNodo(j).getEdad()) {
							Persona tmp = ordenamiento.persona.obtenerNodo(i);
							ordenamiento.persona.asignar(ordenamiento.persona.obtenerNodo(j), i);
							ordenamiento.persona.asignar(tmp, j);
							String tmpEstilo = series.getData().get(j).getNode().getStyle();
							String tmpEstiloDos = series.getData().get(i).getNode().getStyle();
							series.getData().get(j).getNode().setStyle(tmpEstiloDos);
							series.getData().get(i).getNode().setStyle(tmpEstilo);
							series.getData().get(j).setYValue(ordenamiento.persona.obtenerNodo(j).getEdad());
							series.getData().get(i).setYValue(ordenamiento.persona.obtenerNodo(i).getEdad());
							break;
						}
					}
				}
				for (int i = mitad; i < ordenamiento.persona.getLongitud(); i++) {
					for (int j = i + 1; j < ordenamiento.persona.getLongitud(); j++) {
						if (ordenamiento.persona.obtenerNodo(i).getEdad() > ordenamiento.persona.obtenerNodo(j).getEdad()) {
							Persona tmp = ordenamiento.persona.obtenerNodo(i);
							ordenamiento.persona.asignar(ordenamiento.persona.obtenerNodo(j), i);
							ordenamiento.persona.asignar(tmp, j);
							String tmpEstilo = series.getData().get(j).getNode().getStyle();
							String tmpEstiloDos = series.getData().get(i).getNode().getStyle();
							series.getData().get(j).getNode().setStyle(tmpEstiloDos);
							series.getData().get(i).getNode().setStyle(tmpEstilo);
							series.getData().get(j).setYValue(ordenamiento.persona.obtenerNodo(j).getEdad());
							series.getData().get(i).setYValue(ordenamiento.persona.obtenerNodo(i).getEdad());
							break;
						}
					}
					if (i == ordenamiento.persona.getLongitud() - 1) {
						bandera = true;
					}
				}

				if (bandera == true) {
					for (int i = 0; i < ordenamiento.persona.getLongitud() - 1; i++) {
						for (int j = i + 1; j < ordenamiento.persona.getLongitud(); j++) {
							if (ordenamiento.persona.obtenerNodo(i).getEdad() > ordenamiento.persona.obtenerNodo(j).getEdad()) {
								Persona tmp = ordenamiento.persona.obtenerNodo(i);
								ordenamiento.persona.asignar(ordenamiento.persona.obtenerNodo(j), i);
								ordenamiento.persona.asignar(tmp, j);
								String tmpEstilo = series.getData().get(j).getNode().getStyle();
								String tmpEstiloDos = series.getData().get(i).getNode().getStyle();
								series.getData().get(j).getNode().setStyle(tmpEstiloDos);
								series.getData().get(i).getNode().setStyle(tmpEstilo);
								series.getData().get(j).setYValue(ordenamiento.persona.obtenerNodo(j).getEdad());
								series.getData().get(i).setYValue(ordenamiento.persona.obtenerNodo(i).getEdad());
								break;
							}
						}
					}
				}
			});
		}, 0, 1, TimeUnit.SECONDS);
	}

	@FXML
	void quicksort(ActionEvent event) {
		scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
		scheduledExecutorService.scheduleAtFixedRate(() -> {
			Platform.runLater(() -> {
				int derecha = ordenamiento.persona.getLongitud() - 1;
				quicksortPersona(0, derecha);
			});
		}, 0, 1, TimeUnit.SECONDS);

	}

	public void quicksortPersona(int izquierda, int derecha) {
		String tmpEstilo = "";
		String tmpEstiloDos = "";
		Integer pivoteInt = ordenamiento.persona.obtenerNodo(izquierda).getEdad(); // tomamos primer elemento como
		Persona pivote = ordenamiento.persona.obtenerNodo(izquierda); // pivote
		int i = izquierda; // i realiza la busqueda de izquierda a derecha
		int j = derecha; // j realiza la busqueda de derecha a izquierda
		Persona aux;

		while (i < j) { // mientras no se crucen las búsquedas
			while (ordenamiento.persona.obtenerNodo(i).getEdad() <= pivoteInt && i < j)
				i++; // busca elemento mayor que pivote
			while (ordenamiento.persona.obtenerNodo(j).getEdad() > pivoteInt)
				j--; // busca elemento menor que pivote
			if (i < j) { // si no se han cruzado
				aux = ordenamiento.persona.obtenerNodo(i); // los intercambia
				ordenamiento.persona.asignar(ordenamiento.persona.obtenerNodo(j), i);
				ordenamiento.persona.asignar(aux, j);

				tmpEstilo = series.getData().get(j).getNode().getStyle();
				tmpEstiloDos = series.getData().get(i).getNode().getStyle();
				series.getData().get(j).getNode().setStyle(tmpEstiloDos);
				series.getData().get(i).getNode().setStyle(tmpEstilo);
				series.getData().get(j).setYValue(ordenamiento.persona.obtenerNodo(j).getEdad());
				series.getData().get(i).setYValue(ordenamiento.persona.obtenerNodo(i).getEdad());
				//break;
			}
		}

		ordenamiento.persona.asignar(ordenamiento.persona.obtenerNodo(j), izquierda); // se coloca el pivote en su lugar
		ordenamiento.persona.asignar(pivote, j); // de forma que tendremos
													// los menores a su izquierda y los mayores a su derecha
		tmpEstilo = series.getData().get(izquierda).getNode().getStyle();
		tmpEstiloDos = series.getData().get(j).getNode().getStyle();
		series.getData().get(j).getNode().setStyle(tmpEstiloDos);
		series.getData().get(izquierda).getNode().setStyle(tmpEstilo);
		series.getData().get(j).setYValue(ordenamiento.persona.obtenerNodo(j).getEdad());
		series.getData().get(izquierda).setYValue(ordenamiento.persona.obtenerNodo(izquierda).getEdad());

		if (izquierda < j - 1)
			quicksortPersona(izquierda, j - 1); // ordenamos subarray izquierdo
		if (j + 1 < derecha)
			quicksortPersona(j + 1, derecha); // ordenamos subarray derecho
	}

	@FXML
	void seleccion(ActionEvent event) {
		// area.setTitle("Metodo de seleccion");
		scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
		scheduledExecutorService.scheduleAtFixedRate(() -> {
			Platform.runLater(() -> {
				for (int i = 0; i < ordenamiento.persona.getLongitud() - 1; i++) {
					min = i;
					for (int j = i + 1; j < ordenamiento.persona.getLongitud(); j++) {
						if (ordenamiento.persona.obtenerNodo(j).getEdad() < ordenamiento.persona.obtenerNodo(min)
								.getEdad()) {
							min = j;
							break;
						}
					}
					if (i != min) {
						Persona tmp = ordenamiento.persona.obtenerNodo(i);
						ordenamiento.persona.asignar(ordenamiento.persona.obtenerNodo(min), i);
						ordenamiento.persona.asignar(tmp, min);
						String tmpEstilo = series.getData().get(min).getNode().getStyle();
						String tmpEstiloDos = series.getData().get(i).getNode().getStyle();
						series.getData().get(min).getNode().setStyle(tmpEstiloDos);
						series.getData().get(i).getNode().setStyle(tmpEstilo);
						series.getData().get(min).setYValue(ordenamiento.persona.obtenerNodo(min).getEdad());
						series.getData().get(i).setYValue(ordenamiento.persona.obtenerNodo(i).getEdad());

					}

				}
			});
		}, 0, 1, TimeUnit.SECONDS);
	}

	@FXML
	void aleatorios(ActionEvent event) {
		series.getData().clear();
		ordenamiento.persona.eliminarLista();
		guardarDatos();
		for (int i = 0; i < ordenamiento.persona.getLongitud(); i++) {
			series.getData().add(new XYChart.Data<>(String.valueOf(i), ordenamiento.persona.obtenerNodo(i).getEdad()));
			series.getData().get(i).getNode().setStyle(color[new Random().nextInt(4)]);
		}
		if (scheduledExecutorService != null) {
			scheduledExecutorService.shutdown();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		guardarDatos();
		xAxis.setLabel("Time/s");
		xAxis.setAnimated(false);
		yAxis.setLabel("Value");
		yAxis.setAnimated(false);
// idArea = new LineChart<>(xAxis, yAxis);
		area.setTitle(" ");
		area.setAnimated(false); // disable animations
		series = new XYChart.Series<>();
		area.getData().add(series);
		for (int i = 0; i < ordenamiento.persona.getLongitud(); i++) {
			final XYChart.Data<String, Number> dato = new XYChart.Data<>(String.valueOf(i),
					ordenamiento.persona.obtenerNodo(i).getEdad());
			series.getData().add(dato);
			dato.getNode().setStyle(color[new Random().nextInt(4)]);
		}
	}

	private void guardarDatos() {
		ordenamiento.leerArchivoPersonas(System.getProperty("user.dir") + "\\src\\fes\\aragon\\recursos\\Personas.txt");
	}

	@FXML
	void eventoSalir(ActionEvent event) {

		if (scheduledExecutorService != null) {
			scheduledExecutorService.shutdown();
		}
		Platform.exit();

	}
}