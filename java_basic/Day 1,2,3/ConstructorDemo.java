public class ConstructorDemo{
	public static void main(String[] args) {
		Hello hello;
		hello = new Hello(4);
		hello.greet();
	}
}
class Hello{

	static int count;

	Hello(int vargs){
		this.count = vargs;
	}

	void greet(){
		for(int i = 0 ; i < count; i++){
			System.out.println(" Hello Java");
		}

	}
} 