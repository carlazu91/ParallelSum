package Threads;
import java.util.concurrent.ThreadLocalRandom;

public class MultiThreads {
	//Variables		 
	private static long sum = 0;
	private static long start;
	private static long end;
	private static long elapsedTime;
	private static int[] nums = new int[200000000];

	//Method to run array and compute the sum of the values of each element
	public static synchronized void sum() {		
		//Start time 	
		start = System.currentTimeMillis();
							
		//for loop to generate the random numbers 200 million times for numbers between 1-10		
		for(int i = 0; i < nums.length; i++) {				
			nums[i] = ThreadLocalRandom.current().nextInt(1,10);
			//System.out.println("Generated #: " + nums[i]);  //outputs generated random number 
		}
						
		//for each loop to grab ever value in the array to add them up				
		for (int num : nums){
			sum += num;	
			//System.out.println("Value in Array: " + num); //outputs number in array
			//System.out.println("Thread" + Thread.currentThread().getId() + ": Current sum: " + sum);	//outputs the current thread and sum 	
		}
						
		//End time		
		end = System.currentTimeMillis();	
		elapsedTime = end-start;		
	}
				
	public static void main(String[] args) {		
		Thread t1 = new Thread(new Runnable() {
			@Override		
			public void run() {			
				sum();		
			}		
		});
				
		Thread t2 = new Thread(new Runnable() {		
			@Override		
			public void run() {
				sum();	
			}		
		});
		Thread t3 = new Thread(new Runnable() {		
			@Override		
			public void run() {
				sum();	
			}		
		});
		
		t1.start();		
		t2.start();
		t3.start();
						
		try {		
			t1.join();		
			t2.join();
			t3.join();
		} catch (InterruptedException e) {		
			e.printStackTrace();		
		}		
		
		//Outputs the computed sum and execution time 
		System.out.println("Computed Sum: " + sum);		
		System.out.println("Completed in: "+ elapsedTime + " ms");	
	}
}
