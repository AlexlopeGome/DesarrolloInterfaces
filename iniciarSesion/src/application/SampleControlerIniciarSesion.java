package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SampleControlerIniciarSesion {
	
	@FXML
	private TextField textNombre;
	@FXML
	private TextField textContrasenia;
	@FXML
	private Button btnEnviar;
	@FXML
	private Label lblRespuesta;
	
	@FXML
	public void mostrarMensaje (ActionEvent event) {
		lblRespuesta.setText("Bienbenido "+textNombre.getText());
		textNombre.setText(null);
		textContrasenia.setText(null);
	}
}
