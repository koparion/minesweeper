package application;

import java.io.File;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;

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
