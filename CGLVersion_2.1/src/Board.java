import java.util.Scanner;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


/**
 * This class defines the code used used in the creating of board, current generation and also next generation
 * This class will always return a Cell object array,
 * The code attributes in this class are 
 * 1)dimentions of the board which is public access modifier.
 * 2) creating a cell object which is a 2-D array.
 * As we are using a Cell object in board class this is an example of Composition.
 * Code Defination
 * Initially the the board is created with boolean values true and false. here, true means live and false means dead.
 * later the board is transformed in * .
 * "*" means the cell is alive 
 * "." means the cell is dead
 */

/**
 * @author shruti parikh
 *
 */
/**
 * The following are the class attributes that defines the Board class
 * @author shruti parikh
 *
 */
public class Board {

  public int dim;
  public Cell[][] board;

  public Board(int dim) { // default constructor of class Board
    this.dim = dim; // creating the objects for the variables 
    this.board = new Cell[dim][dim];
    for (int i = 0; i < board.length; i++) { // itterating through each cell as per board.length 
      for (int j = 0; j < board.length; j++) {
        board[i][j] = new Cell(i, j, false); // initially setting each cell with false 
      }
    }
  }

  /**
 * This constructor is used to create a new Board type of object based on the input given to 
 * the constructor in the int parameter 
 * @param dim
 */
  public Board(int dim, int l[][]) { // overloading constructor of class Board with dim and integer array Int[][] as the parameters
    this.dim = dim; // i[][] contains the corodinates of live cells.
    this.board = new Cell[dim][dim];
    for (int i = 0; i < board.length; i++) { //itterating through each cell as per board.length
      for (int j = 0; j < board.length; j++) {
        board[i][j] = new Cell(i, j, false); // initially setting each cell with false 
      }
    }
    for (int k = 0; k < l.length; k++) { // itterating through livecells aray length 
      board[l[k][0]][l[k][1]].setAlive(true); // setting those coordintates as true.
    }

  }

  public Board(int boardSizeWidth, Scanner sc) { // overloading constructor of class Board with dim and Scanner object as the parameters
    this.dim = boardSizeWidth;
    this.board = new Cell[dim][dim];
    for (int i = 0; i < board.length; i++) { //itterating through each cell as per board.length
      for (int j = 0; j < board.length; j++) {
        board[i][j] = new Cell(i, j, false); // initially setting each cell with false 
      }
    }
    while (sc.hasNextLine()) { // looping untill the channer obj has inputs
      String[] s1 = sc.nextLine().split(" "); // splitting the input based on " " and storing it in string
      int row = Integer.parseInt(s1[0]); // as there are only 2 indexes -> index 0 is stored as row
      int col = Integer.parseInt(s1[1]); // index 1 is stored as col
      board[row][col].setAlive(true); //  setting those rows and col corodinates as true in the overall board.
    }
  }

  public Board(Board oddGameBoard) { // overloading the constructor by giving board object as parameter 
    this.dim = oddGameBoard.dim;
    this.board = oddGameBoard.board;
  }

  /**
 * this method is to set the rectangle pane which is called by USerInterface.java file to display the UI window.
 * @param window
 */

  public void fillingTheCanvas(Pane window) { //Establish the window which will be displayed in the GUI
    for (int i = 0; i < this.dim; i++) { // writing the nested forloop to iterate through each and every cell 
      for (int j = 0; j < this.dim; j++) { //of the board within the dimension sof the board.
        if (board[i][j].getAlive() == true) { // checking if the cell is live or not.
          Rectangle r = new Rectangle(6, 6); //creating rectangle cell by giving the size of each small cells as 6,6
          r.setFill(Color.BLUE); //setting the colour of each livecell with blue color
          r.setStroke(Color.BLACK); // Giving the boundary to each live cells
          r.setX(6 * i); // seting the x coordinate as multiple of 6
          r.setY(6 * j); // seting the y coordinate as multiple of 6
          window.getChildren().add(r); // adding this rectangle to the window.
        }
      }
    }
  }

  /**
  * This is the createBoard method which take a int array as parameter.
  * Inside this we are creating a Cell board object array as per the dimentions given in the constructor
  * later, iterating through the dimentions we are making all false [dim][dim] array.
  * As per the int array inputs dimentions, the same dimentions are changes to true in the Cell board. 
  * @param l[][] - int array.
  *   * @return  Cell object.
  */

  public Cell[][] createBoard(int l[][]) {
    Cell[][] board = new Cell[this.dim][this.dim];
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        board[i][j] = new Cell(i, j, false);
      }
    }
    for (int k = 0; k < l.length; k++) {
      board[l[k][0]][l[k][1]].setAlive(true);
    }
    return board;
  }

  /**
 * This is the printBoard  method. it takes the cell array object. if the positional value if true it is converted to "*"
 * and if the positional value is false. It is converted to "." . 
 * Marking live cells as * in out board and dead cells as .
 * As strings are not mutable I am making use of String Buffer and appending the modified input with all * & .
 * @return as string 
 */
  public String toString() {
    StringBuffer sd = new StringBuffer();
    for (int i = 0; i < this.board.length; i++) {
      for (int j = 0; j < this.board[i].length; j++) {
        if (this.board[i][j].getAlive() == true) {
          sd.append("*");
        }
        else {
          sd.append(".");
        }
        if (j < this.board.length - 1) {
          sd.append("");
        }

      }
      sd.append("\n");
    }

    return sd.toString();
  }
  /**
   * This is the nextGen()method.It takes Cell board[][] as the parameter. 
   * so in this creating a new Cell onject array and creating all false board. later while itterating, 
   * checking the neighbours and counting the live cells.
   * After itteration we are checking the conditions of Conveys Game of Life. 
   * to print the next generation.
   * *************Rules of Life*********************
   * Cell will die due to overpopulation ==> aliveNeighbours > 3 
   * New cell will born ==> if currently dead cell have aliveNeighbours == 3
   * 
   * @param board[][] board
   * 
   */
  public void nextGen() {
    Cell dub[][] = new Cell[this.dim][this.dim];
    for (int i = 0; i < this.dim; i++) {
      for (int j = 0; j < this.dim; j++) {
        dub[i][j] = new Cell(i, j, false);
      }
    }
    for (int u = 0; u < this.dim; u++) {
      for (int v = 0; v < this.dim; v++) {
        int live = 0;
        int check1[] = new int[3];
        int check2[] = new int[3];
        check1[0] = -1;
        check1[1] = 0;
        check1[2] = +1;
        check2[0] = -1;
        check2[1] = 0;
        check2[2] = +1;
        for (int a = 0; a < 3; a++) {
          for (int b = 0; b < 3; b++) {
            if (u + check1[a] >= 0 && u + check1[a] < this.dim && v + check2[b] >= 0 && v + check2[b] < this.dim) {
              //            		System.out.println(u + check1[a]);
              //            		System.out.println(v + check2[b]);

              if (this.board[u + check1[a]][v + check2[b]].getAlive() == true) {
                live += 1;
              }
            }
          }
        }
        if (this.board[u][v].getAlive() == true) {
          live -= 1;
        }
        if ((this.board[u][v].getAlive() == true) && (live < 2)) {
          dub[u][v].setAlive(false);

        }
        else if ((this.board[u][v].getAlive() == true) && (live > 3)) {
          dub[u][v].setAlive(false);

        }

        else if ((this.board[u][v].getAlive() == false) && (live == 3)) {
          dub[u][v].setAlive(true);

        }
        else {
          dub[u][v] = this.board[u][v];
        }
      }
    }
    board = dub;

  }
}