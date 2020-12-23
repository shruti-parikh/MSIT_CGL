/**
 * 
 */

/**
 * @author shruti parikh
 *
 */
public class Board {
  public int dim;
  public Cell[][] board;

  /**
 * 	
 * @param dim
 * @param livecells
 */
  public Board(int dim) {
    this.dim = dim;
  }

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
 * Marking live cells as * in out board and dead cells as .
 * @return
 */
  public String printBoard(Cell board[][]) {
    StringBuffer sd = new StringBuffer();
    //boolean [][] board=new boolean[this.dim][this.dim];
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j].getAlive() == true) {
          sd.append("*");
        }
        else {
          sd.append(".");
        }
        if (j < board.length - 1) {
          sd.append("");
        }

      }
      sd.append("\n");
    }

    return sd.toString();
  }
/**
 * nextGen() method 
 * @return
 */
  public Cell[][] nextGen(Cell board[][]) {
//    int sh = this.board.length;
//    int sp = this.board[0].length;
    Cell dub[][] = new Cell[this.dim][this.dim];
    for (int i = 0; i < this.dim; i++) {
      for (int j = 0; j < this.dim; j++) {
        dub[i][j] = new Cell(i, j, false);
      }
      }
      for (int u = 0; u <this.dim; u++) {
        for (int v = 0; v <this.dim; v++) {
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
            	if(u + check1[a]>=0 && u + check1[a]<this.dim && v + check2[b]>=0 && v + check2[b]<this.dim) {
//            		System.out.println(u + check1[a]);
//            		System.out.println(v + check2[b]);
            		
            	
            			if (board[u + check1[a]][v + check2[b]].getAlive() == true) {
                            live += 1;
                          }
          
            	}
            	
             

            }
          }
          if (board[u][v].getAlive() == true) {
            live -= 1;
          }
          if ((board[u][v].getAlive() == true) 
        		  && (live < 2)) {
            dub[u][v].setAlive(false);

          }
          else if ((board[u][v].getAlive() 
        		  == true) && (live > 3)) {
            dub[u][v].setAlive(false);

          }

          else if ((board[u][v].getAlive() == false)
        		  && (live == 3)) {
            dub[u][v].setAlive(true);

          }
          else {
            dub[u][v] = board[u][v];
          }

        }
      }
    
    return dub;

  }
}

