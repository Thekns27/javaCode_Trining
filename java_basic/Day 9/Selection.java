public class Selection{

	public static void main(String[] args) {

		int [] array = {3, 2, 4, 5, 3, 9, 8, 0, 1, 3, 5};

		// show data 
			show(array);

		// sort 
			sort(array);

		// show data
		show(array); 
	} 
	static void sort (int [] array) {

		for (int i = 0; i < array.length-1; i++){
			int target = i;

			for(int j = target; j < array.length-1; j++){
				if(array[target] > array[j + 1]) {
					target = j + 1;
				}
			}// End of Inner Loop

			int min = array[target];
			// replace target with initial value 
			array[target] = array[i];
			array[i] = min;
		}
	}

	static void show(int [] array){
		// [1,2,.....,9]
		System.out.print("[");
			for (int i = 0; i < array.length; i++){

				if(i > 0) {
					System.out.print(", ");
				}
				System.out.print(array[i]);
			}
		System.out.println("]");
	}
}