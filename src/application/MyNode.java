package application;

import java.io.File;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public abstract class MyNode extends StackPane { // node for single individual rectangle
	Rectangle rectangle;
	Label label;

	public MyNode(String view, double x, double y, double width, double height) {
		
		rectangle = new Rectangle(width, height); // new rectangle of x width and y height
		rectangle.setStroke(Color.WHITE);
		rectangle.setFill(Color.GREY);
				
		label = new Label(view); // label on top of rectangles
			
		// set position
		setTranslateX(x);
		setTranslateY(y);

		getChildren().addAll(rectangle, label);
	}

	public MyNode() {

	}

	public MyNode(MediaView view, double x, double y, double width, double height) {
		// TODO Auto-generated constructor stub
		rectangle = new Rectangle(width, height); // new rectangle of x width and y height
		rectangle.setStroke(Color.WHITE);
		rectangle.setFill(Color.GREY);

		view.setFitWidth(width);
		view.setFitHeight(height);

		// set position
		setTranslateX(x);
		setTranslateY(y);

		getChildren().addAll(rectangle, view);

	}

}
