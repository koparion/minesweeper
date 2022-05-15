package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Runner extends Application {

	@Override
	public void start(Stage primaryStage) {
		double sceneWidth =500;
		double sceneHeight = 500;

		Group head = new Group(); // A Group node contains an ObservableList of children
		// that are rendered in order whenever this node is rendered.
		BorderPane border = new BorderPane(); // instantiate borderpane
		Grid newGrid = new Grid();
		HBox box = new HBox(20);
		head.getChildren().addAll(newGrid.getGroup());
		Label center = new Label("MineSweeper!");
		//newGrid.player.play();

		
//		HBox hbox = new HBox(20);
//		hbox.setSpacing(20);
//		center.setAlignment(Pos.CENTER);
		
		border.setCenter(center); // center text for border label
		border.setTranslateX(100);
		border.setTranslateY(75);
		border.setBackground(new Background(new BackgroundFill(Color.OLDLACE, new CornerRadii(5), Insets.EMPTY))); // set
																													// border
																													// color
		border.setPrefSize(500, 25);// set border size

		// head.getChildren().add(border); //add border to the group
		Scene scene = new Scene(head, sceneWidth, sceneHeight);
		scene.setFill(Color.BLUEVIOLET);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}