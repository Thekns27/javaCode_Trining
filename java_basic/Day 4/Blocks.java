import java.util.Properties;
import java.io.FileInputStream;
public class Blocks{

	public static void main(String[] args) {
		Hello hello = new Hello();
		hello.show();
	}

}

class Hello {
	String name;
	int count;
	{
		try(FileInputStream input = new FileInputStream("settingsproperties")){

			Properties props = new Properties();
			props.load(input);

			name = props.getProperty("name");
			count = Integer.valueOf(props.getProperty("count"));

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	void show (){
		for (int i = 0; i < count; i++){
			System.out.println(name);
		}
	}
}

class StaticBlock{
	static {

	}
}