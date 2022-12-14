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
			.observableArrayList();

	public ObservableList<String> listaEditoriales = FXCollections.observableArrayList("Planeta", 
			"Altaya", 
			"Kadokawa",
			"Penguin Libros");

	@FXML
	private void initialize() {

		cbEditorial.setItems(listaEditoriales);

		columnTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
		columnEditorial.setCellValueFactory(new PropertyValueFactory<>("editorial"));
		columnAutor.setCellValueFactory(new PropertyValueFactory<>("autor"));
		columnPaginas.setCellValueFactory(new PropertyValueFactory<>("paginas"));
		ObservableList listaLibrosBD = getLibrosBd ();
		tableLibros.setItems(listaLibrosBD);
		
		
	}
	
	private ObservableList<Libro>getLibrosBd(){
		
		ObservableList<Libro>listaLibrosBd=
				 FXCollections.observableArrayList();
		
		DatabaseConnection dbConection= new DatabaseConnection ();
		Connection connection=dbConection.getConnection();
		

		try {
			String query="select * from libros";
			PreparedStatement ps= connection.prepareStatement(query);
			ResultSet rs =ps.executeQuery();
			while(rs.next()) {
				
				Libro libro =new Libro(
						rs.getInt("id"),
						rs.getString("titulo"),
						rs.getString("editorial"),
						rs.getString("autor"),
						rs.getInt("paginas")
	
						);
				listaLibrosBd.add(libro);
						
				
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				 
		return listaLibrosBd;
	}

	@FXML
	public void aniadirLibro(ActionEvent event) {
		DatabaseConnection dbConection= new DatabaseConnection ();
		Connection connection=dbConection.getConnection();
		
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
				
				try {
				String query = "insert into libros"
						+"(titulo,editorial,autor,paginas)"
						+"VALUES(?,?,?,?)";
				
				PreparedStatement ps= connection.prepareStatement(query);
					ps.setString(1, l.getTitulo());
					ps.setString(2, l.getEditorial());
					ps.setString(3,l.getAutor());
					ps.setInt(4,l.getPaginas());
					ps.executeUpdate();
					
					
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				ObservableList listaLibrosBD = getLibrosBd ();
				tableLibros.setItems(listaLibrosBD);
				
				
				
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
		
		if (indiceSeleccionado <= -1) {
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setTitle("Error en el Borrado");
			alerta.setHeaderText("No ha seleccionado ningun Libro en la tabla para borrar");
			alerta.setContentText("Por faVor ,selecciona un Libro");
			alerta.show();
			
			
		} else {

			DatabaseConnection dbConection= new DatabaseConnection ();
			Connection connection=dbConection.getConnection();
			
			try {
				
				String query = "delete from libros where id = ?";
				PreparedStatement ps= connection.prepareStatement(query);
				Libro libro=tableLibros.getSelectionModel().getSelectedItem();
				ps.setInt(1,libro.getId());
				ps.executeUpdate();
				
				tableLibros.getSelectionModel().clearSelection();
				
				ObservableList listaLibrosBD = getLibrosBd ();
				tableLibros.getItems().remove(indiceSeleccionado);
				
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
