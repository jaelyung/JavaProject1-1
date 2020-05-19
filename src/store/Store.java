package store;

import java.util.ArrayList;

public class Store {

	private static Store instance = new Store();
	
	private static String STORE_NAME = "Good Store";
	private ArrayList<Table> tableList = new ArrayList<Table>();
	private ArrayList<Menu> menuList = new ArrayList<Menu>();
	
	private Store() {}
	
	public static Store getInstance() {
		if(instance == null) {
			instance = new Store();
		}
		return instance;		
	}

	public ArrayList<Table> getTableList() {
		return tableList;
	}
	
	public void addTable(Table table) {
		tableList.add(table);
	}
	
	public void addMenu(Menu menu) {
		menuList.add(menu);
	}

	public ArrayList<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(ArrayList<Menu> menuList) {
		this.menuList = menuList;
	}
	
	
	
}
