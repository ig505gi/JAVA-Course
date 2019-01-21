package hello;

import java.util.Scanner;

public class Hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// test中文在windows下是否乱码
		int foot;
		double inch;
		Scanner in = new Scanner(System.in);
		try {
		System.out.println("please input foot=：");
		foot = in.nextInt();
		System.out.println("please input inch=：");
		inch = in.nextInt();
		System.out.println("convert to meter: " + (foot + inch/12)*0.3048);
		System.out.println((int)(170.239));
		}
		finally {
			in.close();
			
		}
	}

}
