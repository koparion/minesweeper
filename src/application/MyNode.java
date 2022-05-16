package application;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Abstract class MyNode inheriting StackPane
 */
public abstract class MyNode extends StackPane  { //node for single individual rectangle
    Rectangle rectangle; // rectangle object
    Label label; // label object
    int num = 0; // initialize num to zero
/**
 * 
 * @param name string for number
 * @param x position
 * @param y position
 * @param width size
 * @param height size
 */
    public MyNode( String name, double x, double y, double width, double height) {

        rectangle = new Rectangle( width, height); // new rectangle of x width and y height
		rectangle.setStroke(Color.WHITE);
        rectangle.setFill(Color.GREY);
       
        label = new Label(name); //label on top of rectangles

        label.setTextFill(Color.WHITE);
        // set position
        setTranslateX(x);
        setTranslateY(y);
       
        getChildren().addAll(rectangle,label);

    }
    /**
     * 
     * @return num
     */
    public int getNum() {
        return num;
    }
    /**
     * 
     * @param num sets num
     */
    public void setNum(int num){this.num = this.num;
    }
    public MyNode() {

    }

}

