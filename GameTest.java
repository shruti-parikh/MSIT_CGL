
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

class GameTest {

	@Test
	public void testGamePosition() {
		Cell cell2 = new Cell(1,1, true);
		System.out.println("======GAMETEST TEST CASE=======");
		Assertions.assertEquals(0,cell2.getypos(0));
		Assertions.assertEquals(0,cell2.getxpos(0));
		Assertions.assertEquals(true,cell2.alive(true));
	   }
//	@Test
//	public void testGameposition2() {
//		Cell cell2 = new Cell(1,1, true);
//		System.out.println("======GAMETEST TEST CASE=======");
//		Assertions.assertEquals(0,cell2.getypos(0));
//		Assertions.assertEquals(0,cell2.getxpos(0));
//		Assertions.assertEquals(true,cell2.alive(true));
//	   }
	
	@Test
	public void testGameBoard() {
		int[][] live = {{0,0},{1,2},{2,2},{1,1},{3,2}}; 
		Board b1 = new Board(4,live); 
		System.out.println(b1.printBoard());
		Assertions.assertEquals("*....**...*...*.",b1.printBoard());
		}
	
	@Test
	public void testNextGeneration() {
		int[][] live = {{0,0},{1,2},{2,2},{1,1},{3,2}}; 
		Board b2 = new Board(4,live); 
		System.out.println(b2.getNextGeneration());
		Assertions.assertEquals("null",b2.getNextGeneration());
		}
	@Test
	public void testGameNext() {
		Game b3 = new Game(4);
		System.out.println("======GAMETEST NEXT CASE=======");
		System.out.println(b3.nextGenBoard(null));
		Assertions.assertEquals(null,b3.nextGenBoard(null));
	}
	
}

