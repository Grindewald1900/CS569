
// ****************************************************************
// LoveCS.java
//
// Use a while loop to print many messages declaring your
// passion for computer science
// ****************************************************************
import java.util.Scanner;

public class LoveCS{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        // final int LIMIT = 10; 
        int userLimit; //user input 
        int count = 1;
        int sum = 0; //sum of numbers
        System.out.println("Please enter how many times to loop: ");
        userLimit = scanner.nextInt();
        while (count <= userLimit){
            System.out.println(count + " I love Computer Science!!"); 
            sum += count;
            count++;
        } 
        System.out.println("Printed this message " + userLimit + " times." + " The sum of the numbers from 1 to " + userLimit + " is " + sum + ".");
        scanner.close();
    } 
}