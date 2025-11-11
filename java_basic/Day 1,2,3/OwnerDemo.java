public class OwnerDemo{

	public static void main(String[] args) {
		
		Counter c1 = new Counter();
		Counter c2 = new Counter();

		c1.name = "Counter 1";
		c2.name = "Counter 2";

		c1.countUp();
		c1.countUp();
		c2.countUp();
		c1.countUp();
	}
}
class Counter{
	String name;
	static int count;
	void countUp(){
		count ++;
		System.out.println("Count Of "+ name + " : " + count);
	}
}   