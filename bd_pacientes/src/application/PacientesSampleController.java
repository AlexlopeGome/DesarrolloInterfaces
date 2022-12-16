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

public class PacientesSampleController {
	@FXML
	private TextField txtNombre;
	@FXML
	private TextField txtApellidoUno;
	@FXML
	private TextField txtApellidoDos;
	@FXML
	private TextField txtEdad;
	@FXML
	private ChoiceBox cbSexos;
	@FXML
	private TextField txtEnfermedad;
	@FXML
	private TextField txtDuracion;
	@FXML
	private ChoiceBox cbdHM;

	@FXML
	private TableView<Paciente> tablaPaciente;
	@FXML
	private Button btnAniadir;

	@FXML
	private Button btnBorrado;

	@FXML
	private TableColumn<Paciente, String> columnaNombre;
	@FXML
	private TableColumn<Paciente, String> columnaApellidoUno;
	@FXML
	private TableColumn<Paciente, String> columnaApellidoDos;
	@FXML
	private TableColumn<Paciente, String> columnaEdad;
	@FXML
	private TableColumn<Paciente, String> columnaSexo;
	@FXML
	private TableColumn<Paciente, String> columnaEnfermedad;
	@FXML
	private TableColumn<Paciente, String> columnaDuracion;
	@FXML
	private TableColumn<Paciente, String> columnadHM;
	
	public ObservableList<String> listaSexos = FXCollections.observableArrayList("Hombre", "Mujer", "Niño", "Ancian@",
			"Otro");

	public ObservableList<String> ListadHM = FXCollections.observableArrayList("dias", "horas", "meses");

	private ObservableList<Paciente> listaPacientes = FXCollections.observableArrayList();
	
	@FXML
	private void initialize() {

		cbSexos.setItems(listaSexos);
		cbdHM.setItems(ListadHM);
		columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		columnaApellidoUno.setCellValueFactory(new PropertyValueFactory<>("apellidoUno"));
		columnaApellidoDos.setCellValueFactory(new PropertyValueFactory<>("apellidoDos"));
		columnaEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));
		columnaSexo.setCellValueFactory(new PropertyValueFactory<>("sexo"));
		columnaEnfermedad.setCellValueFactory(new PropertyValueFactory<>("enfermedad"));
		columnaDuracion.setCellValueFactory(new PropertyValueFactory<>("duracion"));
		columnadHM.setCellValueFactory(new PropertyValueFactory<>("dHM"));
		 ObservableList listaPacientesBd = getPacientesBD();
		 tablaPaciente.setItems(listaPacientesBd);
	}
	
	private ObservableList<Paciente> getPacientesBD() {

		ObservableList<Paciente> listaPacientesBd =
				FXCollections.observableArrayList();

		DatabaseConnection dbConection = new DatabaseConnection();
		Connection connection = dbConection.getConnection();

		try {
			String query = "select * from pacientes";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				Paciente paciente = new Paciente(
						rs.getInt("id"),
						rs.getString("nombre"),
						rs.getString("apellidoUno"), 
						rs.getString("apellidoDos"), 
						rs.getInt("edad"),
						rs.getString("sexo"), 
						rs.getString("enfermedad"),
						rs.getInt("duracion"),
						rs.getString("dHM")
				);
				listaPacientesBd.add(paciente);

			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaPacientesBd;
	}
	
	
	@FXML
	public void aniadirPaciente(ActionEvent event) {

		DatabaseConnection dbConection = new DatabaseConnection();
		Connection connection = dbConection.getConnection();

		if (txtNombre.getText().isEmpty() ||txtApellidoUno.getText().isEmpty() ||txtApellidoDos.getText().isEmpty() 
				|| txtEdad.getText().isEmpty() || cbSexos.getSelectionModel().isEmpty()|| txtEnfermedad.getText().isEmpty()
				|| txtDuracion.getText().isEmpty() || cbdHM.getSelectionModel().isEmpty()) {

			Alert alerta = new Alert(AlertType.WARNING);
			alerta.setTitle("Error al Insertar");
			alerta.setHeaderText("Falta algun campo");
			alerta.setContentText("Por Fabor , inserta las campos que faltan");
			alerta.show();

		} else {

			if (esNumero(txtEdad.getText())||esNumero(txtDuracion.getText())) {
				Paciente p = new Paciente(txtNombre.getText(),txtApellidoUno.getText(),txtApellidoDos.getText(), 
						Integer.parseInt(txtEdad.getText()),cbSexos.getValue().toString(),txtEnfermedad.getText(),
						Integer.parseInt(txtDuracion.getText()),cbdHM.getValue().toString()

				);
				listaPacientes.add(p);
				txtNombre.clear();
				txtApellidoUno.clear();
				txtApellidoDos.clear();
				txtEdad.clear();
				cbSexos.getSelectionModel().clearSelection();
				txtEnfermedad.clear();
				txtDuracion.clear();
				cbdHM.getSelectionModel().clearSelection();

				try {
				String query = "insert into pacientes" 
							+"(nombre,apellidoUno,apellidoDos,edad,sexo,enfermedad,duracion,dHM)" 
							+ "VALUES(?,?,?,?,?,?,?,?)";

					PreparedStatement ps = connection.prepareStatement(query);
					ps.setString(1, p.getNombre());
					ps.setString(2, p.getApellidoUno());
					ps.setString(3, p.getApellidoDos());
					ps.setInt(4, p.getEdad());
					ps.setString(5, p.getSexo());
					ps.setString(6, p.getEnfermedad());
					ps.setInt(7, p.getDuracion());
					ps.setString(8, p.getDHM());
					ps.executeUpdate();

					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				ObservableList listaPacientesBD = getPacientesBD();
				tablaPaciente.setItems(listaPacientesBD);

			} else {

				Alert alerta = new Alert(AlertType.WARNING);
				alerta.setTitle("Error al Insertar");
				alerta.setHeaderText("falta algun campo");
				alerta.setContentText("Por Fabor ,Inserta las campos que faltan");
				alerta.show();
			}

		}

	}
	
	
	@FXML
	public void borrarPaciente(ActionEvent event) {

		int indiceSeleccionado = tablaPaciente.getSelectionModel().getSelectedIndex();

		if (indiceSeleccionado <= -1) {
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setTitle("Error en el Borrado");
			alerta.setHeaderText("No ha seleccionado ningun Videojuego en la tabla para borrar");
			alerta.setContentText("Por favor ,selecciona un Videojuego");
			alerta.show();
		} else {

			DatabaseConnection dbConection = new DatabaseConnection();
			Connection connection = dbConection.getConnection();

			try {

				String query = "delete from pacientes where id = ?";
				PreparedStatement ps = connection.prepareStatement(query);
				Paciente pacientes=tablaPaciente.getSelectionModel().getSelectedItem();
				ps.setInt(1,pacientes.getId());
				ps.executeUpdate();

				tablaPaciente.getSelectionModel().clearSelection();
				ObservableList listaVideojuegosBD = getPacientesBD();

				tablaPaciente.getItems().remove(indiceSeleccionado);

				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

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
