package test;

import store.Menu;
import store.Order;
import store.Store;
import store.Table;
import store.report.GenerateOrderReport;
import utils.Define;

public class TestMain {
	
	Store goodStore = Store.getInstance();
	Menu blackTiger;
	Menu realCheese;
	Menu salad;
	
	GenerateOrderReport orderReport = new GenerateOrderReport();

	public static void main(String[] args) {
		
		TestMain test = new TestMain();
		
		test.createMenu();
		test.createTable();
		
		String report = test.orderReport.getReport();
		System.out.println(report);
		
	}

	public void createTable() {
		Table table1 = new Table(1001);
		Table table2 = new Table(1002);
		Table table3 = new Table(1003);
		Table table4 = new Table(2001);
		Table table5 = new Table(2002);
		
		goodStore.addTable(table1);
		goodStore.addTable(table2);
		goodStore.addTable(table3);
		goodStore.addTable(table4);
		goodStore.addTable(table5);
		
		blackTiger.register(table1);
		blackTiger.register(table2);
		
		realCheese.register(table3);
		realCheese.register(table4);
		realCheese.register(table5);
		
		salad.register(table1);
		salad.register(table5);
		
		addOrderForTable(table1, blackTiger, 1);
		addOrderForTable(table1, salad, 1);
		
		addOrderForTable(table2, blackTiger, 1);
		
		addOrderForTable(table3, realCheese, 1);
		
		addOrderForTable(table4, realCheese, 1);
		
		addOrderForTable(table5, realCheese, 1);
		addOrderForTable(table5, salad, 1);
		
		
	}

	public void createMenu() {
		blackTiger = new Menu("블랙타이거", 29000);
		realCheese = new Menu("리얼치즈   ", 21000);
		salad = new Menu("샐러드      ", 10000);
		
		blackTiger.setPriceType(Define.PREMIUM);
		realCheese.setPriceType(Define.CLASSIC);
		salad.setPriceType(Define.SIDE);
		
		goodStore.addMenu(blackTiger);
		goodStore.addMenu(realCheese);
		goodStore.addMenu(salad);
		
	}

	public void addOrderForTable(Table table, Menu menu, int numberOfOrder) {
		
		Order order = new Order(table.getTableNumber(), menu, numberOfOrder);
		table.addMenuOrder(order);
	}
}
