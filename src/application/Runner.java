package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Cell;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import java.io.IOException;

public class Runner extends Application {

    @Override
    public void start(Stage primaryStage) {
        double sceneWidth = 1024;
        double sceneHeight = 768;
        
        Group head = new Group(); //A Group node contains an ObservableList of children
        // that are rendered in order whenever this node is rendered.
        BorderPane border = new BorderPane(); //instantiate borderpane
        Grid newGrid = new Grid();

        Label center = new Label("MineSweeper!");
        border.setCenter(center); //center text for border label
        border.setTranslateX(100);
        border.setTranslateY(75);
        border.setBackground(new Background(new BackgroundFill(Color.OLDLACE, new CornerRadii(5), Insets.EMPTY))); //set border color
        border.setPrefSize(500, 25);//set border size


        head.getChildren().addAll(newGrid.getGroup());

        head.getChildren().add(border); //add border to the group
        Scene scene = new Scene(head, sceneWidth, sceneHeight);

        scene.setFill(Color.BLACK);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}