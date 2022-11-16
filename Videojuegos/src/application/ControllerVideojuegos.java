package application;

import java.awt.TextField;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ControllerVideojuegos {
	
	@FXML
	private TextField textNombre;
	@FXML
	private TextField textPrecio;
	@FXML
	private ChoiceBox menuConsola;
	@FXML
	private ChoiceBox menuPEGI;
	@FXML
	private TableView tableViewVideojuegos;
	@FXML
	private TableColumn colunaNombres;
	@FXML
	private TableColumn columnaPrecios;
	@FXML
	private TableColumn columnaConsolas;
	@FXML
	private TableColumn PEGIs;
	@FXML
	private MenuBar BarraMenu;

//	@FXML
//	private void initialize() {
//	   	 // Lógica a ejecutar en el momento de ejecutarse la ventana
//		
//		ArrayList<String> array1 = new ArrayList<>(
//			   	Arrays.asList("PS4", "Xbox", "NDS"));
//		
//		ObservableList<String> elementos =FXCollections.observableArrayList(array1);
//		
//		ArrayList<String> array2 = new ArrayList<>(
//			   	Arrays.asList("7", "12", "16","18"));
//		
//		ObservableList<String> elementos2 =FXCollections.observableArrayList(array2);
//		
//		
//		menuConsola.setItems(elementos);
//		menuConsola.setItems(elementos2);
//		
//	}

}
	
	
