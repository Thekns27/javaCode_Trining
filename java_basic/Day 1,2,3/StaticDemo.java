public class StaticDemo{

	// Instance Variable
	String instanceMessage = "Instance Variable";

	// Static Variable
	static String message = "Static Variable";

	// Static Methiod
	public static void main(String[] args) {
		StaticDemo demo = new StaticDemo();
		demo.instanceMessage();
		
	}

	void instanceMessage(){
		System.out.println("Instance Method");
		
		// Instance Variable
		System.out.println(instanceMessage);

		// Static variable
		System.out.println(message);

		// Static Method
		hello();

		// Instance Method
		greet();
	}

	// Static Method
	static void hello(){
		System.out.println("Hello Static Method"); 
	}

	// Instance Method
	void greet(){
		System.out.println("Hello java");
	}
}