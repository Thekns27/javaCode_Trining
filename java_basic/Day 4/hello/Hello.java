package hello;

public class Hello{

	hello.Sub.SubClass Sub = new hello.Sub.SubClass();

	public void greet(){
		System.out.println("Hello java");
		 Sub.greet();
	}
}