
public class Promotion extends Item{
private int promotionprice;

	public Promotion(String assetTag, String promotionname, int promotionprice) {
		super(assetTag, promotionname);
		this.promotionprice = promotionprice;
	}

	public int getpromotionprice() {
		return promotionprice;
	}
	
//	public String toString(){
//		String output = "";
//		// Write your codes here
//		return output;
//	}
}

