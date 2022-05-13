package application;

import javafx.scene.paint.Color;

public class Bomb extends MyNode {

	public Bomb(String name, double x, double y, double width, double height) {
		super(name, x, y, width, height);
		this.rectangle.setFill(Color.PINK);
	}

	public Bomb() {
		super();
	}

}
