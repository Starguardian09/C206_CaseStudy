import java.util.ArrayList;


public class C206_CaseStudy {

	public static void main(String[] args) {
		ArrayList<Nasi_Lemak_stall> HalaFoodList = new ArrayList<Nasi_Lemak_stall>();
		ArrayList<Camcorder> camcorderList = new ArrayList<Camcorder>();
//		ArrayList<Chromebook> chromebookList = new ArrayList<Chromebook>();

		Camcorder cc1 = new Camcorder("CC001", "Sony HDR-CX405", 35);
		camcorderList.add(cc1);
		camcorderList.add(new Camcorder("CC002", "Panasonic HC-MDH2", 10));
//		chromebookList.add(new Chromebook("CB001", "ASUS Chromebook ", "Win 10"));
//		chromebookList.add(new Chromebook("CB002", "HP Chromebook", "Win 10"));

		int option = 0;

		while (option != 5) {

			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// View all items
				C206_CaseStudy.viewAllCamcorder(camcorderList);
//				C206_CaseStudy.viewAllChromebook(chromebookList);

			} else if (option == 2) {
				// Add a new item
				C206_CaseStudy.setHeader("ADD");			
				C206_CaseStudy.setHeader("ITEM TYPES");
				System.out.println("1. Camcorder");
//				System.out.println("2. Chromebook");
				
				int itemType = Helper.readInt("Enter option to select item type > ");

				if (itemType == 1) {
					// Add a camcorder
					Camcorder cc = inputCamcorder();
					C206_CaseStudy.addCamcorder(camcorderList, cc);
					System.out.println("Camcorder added");

				} 
//				else if (itemType == 2) {
//					// Add a Chromebook
//					Chromebook cb = inputChromebook();
//					C206_CaseStudy.addChromebook(chromebookList, cb);
//					System.out.println("Chromebook added");
//
//				} 
				else {
					System.out.println("Invalid type");
				}

			} 
			
			
//			else if (option == 3) {
//				C206_CaseStudy.deletemenu(camcorderList);
//			}
//			else if (option == 3) {
//				// Loan item
//				C206_CaseStudy.setHeader("LOAN");			
//				C206_CaseStudy.setHeader("ITEM TYPES");
//				System.out.println("1. Camcorder");
//				System.out.println("2. Chromebook");
//				
//				int itemType = Helper.readInt("Enter option to select item type > ");
//
//				if (itemType == 1) {
//					// Loan camcorder
//					C206_CaseStudy.loanCamcorder(camcorderList);
//				} else if (itemType == 2) {
//					// Loan Chromebook
//					C206_CaseStudy.loanChromebook(chromebookList);
//				} else {
//					System.out.println("Invalid type");
//				}
//
//			} 
			else if (option == 4) {
				// Return item
				C206_CaseStudy.setHeader("RETURN");				
				C206_CaseStudy.setHeader("ITEM TYPES");
				System.out.println("1. Camcorder");
				
				int itemType = Helper.readInt("Enter option to select item type > ");
				if (itemType == 1) {
					// Return camcorder
					String tag = Helper.readString("Enter asset tag > ");
					C206_CaseStudy.returnCamcorder(camcorderList, tag);
//					C206_CaseStudy.deletemenu(camcorderList);
//				} else if (itemType == 2) {
//					// Return Chromebook
//					C206_CaseStudy.returnChromebook(chromebookList);
				} else {
					System.out.println("Invalid type");
				}

			} else if (option == 5) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}

		}

	}

	public static void menu() {
		C206_CaseStudy.setHeader("RESOURCE CENTRE APP");
		System.out.println("1. Display Inventory");
		System.out.println("2. Add item");
//		System.out.println("3. Delete item");
		System.out.println("4. Return item");
		System.out.println("5. Quit");
		Helper.line(80, "-");

	}
	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

//	public static String showAvailability(boolean isAvailable) {
//		String avail;
//
//		if (isAvailable == true) {
//			avail = "Yes";
//		} else {
//			avail = "No";
//		}
//		return avail;
//	}

	//================================= Option 1 View items (CRUD- Read) =================================
	public static String retrieveAllCamcorder(ArrayList<Camcorder> camcorderList) {
		String output = "";

		for (int i = 0; i < camcorderList.size(); i++) {

			output += String.format("%-10s %-30s %-10s \n", camcorderList.get(i).getAssetTag(),
					camcorderList.get(i).getDescription(), 
//					C206_CaseStudy.showAvailability(camcorderList.get(i).getIsAvailable()),
					camcorderList.get(i).getOpticalZoom());
		}
		return output;
	}
	public static void viewAllCamcorder(ArrayList<Camcorder> camcorderList) {
		C206_CaseStudy.setHeader("CAMCORDER LIST");
		String output = String.format("%-10s %-30s %-10s \n", "ASSET TAG", "DESCRIPTION",
				"AVAILABLE","OPTICAL ZOOM");
		 output += retrieveAllCamcorder(camcorderList);	
		System.out.println(output);
	}

//	public static String retrieveAllChromebook(ArrayList<Chromebook> chromebookList) {
//		String output = "";
//
//		for (int i = 0; i < chromebookList.size(); i++) {
//
//			output += String.format("%-10s %-30s %-10s %-10s \n", chromebookList.get(i).getAssetTag(),
//					chromebookList.get(i).getDescription(), 
//					C206_CaseStudy.showAvailability(chromebookList.get(i).getIsAvailable()),
//					chromebookList.get(i).getOs());
//		}
//		return output;
//	}
//	
//	public static void viewAllChromebook(ArrayList<Chromebook> chromebookList) {
//		C206_CaseStudy.setHeader("CHROME LIST");
//		String output = String.format("%-10s %-30s %-10s %-10s \n", "ASSET TAG", "DESCRIPTION",
//				"AVAILABLE", "OPERATION SYSTEM");
//		 output += retrieveAllChromebook(chromebookList);	
//		System.out.println(output);
//	}

	//================================= Option 2 Add an item (CRUD - Create) =================================
	public static Camcorder inputCamcorder() {
		String tag = Helper.readString("Enter asset tag > ");
		String description = Helper.readString("Enter description > ");
		int zoom = Helper.readInt("Enter optical zoom > ");

		Camcorder cc= new Camcorder(tag, description, zoom);
		return cc;
		
	}
	public static void addCamcorder(ArrayList<Camcorder> camcorderList, Camcorder cc) {
		
		camcorderList.add(cc);
		
	}
	
	public static Nasi_Lemak_stall inputMalayFodd() {	
		
		// write your code here
		String foodName = Helper.readString("Enter asset tag > ");
		String description = Helper.readString("Enter description > ");
		double price = Helper.readDouble("Input price here");

		Nasi_Lemak_stall cb= new Nasi_Lemak_stall(foodName, description, price);
		return cb;
		
	}	
	public static void addChromebook(ArrayList<Nasi_Lemak_stall> chromebookList, Nasi_Lemak_stall cb) {
		// write your code here
		chromebookList.add(cb);
	}
	
	//================================= Option 3 Loan an item (CRUD - Update) =================================
//	public static boolean doLoanCamcorder(ArrayList<Camcorder> camcorderList, String tag) {
//		
//		boolean isLoaned = false;
//
//		for (int i = 0; i < camcorderList.size(); i++) {
//			if (tag.equalsIgnoreCase(camcorderList.get(i).getAssetTag())
//					&& camcorderList.get(i).getIsAvailable() == true) {
//				
//				camcorderList.get(i).setIsAvailable(false);
//				
//				
//				isLoaned = true;
//				
//			}
//		}
//		return isLoaned;
//	}
//	public static void loanCamcorder(ArrayList<Camcorder> camcorderList) {
//		C206_CaseStudy.viewAllCamcorder(camcorderList);
//		String tag = Helper.readString("Enter asset tag > ");
//	
//		Boolean isLoaned =doLoanCamcorder(camcorderList, tag);
//		if (isLoaned == false) {
//			System.out.println("Invalid asset tag");
//		} else {
//			System.out.println("Camcorder " + tag + " loaned out");
//		}
//	}
//	
//	public static boolean doLoanChromebook(ArrayList<Chromebook> chromebookList, String tag) {
//		// write your code here
//		boolean isLoaned = false;
//
//		for (int i = 0; i < chromebookList.size(); i++) {
//			if (tag.equalsIgnoreCase(chromebookList.get(i).getAssetTag())
//					&& chromebookList.get(i).getIsAvailable() == true) {
//				
//				chromebookList.get(i).setIsAvailable(false);
//				
//				
//				isLoaned = true;				
//			}
//		}
//		return isLoaned;
//	}
//	public static void loanChromebook(ArrayList<Chromebook> chromebookList) {
//		// write your code here
//		C206_CaseStudy.viewAllChromebook(chromebookList);
//		String tag = Helper.readString("Enter asset tag > ");
//		
//		Boolean isLoaned =doLoanChromebook(chromebookList, tag);
//		if (isLoaned == false) {
//			System.out.println("Invalid asset tag");
//		} else {
//			System.out.println("Camcorder " + tag + " loaned out");
//		}
//	}
	
	//================================= Option 4 Return an item (CRUD - Update)=================================
	public static boolean doReturnCamcorder(ArrayList<Camcorder> camcorderList,String tag) {
		boolean isReturned = false;

		for (int i = 0; i < camcorderList.size(); i++) {
			if (tag.equalsIgnoreCase(camcorderList.get(i).getAssetTag())
					) {
				camcorderList.get(i).setIsAvailable(true);
				
				isReturned = true;
				
			}
		}
		return isReturned;
		
	}
	//
	public static void returnCamcorder(ArrayList<Camcorder> camcorderList, String tag) {
//		C206_CaseStudy.viewAllCamcorder(camcorderList);
		Boolean isReturned = doReturnCamcorder(camcorderList, tag);
		
		if (isReturned == false) {
			System.out.println("Invalid asset tag");
			
		} else {
		for (int i = 0; i < camcorderList.size(); i++) {
			if (tag.equalsIgnoreCase(camcorderList.get(i).getAssetTag())
					) {
				camcorderList.remove(camcorderList.get(i));
			}
		}
		System.out.println("Camcorder " + tag + " deleted");
		}

	}

//	public static boolean doReturnChromebook(ArrayList<Chromebook> chromebookList,String tag){
//		boolean isReturned = false;
//		// write your code here
//		for (int i = 0; i < chromebookList.size(); i++) {
//			if (tag.equalsIgnoreCase(chromebookList.get(i).getAssetTag())
//					&& chromebookList.get(i).getIsAvailable() == false) {
//				
//				isReturned = true;
//				
//			}
//		}
//		return isReturned;
//	}
//	public static void returnChromebook(ArrayList<Chromebook> chromebookList) {
//		// write your code here
//		C206_CaseStudy.viewAllChromebook(chromebookList);
//		String tag = Helper.readString("Enter asset tag > ");
//		Boolean isReturned = doReturnChromebook(chromebookList, tag);
//		
//		if (isReturned == false) {
//			System.out.println("Invalid asset tag");
//		} else {
//			System.out.println("Camcorder " + tag + " returned");
//		}
//	}
//	public static void deletemenu(ArrayList<Camcorder> camcorderList, Camcorder tag) {
//		
//		camcorderList.remove(tag);
//			
//	}
	
	
	}
