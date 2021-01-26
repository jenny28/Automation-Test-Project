package newTestProject;

public class exceptionHandlingDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
   try {
	demo();
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

	}
	
	public static void demo() throws Exception {
		  System.out.println("Hello world...!");
		    int i=1/0;
		    System.out.println("Completed");
			/*
			 * try { System.out.println("Hello world...!"); int i=1/0;
			 * System.out.println("Completed"); } catch(Exception exp){
			 * System.out.println("i am inside the catch block");
			 * System.out.println("Message is: "+ exp.getMessage());
			 * System.out.println("cause is: " + exp.getCause()); exp.printStackTrace(); }
			 * finally { System.out.println("I am inside finally block"); }
			 */
	}

}
