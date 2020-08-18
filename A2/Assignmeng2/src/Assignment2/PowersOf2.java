
// ************************************************************
//	PowersOf2.java
//
//	Print out as many powers of 2 as the user requests
//
// ************************************************************ 

import java.util.Scanner;

public class PowersOf2{
	
	public static void main(String[] args){
		
		int numPowersOf2;	//How many powers of 2 to compute 
		int nextPowerOf2 = 1;	//Current power of	2
		int exponent;	//Exponent for current power of 2 -- this
						//also serves as a counter for the loop 
		Scanner scan = new Scanner(System.in);

		System.out.println("How many powers of 2 would you like printed?"); 
		numPowersOf2 = scan.nextInt();
		System.out.println("Here are the first " + numPowersOf2 + " powers of 2:"); //print a message saying how many powers of 2 will be printed
		exponent = 0;//initialize exponent -- the first thing printed is 2 to the what?
		while (exponent < numPowersOf2){
			System.out.println("2^" + exponent + " = " + nextPowerOf2);	//print out current power of 2
			nextPowerOf2 *= 2;  	//find next power of 2 -- how do you get this from the last one?
			exponent++; 	//increment exponent
		}
		scan.close();
	}
}
