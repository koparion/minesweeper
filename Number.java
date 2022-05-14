package application;

import javafx.scene.paint.Color;

public class Number extends MyNode{

    private int num;

    public Number(String name, double x, double y, double width, double height, int num){
        super(name, x, y, width, height);
        this.num = num;
        this.rectangle.setFill(Color.BLUE);
    }
    public Number(){
        super();
    }


    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}