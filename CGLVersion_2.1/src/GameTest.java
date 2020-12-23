import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

class GameTest {

	@Test
	public void testGamePosition() {
		Cell cell2 = new Cell(1,1, true);
		System.out.println("======GAMETEST TEST CASE=======");
		Assertions.assertEquals(1,cell2.getXposition());
		Assertions.assertEquals(1,cell2.getYposition());
		Assertions.assertEquals(true,cell2.getAlive());
	   }
	@Test
	public void testGamePosition1() {
		Cell cell2 = new Cell(2,3, false);
		System.out.println("======GAMETEST TEST CASE=======");
		Assertions.assertEquals(2,cell2.getXposition());
		Assertions.assertEquals(3,cell2.getYposition());
		Assertions.assertEquals(false,cell2.getAlive());
	   }

	
	@Test
	public void testBoard() {
		int[][] live = {{0,0},{1,2},{2,2},{1,1},{3,2}}; 
		Board b1 = new Board(4); 
		b1.createBoard(live);
		Cell[][] c1 = b1.createBoard(live);
		System.out.println(b1.printBoard(c1));
		Assertions.assertEquals("*...\n.**.\n..*.\n..*.\n",b1.printBoard(c1));
		Cell[][] c2 = b1.nextGen(c1);
		System.out.println(b1.printBoard(c2));
		Assertions.assertEquals(".*..\n.**.\n..**\n....\n",b1.printBoard(c2));		
		}
	@Test
	public void testBoard1() {
		int[][] live = {{0,2},{1,3},{3,2},{1,2},{0,0},{0,1},{1,1}}; 
		Board b2 = new Board(4); 
		b2.createBoard(live);
		Cell[][] c1 = b2.createBoard(live);
		System.out.println(b2.printBoard(c1));
		Assertions.assertEquals("***.\n.***\n....\n..*.\n",b2.printBoard(c1));
		Cell[][] c2 = b2.nextGen(c1);
		System.out.println(b2.printBoard(c2));
		//Assertions.assertEquals("....\n.**.\n..*.\n....\n",b1.printBoard(c2));		
		}
	
	

//	@Test
//	public void testGameNext() {
//		Game b3 = new Game(4);
//		System.out.println("======GAMETEST NEXT CASE=======");
//		System.out.println(b3.nextGenBoard(null));
//		Assertions.assertEquals(null,b3.nextGenBoard(null));
//	}
	
}
