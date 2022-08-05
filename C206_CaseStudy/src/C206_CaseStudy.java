import java.util.ArrayList;

public class C206_CaseStudy {

//test

		/**
		 * 
		 */
		private static final int OPTION_RETURN = 4;
		/**
		 * 
		 */
		private static final int OPTION_LOAN = 3;
		/**
		 * 
		 */
		private static final int OPTION_ADD = 2;
		/**
		 * 
		 */
		private static final int OPTION_QUIT = 5;
		/**
		 * 
		 */
		private static final int OPTION_VIEW = 1;
		public static void main(String[] args) {

			ArrayList<Camcorder> camcorderList = new ArrayList<Camcorder>();
			ArrayList<Chromebook> chromebookList = new ArrayList<Chromebook>();

			camcorderList.add(new Camcorder("CC001", "Laksa"));
			camcorderList.add(new Camcorder("CC002", "Nasi Lemak"));
			chromebookList.add(new Chromebook("CB001", "Chicken rice"));
			chromebookList.add(new Chromebook("CB002", "Mee Rebus"));

			int option = 0;

			while (option != OPTION_QUIT) {

				C206_CaseStudy.menu();
				option = Helper.readInt("Enter an option > ");

				if (option == OPTION_VIEW) {
					// View all items
					C206_CaseStudy.viewAllCamcorder(camcorderList);
					C206_CaseStudy.viewAllChromebook(chromebookList);

				} else if (option == OPTION_ADD) {
					// Add a new item
					C206_CaseStudy.setHeader("ADD");			
					C206_CaseStudy.setHeader("ITEM TYPES");
					System.out.println("1. Camcorder");
					System.out.println("2. Chromebook");
					
					int itemType = Helper.readInt("Enter option to select item type > ");

					if (itemType == 1) {
						
						Camcorder cc = inputCamcorder();
						C206_CaseStudy.addCamcorder(camcorderList, cc);
						System.out.println("Camcorder added");

					} else if (itemType == 2) {
						
						Chromebook cb = inputChromebook();
						C206_CaseStudy.addChromebook(chromebookList, cb);
						System.out.println("Chromebook added");

					} else {
						System.out.println("Invalid type");
					}

				} else if (option == OPTION_LOAN) {
					// Loan item
					C206_CaseStudy.setHeader("LOAN");			
					C206_CaseStudy.setHeader("ITEM TYPES");
					System.out.println("1. Camcorder");
					System.out.println("2. Chromebook");
					
					int itemType = Helper.readInt("Enter option to select item type > ");

					if (itemType == 1) {
						
						C206_CaseStudy.loanCamcorder(camcorderList);
					} else if (itemType == 2) {
						
						C206_CaseStudy.loanChromebook(chromebookList);
					} else {
						System.out.println("Invalid type");
					}

				} else if (option == OPTION_RETURN) {
					// Return item
					C206_CaseStudy.setHeader("RETURN");				
					C206_CaseStudy.setHeader("ITEM TYPES");
					System.out.println("1. Camcorder");
					System.out.println("2. Chromebook");
					
					int itemType = Helper.readInt("Enter option to select item type > ");
					if (itemType == 1) {
						
						C206_CaseStudy.returnCamcorder(camcorderList);
					} else if (itemType == 2) {
						
						C206_CaseStudy.returnChromebook(chromebookList);
					} else {
						System.out.println("Invalid type");
					}

				} else if (option == OPTION_QUIT) {
					System.out.println("Bye!");
				} else {
					System.out.println("Invalid option");
				}

			}

		}

		public static void menu() {
			C206_CaseStudy.setHeader("Food Items Menu");
			System.out.println("1. Display Menu");
			System.out.println("2. Add item");
			System.out.println("3. Loan item");
			System.out.println("4. Return item");
			System.out.println("5. Quit");
			Helper.line(80, "-");

		}
		
		public static void setHeader(String header) {
			Helper.line(80, "-");
			System.out.println(header);
			Helper.line(80, "-");
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
	 
		//================================= Option 1 View (CRUD - Read) =================================
		public static String retrieveAllCamcorder(ArrayList<Camcorder> camcorderList) {
			String output = "";

			for (int i = 0; i < camcorderList.size(); i++) {

				output += String.format("%-84s \n", camcorderList.get(i).toString());
			}
			return output;
		}
		public static void viewAllCamcorder(ArrayList<Camcorder> camcorderList) {
			C206_CaseStudy.setHeader("NOODLE LIST");
			String output = String.format("%-10s %-30s %-10s %-10s\n", "FOOD TAG", "FOOD",
					"AVAILABLE", "DUE DATE");
			 output += retrieveAllCamcorder(camcorderList);	
			System.out.println(output);
		}
		//test
		public static String retrieveAllChromebook(ArrayList<Chromebook> chromebookList) {
			String output = "";
			// write your code here
			for (int i = 0; i < chromebookList.size(); i++) {

				output += String.format("%-84s \n", chromebookList.get(i).toString());
			}
			return output;
		}
		public static void viewAllChromebook(ArrayList<Chromebook> chromebookList) {
			
			C206_CaseStudy.setHeader("RICE LIST");
			String output = String.format("%-10s %-30s %-10s %-10s\n", "ASSET TAG", "FOOD",
					 "AVAILABLE", "DUE DATE","OPERATING SYSTEM");
			 output += retrieveAllChromebook(chromebookList);
			System.out.println(output);
		}

		//================================= Option 2 Add (CRUD - Create)=================================
		public static Camcorder inputCamcorder() {
			String tag = Helper.readString("Enter asset tag > ");
			String description = Helper.readString("Enter food > ");

			Camcorder cc= new Camcorder(tag, description);
			return cc;
			
		}
		public static void addCamcorder(ArrayList<Camcorder> camcorderList, Camcorder cc) {
			
			camcorderList.add(cc);
			
		}
		
		public static Chromebook inputChromebook() {
			String tag = Helper.readString("Enter asset tag > ");
			String description = Helper.readString("Enter food > ");

			Chromebook cb= new Chromebook(tag, description);
			return cb;
			
		}	
		public static void addChromebook(ArrayList<Chromebook> chromebookList, Chromebook cb) {

			chromebookList.add(cb);
			
		}
		
		//================================= Option 3 Loan (CURD- Update) =================================
		public static boolean doLoanCamcorder(ArrayList<Camcorder> camcorderList, String tag, String dueDate) {
			
			boolean isLoaned = false;

			for (int i = 0; i < camcorderList.size(); i++) {
				
				
				if (tag.equalsIgnoreCase(camcorderList.get(i).getAssetTag())				
						&& camcorderList.get(i).getIsAvailable() == true) {
					
					camcorderList.get(i).setIsAvailable(false);
					camcorderList.get(i).setDueDate(dueDate);
					
					isLoaned = true;
					
				}
			}
			return isLoaned;
		}

		public static void loanCamcorder(ArrayList<Camcorder> camcorderList) {
			C206_CaseStudy.viewAllCamcorder(camcorderList);
			String tag = Helper.readString("Enter asset tag > ");
			String due = Helper.readString("Enter due date > ");
			Boolean isLoaned =doLoanCamcorder(camcorderList, tag, due);
			if (isLoaned == false) {
				System.out.println("Invalid asset tag");
			} else {
				System.out.println("Camcorder " + tag + " loaned out");
			}
		}
		

		public static boolean doLoanChromebook(ArrayList<Chromebook> chromebookList, String tag, String dueDate) {
			// write your code here
			boolean isLoaned = false;

			for (int i = 0; i < chromebookList.size(); i++) {

				if (tag.equalsIgnoreCase(chromebookList.get(i).getAssetTag())
						
						&& chromebookList.get(i).getIsAvailable() == true) {
					
					chromebookList.get(i).setIsAvailable(false);
					chromebookList.get(i).setDueDate(dueDate);
					
					isLoaned = true;
					
				}
			}
			return isLoaned;
		}

		public static void loanChromebook(ArrayList<Chromebook> chromebookList) {
			// write your code here
			C206_CaseStudy.viewAllChromebook(chromebookList);
			String tag = Helper.readString("Enter asset tag > ");
			String due = Helper.readString("Enter due date > ");
			Boolean isLoaned =doLoanChromebook(chromebookList, tag, due);
			if (isLoaned == false) {
				System.out.println("Invalid asset tag");
			} else {
				System.out.println("Chromebook " + tag + " loaned out");
			}	
			
		}
		//================================= Option 4 Return (CURD- Update)=================================
		public static boolean doReturnCamcorder(ArrayList<Camcorder> camcorderList,String tag) {
			//gay
			boolean isReturned = false;

			for (int i = 0; i < camcorderList.size(); i++) {
				String assetTag = camcorderList.get(i).getAssetTag();
				if (tag.equalsIgnoreCase(assetTag)
						&& camcorderList.get(i).getIsAvailable() == false) {
					camcorderList.get(i).setIsAvailable(true);
					camcorderList.get(i).setDueDate("");
					isReturned = true;
					
				}
			}
			return isReturned;
			
		}

		public static void returnCamcorder(ArrayList<Camcorder> camcorderList) {
			C206_CaseStudy.viewAllCamcorder(camcorderList);
			String tag = Helper.readString("Enter asset tag > ");
			Boolean isReturned = doReturnCamcorder(camcorderList, tag);
			
			if (isReturned == false) {
				System.out.println("Invalid asset tag");
			} else {
				System.out.println("Camcorder " + tag + " returned");
			}
		}
		// write your doReturnChromebook code here
		public static boolean doReturnChromebook(ArrayList<Chromebook> chromebookList,String tag) {
			boolean isReturned = false;

			for (int i = 0; i < chromebookList.size(); i++) {
				String assetTag = chromebookList.get(i).getAssetTag();
				if (tag.equalsIgnoreCase(assetTag)
						&& chromebookList.get(i).getIsAvailable() == false) {
					chromebookList.get(i).setIsAvailable(true);
					chromebookList.get(i).setDueDate("");
					isReturned = true;
					
				}
			}
			return isReturned;
			
		}
		public static void returnChromebook(ArrayList<Chromebook> chromebookList) {
			// write your code here
			C206_CaseStudy.viewAllChromebook(chromebookList);
			String tag = Helper.readString("Enter asset tag > ");
			Boolean isReturned = doReturnChromebook(chromebookList, tag);
			
			if (isReturned == false) {
				System.out.println("Invalid asset tag");
			} else {
				System.out.println("Chromebook " + tag + " returned");
			}
		}


	}
