package P122_SellBuyStock;

public class P122_solution {
	private int maxProfit(int[] price) {
		int maxprofit=0;
		
		for(int i=0;i<price.length;i++) {
			if(price[i]<price[i+1]) {
				maxprofit+=(price[i+1]-price[i]);
			}
		}
		return maxprofit;
	}
}
