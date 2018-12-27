package hello;

import java.util.Scanner;


public class Main {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Fraction a = new Fraction(in.nextInt(), in.nextInt());
		Fraction b = new Fraction(in.nextInt(),in.nextInt());
		a.print();
		b.print();
		a.plus(b).print();
		a.multiply(b).plus(new Fraction(5,6)).print();
		a.print();
		b.print();
		in.close();
	}
}

class Fraction{
	int a = 1;
	int b = 1;
	
	public Fraction(){}
	
	public Fraction(int a, int b)
	{
		this.a = a/gcd(a,b);
		this.b = b/gcd(a,b);
	}
	
	public double toDouble()
	{
		return a/(double)b;
	}
	
	public Fraction plus(Fraction f) 
	{
		return new Fraction((this.a * f.b + f.a * this.b), (this.b * f.b));
		
	}
	
	public Fraction multiply(Fraction f) 
	{
		return new Fraction(this.a*f.a, this.b*f.b);
	}
	
	public void print() 
	{
		if (b == 1) 
		{
			System.out.println(a);
		}
		else 
		{
			System.out.println(a + "/" + b);
		}
	}
	
	public int gcd(int a, int b) 
	{
		int r;
		while( b>0 ) 
		{
			r = a%b;
			a = b;
			b = r;
		}
		return a;
	}

}