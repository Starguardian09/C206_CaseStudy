import java.util.ArrayList;


public class C206_CaseStudy {

	public static void main(String[] args) {
		
		// Food 
		
		ArrayList<Foodcorder> foodList = new ArrayList<Foodcorder>();

		Foodcorder cc1 = new Foodcorder("CC001", "Chicken rice", 4);
		foodList.add(cc1);
		
		Foodcorder cc2 = new Foodcorder("CC002", "Nasi Lemak", 4);
		foodList.add(cc2);
		
		// Promotion
		
		ArrayList<Promotion> promotionList = new ArrayList<Promotion>();

		Promotion pc1 = new Promotion("PC001", "breakfast happy hour", 3);
		promotionList.add(pc1);
		
		Promotion pc2 = new Promotion("PC002", "Coffee break time", 3);
		promotionList.add(pc2);
		
		int option = 0;

		while (option != 5) {

			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			
			// PROMOTION OPTION
			if (option == 1) {
			
				while (option != 5) {

					C206_CaseStudy.promotions();
					option = Helper.readInt("Enter an option > ");

					if (option == 1) {
						// View all items
						PromotionList.viewAllPromotion(promotionList);


					} else if (option == 2) {
						// Add a new item
						PromotionList.setHeader("ADD");			

							Promotion cc = inputPromotion();
							PromotionList.addPromotion(promotionList, cc);
							System.out.println("Promotion added");

						} 

					
					else if (option == 3) {
						// Return item
						PromotionList.setHeader("RETURN");				

							String tag = Helper.readString("Enter promo tag > ");
							PromotionList.returnPromotion(promotionList, tag);

					} else if (option == 5) {
						System.out.println("Bye!");
					} else {
						System.out.println("Invalid option");
					}
				}	
			} 
			
			// FOOD OPTION
			else if (option == 2) {
				
				while (option != 5) {

				      C206_CaseStudy.food();
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

				      } else if (option == 5) {
				        System.out.println("Bye!");
				      } else {
				        System.out.println("Invalid option");
				      }

				    }
				
		
				
			} 

			else if (option == 3) {

			} 
			
			else if (option == 4) {
				
				
			} 
			
			else {
				System.out.println("Invalid option");
			}

		}

	}

	public static void menu() {
		C206_CaseStudy.setHeader("CANTEEN APP");
		System.out.println("1. Promotions");
		System.out.println("2. Food");
		System.out.println("3. Stalls");
		System.out.println("4. Request Order");
		System.out.println("5. Quit");
		Helper.line(80, "-");

	}
	
	public static void promotions() {
		PromotionList.setHeader("FOOD PROMOTION APP");
		System.out.println("1. Display promotions");
		System.out.println("2. Add promotion");
		System.out.println("3. Delete promotion");
		System.out.println("5. Quit");
		Helper.line(80, "-");

	}
	
	public static void food() {
		PromotionList.setHeader("FOOD MENU APP");
		System.out.println("1. Display food");
		System.out.println("2. Add food");
		System.out.println("3. Delete food");
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
	
	//================================= Option 1 View Promotions (CRUD- Read) =================================
	public static String retrieveAllPromotion(ArrayList<Promotion> promotionList) {
		String output = "";

		for (int i = 0; i < promotionList.size(); i++) {

			output += String.format("%-10s %-30s %-10s\n", promotionList.get(i).getAssetTag(),
					promotionList.get(i).getName(), 
					promotionList.get(i).getpromotionprice());
		}
		return output;
	}
	public static void viewAllPromotion(ArrayList<Promotion> promotionList) {
		PromotionList.setHeader("PROMOTION LIST");
		String output = String.format("%-10s %-30s %-10s\n", "PROMO TAG", "PROMOTION",
				"PRICE");
		 output += retrieveAllPromotion(promotionList);	
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
	
	
	//================================= Option 2 Add promotion (CRUD - Create) =================================
	public static Promotion inputPromotion() {
		String tag = Helper.readString("Enter promo tag > ");
		String name = Helper.readString("Enter promotion > ");
		int price = Helper.readInt("Enter promotion price > ");

		Promotion cc= new Promotion(tag, name, price);
		return cc;
		
	}
	public static void addPromotion(ArrayList<Promotion> promotionList, Promotion cc) {
		
		promotionList.add(cc);
		
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
	
	
	//================================= Option 3 Delete Promotion (CRUD - Update)=================================
	public static boolean doReturnPromotion(ArrayList<Promotion> promotionList,String tag) {
		boolean isReturned = false;

		for (int i = 0; i < promotionList.size(); i++) {
			if (tag.equalsIgnoreCase(promotionList.get(i).getAssetTag())
					) {
				promotionList.get(i).setIsAvailable(true);
				
				isReturned = true;
				
			}
		}
		return isReturned;
		
	}
	
	public static void returnPromotion(ArrayList<Promotion> promotionList, String tag) {
		Boolean isReturned = doReturnPromotion(promotionList, tag);
		
		if (isReturned == false) {
			System.out.println("Invalid promo tag");
			
		} else {
		for (int i = 0; i < promotionList.size(); i++) {
			if (tag.equalsIgnoreCase(promotionList.get(i).getAssetTag())
					) {
				promotionList.remove(promotionList.get(i));
			}
		}
		System.out.println("promotion " + tag + " deleted");
		}

	}
	}
//small test reuben 
