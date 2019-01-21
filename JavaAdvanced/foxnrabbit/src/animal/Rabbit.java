package animal;

import java.awt.Color;
import java.awt.Graphics;

import cell.Cell;

public class Rabbit extends Animal implements Cell{

	public Rabbit() {
		super(5,2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Animal breed() {
		// TODO Auto-generated method stub
		Animal baby = null;
		if( isBreedable() && Math.random()< 0.03) {
		baby = new Rabbit();
		}
		return baby;
	}

	@Override
	public void draw(Graphics g, int x, int y, int size) {
		// TODO Auto-generated method stub
		int alpha = (int)((1-getAgePercent())*255);
		g.setColor(new Color(0, 0, 0, alpha));
		g.fillRect(x, y, size, size);
	
	}

}
