public class Food {
	private String foodName;
	private String description;
	private double Price;
	private boolean isAvailable;
//test
	public Food(String foodName, String description, double price) {
		this.foodName = foodName;
		this.description = description;
		this.Price = price;
		this.isAvailable = true;
	}
	public String toString() {
		
		// Write your codes here
		String foodDscrp = String.format("%-10s %-30s %-10s %-10s", 
				foodName,
				description, 
				showAvailability(isAvailable),	
				Price);
		return foodDscrp;
	}
	
	public static String showAvailability(boolean isAvailable) {
		String avail;

		if (isAvailable == true) {
			avail = "Yes";
		} else {
			avail = "No";
		}
		return avail;
	}
	
	public String getFoodName() {
		return foodName;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		this.Price = price;
	}

	public boolean getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
}
