package application;

import javafx.scene.Group;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Grid implements MouseClick {
	//File troll = new File("src/application/troll-pilled.mp4");
	//File troll = new File("https://c.tenor.com/_bTaLmoLSc4AAAAd/troll-pilled.gif");
    //Media media = new Media(troll.toURI().toString());
    Media media = new Media("https://c.tenor.com/_bTaLmoLSc4AAAAd/troll-pilled.gif");
    MediaPlayer player = new MediaPlayer(media);
    MediaView view = new MediaView(player);
    
	
    
//    Image img = new Image("https://c.tenor.com/_bTaLmoLSc4AAAAd/troll-pilled.gif");
//	ImageView imageView = new ImageView(img);
//		
	double sceneWidth = 500;
	double sceneHeight = 500;

	int n = 10; // controlls size of the board
	int m = 10; // controlls size of the board
	int num = 0; // used for displaying num on Numbers

	double gridWidth = (sceneWidth -n )/ n;
	double gridHeight = (sceneHeight -m) / m;

	MyNode[][] mineField = new MyNode[n][m]; // minefield of nodes.

	private Group head = new Group(); // A Group node contains an ObservableList of children
	// that are rendered in order whenever this node is rendered.

	public MyNode getNode(int n, int j) { // get specific node n, j
		return mineField[n][j];
	}

	public void reveal(Group group, Blank blank) {
		group.getChildren().remove(blank); // remove blank for appearance purposes
		
	}

	public void revealNum(MyNode blank, Group group, int i, int j) {
		System.out.println("Regular Blank"); // show number, or, nothing
		if (mineField[i - 1][j - 1] instanceof Bomb) {
			num++;
		}
		if (mineField[i + 1][j + 1] instanceof Bomb) {
			num++;
		}
		if (mineField[i - 1][j + 1] instanceof Bomb) {
			num++;
		}
		if (mineField[i + 1][j - 1] instanceof Bomb) {
			num++;
		}
		if (mineField[i][j + 1] instanceof Bomb) {
			num++;
		}
		if (mineField[i][j - 1] instanceof Bomb) {
			num++;
		}
		if (mineField[i - 1][j] instanceof Bomb) {
			num++;
		}
		if (mineField[i + 1][j] instanceof Bomb) {
			num++;
		}
		System.out.println(num); // print num of bombs around
		String s = Integer.toString(num); // set to string
		Number number = new Number(s, i * gridWidth, j * gridHeight, gridWidth, gridHeight, num); // display on num
		group.getChildren().add(number); // show num of bombs
		
		num = 0;
	}
	/*
	 * public void revealBunch(int x, int y){ //we must take a recursive approach.
	 * // if((mineField[x][y] instanceof Node)) void floodFill( int x, int y ) { if
	 * ( btn( x, y ) isFillable ) { fillBtn(x,y); floodFill( x+1, y ); floodFill(
	 * x-1, y ); floodFill( x, y-1 ); floodFill( x, y+1 ); } else { return; } }
	 * 
	 */

	@Override
	public void revealOnClick(MyNode blank, Group group, int i, int j) { // event handler
		blank.setOnMousePressed(event -> {
			// what we really wanna do here is,
			// on click, we wanna remove blank from the group, and we want to see
			// wether a bomb, number, or a nothing is underneath
			reveal(group, (Blank) blank);// all we are doing is revealing on click.
			
			if (mineField[i][j] instanceof Bomb) {
				System.out.println("Im a bomb breh, you lose"); // implement way to make player lose
				num = 0;
				this.player.play();

				// storing image as icon
                ImageIcon file = new ImageIcon(getClass().getResource("/troll-pilled.gif"));
              
                // pop up dialag upon losing
                JOptionPane.showMessageDialog(
                        null,
                        "You Lost Bro!",
                        "Message", JOptionPane.INFORMATION_MESSAGE,
                        file);

						
				//JOptionPane.showMessageDialog(null, "You Lost"); // popups up message
				
			    
			} else if (mineField[i][j] instanceof Blank) {
				
				System.out.println("Regular Blank"); // show number, or, nothing
				if (mineField[i - 1][j - 1] instanceof Bomb) {
					num++;
				}
				if (mineField[i + 1][j + 1] instanceof Bomb) {
					num++;
				}
				if (mineField[i - 1][j + 1] instanceof Bomb) {
					num++;
				}
				if (mineField[i + 1][j - 1] instanceof Bomb) {
					num++;
				}
				if (mineField[i][j + 1] instanceof Bomb) {
					num++;
				}
				if (mineField[i][j - 1] instanceof Bomb) {
					num++;
				}
				if (mineField[i - 1][j] instanceof Bomb) {
					num++;
				}
				if (mineField[i + 1][j] instanceof Bomb) {
					num++;
				}
				
				System.out.println(num); // print num of bombs around
				String s = Integer.toString(num); // set to string
				Number number = new Number(s, i * gridWidth, j * gridHeight, gridWidth, gridHeight, num); // display on
																							// num
				number.label.setStyle("-fx-text-fill: white;"); // displaying numbers from bomb white
				group.getChildren().add(number); // show num of bombs
			
				num = 0;
				
			}
		});
		
	}

	// initialize mineField
	public Grid() {

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// create node
				Blank node = new Blank("Item " + i + "/" + j, i * gridWidth, j * gridHeight, gridWidth, gridHeight);
				//Bomb bomb = new Bomb("Im a bomb", i * gridWidth, j * gridHeight, gridWidth, gridHeight);
				// i want 20 bombs
				Bomb bomb = new Bomb(view, i * gridWidth, j * gridHeight, gridWidth, gridHeight);
				
				this.revealOnClick(node, head, i, j); // call event handler
				
				if (Math.random() <= 0.20) {
					head.getChildren().add(bomb); // add the bomb
					head.getChildren().add(node); // add the node on top to hide the bomb
					mineField[i][j] = bomb; // that position is a bomb
				} else {
					head.getChildren().add(node); // just add the node only
					mineField[i][j] = node; // that position is a node
				}
				
				// else if (){ // this will be the numbers?
				// }
				// add node to group
				// add to minefield for further reference using an array
			}
		}
	}

	public Group getGroup() { // return head to be used in runner
		return head;
	}
	
//	public void floodFill(int col, int row, int num) {
//		
//		if(row < 0 || row >= num || col < 0 || col >= num) {
//			return;
//		}
//		if(mineField[col][row] != num) {
//			return;
//		}
//	}
}
