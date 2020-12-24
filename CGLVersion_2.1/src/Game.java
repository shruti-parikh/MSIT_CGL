/**
 * ****************Conways Game Of Life***********************************
 * Initially, there is a board with some cells which may be alive or dead. 
 * Task is to generate the next generation of cells based on the following rules: 
 *     
 * Rule 1: Any live cell with fewer than two live neighbors dies, as if caused by under
 * population. 
 * Rule 2:Any live cell with two or three live neighbors lives on
 * to the next generation. 
 * Rule 3: Any live cell with more than three live  neighbors dies, as if by overpopulation. 
 * Ruele 4: Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * 
 * Step 1 => find the no Of Neighbors that are alive; 
 * Step 2 => apply rules of game to get next generation by use the if conditions
 * to check all neighbors eluding it self as given video lecture
 * 
 * *************Rules of Life********************* 
 * Lonely cell will die ==> aliveNeighbours < 2 ;
 * Cell will die due to overpopulation ==> aliveNeighbours > 3 
 * A new cell will born ==> if currently dead cell have aliveNeighbours == 3
 * 

/**
 * @author shruti parikh
 *
 */

public class Game{
	
	public Board board;
	public int kthGen; 
	
	public Game(int kthGen,Board board) {
		this.kthGen = kthGen;
		this.board = board;	
	}
	
	public void kthGenerations() {
		//Cell[][] dub = new Cell[this,board.dim][]
		
		int k=0;
		while(k<=this.kthGen)
		{
		//Cell[][] g = board.nextGen();
		board.nextGen();
		System.out.println("Generations : "+ (k+1));
		System.out.println(board.toString());
		k++;
		}
	}	
}




 


