// **************************************************
//	StringPlay.java
//
//	Play with String objects
// **************************************************

public class StringPlay{
	public static void main (String[] args){
		String college = new String ("PoDunk College");
		String town = new String("NYC, USA"); // part (a)
			
		int stringLength;
		String change1, change2, change3;
		stringLength = college.length(); // part (b) 
		System.out.println (college + " contains " + stringLength + " characters."); 
		changel = college.toUpperCase();  // part (c) 
		change2 = college.replace("O", "*"); // part (d) 
		change3 = college.concat(town); // part (e) 
		System.out.println ("The final string is " + change3);
	}
}

