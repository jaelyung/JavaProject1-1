package user.order;

import java.util.Scanner;

import store.Menu;
import store.Order;
import store.Store;
import store.Table;
import store.report.GenerateOrderReport;
import test.StartOrderTest;
import utils.Define;

public class StartOrder {
	Store goodStore = Store.getInstance();
	Menu blackTiger;
	Menu realCheese;
	Menu salad;
	
	GenerateOrderReport orderReport = new GenerateOrderReport();
	
	Table table;
	
	public void order(Table t) {
		boolean flag=true;	
		table=t;
		Scanner sc = new Scanner(System.in);
		
		while(flag) {
			System.out.println("\n1.메뉴확인  2.주문하기  3.주문확인  4.종료");
			System.out.print("입력>>");
			String select=sc.nextLine();
			switch(select) {
			case "1":
				goodStore.displayMenu();
				break;
			case "2":
				selectMenu(table);
				break;
			case "3":
				String report = orderReport.getReport();
				System.out.println(report);
				break;
			case "4":
				System.out.println("프로그램을 종료합니다.");
				flag=false;
				break;
			default:
				System.out.println("잘못된 입력입니다.");
				break;
			}
		}
	}
	
	public void createDefaultMenu() {
		blackTiger = new Menu("블랙타이거 피자", 29000);
		realCheese = new Menu("리얼치즈 피자   ", 21000);
		salad = new Menu("샐러드             ", 10000);
		
		blackTiger.setPriceType(Define.PREMIUM);
		realCheese.setPriceType(Define.CLASSIC);
		salad.setPriceType(Define.SIDE);
		
		goodStore.addMenu(blackTiger);
		goodStore.addMenu(realCheese);
		goodStore.addMenu(salad);
		
	}
	
	public void selectMenu(Table table) {
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		while(flag) {
			System.out.println("\n주문할 메뉴를 선택하세요.");
			System.out.println("1.블랙타이거 피자  2.리얼치즈 피자  3.샐러드  4.종료");
			String select = sc.nextLine();
			switch(select) {
			case "1":
				System.out.println("블랙타이거 피자 선택");
				System.out.print("수량입력>>");
				int countMenu1 = Integer.parseInt(sc.nextLine());
				addOrderForTable(table, blackTiger, countMenu1);
				blackTiger.register(table);
				break;
			case "2":
				System.out.println("리얼치즈 피자 선택");
				System.out.print("수량입력>>");
				int countMenu2 = Integer.parseInt(sc.nextLine());
				addOrderForTable(table, realCheese, countMenu2);
				realCheese.register(table);
				break;
			case "3":
				System.out.println("샐러드 선택");
				System.out.println("수량입력>>");
				int countMenu3 = Integer.parseInt(sc.nextLine());
				addOrderForTable(table, salad, countMenu3);
				salad.register(table);
				break;
			case "4":
				System.out.println("주문 종료");
				flag = false;
				break;
			default:
				System.out.println("잘못된 입력입니다.");
				break;
			}
		}
	}
	
	public void addOrderForTable(Table table, Menu menu, int numberOfOrder) {
		
		Order order = new Order(table.getTableNumber(), menu, numberOfOrder);
		table.addMenuOrder(order);
	}
	
}
