package selenium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoreJavaBasics1 {

	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> a = new ArrayList<String>();
		a.add("Madhu");
		a.add("Sudhan");
	
		
		for(String b:a) // enhanced for loop
		{
			System.out.println(b);
		}
		//System.out.println("My name is "+	a.get(0) );
		
		int[] num = new int[5];
		num[0] = 10;
		num[1] = 101;
		num[2] = 102;
		num[3] = 103;
		num[4] = 104;
		
		
		List<int[]> numArraylist = Arrays.asList(num);
		
		boolean con = numArraylist.contains(104);
		
		if(con) {
			System.out.println("Yes is there");
		}else {
			System.out.println("Not there");
		}
		
		/*
		 * for(int m:num) { System.out.println(m); }
		 */
		
	}

}
