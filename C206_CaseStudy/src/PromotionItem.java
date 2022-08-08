
public class PromotionItem {
	private String assetTag;
	private String promotionname;

//test
	public PromotionItem(String assetTag, String promotionname) {
		this.assetTag = assetTag;
		this.promotionname = promotionname;

	}
	public String toString() {
		
		// Write your codes here
		String itemInfo = String.format("%-10s %-30s", 
				assetTag,
				promotionname);
		return itemInfo;
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
	
	public String getAssetTag() {
		return assetTag;
	}

	public String getName() {
		return promotionname;
	}

}

