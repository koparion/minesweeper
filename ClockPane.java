package application;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

class ClockPane extends Pane{
	int time = 0;
	
	public ClockPane() {
		setCurrentTime();
	}
	
	public void setCurrentTime() {
		time++;
		paintClock();
	}
	
	protected void paintClock() {
		Label label = new Label(String.valueOf(time));
		label.setTextFill(Color.web("#0076a3"));
		label.setFont(Font.font("Arial", 50));
		getChildren().clear();
		getChildren().add(label);
	}
	
	public int getTime() {
		return time;
	}
}