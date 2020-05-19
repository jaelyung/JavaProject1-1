package price;

public class ClassicPrice implements StandardPrice {
	private double classicFee=0.1;
	private double tax=0.1;
	@Override
	public double getPrice(int price) {
		return (price*(1+classicFee))*(1+tax);
	}
	

}
