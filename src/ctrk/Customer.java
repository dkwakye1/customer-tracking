package ctrk;

import java.util.ArrayList;

/**
 * Represents a customer with name, ID and geography
 * 
 * 
 */
public class Customer {

	//static vars shared across all instances of Customer

	/**
	 * Company for all customers
	 */
	static final String COMPANY = "CVS";

	/**
	 * Stores list of all customers
	 */
	static ArrayList<Customer> CUSTOMERS = new ArrayList<Customer>();

	/**
	 * Generate and keep track of customer IDs
	 */
	static Counter COUNTER;


	//instance vars

	//name of customer
	String name;

	//geography of customer
	String geography;

	//id of customer
	int ID;

	//constructor

	public Customer(String name, String geography) {

		this.name = name;
		this.geography = geography;

		//get unique ID from counter
		this.ID = Customer.COUNTER.getCount();

		//increment counter
		Customer.COUNTER.increment();

		//adds this customer to list of all customer
		Customer.CUSTOMERS.add(this);

	}

	//methods



	//prints all customer
	public static void printAllCustomers() {

		System.out.println("All Customers: ");



		//iterate over statically referenced list of customers
		for (Customer c : Customer.CUSTOMERS) {

			System.out.println(c);
		}
		System.out.println("\n");


	}


	/**
	 * compares two customers for equality
	 * If they have the same name and geography, they are equal
	 * 
	 */
	public boolean equals(Object obj){

		//cast given object to Customer object
		Customer otherCustomer = (Customer) obj;

		if (this.name.equals(otherCustomer.name) && this.geography.equals(otherCustomer.geography)){

			return true;
		}

		return false;

	}


	//returns details on a customer
	public String toString() {
		
	
		
		
		return this.ID + ": " + this.name + ", Company: " + Customer.COMPANY + ", Location: " + this.geography;
		
		
	}


	/**
	 * Locates the given customer in the list of customer.
	 * @param customer t0 look up
	 * @return index of the given customer in the list, other -1
	 */
	public static int findCustomer(Customer customer) {

		//set default index
		
		
		int index = -1;


		//iterate over customer list and locate the given customer

		for (int i = 0; i < Customer.CUSTOMERS.size(); i++) {
			if (Customer.CUSTOMERS.get(i).equals(customer)){ //calls the equals method in the customer class.
				index = i;
				break;
			}
		}

		return index;
	}
	
	/*
	 * Removes the given customer from the list of customer
	 * @param customer to remove
	 */
	public static void remove(Customer customer) {
		
	int removeIndex = Customer.findCustomer(customer);
	
	if(removeIndex>=0) {
		
		Customer.CUSTOMERS.remove(removeIndex);
		
		
	}
	
	}



	public static void main(String[] args) {
		
		//initialise counter for generating unique IDs for each customer
		Customer.COUNTER = new Counter(1);
		
		//create customer
		
		Customer c1 = new Customer("Kwadwo", "Awoshie");
		Customer c2 = new Customer("Yaw", "Assylum Down");
		Customer c3 = new Customer("Preko", "Botwe");
		
		//prints all customers
		
		Customer.printAllCustomers();
		
		
		//find Customer
		Customer.findCustomer(c3);
		
		//remove customer
		Customer.remove(c3);
		
		
		//prints all customers
		Customer.printAllCustomers();

	}

}
