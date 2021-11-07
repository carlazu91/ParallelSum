package Threads;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.ThreadLocalRandom;

import org.junit.jupiter.api.Test;

class ThreadTesting {

	@Test
	void sumTesting() {
		//for each loop to grab ever value in the array and check if there are any 0's	
		for(int i = 0; i < Threads.SingleThread.nums.length; i++) {		
			Threads.SingleThread.nums[i] = ThreadLocalRandom.current().nextInt(1,10);
			if (Threads.SingleThread.nums[i] == 0) {
			fail("A zero was found in the nums Array");
			}	
		}
	}
	
	@Test
	void arrayTesting() {
		//checks to be sure the array size is 200 Million
		assertEquals(200000000, Threads.SingleThread.nums.length);
	}
	
	@Test
	void timeoutNotExceeded() {
		//verifies that the execution time does not exceed 1000 milliseconds
	    assertTimeout(ofMillis(1000), () -> {
	        Threads.SingleThread.sum();
	    });
	}

}
