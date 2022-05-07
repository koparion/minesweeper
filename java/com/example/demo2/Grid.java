package com.example.demo2;

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

public class Grid extends Application {


    double sceneWidth = 1024;
    double sceneHeight = 768;

    private int n = 10;
    private int m = 10;

    double gridWidth = 50;//adjust width of actual minefield
    double gridHeight = 50; //adjust height of actual minefield

    MyNode[][] mineField = new MyNode[n][m];

    @Override
    public void start(Stage primaryStage) {

        Group head = new Group(); //A Group node contains an ObservableList of children
                                  // that are rendered in order whenever this node is rendered.
        BorderPane border = new BorderPane(); //instantiate borderpane

        Label center = new Label("MineSweeper!");
        border.setCenter(center); //center text for border label
        border.setTranslateX(100);
        border.setTranslateY(75);
        border.setBackground(new Background(new BackgroundFill(Color.OLDLACE, new CornerRadii(5), Insets.EMPTY))); //set border color
        border.setPrefSize(500, 25);//set border size


        // initialize mineField
        for( int i=0; i < n; i++) {
            for( int j=0; j < m; j++) {

                // create node
                MyNode node = new MyNode("Item " + i + "/" + j, i * 50, j * 50, gridWidth, gridHeight);

                // add node to group
                head.getChildren().add(node);

                // add to minefield for further reference using an array
                mineField[i][j] = node;

            }

        }

        head.getChildren().add(border); //add border to the group

        Scene scene = new Scene(head, sceneWidth, sceneHeight);

        scene.setFill(Color.BLUEVIOLET);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}