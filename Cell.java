/**
 * 
 */

/**
 * @author shruti parikh
 *
 */


public class Cell {
	public int xposition, yposition;
	public boolean alive;

/**
 * 
 * @param xposition
 * @param yposition
 * @param alive
 */
public Cell(int xposition, int yposition, boolean alive ) {
	this.xposition=xposition;
	this.yposition=yposition;
	this.alive=alive;	
}
/**
 * 
 * @param xposition
 * @return
 */
public int getxpos(int xposition) {
	return xposition;	
}
/**
 * 
 * @param yposition
 * @return
 */
public int getypos(int yposition) {
	return yposition;	
}
/**
 * 
 * @param alive
 * @return
 */
public boolean alive(boolean alive){
	return alive;
	
}

}