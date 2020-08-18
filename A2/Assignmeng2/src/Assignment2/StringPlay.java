// **************************************************
//	StringPlay.java
//
//	Play with String objects
// **************************************************

public class StringPlay{
	public static void main (String[] args){
		String college = new String ("PoDunk College");
		String town = new String(", NYC, USA"); // part (a)
			
		int stringLength;
		String change1, change2, change3;
		stringLength = college.length(); // part (b) 
		System.out.println (college + " contains " + stringLength + " characters."); 
		change1 = new String(college.toUpperCase()); // part (c)
		change2 = new String(change1.replace("O", "*")); // part (d) 
        change3 = new String(college.concat(town)); // part (e) 
        System.out.println("change1:" + change1);
        System.out.println("change2:" + change2);
        System.out.println ("The final string is " + change3);
	}
}

