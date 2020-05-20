package store;

import java.util.ArrayList;

import utils.Define;

public class Menu {
	private String menuName;
	private int price;
	private int priceType;
	private String priceTypeName;
	
	private ArrayList<Table> tableList = new ArrayList<Table>();
	
	public Menu() {}

	public Menu(String menuName, int price) {
		this.menuName = menuName;
		this.price = price;
		this.priceType = Define.CLASSIC;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPriceType() {
		return priceType;
	}

	public void setPriceType(int priceType) {
		this.priceType = priceType;
	}

	public ArrayList<Table> getTableList() {
		return tableList;
	}

	public void setTableList(ArrayList<Table> tableList) {
		this.tableList = tableList;
	}
	
	public void register(Table table) {
		tableList.add(table);
	}

	@Override
	public String toString() {
		if(priceType == Define.PREMIUM) {
			priceTypeName = "Premium Pizza (Premium fee:20%, tax:10% 별도부과)";
		}else if(priceType == Define.CLASSIC) {
			priceTypeName = "Classic Pizza (Classic fee:10%, tax:10% 별도부과)";
		}else {
			priceTypeName = "Sidemenu (Sidemenu fee:0%, tax:10% 별도부과)";
		}
		return "Menu [메뉴명=" + menuName + ", 단가=" + price + ", 메뉴가격=" + priceTypeName + "]";
	}
}
