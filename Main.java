package application;
	

import java.io.IOException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

 
public class Main extends Application{
	 GridPane pane = new GridPane();   //game field
	 GridPane menu = new GridPane();  //menu field
	 Minefield mineField = new  Minefield(10,10,20,400,1);     //mine field
    GridPane ChoosePane = new GridPane();  //difficulty level field
    GridPane CustomPane = new GridPane();  //self-defined pane field
    
    Scene ChooseLevel = new Scene(ChoosePane,400,400);  
    Scene Game = new Scene(pane);  //game scene
    Scene CustomMine = new Scene(CustomPane,400,400);
   /**
   //menu button field
   MenuBt btStar = new MenuBt("play agin");
   MenuBt btChange = new MenuBt("change level");
   MenuBt btHint = new MenuBt("hint");
        
   Scene ChooseLevel = new Scene(ChoosePane,400,400);  
   Scene Game = new Scene(pane);  //game scene
   Scene CustomMine = new Scene(CustomPane,400,400);    //custom pane field**/
   
  
   public void Start(Stage minesweeper) throws IOException {
   	
   	    
       //game field set up
       pane.setHgap(25);  
       pane.setVgap(25);  
       pane.setAlignment(Pos.CENTER_LEFT);
       pane.add(mineField,0,0);  
       pane.add(menu,1,0);  
       
       //menu field set up
       menu.setHgap(20);
       menu.setVgap(20);
       menu.setAlignment(Pos.CENTER);
       menu.setPadding(new Insets(10,10,10,10));
      
     
       
       //custom field set up
       CustomPane.setHgap(25);
       CustomPane.setVgap(25);
       CustomPane.setAlignment(Pos.CENTER);
       CustomPane.setPadding(new Insets(10,10,10,10));         
      
       //level choose field set up
       ChoosePane.setVgap(20);
       ChoosePane.setHgap(20);
       ChoosePane.setAlignment(Pos.CENTER);
       
       minesweeper.setScene(Game);
       minesweeper.setMinWidth(400);        //minimum width
       minesweeper.setResizable(false);     
       minesweeper.setTitle("Minesweeper GUI");
       minesweeper.show();
   }
   
   public static void main(String[] args) {
       
       launch(args);
   }

   
}
