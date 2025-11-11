public class NestedDemo {
	public static void main(String[] args) {
		int [][] arrays = {
		  {1,2,3},
		  {4,5,6},
		  {7,8,9},
		};
		for (int i = 0; i<arrays.length; i++){

		  int [] array = arrays[i];

		  for(int j = 0; j < array.length; j++){
		  	System.out.println(array[j]);
		  }
	 	}
	}
}
