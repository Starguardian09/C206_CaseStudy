/*
 * I declare that this code was written by me. 
 * I do not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: {Min Yao Xin}
 * Student ID: {21008740}
 * Class: {c208-2S4S-W64L}
 * Date/Time created: Sunday 07-08-2022 11:53
 */

/**
 * @author thesa
 *
 */
import java.util.ArrayList;
public class Customer_menu {
	public static void main(String[] args) {
		ArrayList<Nasi_Lemak_stall> HalaFoodList = new ArrayList<Nasi_Lemak_stall>();
		ArrayList<Chicken_Rice_Stall> chickenRice = new ArrayList<Chicken_Rice_Stall>();
		
		Nasi_Lemak_stall HalaFd = new Nasi_Lemak_stall("Nasi Lemak", "Ikanbilis, peanuts, drumstick and rice", 3.20);
		HalaFoodList.add(HalaFd);
		HalaFoodList.add(new Nasi_Lemak_stall("Curry chicken rice", "Curry sauce, rice and curry chieck", 3.50));
		
		int option = 0;
		
		while (option != 5) {
			Customer_menu.menu();
			option = Helper.readInt("Enter an option > ");
			
			if(option == 1) {
				Customer_menu.viewAllNasi_Lemak_stall(HalaFoodList);
			}else if (option ==2) {
				//choose stall to buy 
				Customer_menu.selectFood("Select a stall");
				System.out.println("1. Nasi Lemak Stall");
				
				int HalaFood = Helper.readInt("Enter an option to choose a Hala food > ");
				
				System.out.println("1. Nasi lemak");
				System.out.println("2. Curry chicken rice");
				
				if (HalaFood == 1) {
					Nasi_Lemak_stall select = selectedfood();
					Customer_menu.selectFood(HalaFoodList, HalaFood);
					System.out.println("Nasi Lemak Order has been added to your basket!");
				}else if (HalaFood ==2) {
					Customer_menu.selectFood(HalaFoodList, HalaFood);
			}else {
					System.out.println("Invlaid option");
				}
			}
		}
		
	}

	/**
	 * @param halaFoodList
	 * @param halaFood
	 */
	private static void selectFood(ArrayList<Nasi_Lemak_stall> halaFoodList, int halaFood) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @return
	 */
	private static Nasi_Lemak_stall selectedfood() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param string
	 */
	private static void selectFood(String string) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 
	 */
	private static void menu() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @param halaFoodList
	 */
	private static void viewAllNasi_Lemak_stall(ArrayList<Nasi_Lemak_stall> halaFoodList) {
		// TODO Auto-generated method stub
		
	}
}
