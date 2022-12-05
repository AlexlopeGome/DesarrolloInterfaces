package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class SampleControllerVideojuegos {
	@FXML
	private TextField txtNombre;
	@FXML
	private TextField txtPrecio;
	@FXML
	private ChoiceBox cbConsolas;
	@FXML
	private ChoiceBox cbPEGIs;
	@FXML
	private TableView tablaVideojuegos;
	@FXML
	private Button btnAniadir;
	
	@FXML
	private Button btnBorrado;
	
	@FXML
	private TableColumn<Videojuego, String> columnaNombre;

	@FXML
	private TableColumn<Videojuego, Float> columnaPrecio;

	@FXML
	private TableColumn<Videojuego, String> columnaConsola;

	@FXML
	private TableColumn<Videojuego, Integer> columnaPEGI;

	public ObservableList<String> listaConsolas = FXCollections.observableArrayList("PlayStation 4", "PlayStation 5",
			"XBox", "Nintedo DS", "PC");

	public ObservableList<String> listaPEGIs = FXCollections.observableArrayList("7", "12", "16", "18"

	);
	public ObservableList<Videojuego> listaVideojuegos = FXCollections
			.observableArrayList(new Videojuego("Ghost of Tsushima", (float) 20.99, "PlayStation 4", 16));

	@FXML
	private void initialize() {

		cbConsolas.setItems(listaConsolas);
		cbPEGIs.setItems(listaPEGIs);

		columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		columnaPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
		columnaConsola.setCellValueFactory(new PropertyValueFactory<>("consola"));
		columnaPEGI.setCellValueFactory(new PropertyValueFactory<>("PEGI"));
		ObservableList listaVideojuegosBD = getVideojuegosBd ();
		tablaVideojuegos.setItems(listaVideojuegosBD);
	}

private ObservableList<Videojuego>getVideojuegosBd(){
		
		ObservableList<Videojuego>ListaVideojuegosBd=
				 FXCollections.observableArrayList();
		
		DatabaseConnection dbConection= new DatabaseConnection ();
		Connection connection=dbConection.getConnection();
		

		try {
			String query="select * from videojuegos";
			PreparedStatement ps= connection.prepareStatement(query);
			ResultSet rs =ps.executeQuery();
			while(rs.next()) {
				
				Videojuego videojuego =new Videojuego(
						rs.getString("nombre"),
						rs.getFloat("precio"),
						rs.getString("consola"),
						rs.getInt("PEGI")
	
						);
				ListaVideojuegosBd.add(videojuego);
						
				
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				 
		return ListaVideojuegosBd;
	}
	
	
	
	
	@FXML
	public void aniadirLibro(ActionEvent event) {
		if (txtNombre.getText().isEmpty() || txtPrecio.getText().isEmpty() || cbConsolas.getSelectionModel().isEmpty()
				|| cbPEGIs.getSelectionModel().isEmpty()) {

			Alert alerta = new Alert(AlertType.WARNING);
			alerta.setTitle("Error al Insertar");
			alerta.setHeaderText("falta algun campo");
			alerta.setContentText("Por Fabor ,las campos que faltan");
			alerta.show();

		} else {

			if (esNumero(txtPrecio.getText())) {
				Videojuego v = new Videojuego(txtNombre.getText(), Float.parseFloat(txtPrecio.getText()),
						cbConsolas.getValue().toString(), cbPEGIs.getValue().hashCode()

				);
				listaVideojuegos.add(v);
				txtNombre.clear();
				txtPrecio.clear();
				cbConsolas.getSelectionModel().clearSelection();
				cbPEGIs.getSelectionModel().clearSelection();
			}

		}

	}

	@FXML
	public void borrarLibro(ActionEvent event) {

		int indiceSeleccionado = tablaVideojuegos.getSelectionModel().getSelectedIndex();

		if (indiceSeleccionado <= -1) {
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setTitle("Error en el Borrado");
			alerta.setHeaderText("No ha seleccionado ningun Videojuego en la tabla para borrar");
			alerta.setContentText("Por favor ,selecciona un Videojuego");
			alerta.show();
		} else {
			tablaVideojuegos.getItems().remove(indiceSeleccionado);
			tablaVideojuegos.getSelectionModel().clearSelection();

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
