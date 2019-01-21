package animal;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import cell.Cell;

public class Fox extends Animal implements Cell{

	public Fox() {
		super(10, 4);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Animal feed(ArrayList<Animal> feds) {
		// TODO Auto-generated method stub
		Animal res = null;
		for (Animal fed : feds) {
			if (Math.random()<0.03) {
				res = fed;
				break;
			}
		}
		return res;
	}

	@Override
	public Animal breed() {
		// TODO Auto-generated method stub
		Animal baby = null;
		if( isBreedable() && Math.random()< 0.01) {
		baby = new Fox();
		}
		return baby;
	}

	@Override
	public void draw(Graphics g, int x, int y, int size) {
		// TODO Auto-generated method stub
		int alpha = (int)((1-getAgePercent())*255);
		g.setColor(new Color(200 , 0, 0, alpha));
		g.fillRect(x, y, size, size);
	}
	
	
}
