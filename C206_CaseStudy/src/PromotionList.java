import java.util.ArrayList;


public class PromotionList {

	public static void main(String[] args) {
		
		ArrayList<Promotion> promotionList = new ArrayList<Promotion>();

		Promotion cc1 = new Promotion("PC001", "breakfast happy hour", 3);
		promotionList.add(cc1);
		
		Promotion cc2 = new Promotion("PC002", "Coffee break time", 3);
		promotionList.add(cc2);
		
		
		int foodoption = 0;
		while (foodoption != 1) {
		PromotionList.main();
		foodoption = Helper.readInt("Enter an option > ");
		
		int option = 0;
		if (option == 1) {
		while (option != 5) {

			PromotionList.promotions();
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
		} else {
			System.out.println("Invalid option");
		}
		}


	}
	
	
	public static void main() {
		PromotionList.setHeader("FOOD promotions APP");
		System.out.println("1. Display FOOD");

		Helper.line(80, "-");

	}

	public static void promotions() {
		PromotionList.setHeader("FOOD promotions APP");
		System.out.println("1. Display promotions");
		System.out.println("2. Add promotion");
		System.out.println("3. Delete promotion");
		System.out.println("5. Quit");
		Helper.line(80, "-");

	}
	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}


	//================================= Option 1 View items (CRUD- Read) =================================
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
