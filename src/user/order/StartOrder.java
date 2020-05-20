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
			System.out.println("\n1.�޴�Ȯ��  2.�ֹ��ϱ�  3.�ֹ�Ȯ��  4.����");
			System.out.print("�Է�>>");
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
				System.out.println("���α׷��� �����մϴ�.");
				flag=false;
				break;
			default:
				System.out.println("�߸��� �Է��Դϴ�.");
				break;
			}
		}
	}
	
	public void createDefaultMenu() {
		blackTiger = new Menu("��Ÿ�̰� ����", 29000);
		realCheese = new Menu("����ġ�� ����   ", 21000);
		salad = new Menu("������             ", 10000);
		
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
			System.out.println("\n�ֹ��� �޴��� �����ϼ���.");
			System.out.println("1.��Ÿ�̰� ����  2.����ġ�� ����  3.������  4.����");
			String select = sc.nextLine();
			switch(select) {
			case "1":
				System.out.println("��Ÿ�̰� ���� ����");
				System.out.print("�����Է�>>");
				int countMenu1 = Integer.parseInt(sc.nextLine());
				addOrderForTable(table, blackTiger, countMenu1);
				blackTiger.register(table);
				break;
			case "2":
				System.out.println("����ġ�� ���� ����");
				System.out.print("�����Է�>>");
				int countMenu2 = Integer.parseInt(sc.nextLine());
				addOrderForTable(table, realCheese, countMenu2);
				realCheese.register(table);
				break;
			case "3":
				System.out.println("������ ����");
				System.out.println("�����Է�>>");
				int countMenu3 = Integer.parseInt(sc.nextLine());
				addOrderForTable(table, salad, countMenu3);
				salad.register(table);
				break;
			case "4":
				System.out.println("�ֹ� ����");
				flag = false;
				break;
			default:
				System.out.println("�߸��� �Է��Դϴ�.");
				break;
			}
		}
	}
	
	public void addOrderForTable(Table table, Menu menu, int numberOfOrder) {
		
		Order order = new Order(table.getTableNumber(), menu, numberOfOrder);
		table.addMenuOrder(order);
	}
	
}
