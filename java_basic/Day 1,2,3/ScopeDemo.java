public class ScopeDemo{

public static void main(String[] args) {

	 Demo demo = new Demo();

	 demo.doSomething(); 

 	}
}
/** 
 * Testing program.
 */

class Demo{
		
		//Constructor
	Demo (){
		System.out.println("Constructor : Body : " + body);
	}
		// Method
	void doSomething (){  
		System.out.println("Method  : Body : " + body);
		//For Loop
		for(int i = 0; i < 10; i ++){
			System.out.println("For Loop : Body : " + body);
		}
	}
	int body = 1; 
	{
		//Code Block
		System.out.println("Code Block : Body : " + body);
	}
}