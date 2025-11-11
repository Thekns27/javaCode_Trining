public class MultiReference {

	public static void main(String[] args) {

		Counter c1 = new Counter("C1");
		//C1 : 1
		c1.countUp();


		Counter c2 = c1;
		Counter c3 = c2;

		//C1 : 2 
		c2.countUp();

		c3.setName("C3");
		//C3 : 3
		c1.countUp();
	}
}
class Counter{
	private  String name;
	private int count;

	Counter (String name){
		this.name = name;
	}

	void setName (String name){
		this.name = name;
	}
	void countUp(){
		++ count;
		System.out.println(name + ":" + count);

	}
}