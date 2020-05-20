package store.report;

import java.util.ArrayList;

import price.ClassicPrice;
import price.PremiumPrice;
import price.SideDishPrice;
import price.StandardPrice;
import store.Menu;
import store.Order;
import store.Store;
import store.Table;
import utils.Define;

public class GenerateOrderReport {
	Store store = Store.getInstance();
	public static final String TITLE = " �ֹ��� \t\t\n";
	public static final String HEADER = "  �޴���            |  �ܰ�     | ����  | �Ѱ�(��������) \n";
	public static final String LINE ="--------------------------------\n";
	private StringBuffer buffer = new StringBuffer();

	public String getReport() {
		ArrayList<Table> tableList = store.getTableList();
		for(Table table : tableList) {
			makeHeader(table);
			makeBody(table);
			makeFooter();
		}
		return buffer.toString();
	}
	
	public void makeHeader(Table table) {
		buffer.append(GenerateOrderReport.LINE);
		buffer.append("\t" + "<Table"+ table.getTableNumber()+">");
		buffer.append(GenerateOrderReport.TITLE);
		buffer.append("\n");
		buffer.append(GenerateOrderReport.HEADER);
		buffer.append(GenerateOrderReport.LINE);
		
	}
	
	public void makeBody(Table table) {
		ArrayList<Order> orderList = table.getOrderList();
		int totalAmount=0;
		int totalPrice=0;
		for(int i=0; i<orderList.size(); i++) {
			Order order = orderList.get(i);
			buffer.append(order.getMenu().getMenuName());//�޴��̸�
			buffer.append(" | ");
			buffer.append(order.getMenu().getPrice());//�޴��ܰ�
			buffer.append(" | ");
			buffer.append(order.getNumberOfOrder());//�ֹ�����
			totalAmount=totalAmount+order.getNumberOfOrder();
			buffer.append("  | ");
			
			getTotalPrice(table, order.getMenu());
			totalPrice=totalPrice+totalPrice(table, order.getMenu());
			buffer.append("\n");
			buffer.append(LINE);
			
		}
		buffer.append("�� ��������/�����ݾ�           | "+totalAmount+"  | "+totalPrice+" \n");
		buffer.append(LINE);
	}
	
	public int totalPrice(Table table, Menu menu) {
		int returnValue=0;
		ArrayList<Order> orderList = table.getOrderList();
		
		StandardPrice[] standardPrice = { new PremiumPrice(), new ClassicPrice(), new SideDishPrice()};
		
		for(int i=0; i<orderList.size(); i++) {
			
			Order order = table.getOrderList().get(i);
			if(order.getMenu().getMenuName() == menu.getMenuName()) {
				double price = 0;
				
				if(menu.getPriceType() == Define.SIDE) {
					price = standardPrice[Define.SIDE].getPrice(menu.getPrice());
				}else {
					if(menu.getPriceType() == Define.PREMIUM) {
						price = standardPrice[Define.PREMIUM].getPrice(menu.getPrice());
					}else if(menu.getPriceType() == Define.CLASSIC) {
						price = standardPrice[Define.CLASSIC].getPrice(menu.getPrice());
					}
				}
				
				returnValue=(int)price;
				break;
			}
		}
		return returnValue;
	}
	public void getTotalPrice(Table table, Menu menu) {
		ArrayList<Order> orderList = table.getOrderList();
		
		StandardPrice[] standardPrice = { new PremiumPrice(), new ClassicPrice(), new SideDishPrice()};
		
		for(int i=0; i<orderList.size(); i++) {
			
			Order order = table.getOrderList().get(i);
			if(order.getMenu().getMenuName() == menu.getMenuName()) {
				double price = 0;
				
				if(menu.getPriceType() == Define.SIDE) {
					price = standardPrice[Define.SIDE].getPrice(menu.getPrice());
				}else {
					if(menu.getPriceType() == Define.PREMIUM) {
						price = standardPrice[Define.PREMIUM].getPrice(menu.getPrice());
					}else if(menu.getPriceType() == Define.CLASSIC) {
						price = standardPrice[Define.CLASSIC].getPrice(menu.getPrice());
					}
				}
				
				buffer.append((int)price);
				break;
			}
		}
			
	}
	
	public void makeFooter() {
		buffer.append("\n");
	}
}
