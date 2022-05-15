package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public abstract class MyNode extends GridPane  { //node for single individual rectangle
	
	
    Rectangle rectangle;
    Label label;
    int num = 0;



    public MyNode( String name, double x, double y, double width, double height) {

        rectangle = new Rectangle( width, height); // new rectangle of x width and y height
        rectangle.setStroke(Color.ALICEBLUE);
        rectangle.setStrokeWidth(3);
        
        rectangle.setFill(Color.SILVER);
        setPadding(new Insets(50,50,50,50));
        setAlignment(Pos.CENTER);
        rectangle.setArcHeight(50);
        rectangle.setArcWidth(50);
        
       //rectangle.setLayoutX(5);
       //rectangle.setLayoutY(5);
     
        
        
        
        label = new Label(name); //label on top of rectangles
        

        // set position
        setTranslateX(x);
        setTranslateY(y);
        
        getChildren().addAll( rectangle);

    }
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
    	this.num = num;
    }

    public MyNode() {
    	 
    }
}