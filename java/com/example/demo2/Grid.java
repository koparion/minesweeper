package com.example.demo2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Cell;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import java.io.IOException;

public class Grid extends Application {

    Stage window;
    @Override
    public void start(Stage primaryStage) throws IOException {
        window = primaryStage;
        window.setTitle("Our Project!");

        int x = 10;
        int y = 10;
        Box [][]cells = new int[x][y];

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(30, 30, 30, 30)); //10 px padding around layout and window
        grid.setVgap(1); //individual cells themselves
        grid.setHgap(1); //individual cells themselves




        for(int i=0; i<10; i++){
            Rectangle rectangle = new Rectangle(10, 10);
            rectangle.setStroke(Color.BLACK);
            rectangle.setFill(Color.LIGHTBLUE);
            GridPane.setConstraints(rectangle, i, 0);
            grid.getChildren().add(rectangle);
            for(int p =0; p<10; p++){
                Rectangle rectangle2 = new Rectangle(10, 10);
                rectangle2.setStroke(Color.BLACK);
                rectangle2.setFill(Color.LIGHTBLUE);
                GridPane.setConstraints(rectangle2, p, i);

                grid.getChildren().add(rectangle2);
            }

        }



        Scene scene = new Scene(grid, 500, 700); //creates the scene, parameters are what you wanna show.
        window.setScene(scene); //sets the scene for the window to display;







        window.show();

    }

    public static void main(String[] args) {
        launch();
    }
}