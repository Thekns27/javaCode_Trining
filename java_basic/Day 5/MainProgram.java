public class MainProgram{
	public static void main(String[] args) {
		method1();
	}
	static void method1(){
		System.out.println("Method 1");
		method2();
	}
	static void method2(){
		System.out.println("Method 2");
		method3();
	}
	static void method3(){
		System.out.println("Method 3");
	}
}