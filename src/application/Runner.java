package application;


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
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Runner extends Application {

    @Override
    public void start(Stage primaryStage) {
        double sceneWidth = 1024;
        double sceneHeight = 768;
      
        Group head = new Group(); //A Group node contains an ObservableList of children
        // that are rendered in order whenever this node is rendered.
        BorderPane border = new BorderPane(); //instantiate borderpane
        GridPane menu = new GridPane();
       
        GridPane LevelPane = new GridPane();  //set difficulty
        GridPane CustomPane = new GridPane();  // custom pane by player
        
        ClockPane clock = new ClockPane();
        EventHandler<ActionEvent> eventHandler = e ->{
    		clock.setCurrentTime();
    	};
    	Timeline animation = new Timeline(
    			new KeyFrame(Duration.millis(1000),eventHandler));
    	
        animation.setCycleCount(Animation.INDEFINITE);  
        animation.play(); 
   
        Grid newGrid = new Grid();
        
        head.getChildren().addAll(newGrid.getGroup());
        head.getChildren().addAll(menu);
        head.getChildren().addAll(clock);
        
        Label center = new Label("MineSweeper!");
        border.setCenter(center); //center text for border label
        border.setTranslateX(100);
        border.setTranslateY(75);
        border.setBackground(new Background(new BackgroundFill(Color.HONEYDEW, new CornerRadii(5), Insets.EMPTY))); //set border color
        border.setPrefSize(500, 50);//set border size

        
        

        //head.getChildren().add(border); //add border to the group
        Scene scene = new Scene(head, sceneWidth, sceneHeight);
        Scene setLevel = new Scene(LevelPane,600,600); 
        Scene CustomGame = new Scene(CustomPane,600,600);  
        
        
        MenuBtn btnR = new MenuBtn("Reset");
        MenuBtn btnL = new MenuBtn("Set Difficulty");
        MenuBtn btnH = new MenuBtn("Hint");
        
        
        
        btnR.setOnMouseClicked(e->{    //when mouse clicked, game restart   
        	head.getChildren().remove(newGrid);
        	
            menu.getChildren().remove(clock);
            
            menu.add(clock,35,15);
        });
        
        
        ChooseBtn easy = new ChooseBtn("  EASY ");
        ChooseBtn medium = new ChooseBtn(" MEDIUM ");
        ChooseBtn hard = new ChooseBtn("  HARD ");
        ChooseBtn custom = new ChooseBtn("CUSTOM");
        
        btnL.setOnMouseClicked(e-> primaryStage.setScene(setLevel));
        
        easy.setOnMouseClicked(e->{   //easy Level
        	
        	head.getChildren().remove(newGrid);
            menu.getChildren().remove(clock);
            Grid easyGrid = new Grid ();
            head.getChildren().addAll(easyGrid.getGroup());
            primaryStage.setScene(scene);
            menu.add(clock,35,15);
            });
            
            medium.setOnMouseClicked(e->{   
            	head.getChildren().remove(newGrid);
            menu.getChildren().remove(clock);
           
            primaryStage.setScene(scene);
            menu.add(clock,35,15);
            });
           
            hard.setOnMouseClicked(e->{   
            	head.getChildren().remove(newGrid);
            menu.getChildren().remove(clock);
            Grid hardGrid = new Grid(30.0,20.0,100.0,400.0);
            head.getChildren().addAll(hardGrid.getGroup());
            primaryStage.setScene(scene);
            menu.add(clock,35,15);
            });
            
            btnH.setOnMouseClicked(e->{  
            	newGrid.bombHint(1, 1);
            });
            
            
            
            MenuBtn btnCustom = new MenuBtn("PLAY");    
            Label label1 = new Label("Widths： ");
            Label label2 = new Label("Heights： ");
            Label label3 = new Label("Bombs ：  ");
            
            TextField MapWidth = new TextField("");
            TextField MapHeight = new TextField("");
            TextField MineNum = new TextField("");
            
            custom.setOnMouseClicked(e-> primaryStage.setScene(CustomGame));    //选择自定义难度则进入自定义区
            btnCustom.setOnMouseClicked(e->{
            	head.getChildren().remove(newGrid);
            	menu.getChildren().remove(clock);
            	
             Grid customeGrid= new Grid (Integer.parseInt(MapWidth.getText()),Integer.parseInt(MapHeight.getText()),Integer.parseInt(MineNum.getText()),400);
            	head.getChildren().addAll(customeGrid.getGroup());
            	
             
             
             primaryStage.setScene(scene);
            	menu.add(clock,35,15);
            });
            
        //set up the menu area
        menu.setHgap(20);
        menu.setVgap(20);
        menu.setAlignment(Pos.CENTER);
        menu.setPadding(new Insets(20,20,20,20));
        menu.add(btnR,35,6);
        menu.add(btnL,35,9);
        menu.add(btnH,35,12); 
        menu.add(clock,35,15);
        
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
        
        
        TextField Width = new TextField("");
        TextField Height = new TextField("");
        TextField BombNum = new TextField("");
        
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
       
       
        scene.setFill(Color.ALICEBLUE);
        primaryStage.setTitle("GUI GUI Minesweeper");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}