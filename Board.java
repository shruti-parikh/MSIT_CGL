/**
 * 
 */

/**
 * @author shruti parikh
 *
 */
public class Board {
	public int dim;
	public boolean[][] cells;
	
/**
 * 	
 * @param dim
 * @param livecells
 */
	public Board(int dim,int[][] livecells){
		this.dim = dim;
		this.cells = new boolean[dim][dim];
		for(int i=0;i<livecells.length;i++) {
			cells[livecells[i][0]][livecells[i][1]]= true;	
		}
	}

/**
 * Marking live cells as * in out board and dead cells as .
 * @return
 */
	public String printBoard() {
		StringBuffer sd = new StringBuffer();
		//boolean [][] board=new boolean[this.dim][this.dim];
		for(int i=0;i<this.cells.length;i++){
	        for(int j=0;j<this.cells[i].length;j++){
	            if(this.cells[i][j]){
	                //System.out.print("*");
	                sd.append("*");
	            }
	            else{
                //System.out.print(".");
	            	sd.append(".");
	            }
	        } 	
		}
		return sd.toString();	
	}
/**
 * @Method getNextGeneration()
 */
	public String getNextGeneration() {
		return "null";	
	}
		
}







