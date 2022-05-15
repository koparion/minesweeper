package application;

import javafx.scene.layout.StackPane;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;

public class Bomb extends MyNode {

	public Bomb(MediaView view, double x, double y, double width, double height) {
		super(view, x, y, width, height);
		this.rectangle.setFill(Color.PINK);
		
		StackPane pane = new StackPane();
		pane.setStyle("-fx-background-image: url(\"https://c.tenor.com/_bTaLmoLSc4AAAAd/troll-pilled.gif\");"+
	            "-fx-background-size: cover;");
		getChildren().add(pane);

	}

	public Bomb() {
		super();
	}

}
