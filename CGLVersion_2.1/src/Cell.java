/**
 * 
 */

/**
 * @author shruti parikh
 *
 */


public class Cell {
	public int xposition, yposition;
	private boolean alive;

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

///Getters and setters//
public int getXposition() {
	return xposition;
}

public int getYposition() {
	return yposition;
}


public boolean getAlive(){
	return alive;
}

public void setAlive(boolean alive) {
	this.alive = alive;
}

}