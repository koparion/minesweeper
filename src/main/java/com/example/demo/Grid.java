package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
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

public class Grid implements MouseClick {


    double sceneWidth = 1024;
    double sceneHeight = 768;

    int n = 10;
    int m = 10;
    int num = 0; //used for displaying num on Numbers
    int mineFieldNums = 0; //used to hold nums in minefield numbers
    double gridWidth = sceneWidth / n;
    double gridHeight = sceneHeight / m;

    MyNode[][] mineField = new MyNode[n][m]; //minefield of nodes.

    private Group head = new Group(); //A Group node contains an ObservableList of children
    // that are rendered in order whenever this node is rendered.

    public void reveal(Group group, Blank blank) { //reveal underneath nodes
        group.getChildren().remove(blank); //remove blank for appearance purposes
    }

    public void bombHint(int i, int j) {
        try {
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
        } catch (ArrayIndexOutOfBoundsException e) {
            //IF THERE IS AN EXCEPTION, ONLY SCAN ARRAY INDEXES THAT DO NOTTT LEAD TO
            //AN OUT-OF-BOUNDS INDEX.
            if (i == 0) {
                if (j == 9) {
                    if (mineField[i + 1][j] instanceof Bomb) {
                        num++;
                    }
                    if (mineField[i][j - 1] instanceof Bomb) {
                        num++;
                    }
                    if (mineField[i + 1][j - 1] instanceof Bomb) {
                        num++;
                    }
                } else {
                    if (mineField[i + 1][j + 1] instanceof Bomb) {
                        num++;
                    }
                    if (mineField[i + 1][j] instanceof Bomb) {
                        num++;
                    }
                    if (mineField[i][j + 1] instanceof Bomb) {
                        num++;
                    }
                }
            } else if (j == 0) {
                if (i == 9) {
                    if (mineField[i][j + 1] instanceof Bomb) {
                        num++;
                    }
                    if (mineField[i - 1][j] instanceof Bomb) {
                        num++;
                    }
                    if (mineField[i - 1][j + 1] instanceof Bomb) {
                        num++;
                    }
                } else {
                    if (mineField[i][j + 1] instanceof Bomb) {
                        num++;
                    }
                    if (mineField[i + 1][j + 1] instanceof Bomb) {
                        num++;
                    }
                    if (mineField[i + 1][j] instanceof Bomb) {
                        num++;
                    }
                }
            } else if (i == 9) {
                if (j == 9) {
                    if (mineField[i - 1][j] instanceof Bomb) {
                        num++;
                    }
                } else {
                    if (mineField[i][j + 1] instanceof Bomb) {
                        num++;
                    }
                    if (mineField[i - 1][j + 1] instanceof Bomb) {
                        num++;
                    }
                }

            } else if (j == 9) {
                if (i == 9) {
                    if (mineField[i][j - 1] instanceof Bomb) {
                        num++;
                    }
                } else {
                    if (mineField[i + 1][j] instanceof Bomb) {
                        num++;
                    }
                    if (mineField[i + 1][j - 1] instanceof Bomb) {
                        num++;
                    }
                }
            } else if (i == 9 || j == 9) {
                if (mineField[i - 1][j - 1] instanceof Bomb) {
                    num++;
                }
                if (mineField[i][j - 1] instanceof Bomb) {
                    num++;
                }
                if (mineField[i - 1][j] instanceof Bomb) {
                    num++;
                }
            }
        }
    }


    void floodFill( int x, int y, Group group, Blank blank ) {
        Boolean isFillable = false;
        if ( mineField[x][y].getNum()==0) {
            if (mineField[x][y] instanceof Number){
                isFillable = true;
            }
            if(isFillable==true){
                reveal(group, blank);
                floodFill( x+1, y, group, blank );
                floodFill( x-1, y, group, blank );
                floodFill( x, y-1, group, blank );
                floodFill( x, y+1, group, blank );

            }

        } else {
            return;
        }
    }





    @Override
    public void revealOnClick(MyNode blank, Group group, int i, int j) { //event handler

        blank.setOnMousePressed(event -> {
            //what we really wanna do here is,
            //on click, we wanna remove blank from the group, and we want to see
            //wether a bomb, number, or a nothing is underneath
            reveal(group, (Blank) blank);//all we are doing is revealing on click.
            floodFill(i, j, group, (Blank) blank);
            if (mineField[i][j] instanceof Bomb) {
                System.out.println("Im a bomb breh, you lose"); //implement way to make player lose
                num = 0;
            } else if (mineField[i][j] instanceof Number) {

            }
        });


    }

    // initialize mineField
    public Grid() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // create node
                Blank node = new Blank("Item " + i + "/" + j, i * gridWidth, j * gridHeight, gridWidth, gridHeight);
                Bomb bomb = new Bomb("Im a bomb", i * gridWidth, j * gridHeight, gridWidth, gridHeight);
                //i want 20 bombs



                if (Math.random() <= 0.20) {
                    head.getChildren().add(bomb); //add the bomb
                    head.getChildren().add(node); //add the node on top to hide the bomb
                    mineField[i][j] = bomb; //that position is a bomb
                    this.revealOnClick(node, head, i, j); //call event handler
                } else {
                    Number number = new Number();
                    mineField[i][j] = number; //that position is a node
                }

            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mineField[i][j] instanceof Number) {
                    bombHint(i, j);


                    mineFieldNums = num;
                    mineField[i][j].setNum(mineFieldNums);
                    String s = Integer.toString(num); //set to string
                    Number number = new Number(s, i * gridWidth, j * gridHeight, gridWidth, gridHeight, num); //display on num
                    Blank node = new Blank("Item " + i + "/" + j, i * gridWidth, j * gridHeight, gridWidth, gridHeight);
                    this.revealOnClick(node, head, i, j); //call event handler
                    //after the new number is constructed, set num=0;
                    num = 0;
                    head.getChildren().add(number); //number goes underneath node
                    head.getChildren().add(node); //add node to hide number

                }
            }

        }
    }



        //right now, we construct bombs all ove rthe board, and hide them with blanks.
        //we then, construct numbers when a blank is clicked, to see how many bombs are around.
        //what if we constructed the numbers before?? is this possible?

        //maybe we can throw bombs all around the board, then write another for loop, to throw numbers all around the board?


        public Group getGroup () { //return head to be used in runner
            return head;
        }
}




