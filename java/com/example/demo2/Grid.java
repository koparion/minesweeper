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

public class Grid implements MouseClick{


    double sceneWidth = 1024;
    double sceneHeight = 768;

    int n = 10;
    int m = 10;

    double gridWidth = sceneWidth / n;
    double gridHeight = sceneHeight / m;

    MyNode[][] mineField = new MyNode[n][m]; //minefield of nodes.

    private Group head = new Group(); //A Group node contains an ObservableList of children
    // that are rendered in order whenever this node is rendered.

    public MyNode getNode(int n, int j) { //get specific node n, j
        return mineField[n][j];
    }

    @Override
    public void revealOnClick(MyNode bomb, MyNode blank, Group group) { //event handler
        blank.setOnMousePressed(event -> {
            group.getChildren().remove(blank);
            group.getChildren().add(bomb);
        });
    }

    // initialize mineField
    public Grid() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // create node
                Blank node = new Blank( "Item " + i + "/" + j, i * gridWidth, j * gridHeight, gridWidth, gridHeight);
                Bomb bomb = new Bomb( "Im a bomb", i * gridWidth, j * gridHeight, gridWidth, gridHeight);
                int finalI = i;
                int finalJ = j;
                this.revealOnClick(bomb, node, head); //call event handler

                // add node to group
                head.getChildren().add(node);

                // add to minefield for further reference using an array
                mineField[i][j] = node;

            }

        }

    }




    public Group getGroup() { //return head to be used in runner
        return head;
    }
}



