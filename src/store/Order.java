package store;

public class Order {
	int tableNumber;
	Menu menu;
	int numberOfOrder;
	
	public Order() {}
	public Order(int tableNumber, Menu menu, int numberOfOrder) {
		this.tableNumber=tableNumber;
		this.menu=menu;
		this.numberOfOrder=numberOfOrder;
	}
	
	public int getTableNumber() {
		return tableNumber;
	}
	
	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}
	
	public Menu getMenu() {
		return menu;
	}
	
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
	public int getNumberOfOrder() {
		return numberOfOrder;
	}
	
	public void setNumberOfOrder(int numberOfOrder) {
		this.numberOfOrder = numberOfOrder;
	}
	@Override
	public String toString() {
		return "주문서 [테이블번호=" + tableNumber + ", menu=" + menu + ", numberOfOrder=" + numberOfOrder + "]";
	}
	
	
}
