import java.util.ArrayList;


public class C206_CaseStudy {

	public static void main(String[] args) {
		
		ArrayList<Foodcorder> foodList = new ArrayList<Foodcorder>();
		ArrayList<Ingredient> orderList = new ArrayList<Ingredient>();
		
		Foodcorder cc1 = new Foodcorder("CC001", "Chicken rice", 4);
		Foodcorder cc2 = new Foodcorder("CC002", "Nasi Lemak", 4);
				
		Ingredient ig1 = new Ingredient("OR001", "Green Onion", "08/08/2022", 10, 1.5, false);
		Ingredient ig2 = new Ingredient("OR002", "Tomato", "07/07/2022", 20, 2.0, false);
		
		foodList.add(cc1);
		foodList.add(cc2);
		orderList.add(ig1);
		orderList.add(ig2);
		
		int option = 0;

		while (option != 5) {

			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// View all items
				C206_CaseStudy.viewAllFood(foodList);


			} else if (option == 2) {
				// Add a new item
				C206_CaseStudy.setHeader("ADD");			

					Foodcorder cc = inputFood();
					C206_CaseStudy.addFoodcorder(foodList, cc);
					System.out.println("Food added");

				} 

			
			else if (option == 3) {
				// Return item
				C206_CaseStudy.setHeader("RETURN");				

					String tag = Helper.readString("Enter food tag > ");
					C206_CaseStudy.returnFoodcorder(foodList, tag);

			} else if (option == 4) {
				while (option != 5) {
					C206_CaseStudy.ingredientMenu();
					option = Helper.readInt("Enter an option > ");
					if (option == 1) {
						C206_CaseStudy.viewAllOrder(orderList);
					} else if (option == 5) {
						System.out.println("Good bye!");
					} else {
						System.out.println("Invalid Option");
					}
				}
			} else if (option == 5) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}

		}

	}

	public static void menu() {
		C206_CaseStudy.setHeader("FOOD MENU APP");
		System.out.println("1. Display menu");
		System.out.println("2. Add food");
		System.out.println("3. Delete food");
		System.out.println("4. Ingredients");
		System.out.println("5. Quit");
		Helper.line(80, "-");

	}
	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}


	//================================= Option 1 View items (CRUD- Read) =================================
	public static String retrieveAllFood(ArrayList<Foodcorder> foodList) {
		String output = "";

		for (int i = 0; i < foodList.size(); i++) {

			output += String.format("%-10s %-30s %-10s\n", foodList.get(i).getAssetTag(),
					foodList.get(i).getName(), 
					foodList.get(i).getOpticalZoom());
		}
		return output;
	}
	public static void viewAllFood(ArrayList<Foodcorder> foodList) {
		C206_CaseStudy.setHeader("FOOD LIST");
		String output = String.format("%-10s %-30s %-10s\n", "FOOD TAG", "FOOD",
				"PRICE");
		 output += retrieveAllFood(foodList);	
		System.out.println(output);
	}



	//================================= Option 2 Add an item (CRUD - Create) =================================
	public static Foodcorder inputFood() {
		String tag = Helper.readString("Enter food tag > ");
		String name = Helper.readString("Enter food > ");
		int price = Helper.readInt("Enter food price > ");

		Foodcorder cc= new Foodcorder(tag, name, price);
		return cc;
		
	}
	public static void addFoodcorder(ArrayList<Foodcorder> foodList, Foodcorder cc) {
		
		foodList.add(cc);
		
	}
	
	
	
	
	//================================= Option 3 Return an item (CRUD - Update)=================================
	public static boolean doReturnFoodcorder(ArrayList<Foodcorder> foodList,String tag) {
		boolean isReturned = false;

		for (int i = 0; i < foodList.size(); i++) {
			if (tag.equalsIgnoreCase(foodList.get(i).getAssetTag())
					) {
				foodList.get(i).setIsAvailable(true);
				
				isReturned = true;
				
			}
		}
		return isReturned;
		
	}
	
	public static void returnFoodcorder(ArrayList<Foodcorder> foodList, String tag) {
		Boolean isReturned = doReturnFoodcorder(foodList, tag);
		
		if (isReturned == false) {
			System.out.println("Invalid food tag");
			
		} else {
		for (int i = 0; i < foodList.size(); i++) {
			if (tag.equalsIgnoreCase(foodList.get(i).getAssetTag())
					) {
				foodList.remove(foodList.get(i));
			}
		}
		System.out.println("food " + tag + " deleted");
		}

	}

	//================================= Option 4 Return an item (CRUD - Update)=================================
	public static void ingredientMenu() {
		C206_CaseStudy.setHeader("Order Menu");
		System.out.println("1. View Order List");
		System.out.println("2. Add Order");
		System.out.println("3. Delete Order");
		System.out.println("5. Quit");
		Helper.line(80, "-");

	}
	
	public static String retrieveAllOrder(ArrayList<Ingredient> orderList) {
		String output = "";

		for (int i = 0; i < orderList.size(); i++) {

			output += String.format("%-84s \n", orderList.get(i).toString());
		}
		return output;
	}
	
	public static void viewAllOrder(ArrayList<Ingredient> orderList) {
		C206_CaseStudy.setHeader("CAMCORDER LIST");
		String output = String.format("%-10s %-10s %-10s %-10s %-20s %-20s\n", "ORDER ID", "NAME",
				"ORDER DATE", "QUATITY","PRICE","DELIVERED");
		 output += retrieveAllOrder(orderList);	
		System.out.println(output);
	}
}