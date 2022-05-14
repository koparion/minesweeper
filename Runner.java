package application;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Cell;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;


import java.io.IOException;


public class Runner extends Application {

    @Override
    public void start(Stage primaryStage) {
        double sceneWidth = 1024;
        double sceneHeight = 768;
        
        Group head = new Group(); //A Group node contains an ObservableList of children
        // that are rendered in order whenever this node is rendered.
        BorderPane border = new BorderPane(); //instantiate borderpane
        GridPane menu = new GridPane();
        ClockPane clock = new ClockPane();
        clock.setCurrentTime();
   
        Grid newGrid = new Grid();
        head.getChildren().addAll(newGrid.getGroup());
        head.getChildren().addAll(menu);
        head.getChildren().addAll(clock);
        Label center = new Label("MineSweeper!");
        border.setCenter(center); //center text for border label
        border.setTranslateX(100);
        border.setTranslateY(75);
        border.setBackground(new Background(new BackgroundFill(Color.GREY, new CornerRadii(5), Insets.EMPTY))); //set border color
        border.setPrefSize(500, 50);//set border size

        
        

        //head.getChildren().add(border); //add border to the group
        Scene scene = new Scene(head, sceneWidth, sceneHeight);
         
        
        MenuBtn btnR = new MenuBtn("Reset");
        MenuBtn btnL = new MenuBtn("Set Difficulty");
        MenuBtn btnH = new MenuBtn("Hint");
        
        menu.setHgap(20);
        menu.setVgap(20);
        menu.setAlignment(Pos.CENTER);
        menu.setPadding(new Insets(20,20,20,20));
        menu.add(btnR,35,6);
        menu.add(btnL,35,9);
        menu.add(btnH,35,12); 
        menu.add(clock,35,15);
      
       
        scene.setFill(Color.WHITE);
        primaryStage.setTitle("GUI GUI Minesweeper");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}