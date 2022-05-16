package application;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * MenuBtn inherits Button
 */
public class MenuBtn extends Button{
	/**
	 * sets size and color of buttons
	 * @param text
	 */
	 public MenuBtn(String text){
	        setText(text);   
	        setMaxWidth(200);  
	        setMaxHeight(20);  
	        Rectangle rectangle = new Rectangle(300,20); 
	        rectangle.setArcWidth(12);   
	        rectangle.setArcHeight(12);  
	        setShape(rectangle);
	        setFont(Font.font("Times New Roman",FontWeight.BOLD,20)); 
	 
	        setPadding(new Insets(20,20,20,20));
	    }

}
