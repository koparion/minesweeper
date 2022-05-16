package application;

import javafx.scene.paint.Color;

/**
 * Number inherits myNode
 */
public class Number extends MyNode {

	private int num;
	/**
	 * sets the colors and inherits from myNode
	 * @param name string for number
	 * @param x position
	 * @param y position
	 * @param width size
	 * @param height size
	 * @param num to display
	 */
	public Number(String name, double x, double y, double width, double height, int num) {
		super(name, x, y, width, height);
		this.num = num;
		this.rectangle.setFill(Color.BLUE);
		this.rectangle.setStroke(Color.WHITE);
		this.label.setTextFill(Color.WHITE);
		//this.rectangle.setStyle("-fx-text-color: white");    
		//this.rectangle.setEffect(glow);
	}

	/**
	 * constructor
	 */
	public Number() {
		super();
	}
	/**
	 * @return num
	 */
	public int getNum() {
		return num;
	}
	/**
	 * @param sets num
	 */
	public void setNum(int num) {
		this.num = num;
	}
}
