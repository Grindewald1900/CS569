
// ***************************************************************
//	Shop.java
//
//	Uses the Item class to create items and add them to a shopping
//	cart stored in an ArrayList.
// ***************************************************************

import java.util.ArrayList; 
import java.util.Scanner;

public class Shop{
	public static void main (String[] args){

		Item item;
		String itemName;
		double itemPrice; 
		int quantity;
		ArrayList<Item> cart = new ArrayList<Item>();  //a. Declare and instantiate a variable cart to be an empty ArrayList.

		Scanner scan = new Scanner(System.in); 
		String keepShopping = "y";
		do{
			double totalPrice = 0;
			System.out.println("keep:"+ keepShopping);
			System.out.print ("Enter the name of the item: "); 
			itemName = scan.nextLine();
			System.out.print ("Enter the unit price: "); 
			itemPrice = scan.nextDouble();
			System.out.print ("Enter the quantity: "); 
			quantity = scan.nextInt();
			// *** create a new item and add it to the cart
			item = new Item(itemName, itemPrice, quantity);
			cart.add(item);
			// *** print the contents of the cart object using println
			System.out.println("The contents of the cart: ");
			for(int i=0; i<cart.size(); i++){
				System.out.println((i+1) + ". " + cart.get(i).toString());
				totalPrice += cart.get(i).getPrice() * cart.get(i).getQuantity();
			}
			System.out.println("--------------------------------------------------------------");
			System.out.println("Totol price: ¥" + totalPrice);
			System.out.print ("Continue shopping (y/n)? "); 
			scan.nextLine();
			keepShopping = scan.nextLine();
		}
		while (keepShopping.equals("y"));
		scan.close();
	}
}
