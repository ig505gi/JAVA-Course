package animal;

import java.util.ArrayList;

import field.Location;

public class Animal {
	private boolean alive = true;
	private int ageLimit;
	private int breedableAge;
	private int age = 0;
	
	public Animal(int ageLimit, int breedableAge) {
		this.ageLimit = ageLimit;
		this.breedableAge = breedableAge;
	}

	public Animal breed() 
	{
		return null;
	}
	
	public int getAge() 
	{
		return age;
	}
	
	public double getAgePercent() 
	{
		double a = age/(double)ageLimit;
		return a;
	}
	
	public void grow() 
	{
		age++;
		if(age >= ageLimit) {die();}
	}
	
	public void die() 
	{
		alive = false; 
	}
	
	public boolean isAlive() 
	{ 
		return alive;
	}
	
	public boolean isBreedable() 
	{
		return (age >= breedableAge) ? true : false;
	}
	
	public Location move(Location[] locs) 
	{
		Location res =null;
		for(Location loc : locs) {
			if ( Math.random()<0.1 ) {
				res = loc;
				break;
			}
		}
		return res;
	}
	
	public Animal feed(ArrayList<Animal> fed) 
	{
		return null;
	}
	
	public void longerLife() 
	{
		ageLimit +=2;
	}
}
