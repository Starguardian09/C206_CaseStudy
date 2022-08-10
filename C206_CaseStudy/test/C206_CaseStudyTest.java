import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

// C206 AY2022 SEM1 - Eclipse 21-09 JDK16
public class C206_CaseStudyTest {
	// prepare test data

	// food
	private Foodcorder cc1;
	private Foodcorder cc2;

	// promotion
	private Promotion pc1;
	private Promotion pc2;
	
	// stalls
	private Stall st1;
	private Stall st2;

	// food
	private ArrayList<Foodcorder> FoodcorderList;

	// promotion
	private ArrayList<Promotion> promotionList;

	
	// stall
	private ArrayList<Stall> stallList; 
	
	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		// prepare test data
		// food
		cc1 = new Foodcorder("CC001", "Chicken rice", 4);
		cc2 = new Foodcorder("CC002", "Nasi Lemak", 4);

		// promotion
		pc1 = new Promotion("PC001", "breakfast happy hour", 3);
		pc2 = new Promotion("PC002", "Coffee break time", 3);
		
		// stall
		st1 = new Stall("ST001" , "Ah Huat Chicken Rice");
		st2 = new Stall("ST002" , "Muhd Nasi Briyani");

		FoodcorderList = new ArrayList<Foodcorder>();
		promotionList = new ArrayList<Promotion>();
		stallList = new ArrayList<Stall>();

	}

	@Test
	public void testAddFoodcorder() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid Foodcorder arraylist to add to", FoodcorderList);

		// Given an empty list, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addFoodcorder(FoodcorderList, cc1);
		assertEquals("Test if that Foodcorder arraylist size is 1?", 1, FoodcorderList.size());

		// The item just added is as same as the first item of the list
		assertSame("Test that Foodcorder is added same as 1st item of the list?", cc1, FoodcorderList.get(0));

	}

	@Test
	public void testAddFoodPromotion() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid Foodcorder arraylist to add to", promotionList);

		// Given an empty list, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addPromotion(promotionList, pc1);
		assertEquals("Test if that Foodcorder arraylist size is 1?", 1, promotionList.size());

		// The item just added is as same as the first item of the list
		assertSame("Test that Foodcorder is added same as 1st item of the list?", pc1, promotionList.get(0));

	}

	@Test
	public void testRetrieveAllFoodcorder() {
		// Test if Item list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid Foodcorder arraylist to add to", FoodcorderList);

		// test if the list of Foodcorders retrieved from the SourceCentre is empty
		String allFoodcorder = C206_CaseStudy.retrieveAllFood(FoodcorderList);
		String testOutput = "";
		assertEquals("Check that ViewAllFoodcorderlist", testOutput, allFoodcorder);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		C206_CaseStudy.addFoodcorder(FoodcorderList, cc1);
		C206_CaseStudy.addFoodcorder(FoodcorderList, cc2);
		assertEquals("Test if that Foodcorder arraylist size is 2?", 2, FoodcorderList.size());

		// test if the expected output string same as the list of Foodcorders retrieved
		// from the SourceCentre
		allFoodcorder = C206_CaseStudy.retrieveAllFood(FoodcorderList);

		testOutput = String.format("%-10s %-30s %-10s\n", "CC001", "Chicken rice", 4);
		testOutput += String.format("%-10s %-30s %-10s\n", "CC002", "Nasi Lemak", 4);

		assertEquals("Check that ViewAllFoodcorderlist", testOutput, allFoodcorder);

	}

	@Test
	public void testDoReturnFoodcorder() {
		// boundary
		assertNotNull("Test if there is valid Foodcorder arraylist to add to", FoodcorderList);
		C206_CaseStudy.addFoodcorder(FoodcorderList, cc1);
		// error
		Boolean isReturned = C206_CaseStudy.doReturnFoodcorder(FoodcorderList, "CC001");
		assertTrue("Test if available Foodcorder CC001 is returned -false?", isReturned);
		// normal
//		C206_CaseStudy.addFoodcorder(FoodcorderList, cc2);
//		cc2.setIsAvailable(false);
//		isReturned = C206_CaseStudy.doReturnFoodcorder(FoodcorderList, "CC002");
//		assertTrue("Test if loaned out amcorder CC0012 is returned- true", isReturned);
		// error
		isReturned = C206_CaseStudy.doReturnFoodcorder(FoodcorderList, "CC0013");
		assertFalse("Test if non-existing amcorder CC0013 is returned - false?", isReturned);

	}

	@Test
	public void testRetrieveAllPromotions() {
		assertNotNull("Test if there is a valid promotioncorder array to add to", promotionList);
		String allPromotioncorder = C206_CaseStudy.retrieveAllPromotion(promotionList);
		String testOutput = "";
		assertEquals("Check that ViewAllPromotionslist", testOutput, allPromotioncorder);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		C206_CaseStudy.addPromotion(promotionList, pc1);
		C206_CaseStudy.addPromotion(promotionList, pc2);
		assertEquals("Test if that promotion arraylist size is 2?", 2, promotionList.size());

		// test if the expected output string same as the list of promotioncorder
		// retrieved
		// from the SourceCentre
		allPromotioncorder = C206_CaseStudy.retrieveAllPromotion(promotionList);

		testOutput = String.format("%-10s %-30s %-10s\n", "PC001", "breakfast happy hour", 3);
		testOutput += String.format("%-10s %-30s %-10s\n", "PC002", "Coffee break time", 3);

		assertEquals("Check that ViewAllPromotionlist", testOutput, allPromotioncorder);

	}
	
	@Test
	public void testDoReturnPromotion() {
		// boundary
		assertNotNull("Test if there is valid Promotion arraylist to add to", promotionList);
		C206_CaseStudy.addPromotion(promotionList, pc1);
		// error
		Boolean isReturned = C206_CaseStudy.doReturnPromotion(promotionList, "PC001");
		assertTrue("Test if available Promotion PC001 is returned -false?", isReturned);
		// normal
//		C206_CaseStudy.addFoodcorder(FoodcorderList, cc2);
//		cc2.setIsAvailable(false);
//		isReturned = C206_CaseStudy.doReturnFoodcorder(FoodcorderList, "CC002");
//		assertTrue("Test if loaned out amcorder CC0012 is returned- true", isReturned);
		// error
		isReturned = C206_CaseStudy.doReturnPromotion(promotionList, "PC0013");
		assertFalse("Test if non-existing amcorder PC0013 is returned - false?", isReturned);

	}
	
	@Test
	public void testRetrieveAllStall() {
		assertNotNull("Test if there is a valid stallcorder array to add to", stallList);
		String allStallcorder = C206_CaseStudy.retrieveAllStall(stallList);
		String testOutput = "";
		assertEquals("Check that ViewAllStalllist", testOutput, allStallcorder);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		C206_CaseStudy.addStall(stallList, st1);
		C206_CaseStudy.addStall(stallList, st2);
		assertEquals("Test if that stall arraylist size is 2?", 2, stallList.size());

		// test if the expected output string same as the list of promotioncorder
		// retrieved
		// from the SourceCentre
		allStallcorder = C206_CaseStudy.retrieveAllStall(stallList);

		testOutput = String.format("%-10s %-30s\n", "ST001", "Ah Huat Chicken Rice");
		testOutput += String.format("%-10s %-30s\n", "ST002", "Muhd Nasi Briyani");

		assertEquals("Check that ViewAllStalllist", testOutput, allStallcorder);

	}
	
	@Test
	public void testAddStall() {
		// Item list is not null, so that can add a new item
		assertNotNull("Test if there is valid stall arraylist to add to", stallList);

		// Given an empty list, after adding 1 item, the size of the list is 1
		C206_CaseStudy.addStall(stallList, st1);
		assertEquals("Test if that stall arraylist size is 1?", 1, stallList.size());

		// The item just added is as same as the first item of the list
		assertSame("Test that stall is added same as 1st item of the list?", st1, stallList.get(0));

	}
	
	@Test
	public void testDoReturnStall() {
		// boundary
		assertNotNull("Test if there is valid Stall arraylist to add to", stallList);
		C206_CaseStudy.addStall(stallList, st1);
		// error
		Boolean isReturned = C206_CaseStudy.doDeleteStall(stallList, "ST001");
		assertTrue("Test if available Stall ST001 is returned -false?", isReturned);
		// normal
//		C206_CaseStudy.addFoodcorder(FoodcorderList, cc2);
//		cc2.setIsAvailable(false);
//		isReturned = C206_CaseStudy.doReturnFoodcorder(FoodcorderList, "CC002");
//		assertTrue("Test if loaned out amcorder CC0012 is returned- true", isReturned);
		// error
		isReturned = C206_CaseStudy.doDeleteStall(stallList, "ST0013");
		assertFalse("Test if non-existing stall ST0013 is returned - false?", isReturned);

	}
	
	
	
	

	// yes
	@After
	public void tearDown() throws Exception {
		cc1 = null;
		cc2 = null;
		pc1 = null;
		pc2 = null;
		st1 = null;
		st2 = null;
		
		FoodcorderList = null;
		promotionList = null;
		stallList = null;

//test
	}

}
