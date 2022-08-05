
public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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

		   ResourceCentre.menu();
		   option = Helper.readInt("Enter an option > ");

		   if (option == OPTION_VIEW) {
		    // View all items
		    ResourceCentre.viewAllCamcorder(camcorderList);
		    ResourceCentre.viewAllChromebook(chromebookList);

		   } else if (option == OPTION_ADD) {
		    // Add a new item
		    ResourceCentre.setHeader("ADD");   
		    ResourceCentre.setHeader("ITEM TYPES");
		    System.out.println("1. Camcorder");
		    System.out.println("2. Chromebook");
		    
		    int itemType = Helper.readInt("Enter option to select item type > ");

		    if (itemType == 1) {
		     
		     Camcorder cc = inputCamcorder();
		     ResourceCentre.addCamcorder(camcorderList, cc);
		     System.out.println("Camcorder added");

		    } else if (itemType == 2) {
		     
		     Chromebook cb = inputChromebook();
		     ResourceCentre.addChromebook(chromebookList, cb);
		     System.out.println("Chromebook added");

		    } else {
		     System.out.println("Invalid type");
		    }

		   } else if (option == OPTION_LOAN) {
		    // Loan item
		    ResourceCentre.setHeader("LOAN");   
		    ResourceCentre.setHeader("ITEM TYPES");
		    System.out.println("1. Camcorder");
		    System.out.println("2. Chromebook");
		    
		    int itemType = Helper.readInt("Enter option to select item type > ");

		    if (itemType == 1) {
		     
		     ResourceCentre.loanCamcorder(camcorderList);
		    } else if (itemType == 2) {
		     
		     ResourceCentre.loanChromebook(chromebookList);
		    } else {
		     System.out.println("Invalid type");
		    }

		   } else if (option == OPTION_RETURN) {
		    // Return item
		    ResourceCentre.setHeader("RETURN");    
		    ResourceCentre.setHeader("ITEM TYPES");
		    System.out.println("1. Camcorder");
		    System.out.println("2. Chromebook");
		    
		    int itemType = Helper.readInt("Enter option to select item type > ");
		    if (itemType == 1) {
		     
		     ResourceCentre.returnCamcorder(camcorderList);
		    } else if (itemType == 2) {
		     
		     ResourceCentre.returnChromebook(chromebookList);
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
		  ResourceCentre.setHeader("Food Items Menu");
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

}
