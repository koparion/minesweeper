package application;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
/**
 * Bomb method that inherits myNode 
 */
public class Bomb extends MyNode {
	/**
	 * 
	 * @param view displays
	 * @param x size of row
	 * @param y size of col
	 * @param width size of field
	 * @param height size of field
	 */
	public Bomb(String view, double x, double y, double width, double height) {
		super(view, x, y, width, height);
		this.rectangle.setFill(Color.PINK); // if image doesn't work then will display color
		
		// adding image to bomb
		StackPane pane = new StackPane();
		pane.setStyle("-fx-background-image: url(\"https://c.tenor.com/_bTaLmoLSc4AAAAd/troll-pilled.gif\");"+
	            "-fx-background-size: cover;");
		getChildren().add(pane);

	}
	/**
	 * constructor
	 */
	public Bomb() {
		super();
	}

}
