package com.example.demo;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public abstract class MyNode extends StackPane  { //node for single individual rectangle
    Rectangle rectangle;
    Label label;
    int num = 0;

    public MyNode( String name, double x, double y, double width, double height) {

        rectangle = new Rectangle( width, height); // new rectangle of x width and y height
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(Color.GREY);

        label = new Label(name); //label on top of rectangles

        // set position
        setTranslateX(x);
        setTranslateY(y);

        getChildren().addAll( rectangle, label);

    }
    public int getNum() {
        return num;
    }
    public void setNum(int num){this.num = this.num;
    }
    public MyNode() {

    }

}
