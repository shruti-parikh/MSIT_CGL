/**
 * This class defines the cell code used in getting the x position and y position of the cell.
 * This class will return an integer or a boolean based on the requirememnt.
 */
/**
 * The code attributes specifies the location of the cell in integers and the alive cell which contains boolean value.
 * 
 */

/**
 * @author shruti parikh
 *
 */


public class Cell {
	private int xposition, yposition;
	private boolean alive;

	/**This constructor is used to create a new cell type of object based on the input given
	 * to the constructor in the int parameter and boolean parameter.
	 * 
	 * @param xposition	This input value must return int value.
	 * @param yposition	This input value must return int value.
	 * @param alive     This alive value must return true or false 
	 * 					true -  it means the cell is alive.
	 * 					flase - it means the cell is dead.
	 * 
	 *  
	 */
public Cell(int xposition, int yposition, boolean alive ) {
	this.xposition=xposition;
	this.yposition=yposition;
	this.alive=alive;	
}

/**
 * As the instanse variable are private, in order to get or set the value we need to use getters and setters
 * @return int xposition
 */
public int getXposition() {
	return xposition;
}
/**
 * As the instanse variable are private, in order to get or set the value we need to use getters and setters
 * @return int yposition
 */
public int getYposition() {
	return yposition;
}

/**
 * As the instanse variable are private, in order to get or set the value we need to use getters and setters
 * @return boolean getAlive
 */

public boolean getAlive(){
	return alive;
}

/**
 * setting the alive parameter
 * @param alive
 */
public void setAlive(boolean alive) {
	this.alive = alive;
}

}