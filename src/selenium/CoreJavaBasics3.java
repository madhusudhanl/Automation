package selenium;

public class CoreJavaBasics3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CoreJavaBasics3 m = new CoreJavaBasics3();
		m.getdata();// calling method using object
		String m3 = m.getdata();// to catch the returning object;
		System.out.println(m3);
		getdata2(); // calling method directly since its static.
		methodsdemo m1 = new methodsdemo(); // need to create object the method which we have to access which is outside the class
		m1.getdata3();
		

	}

	public String getdata() {

		System.out.println("Data from getdata() method");
		return "returing statement";
	}

	public static void getdata2() {

		System.out.println("Data from getdata2() static method");
	}
}
