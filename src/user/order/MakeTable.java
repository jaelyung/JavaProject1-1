package user.order;

import java.util.Scanner;

import store.Store;
import store.Table;

public class MakeTable {
	Store goodStore = Store.getInstance();
	
	public Table selectTable() {
		Table returnValue = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("���̺� ��ȣ�� �Է��ϼ���.");
		System.out.println("�ֹ����� ���̺� ��ȣ �Է�");
		int tableNumber=Integer.parseInt(sc.nextLine());
		
		returnValue = new Table(tableNumber);
		
		goodStore.addTable(returnValue);
		return returnValue;
	}
}
