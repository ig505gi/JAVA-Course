package foxnrabbit;

import java.util.ArrayList;

import javax.swing.JFrame;

import cell.Cell;
import field.Field;
import field.Location;
import field.View;
import animal.*;

public class Foxnrabbit {
	
	private Field theField;
	private View theView;
	private JFrame frame;
	private double foxPercent = 0.02;
	private double rabbitPercent = 0.1;	
	
	public Foxnrabbit(int size)
	{
		theField = new Field(size, size);
		for ( int row = 0; row<theField.getHeight(); row++ ) {
			for ( int col = 0; col<theField.getWidth(); col++ ) {
				double probability = Math.random();
				if (probability < foxPercent) {
					theField.place(row, col, new Fox());
				}				
				else if (probability < rabbitPercent) {
					theField.place(row, col, new Rabbit());
				}
			}
		}
		theView = new View(theField);
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setTitle("Foxnrabbit");
		frame.add(theView);
		frame.pack();
		frame.setVisible(true);
	}
	
	public void run()  //遍历整个theField
	{
		//一开始就岁数增长，
		// 到达年龄就死了， 没死就移动，不能移动不移动，有兔子就吃，
		// 可以生育就生孩子，周围没格子不能生
		for ( int col = 0; col<theField.getWidth(); col++ ) {
		for ( int row = 0; row<theField.getHeight(); row++ ) {
			
				Cell cell = theField.get(row, col);
				if(cell != null) 
				{
					//grow
					Animal animal = (Animal)cell;
					animal.grow();					
					//move
					if ( animal.isAlive() ) 
					{
						Location loc = animal.move(theField.getFreeNeighbour(row, col));
						if (loc != null) 
						{
							theField.move(row, col, loc);
						}
						// eat
						Cell[] Neighbour = theField.getNeighbour(row, col);
						ArrayList<Animal> listRabbit = new ArrayList<Animal>();
						for(Cell c : Neighbour) {
							if( c instanceof Rabbit ) {
								listRabbit.add((Animal)c);
							}
							if( !listRabbit.isEmpty() ) {
								Animal fed = animal.feed(listRabbit);
								if( fed != null ) {
									theField.remove(row, col, (Cell)fed);
								}
								animal.longerLife();
							}
						}
						// breed 不好代码，因为判断可不可以生育是animal类的功能，不应该放在这里
//						if( animal.isBreedable() ) {
//							Animal baby = animal.breed();
//							theField.placeRandomAdj(row, col, (Cell)baby);
//						}
						Animal baby = animal.breed();
						if( baby != null ) {
							theField.placeRandomAdj(row, col, (Cell)baby);
						}
					}
					else 
					{
						theField.remove(row, col);
					}
				}
			}
		}
		frame.repaint();
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}
	
	public static void main(String[] args) {
		
		//初始化
		Foxnrabbit game = new Foxnrabbit(50);
		//run
		for (int i=0;i<1000;i++) 
		{
			game.run();
		}
	}

}
