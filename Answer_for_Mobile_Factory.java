import java.util.Scanner;


public class Answer_for_Mobile_Factory {

	public static void main(String[] args) {
		
		int assign=0, start = 0, end =0, value_a=0, value_b=0, value_c=0;
		System.out.println("Please input the time frame(0-23)");
		
		do{
			if (start>23 || start<0 || end>23 || end<0 || assign>23 || assign<0)
			System.out.println("All numbers should be an integer between 0 and 23!");
		
			System.out.println();
			System.out.print("Start hour:"); //Input the start point of the time frame
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			start = input.nextInt();
			
			System.out.print("End hour:");  //Input the end point of the time frame
			@SuppressWarnings("resource")
			Scanner input2 = new Scanner(System.in);
			end = input2.nextInt();
			
			System.out.print("Assign a time point for checking:"); //Input an assigned number for checking
			@SuppressWarnings("resource")
			Scanner input3 = new Scanner(System.in);
			assign = input3.nextInt();
						
		}while(start>23 || start<0 || end>23 || end<0 || assign>23 || assign<0);
		
		
		//Following codes is to check whether the assigned time point is located inside the time frame
		
		System.out.println();
		System.out.println();
		System.out.println("Whether the assigned time is located in the time frame?");
		System.out.print("Answer: ");
		
		
		//The logic for checking is to determine whether the sum of the distance from the assigned
		//time point to start time and end time is equal to the clockwise distance between start
		//time and end time
		
		
		if (start==end){
			System.out.print("Yes");
			
		}else if(end==0)
		{
			value_a = Math.abs(assign - start); 
			//value_a stands for the distance between assigned time and start time
			value_b = 24 - assign;
			//value_b stands for the distance between assigned time and end time
			value_c = 24 - start;
			//value_c stands for the distance between start time and end time
			
			
			check(value_a,value_b,value_c);  //Set a method to make the codes more concise
			
			
		}else if(end > start){
			value_a = Math.abs(assign - start); 
			value_b = Math.abs(end - assign); 
			value_c = end - start;
			
			check(value_a,value_b,value_c);
			
		}else if((assign<end) || (assign>start && assign>end)){
			System.out.print("Yes");
			//Given the situation that the end point is smaller than the start point 
			//(which means that the time frame crossed the time point of 24 or 00),
			//then the point assigned less than the end point or those greater than	
			//both start and end point are definitely within the time frame
		}else{
			System.out.print("No!");
		}
		
		
	}
	
	private static void check(int a, int b, int c) {
		//The function for checking whether a assigned time is within the time frame by
		//calculating the value a, b and c elaborated between line 42 to line 57
		
		if (a + b == c || a==b || a==c){
		// 1. a + b = c : the assigned time point is between the start and end but not in the middle
		// 2. a == b: the assigned time point is between the start and end and locate in the middle
		// 3. a == c: the assigned time point is exactly the same as the end point 
			System.out.print("Yes");
		}else{
			System.out.print("No!");
		};
				
	}

	

}
