package application;
	
import java.awt.TextField;

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
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


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
			
//			Button btn1= new Button(" Butón 1 ");
//			Button btn2= new Button(" Butón 2 ");
//			Button btn3= new Button(" Butón 3 ");
//			Button btn4= new Button(" Butón 4 ");
//			
//			GridPane panel =new GridPane();
//			panel.add(btn1, 0, 0);
//			panel.add(btn2, 1, 0);
//			panel.add(btn3, 0, 1);
//			panel.add(btn4, 1, 1);
//			
//			panel.setVgap(15);
//			panel.setHgap(15);
//			panel.setPadding(new Insets(15));
//			Scene scene= new Scene(panel,400,300);
//			
//			primaryStage.setScene(scene);
//			primaryStage.setTitle("Introducion JavaFX");
//			primaryStage.getIcons().add(new Image("/application/icono.png"));
//			primaryStage.show();
		
//		// Ejerccicio  2
//			StackPane panel=new  StackPane();
//			Rectangle rect = new Rectangle(20,20,300,300);
//		    rect.setFill(Color.DARKGREEN);
//		    rect.setLayoutX(0);
//		    rect.setLayoutY(0);
//		    Rectangle rect2 = new Rectangle(20,20,250,250);
//		    rect2.setFill(Color.GREEN);
//		    rect2.setLayoutX(1);
//		    rect2.setLayoutY(1);
//		    Rectangle rect3 = new Rectangle(20,20,200,200);
//		    rect3.setFill(Color.AQUAMARINE);
//		    rect3.setLayoutX(2);
//		    rect3.setLayoutY(2);
//		    
//		    panel.getChildren().addAll(rect,rect2,rect3);
//			Scene scene= new Scene(panel,300,300);
//			primaryStage.setScene(scene);
//			primaryStage.setTitle("Introducion JavaFX");
//			primaryStage.getIcons().add(new Image("/application/icono.png"));
//			primaryStage.show();
		
			
	// ejecicio 3
			
			Button btn1= new Button("1");
			Button btn2= new Button("2");
			Button btn3= new Button("3");
			Button btn4= new Button("4");
			Button btn5= new Button("5");
			Button btn6= new Button("6");
			Button btn7= new Button("7");
			Button btn8= new Button("8");
			Button btn9= new Button("9");
			Button btn0= new Button("0");
			Button btnLlamar= new Button("Llamar");
			Button btnColgar= new Button("Colgar");
			GridPane panel =new GridPane();
			panel.add(btn1, 0, 0);
			panel.add(btn2, 1, 0);
			panel.add(btn3, 2, 0);
			panel.add(btn4, 0, 1);
			panel.add(btn5, 1, 1);
			panel.add(btn6, 2, 1);
			panel.add(btn7, 0, 2);
			panel.add(btn8, 1, 2);
			panel.add(btn9, 2, 2);
			panel.add(btn0, 1, 3);
			panel.add(btnLlamar, 3, 1);
			panel.add(btnColgar, 3, 2);
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
