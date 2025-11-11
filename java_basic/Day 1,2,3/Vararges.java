public class Vararges{
	public static void main(String[] args) {
		String [] array = {"A"."B"};
		show ("Hello");
	}
	static void show(String ... strs){
		for(String str : strs){
			System.out.println(str);
		}
	}
	static void show(String string , String ...strs){
		System.out.println("first" + string);
		for (String str : strs){
			System.out.println(str);
		}
	}
}