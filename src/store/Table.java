package store;

import java.util.ArrayList;

public class Table {
	private int tableNumber;
	private ArrayList<Order> orderList = new ArrayList<Order>();
	
	public Table(){}
	public Table(int tableNumber) {
		this.tableNumber=tableNumber;
	}
	
	public void addMenuOrder(Order order) {
		orderList.add(order);
	}
	public int getTableNumber() {
		return tableNumber;
	}
	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}
	public ArrayList<Order> getOrderList() {
		return orderList;
	}
	public void setOrderList(ArrayList<Order> orderList) {
		this.orderList = orderList;
	}
	
}
