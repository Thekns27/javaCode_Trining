public class MyFirstProgram{
	 public static void main(String[] args) {
		System.out.println("Start My First Program");

		System.out.println("Length of Args : " + args.length);

		for (String str: args ) {
			System.out.println(str);
		} 
		// Create An Object 
		Dog aungNet = new Dog();
		aungNet.name = "Aung Net";

		//aungNet.greet();

		System.out.println("Hi! I am Aung Net");

		Dog goteKyar = new Dog();
		goteKyar.name ="Gote Kyar";

		goteKyar.greet();
		aungNet.greet();

	 }
}
 	

 	class Dog{
 		String name;

 		 void greet() {
 			System.out.println("Hi! I am "+ name);
 		}
 	}