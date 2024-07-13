package ctrk;

/**
 * Represents a counter with methods for manipulating a count
 */
public class Counter {
	
	//instance vars
	
	//internal count for counter class
	int count;
	
	/**
	 * Creates counter object with given value as initial count.
	 * @param initialCount
	 */
	public Counter(int initialCount) {
		
		 this.setCount(initialCount); //call setCount with given initial count
	}
	
	//methods
	
	public void increment() {
		 
		this.count++;
	}
	
	
	/**
	 * 
	 * @return the internal count
	 */
	public int getCount() {
		
		return this.count;
	}
	
	public void setCount(int count) {
		
		this.count = count;
	}

}
