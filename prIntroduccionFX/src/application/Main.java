package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			/*Button btn=new Button("Click aqui");
			btn.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent event) {
					System.out.println("Hola mundo");
				}
			});
			Label lbl= new Label(" ¡ Hola Mundo ! ");
			StackPane panel=new StackPane();
			//panel.getChildren().add(btn);
			panel.setAlignment(lbl,Pos.TOP_CENTER);
			panel.setAlignment(btn,Pos.CENTER);
			panel.getChildren().addAll(lbl,btn);
			*/
		//Vbox
			/*
			Button btn1= new Button(" Butón 1 ");
			Button btn2= new Button(" Butón 2 ");
			Button btn3= new Button(" Butón 3 ");
			
			VBox panel=new VBox(15);
			panel.setPadding(new Insets(15));
			panel.getChildren().addAll(btn1,btn2,btn3);
			
			
			Scene scene= new Scene(panel,400,300);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Introducion JavaFX");
			primaryStage.getIcons().add(new Image("/application/icono.png"));
			primaryStage.show();
			*/
	//Hbox
			/*
			Button btn1= new Button(" Butón 1 ");
			Button btn2= new Button(" Butón 2 ");
			Button btn3= new Button(" Butón 3 ");
			
			HBox panel=new HBox(15);
			panel.setPadding(new Insets(15));
			panel.getChildren().addAll(btn1,btn2,btn3);
			
			
			Scene scene= new Scene(panel,400,300);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Introducion JavaFX");
			primaryStage.getIcons().add(new Image("/application/icono.png"));
			primaryStage.show();
			*/
			
			
	//BORDERPANE
			/*
			Button btn1= new Button(" Butón 1 ");
			Button btn2= new Button(" Butón 2 ");
			Button btn3= new Button(" Butón 3 ");
			
			VBox panelVertical =new VBox(15);
			panelVertical.getChildren().addAll(btn1,btn2,btn3);
			
			BorderPane panel =new BorderPane();
			panel.setRight(panelVertical);
			Scene scene= new Scene(panel,400,300);
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Introducion JavaFX");
			primaryStage.getIcons().add(new Image("/application/icono.png"));
			primaryStage.show();
			*/
	//GridPane
			
			Button btn1= new Button(" Butón 1 ");
			Button btn2= new Button(" Butón 2 ");
			Button btn3= new Button(" Butón 3 ");
			Button btn4= new Button(" Butón 4 ");
			
			GridPane panel =new GridPane();
			panel.add(btn1, 0, 0);
			panel.add(btn2, 1, 0);
			panel.add(btn3, 0, 1);
			panel.add(btn4, 1, 1);
			
			panel.setVgap(15);
			panel.setHgap(15);
			panel.setPadding(new Insets(15));
			Scene scene= new Scene(panel,400,300);
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Introducion JavaFX");
			primaryStage.getIcons().add(new Image("/application/icono.png"));
			primaryStage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
