import java.util.Scanner;

public class SwitchDemo {

public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);

	String decision = null;
	do {
		System.out.println("Enter Number: ");
		String str = sc.nextLine();

		byte b = Byte.valueOf(str);
		doDemo(b);

		System.out.print("Exit (Y / Others) :");
		decision = sc.nextLine();

	}while (!"Y".equalsIgnoreCase(decision));
	
	
}
static void doDemo (byte value){
	switch (value){
	case 0 :
		//System.out.println("This is 0");
	case 1 :
		System.out.println("This is 0 ot 1");
		break;
	case 2 :
		System.out.println("This is 2");
		break;  
	case 3:
		System.out.println("This is 3");
	break;
default:
	System.out.println("This is more than 3");
	break;
	}
  }
}