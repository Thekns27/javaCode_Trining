public class Reference{

	Student s1 = new Student("Aung Aung ");
	sayHello(s1);

	s1 = new Student("Thidar");

	sayHello(s1);
}
static void sayHello(Student student){
	student.greet();
}

class Student{
	private String name;

	Student(String name){
		this.name = name;
	}
	void greet(){
		System.out.println("Hello I am " + name);
	}
}