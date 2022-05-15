package application;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

public class Flag extends Grid implements MouseClick {
	
	
	 if (mineField[i][j] instanceof Bomb) {
		 
	 
	Line flag = new Line(gridHeight/m/2-5,5,gridHeight/m/2-5,gridHeight/m-10);
	Line flag1 = new Line(gridHeight/m/2-5,5,gridHeight/m-5,gridHeight/m/2-5);
	Line flag2 = new Line(gridHeight/m/2-5,gridHeight/m/2-5,gridHeight/m-5,gridHeight/m/2-5);
	
	flag.setStrokeWidth(3);
    flag.setStroke(Color.RED);
    flag1.setStrokeWidth(3);
    flag1.setStroke(Color.RED);
    flag2.setStrokeWidth(3);
    flag2.setStroke(Color.RED);
    Pane tmp1 = new Pane(flag,flag1,flag2);
     add(tmp1,i,j; 
    
    //如果小方块已经打上标记则消除标记
    tmp1.setOnMouseRightClicked(k->{                       	
    	getChildren().remove(tmp1);
    });
	
	
	 } 


