// ***************************************************************
// StringManips.j ava
//
// Test several methods for manipulating String objects
// **************************************************************** 
import java.util.Scanner;

public class StringManips {
public static void main (String[] args){
        String phrase = new String ("This is a String test.");
        int phraseLength; // number of characters in the phrase String int
        int middleIndex; // index of the middle character in the String 
        String firstHalf; // first half of the phrase String
        String secondHalf; // second half of the phrase String
        String switchedPhrase; //a new phrase with original halves switched
        String middle3; //3 characters at the middle of the original string
        String city, state; // hometown
        Scanner scanner = new Scanner(System.in);
        // compute the length and middle index of the phrase 
        phraseLength = phrase.length();
        middleIndex = phraseLength / 2;
        // get the substring for each half of the phrase 
        firstHalf = phrase.substring(0,middleIndex);
        secondHalf = phrase.substring(middleIndex, phraseLength);
        // concatenate the firstHalf at the end of the secondHalf 
        switchedPhrase = secondHalf.concat(firstHalf).replace(" ", "*");
        // get the substring for the 3 middle characters
        middle3 = phrase.substring(middleIndex - 1, middleIndex + 2);
        // print information about the phrase System.out.println();
        System.out.println ("Original phrase: " + phrase); 
        System.out.println ("Length of the phrase: " + phraseLength +
        " characters");
        System.out.println ("Index of the middle: " + middleIndex); 
        System.out.println ("Character at the middle index: " +
        phrase.charAt(middleIndex)); 
        System.out.println ("Switched phrase: " + switchedPhrase);
        System.out.println("3 characters in the middle: "+ middle3);
        System.out.println();
        //Question 3
        System.out.println("Please enter your hometown(city and state): ");
        city = scanner.nextLine();
        state = scanner.nextLine();
        System.out.println(state.toUpperCase() + city.toLowerCase() + state.toUpperCase());
        scanner.close();
    }
}