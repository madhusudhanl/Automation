package selenium;

public class CoreJavaBasics2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "Madhu sudhan L";
		String s1 = "Madhu sudhan L"; // Both object s and s1 will point to same string since the value is same.


		String a = new String("Madhu sudhan L");
		String a1 = new String("Madhu sudhan L"); // Here both object a and a1 will point to different string since we are using new operator to create string.
		
		String[] b1 =	a1.split(" "); // once we split the string it should stored as arrays since it will collection of characters.
		System.out.println(b1[0]);
		System.out.println(b1[1]);
		System.out.println(b1[2]);
		
		/*
		 * for(int i=0; i<a1.length();i++) { System.out.println(a1.charAt(i)); }
		 */
		
		for(int i=a1.length()-1; i>=0;i--) // printing string in reverse. 
		{
			System.out.print(a1.charAt(i));
		}
	}

}
