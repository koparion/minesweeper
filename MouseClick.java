package application;

import javafx.scene.Group;

public interface MouseClick {
	public void revealOnClick(MyNode blank, Group group, int i, int j);
	//public void flag(MyNode node);
	public void setOnMouseClicked(MyNode blank, Group group, int i, int j);
	public void setOnMouseRightClicked(MyNode blank, Group group, int i, int j);
	
}