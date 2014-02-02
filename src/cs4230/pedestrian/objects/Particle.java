package cs4230.pedestrian.objects;

import java.awt.Graphics;

import cs4230.pedestrian.graphics.DisplayPanel;
import cs4230.pedestrian.math.LinCogRandom;
import cs4230.pedestrian.math.Statistics;

public abstract class Particle {
	protected int x,y,moveIncrement,moveCount;
	protected double[][] moveField;
	protected static LinCogRandom random = new LinCogRandom();;
	protected static Grid grid;
	
	public double priority;
	
	public static final int TILE_PX = DisplayPanel.TILE_PX;
	
	protected Particle(double[][] moveField) {
		moveCount = 0;
		this.moveField = moveField;
		x = -1;
		y = -1;
	}
	
	public static void setGrid(Grid newGrid) {
		grid = newGrid;
	}
	
	public void generateMoveMask(int x, int y) {
		double[][] mg = new double[3][3];
		for (int i = 0; i < mg.length; i++) {
			for (int j = 0; j < mg[0].length; j++) {
				int newX = this.x + (i - 1);
				int newY = this.y + (j - 1);
				int dist = Math.abs(this.x - newX) + Math.abs(this.y - newY);
				mg[i][j] = 1.0 / dist;
			}
		}
	}
	
	public static double[][] generateUniform() {
		double[][] mg = new double[3][3];
		for (int i = 0; i < mg.length; i++) {
			for (int j = 0; j < mg[0].length; j++) {
				mg[i][j] = 1.0 / 9;
			}
		}
		
		return mg;
	}
	
	/**
	 * Set position, primarily for door assignment and
	 * Used by cell at end of each update
	 */
	public void setPosition(int x, int y) {
		
		// increments field of cell previously occupied by pedestrian
		Cell temp = grid.getCell(this.x, this.y);
		if(temp!=null) {
			temp.incrementField();
			//set old position to empty
			temp.setVoid();
		}		
		this.x = x;
		this.y = y;
		temp = grid.getCell(x, y);
		temp.setOccupied(this);
	}
	
	public abstract void requestMove();
	public abstract void draw(Graphics gfx);

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
