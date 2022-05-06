package application;
	

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.Game;
import model.Level;


public class Main extends Application {
  
   
       Game game;
    
    public void start(Stage primaryStage) {
        
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 650, 750);
        scene.setFill(Color.OLDLACE);
       
        game = new Game(Level.MEDIUM);
        
        
        
        /* Menu */
        MenuBar menuBar = new MenuBar();
        Menu menus = new Menu("Menus");
        Menu newGame = new Menu("New Game");
        MenuItem exitApp = new MenuItem("Quit");
        MenuItem easy = new MenuItem("Easy (5x5)");
        MenuItem medium = new MenuItem("Medium (15x15)");
        MenuItem hard = new MenuItem("Hard (25x25)");
        
        newGame.getItems().addAll(easy, medium, hard);
        menus.getItems().addAll(newGame, exitApp);
        menuBar.getMenus().addAll(menus);
        
        easy.setOnAction(new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent t) {
                restartGame(Level.EASY);
            }
        });
        
        medium.setOnAction(new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent t) {
                restartGame(Level.MEDIUM);
            }
        });
        
        hard.setOnAction(new EventHandler<ActionEvent>() { 
            public void handle(ActionEvent t) {
                restartGame(Level.HARD);
            }
        });
        
        exitApp.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                scene.getWindow().hide();
            }
        });
        
        
        
       
        
       
        VBox topVbox = new VBox();
        topVbox.getChildren().add(menuBar);
       
        
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
          public void handle(WindowEvent we) {
           
              System.exit(0);
          }
        });     
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Minesweeper");
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    private void restartGame(Level level) {
        game.restart(level);
       
    }
    
   
        //root.setCenter(grid);
    
}