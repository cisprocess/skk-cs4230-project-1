package cs4230.pedestrian.objects;

import java.awt.Color;
import java.awt.Graphics;

import cs4230.pedestrian.math.Statistics;

public class Road extends Cell {

	public Road(int x, int y) {
		super(x, y, 0);
		
		this.isOccupiable = false;
	}
	
	@Override
	public void update() {
		//road shouldn't require any additional computation time
	}
	
	@Override
	public void draw(Graphics gfx) {
		int color = (int)(255*Statistics.sigmoid(getMultiplier()));
		Color col = new Color(color, color, color);
		gfx.setColor(col);
		gfx.fillRect(x * TILE_PX + 1, y * TILE_PX + 1, TILE_PX - 1, TILE_PX - 1);
	}

}
