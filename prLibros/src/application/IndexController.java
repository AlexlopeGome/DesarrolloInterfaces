package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class IndexController {

	@FXML
	private TextField txtTitulo;

	@FXML
	private ChoiceBox cbEditorial;

	@FXML
	private TextField txtAutor;

	@FXML
	private TextField txtPaginas;
	@FXML
	private Button btnAñadir;

	@FXML
	private Button btnBorrar;

	@FXML
	private TableView<Libro> tableLibros;

	@FXML
	private TableColumn<Libro, String> columnTitulo;

	@FXML
	private TableColumn<Libro, String> columnEditorial;

	@FXML
	private TableColumn<Libro, String> columnAutor;

	@FXML
	private TableColumn<Libro, Integer> columnPaginas;

	private ObservableList<Libro> listaLibros = FXCollections
			.observableArrayList(new Libro("La Biblia", "Planeta", "Jesús", 500));

	public ObservableList<String> listaEditoriales = FXCollections.observableArrayList("Planeta", "Altaya", "Kadokawa",
			"Penguin Libros");

	@FXML
	private void initialize() {

		cbEditorial.setItems(listaEditoriales);

		columnTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
		columnEditorial.setCellValueFactory(new PropertyValueFactory<>("editorial"));
		columnAutor.setCellValueFactory(new PropertyValueFactory<>("autor"));
		columnPaginas.setCellValueFactory(new PropertyValueFactory<>("paginas"));

		tableLibros.setItems(listaLibros);
	}

	@FXML
	public void aniadirLibro(ActionEvent event) {

		if (txtTitulo.getText().isEmpty() || cbEditorial.getSelectionModel().isEmpty() || txtAutor.getText().isEmpty()
				|| txtPaginas.getText().isEmpty()) {

			Alert alerta = new Alert(AlertType.WARNING);
			alerta.setTitle("Error al Insertar");
			alerta.setHeaderText("falta algun campo");
			alerta.setContentText("Por Fabor ,las campos que faltan");
			alerta.show();

		} else {

			if (esNumero(txtPaginas.getText())) {

				Libro l = new Libro(txtTitulo.getText(), cbEditorial.getValue().toString(), txtAutor.getText(),
						Integer.parseInt(txtPaginas.getText()));
				listaLibros.add(l);
				txtTitulo.clear();
				cbEditorial.getSelectionModel().clearSelection();
				txtAutor.clear();
				txtPaginas.clear();
			} else {
				Alert alerta = new Alert(AlertType.ERROR);
				alerta.setTitle("Error al Insertar");
				alerta.setHeaderText("No se ha introducido un numero el la pagina");
				alerta.setContentText("Por Fabor ,introduzca número en las paginas");
				alerta.show();
			}

		}

	}

	@FXML
	public void borrarLibro(ActionEvent event) {

		int indiceSeleccionado = tableLibros.getSelectionModel().getSelectedIndex();

		System.out.println(indiceSeleccionado);
		
		if (indiceSeleccionado <= -1) {
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setTitle("Error en el Borrado");
			alerta.setHeaderText("No ha seleccionado ningun Libro en la tabla para borrar");
			alerta.setContentText("Por faVor ,selecciona un Libro");
			alerta.show();
			
			
		} else {

			tableLibros.getItems().remove(indiceSeleccionado);
			tableLibros.getSelectionModel().clearSelection();

		}

	}

	public static boolean esNumero(String s) {

		boolean resultado;

		try {
			Integer.parseInt(s);
			resultado = true;
		} catch (NumberFormatException excepcion) {
			resultado = false;
		}

		return resultado;
	}

}
