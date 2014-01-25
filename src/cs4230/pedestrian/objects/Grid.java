package cs4230.pedestrian.objects;

/**
 * This class contains all the cells in the Automata simulation. 
 * For now, it is an organizational placeholder.
 * @author Nathan
 */
public class Grid {
	private Cell[][] cells;
	
	public Grid() {
		
	}
	
	public void setCell(int x, int y, Cell cell) {
		cells[x][y] = cell;
	}
	
	public Cell getCell(int x, int y) {
		return cells[x][y];
	}
	
	public int getWidth() {
		return cells.length;
	}
	
	public int getHeight() {
		return cells[0].length;
	}
}