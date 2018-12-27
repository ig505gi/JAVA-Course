package hello;

import java.util.Scanner;

public class countVotes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] counts = new int[10];
		// JAVA会自动初始化int数组全为0
//		for(int i =0;i<counts.length;i++) 
//		{
//			counts[i] = 0;
//		}
		Scanner in = new Scanner(System.in);
		int vote = -1;
		try 
		{
			do 
			{
				System.out.println("input -1 to stop voting");
				System.out.print("please vote: ");
				vote = in.nextInt();
				if (vote >= 0 && vote<=9) 
				{
					counts[vote]++;
				}
			}
			while(vote>=0);
			for(int i =0;i<counts.length;i++) 
			{
				System.out.println("the count of vote \'" + i + "\' :" + counts[i]);
			}
		}
		finally 
		{
			in.close();
		}
	}

}
