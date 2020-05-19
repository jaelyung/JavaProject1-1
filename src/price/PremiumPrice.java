package price;

public class PremiumPrice implements StandardPrice {
	private double premiumFee=0.2;
	private double tax=0.1;
	@Override
	public double getPrice(int price) {
		return (price*(1+premiumFee))*(1+tax);
	}
	
	
}
