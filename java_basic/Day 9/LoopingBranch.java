public class LoopingBranch {
	public static void main(String[] args) {
		
	 if(args.length == 2) {

	 	// first arg (total count)
	 	int total = Integer.parseInt(args[0]);

	 	// second arg (show count)
	 	int show = Integer.parseInt(args[1]);

	 	if(total <= show){
	 		System.out.println("Total must greater than show count");
	 		return;
	 	}
	 		for (int i= 1; i <= total; i++){
	 			if(i % 2 == 1){ 
	 				// skip current loop
	 				continue;
	 			}

	 			System.out.println(i);

	 			if(i>= show){
	 				// skip rest of the loop
	 				break;
	 			}
	 		}
	 	}else {
	 		System.out.println("Please enter total and show count parameters");
	 	}
	}
}