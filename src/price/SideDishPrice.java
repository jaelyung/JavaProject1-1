package price;

public class SideDishPrice implements StandardPrice {
	private double tax=0.1;
	@Override
	public double getPrice(int price) {
		return price*(1+tax);
	}

}
