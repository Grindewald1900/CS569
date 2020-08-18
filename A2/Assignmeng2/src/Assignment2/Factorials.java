// ************************************************************
//	Factorials.java
//
//	Print out the factorial of the integer
//
// ************************************************************ 

import java.util.Scanner;

public class Factorials {
    public static void main(String[] args){
        int numFactorial, counter, factorial = 0;    //counter and result
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a non-negative integer: ");
        numFactorial = scanner.nextInt();
        if(numFactorial < 0){       //if negative, request for another input
            while(numFactorial < 0){
                System.out.println("Please enter a non-negative integer: ");
                numFactorial = scanner.nextInt();
            }
        }else if(numFactorial == 0 || numFactorial == 1){  // if 1 or 0, assign 1 to the result
            factorial = 1;
        }else{  //if positive, calculate the factorial
            counter = factorial = numFactorial;
            while(counter > 1){
                counter--;
                factorial *= counter;
            }
        }
        System.out.println("The factorial of " + numFactorial + " is " + factorial);
        scanner.close();
    }
}