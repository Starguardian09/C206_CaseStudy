/*
 * I declare that this code was written by me. 
 * I do not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Reuben Sim
 * Student ID: 21019352
 * Class: W64N
 * Date/Time created: Monday 08-08-2022 10:12
 */

/**
 * @author 21019352
 *
 */
public class Ingredient {
	private String orderID;
	private String name;
	private String orderDate;
	private int quantity;
	private double price;
	private boolean isDelivered;
//test
	public Ingredient(String orderID, String name) {
		this.orderID = orderID;
		this.name = name;
		this.orderDate = "";
		this.isDelivered = true;
	}
	
	public String toString() {
		
		String itemInfo = String.format("%-10s %-30s %-10s %-10s", 
				orderID,
				name, 
				showAvailability(isDelivered),	
				orderDate);
		return itemInfo;
	}
	
	public static String showAvailability(boolean isDelivered) {
		String avail;

		if (isDelivered == true) {
			avail = "Yes";
		} else {
			avail = "No";
		}
		return avail;
	}
	
	public String getorderID() {
		return orderID;
	}

	public String getName() {
		return name;
	}

	public String getorderDate() {
		return orderDate;
	}

	public void setorderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean getisDelivered() {
		return isDelivered;
	}

	public void setisDelivered(boolean isDelivered) {
		this.isDelivered = isDelivered;
	}
}
