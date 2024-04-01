package codingInterviewQuestions;

public class numbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String name = new String("Madhusudhan");
		//System.out.print(name.length()-1);
		
		int i;
		for( i=name.length()-1; i>=0 ; i-- )
		{
			System.out.print(name.charAt(i));
		}
	}

}
