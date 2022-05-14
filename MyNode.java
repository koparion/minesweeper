package application;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public abstract class MyNode extends GridPane  { //node for single individual rectangle
	
	
    Rectangle rectangle;
    Label label;


    public MyNode( String name, double x, double y, double width, double height) {

        rectangle = new Rectangle( width, height); // new rectangle of x width and y height
        rectangle.setStroke(Color.rgb(175,175,175));
        rectangle.setStrokeWidth(3);
        
        rectangle.setFill(Color.rgb(122,197,205));
        setPadding(new Insets(50,50,50,50));
        setAlignment(Pos.CENTER);
        rectangle.setArcHeight(40);
        rectangle.setArcWidth(40);
       
       // rectangle.setLayoutX(5);
        //rectangle.setLayoutY(5);
     

        
        
        label = new Label(name); //label on top of rectangles
        

        // set position
        setTranslateX(x);
        setTranslateY(y);

        getChildren().addAll( rectangle, label);

    }


    public MyNode() {
    	 
    }
}