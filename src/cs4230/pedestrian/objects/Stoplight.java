package cs4230.pedestrian.objects;

import java.awt.Color;
import java.awt.Graphics;

import cs4230.pedestrian.math.Statistics;

public class Stoplight extends Cell {
	
	private int lightIncrement, count, maxCounts;
	private double onMult;
	
	public Stoplight(int x, int y, double mult, int lightIncrement, int duration) {
		
		super(x,y,mult);
		
		this.lightIncrement = lightIncrement;
		count = 0;
		this.staticMult = 0;
		onMult = mult;
		this.maxCounts = duration+lightIncrement;
	}
	
	@Override
	public void draw(Graphics gfx) {
		int color = (int)(255*Statistics.sigmoid(getMultiplier()));
		Color col = new Color(color, color, 0);
		gfx.setColor(col);
		gfx.fillRect(x * TILE_PX + 1, y * TILE_PX + 1, TILE_PX - 1, TILE_PX - 1);
		gfx.setColor(Color.black);
		gfx.drawString("SP", x * TILE_PX + 5, y * TILE_PX + 15);
	}
		
	@Override
	public void update() {
		
		count++;
		if(count>maxCounts) {
			count = 0;
			staticMult = 0;
		}
		else if(count>lightIncrement) {
			staticMult = onMult;
		}
		
		super.update();
	}
	
}
