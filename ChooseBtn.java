package application;

import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ChooseBtn extends Button{

	public ChooseBtn(String str){
        setText(str);  
        setMinWidth(175); 
        setMinHeight(175);  
        setFont(Font.font("Times New Roman",FontWeight.BOLD,20));  
        Rectangle rectangle = new Rectangle(175,175);  
        rectangle.setArcWidth(12);  
        rectangle.setArcHeight(12);  
        setShape(rectangle);
    }
	
	
}
