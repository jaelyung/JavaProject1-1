package test;

import store.Menu;
import store.Store;
import store.Table;
import store.report.GenerateOrderReport;
import user.order.MakeTable;
import user.order.StartOrder;
import utils.Define;

public class StartOrderTest {
	
	public static void main(String[] args) {
		StartOrder so = new StartOrder();
		so.createDefaultMenu();
		
		MakeTable mt = new MakeTable();
		Table selectTable = mt.selectTable();
		so.order(selectTable);
	}

}
