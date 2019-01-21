package hello;

public class constructPrimeTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[] isPrime = new boolean[100];
		for( int i=0; i<isPrime.length; i++ ) 
		{
			isPrime[i] = true;
		}
		
		for( int i=2; i<isPrime.length; i++ ) 
		{
			if( isPrime[i] ) 
			{
				for( int p=2; p*i<isPrime.length; p++ ) 
				{
					isPrime[p*i] = false;
				}
			}
		}
		
		for ( int i=2; i<isPrime.length; i++ ) 
		{
			if( isPrime[i] ) 
			{
				System.out.print(i + " ");
			}
		}
		
	}

}
