import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

class GameTest {

	@Test
	public void testGamePosition() {
		Cell cell2 = new Cell(1,1, true);
		Assertions.assertEquals(1,cell2.getXposition());
		Assertions.assertEquals(1,cell2.getYposition());
		Assertions.assertEquals(true,cell2.getAlive());
	   }
	@Test
	public void testGamePosition1() {
		Cell cell2 = new Cell(2,3, false);
		Assertions.assertEquals(2,cell2.getXposition());
		Assertions.assertEquals(3,cell2.getYposition());
		Assertions.assertEquals(false,cell2.getAlive());
	   }

	
	@Test
	public void testBoard() {
		int[][] live = {{0,0},{1,2},{2,2},{1,1},{3,2}}; 
		Board b1 = new Board(4, live); 
		b1.createBoard(live);
		
		b1.board = b1.createBoard(live);
//		System.out.println("===============================");
//		System.out.println("======CURRENT GENERATION=======");
//		System.out.println(b1.toString());
		Assertions.assertEquals("*...\n.**.\n..*.\n..*.\n",b1.toString());
		b1.nextGen();
//		System.out.println("===============================");
//		System.out.println("======NEXT GENERATION=======");
//		System.out.println(b1.toString());
		Assertions.assertEquals(".*..\n.**.\n..**\n....\n",b1.toString());		
		}
	@Test
	public void testBoard1() {
		int[][] live = {{0,2},{1,3},{3,2},{1,2},{0,0},{0,1},{1,1}}; 
		Board b2 = new Board(4, live); 
		b2.createBoard(live);
		b2.board = b2.createBoard(live);
//		System.out.println("===============================");
//		System.out.println("======CURRENT GENERATION=======");
//		System.out.println(b2.toString());
		Assertions.assertEquals("***.\n.***\n....\n..*.\n",b2.toString());
		b2.nextGen();
//		System.out.println("===============================");
//		System.out.println("======NEXT GENERATION=======");
//		System.out.println(b2.toString());
		Assertions.assertEquals("*..*\n*..*\n.*.*\n....\n",b2.toString());		
		}
	@Test
	public void testGame() {
		int[][] live = {{2,3},{2,4},{3,3},{3,4},{4,3},{4,4}};
		Board b1 = new Board(6, live);
		Game g1 = new Game(5,b1);
		g1.kthGenerations();
	}
	
	
}
