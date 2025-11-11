public class Arguments{
	public static void main(String[] args) {

		Value value = new Value();
		value.data = 10;

		System.out.println(value.data);

		doSomething(value);

		System.out.println(value.data);
	}

	static void doSomething(Value value){

	System.out.println(value.data);
	
	value.data = (value.data * 2);

	System.out.println(value.data);
	}
}

class Value {
	int data;
}