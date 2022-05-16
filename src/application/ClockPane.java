package application;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
/**
 * ClockPane inherits Pane
 */
class ClockPane extends Pane{
	int time = 0;
	/**
	 * calls currenttime
	 */
	public ClockPane() {
		setCurrentTime();
	}
	/**
	 * increments time and sets it
	 */
	public void setCurrentTime() {
		time++;
		paintClock();
	}
	/**
	 * sets the colors of the clock
	 */
	protected void paintClock() {
		Label label = new Label(String.valueOf(time));
		label.setTextFill(Color.web("#0076a3"));
		label.setFont(Font.font("Arial", 50));
		getChildren().clear();
		getChildren().add(label);
	}
	/**
	 * @return time
	 */
	public int getTime() {
		return time;
	}
}