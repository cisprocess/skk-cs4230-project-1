package cs4230.pedestrian.objects;

import java.awt.Color;
import java.awt.Graphics;

import cs4230.pedestrian.math.Statistics;


public class Exit extends Cell{

	public static final int MAX_MULT = 500;
	
	public Exit(int x, int y) {
		super(x, y, MAX_MULT);
	}
	
	public Exit(int x, int y, double mult) {
		super(x, y, mult);
	}
	
	public void update() {
		//remove occupant, handle statistics method and set null
		if(this.isOccupied) {
			//System.out.println("!");
			if(grid.getExited().remove(this.occupant)) {
				Pedestrian temp = (Pedestrian)this.occupant;
				Statistics.oneLeftArea(grid.time, temp.totalSteps, temp.walkingSteps, temp.distance, this.x, this.y);
			}
			this.setVoid();
		}
		super.update();
	}
	
	public void draw(Graphics gfx) {
		Color col = new Color(255 , 0 , 0);
		gfx.setColor(col);
		gfx.fillRect(x * TILE_PX, y * TILE_PX, TILE_PX, TILE_PX);
	}
}
