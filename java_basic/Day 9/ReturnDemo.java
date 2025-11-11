public class ReturnDemo{
	public static void main(String[] args) {

		System.out.println("Hello Return ");
		if (args.length > 0) {
			return;
		}
		
		System.out.println("After Return");
	}
} 