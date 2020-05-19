package user.order;

import java.util.Scanner;

import store.Menu;
import store.Store;
import store.Table;
import store.report.GenerateOrderReport;

public class Admin {
	Store goodStore = Store.getInstance();
	Menu blackTiger;
	Menu realCheese;
	Menu salad;
	
	GenerateOrderReport orderReport = new GenerateOrderReport();
	
	public void createTable() {
		Scanner sc = new Scanner(System.in);
		Table table=null;
		
		System.out.println("주문받을 테이블 번호 입력");
		int tableNumber=Integer.parseInt(sc.nextLine());
		
		table = new Table(tableNumber);
		
		goodStore.addTable(table);
	}
	
	public void orderMenu() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("주문하시겠습니까?");
		System.out.println();//테이블 번호 
	}
}
