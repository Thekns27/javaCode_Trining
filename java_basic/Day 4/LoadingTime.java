import java.util.Scanner;

public class LoadingTime{

	public static void main(String[] args) {

		System.out.println("Start Program");
		Scanner sc = new Scanner(System.in);
		sc.nextLine();

		LoadDemo demo;
		System.out.println("Declare Class");
		sc.nextLine();

		demo = new LoadDemo();
		System.out.println("Create Object from calls");
		sc.nextLine();

		demo = new LoadDemo();
		System.out.println("Create Object again");
		sc.nextLine();
		
	}
}
class LoadDemo{
	static {
		System.out.println("Static Block");
	}
	{
		System.out.println("Instance Block");

	}

	LoadDemo(){
		System.out.println("Constructor");
	}
}