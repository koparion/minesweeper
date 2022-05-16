package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Runner extends Application {

    @Override
    public void start(Stage primaryStage) {
        /**
         * declaring scene size
         */
    	double sceneWidth = 1250;
        double sceneHeight = 800;
        
        /**
         * initializing objects
         */
        Group head = new Group(); //A Group node contains an ObservableList of children
        // that are rendered in order whenever this node is rendered.
        BorderPane border = new BorderPane(); //instantiate borderpane
        Grid newGrid = new Grid();
     
        /**
         * adding group to grid
         */
        head.getChildren().addAll(newGrid.getGroup());
        
        /**
         * initialzing GridPane
         */
        GridPane menu = new GridPane();
        GridPane LevelPane = new GridPane();  //set difficulty
        GridPane CustomPane = new GridPane();  // custom pane by player
        
        /**
         * adding Clock object and event
         */
        ClockPane clock = new ClockPane();
        EventHandler<ActionEvent> eventHandler = e ->{
    		clock.setCurrentTime();
    	};
        
    	/**
    	 * adding clock animation
    	 */
    	Timeline animation = new Timeline(
    			new KeyFrame(Duration.millis(1000),eventHandler));
        animation.setCycleCount(Animation.INDEFINITE);  
        animation.play(); 
    	
        //head.getChildren().addAll(newGrid.getGroup());
        head.getChildren().addAll(menu);
        head.getChildren().addAll(clock);
        
        /**
         * creating label and centering
         */
        Label label = new Label("Avoid The Troll!");
        label.setTextFill(Color.BLACK);
        label.setFont(new Font("18thCentury", 40));
    
//		head.setStyle("-fx-background-image: url(\"https://i.ibb.co/bvRZf1h/title.png\");"+
//	            "-fx-background-size: cover;");
//      
//        head.getChildren().add(label); 
  
        /**
         * Setting the position
         * border
         */
        border.setCenter(label); //center text for border label
        border.setTranslateX(100);
        border.setTranslateY(75);
        border.setBackground(new Background(new BackgroundFill(Color.HONEYDEW, new CornerRadii(5), Insets.EMPTY))); //set border color
        border.setPrefSize(400, 50);//set border size

        /**
         * setting the scene
         */
        //head.getChildren().add(border); //add border to the group
        Scene scene = new Scene(head, sceneWidth, sceneHeight);
        Scene setLevel = new Scene(LevelPane,sceneWidth,sceneHeight); 
        Scene CustomGame = new Scene(CustomPane,sceneWidth,sceneHeight);  
        
        /**
         * creating menu buttons
         */
        MenuBtn btnR = new MenuBtn("Reset");
        MenuBtn btnL = new MenuBtn("Set Difficulty");
        MenuBtn btnH = new MenuBtn("Hint");
        
        /**
         * set difficulty button
         */
        btnL.setOnMouseClicked(e-> primaryStage.setScene(setLevel));
        
        /*
         * reset button
         */
        btnR.setOnMouseClicked(e->{    //when mouse clicked, game restart   
        	head.getChildren().clear();
            menu.getChildren().remove(clock);
            menu.add(clock,25,15);
            head.getChildren().addAll(menu);
            head.getChildren().addAll(clock);
            head.getChildren().addAll(newGrid.getGroup());
            animation.setCycleCount(Animation.INDEFINITE);  
            animation.play(); 
        });
        /**
         *  easy setting
         */
        ChooseBtn easy = new ChooseBtn("  EASY ");
        	easy.setOnMouseClicked(e->{   //easy Level
        	head.getChildren().remove(newGrid);
            menu.getChildren().remove(clock);
            Grid easyGrid = new Grid ();
            head.getChildren().addAll(easyGrid.getGroup());
            primaryStage.setScene(scene);
            menu.add(clock,25,15);
            });
            btnH.setOnMouseClicked(e->{  
            	newGrid.bombHint(1, 1);
            });
        /**
         *  medium setting
         */
        ChooseBtn medium = new ChooseBtn(" MEDIUM ");
	        medium.setOnMouseClicked(e->{   
	        	head.getChildren().remove(newGrid);
	        menu.getChildren().remove(clock);
	       
	        primaryStage.setScene(scene);
	        menu.add(clock,25,15);
	        });
	    /**
	     *  hard setting
	     */
        ChooseBtn hard = new ChooseBtn("  HARD ");
	        hard.setOnMouseClicked(e->{ 
	        	head.getChildren().clear();
	        	//head.getChildren().remove(newGrid);
	        	head.getChildren().addAll(menu);
	            head.getChildren().addAll(clock);
	            head.getChildren().addAll(newGrid.getGroup());
	        menu.getChildren().remove(clock);
	        Grid hardGrid = new Grid(9,9);
	        head.getChildren().addAll(hardGrid.getGroup());
	        primaryStage.setScene(scene);
	        menu.add(clock,25,15);
	        });
	    
	    /**
	     * custom setting
	     */
        ChooseBtn custom = new ChooseBtn("CUSTOM");
	        MenuBtn btnCustom = new MenuBtn("PLAY");    
	        Label label1 = new Label("Widths ");
	        Label label2 = new Label("Heights ");
	        Label label3 = new Label("Bombs   ");
		        
	        TextField MapWidth = new TextField("");
	        TextField MapHeight = new TextField("");
	        TextField MineNum = new TextField("");
        /**
         * custom button event
         */
        custom.setOnMouseClicked(e-> primaryStage.setScene(CustomGame)); 
        btnCustom.setOnMouseClicked(e->{
        	head.getChildren().remove(newGrid);
        	menu.getChildren().remove(clock);
        	
         Grid customGrid= new Grid (Integer.parseInt(MapWidth.getText()),Integer.parseInt(MapHeight.getText()));
        	head.getChildren().addAll(customGrid.getGroup());
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setScene(scene);
    	menu.add(clock,35,15);
        });
	        
	/**
	 * set up the menu area
	 */
        menu.setHgap(20);
        menu.setVgap(20);
        menu.setAlignment(Pos.CENTER);
        menu.setPadding(new Insets(20,20,20,20));
        menu.add(label, 25, 3);
        menu.add(btnR,25,6);
        menu.add(btnL,25,9);
        menu.add(btnH,25,12); 
        menu.add(clock,25,15);

        //clock.setFont(new Font(16));
		//clock.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
      
        //set up the levelpane 
        LevelPane.setVgap(10);
        LevelPane.setHgap(10);
        LevelPane.setAlignment(Pos.CENTER);
        
        //positions of different levels
        LevelPane.add(easy,0,0);
        LevelPane.add(medium,1,0);
        LevelPane.add(hard,0,1);
        LevelPane.add(custom,1,1);
        /**
         * textfield to add values
         */
        TextField Width = new TextField("");
        TextField Height = new TextField("");
        TextField BombNum = new TextField("");
        /**
         * adding buttons to custom fields
         */
        CustomPane.setHgap(25);
        CustomPane.setVgap(25);
        CustomPane.setAlignment(Pos.CENTER);
        CustomPane.setPadding(new Insets(10,10,10,10));         
        CustomPane.add(label1,0,1);
        CustomPane.add(Width,1, 1);
        CustomPane.add(label2,0,3);
        CustomPane.add(Height,1,3);
        CustomPane.add(label3,0,5);
        CustomPane.add(BombNum,1,5);
        CustomPane.add(btnCustom,0,7); 
       
        
        /**
         * save function
         */
	      //  ImageView imgView = new ImageView("UIControls/Save.png");
	       // imgView.setFitWidth(20);
	      //  imgView.setFitHeight(20);
        MenuBtn saveBTN = new MenuBtn("Save Game");
        saveBTN.setOnMouseClicked(event->{    
	       // Menu file = new Menu("File");
	       // MenuItem item = new MenuItem("Save");
//        	FileChooser fileChooser = new FileChooser();
//        	File file = fileChooser.showSaveDialog(new Stage());
//	        //Creating a File chooser
//	        fileChooser.setTitle("Save");
//	        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("All Files", "*.*"));
//	        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
	        try {
				ObjectOutputStream out = new ObjectOutputStream(
						new FileOutputStream("game.obj"));
				//Write our data
				out.writeObject(primaryStage);
				out.close();
			} catch (Exception e) {
				System.out.println("Something happened when writing to file.");
				e.printStackTrace();
			}
	        //Adding action on the menu item
//	        saveBTN.setOnAction(new EventHandler<ActionEvent>() {
//	           public void handle(ActionEvent event) {
//	              //Opening a dialog box   
////	              fileChooser.showSaveDialog(primaryStage);
//	           }
//	        });
	        primaryStage.setTitle("File Chooser Example");
        });
	        
	        /**
	         * save button
	         */
	    menu.add(saveBTN,10,18); 
	    
	    /**
	     * loading function
	     */
	    MenuBtn loadBTN = new MenuBtn("Load Game");
	    	loadBTN.setOnMouseClicked(event ->{
	    		FileChooser fileChooser = new FileChooser();
	        	File file = fileChooser.showSaveDialog(new Stage());
	
		        //Creating a File chooser
		        fileChooser.setTitle("Load");
		        fileChooser.getExtensionFilters().addAll(new ExtensionFilter("All Files", "*.*"));
		        //Adding action on the menu item
		        loadBTN.setOnAction(new EventHandler<ActionEvent>() {
		           public void handle(ActionEvent event) {
		              //Opening a dialog box   
		              fileChooser.showSaveDialog(primaryStage);
		           }
		        });
	    	});
		  /**
		   * load button      
		   */
		  menu.add(loadBTN, 15, 18);
		  /**
		   * exit function
		   */
		  MenuBtn exitBTN = new MenuBtn("Exit Game");
		  	exitBTN.setOnMouseClicked(event -> {
		  		System.exit(0);
		  	});
		  	menu.add(exitBTN,20, 18);
	    
	    /**
	     * set the scene color
	     */
        scene.setFill(Color.ALICEBLUE);
        /**
         * Load the Scene
         */
        primaryStage.setTitle("GUI GUI Minesweeper");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);        
    }

}