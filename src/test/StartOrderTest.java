package test;

import store.Table;
import user.order.MakeTable;
import user.order.StartOrder;

public class StartOrderTest {
	
	public static void main(String[] args) {
		StartOrder so = new StartOrder();
		MakeTable mt = new MakeTable();
		Table selectTable = mt.selectTable();
		so.order(selectTable);
	}

}
