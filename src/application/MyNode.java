package application;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MyNode extends StackPane  { //node for single individual rectangle

    public MyNode( String name, double x, double y, double width, double height) {


        Rectangle rectangle = new Rectangle( width, height); // new rectangle of x width and y height
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(Color.GREY);

        Label label = new Label( name); //label on top of rectangles

        // set position
        setTranslateX(x);
        setTranslateY(y);

        getChildren().addAll( rectangle, label);
        setPadding(new Insets(100, 100, 100, 100)); //50 px padding around layout and windo
    }

}
