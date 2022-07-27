package comp3350.ims.persistence;

import java.util.ArrayList;

import comp3350.ims.application.Main;
import comp3350.ims.objects.Inventory;
import comp3350.ims.objects.Item;
import comp3350.ims.objects.ItemType;
import comp3350.ims.persistence.DataAccess;

public class DataAccessStub implements DataAccess {
	private String dbName;
	private String dbType = "stub";

	private Inventory activeInventory;
	private ArrayList < String > categoryList;
	private ArrayList < String > locationList;

	public DataAccessStub(String dbName) {
		this.dbName = dbName;
	}

	public DataAccessStub() {
		this(Main.dbName);
	}

	public void open(String dbName) {
		ItemType item;

		activeInventory = new Inventory();
		categoryList = new ArrayList < > ();
		locationList= new ArrayList < > ();

		locationList.add("WareHouse");
		locationList.add("Sales-floor");

		categoryList.add("Dairy");
		categoryList.add("Fruits & vegetables");
		categoryList.add("Meat");
		categoryList.add("Pantry");
		categoryList.add("Seafood");
		categoryList.add("Drinks");
		categoryList.add("Frozen");
		categoryList.add("Bakery");

		item = new ItemType("Milk", 5.55f,  "Ware House", "12/06/2022", "Dairy");
		activeInventory.addItem(item);
		item = new ItemType("Cream", 3.00f,  "Ware House", "12/06/2022", "Dairy");
		activeInventory.addItem(item);
		item = new ItemType("Oreo", 4.00f,  "Ware House", "12/06/2022", "Pantry");
		activeInventory.addItem(item);
		item = new ItemType("Ice Cream", 8.5f,  "Ware House", "12/06/2022", "Frozen");
		activeInventory.addItem(item);
		item = new ItemType("Butter", 3.5f,  "Ware House", "12/06/2022", "Dairy");
		activeInventory.addItem(item);
		item = new ItemType("Bread", 3.5f,  "Ware House", "12/06/2022", "Bakery");
		activeInventory.addItem(item);
		item = new ItemType("Coke 12 pk", 8f,  "Ware House", "12/06/2022", "Drinks");
		activeInventory.addItem(item);
		item = new ItemType("Cheese", 6.5f,  "Ware House", "12/06/2022", "Dairy");
		activeInventory.addItem(item);

		System.out.println("Opened " + dbType + " database " + dbName);
	}

	public void close() {
		System.out.println("Closed " + dbType + " database " + dbName);
	}

	@Override
	public void addItem(Item item, int itemTypeID) {

	}


	public void addItem(Item item, ItemType itemType) {
		activeInventory.addItem(itemType);
	}

	public Inventory getActiveInventory() {
		return activeInventory;
	}

	public void insertItem(ItemType item) {
		// don't bother checking for duplicates
		if(item != null) {
			activeInventory.addItem(item);
		}

	}


	public String getCategoryList(ArrayList < String > categoryList) {
		categoryList.addAll(this.categoryList);
		return null;
	}
	public String getLocationList(ArrayList < String > locationList) {
		locationList.addAll(this.locationList);
		return null;
	}

	public void addCategory(String category) {
		if (category != null) {
			categoryList.add(category);
		}
	}
	public void addLocation(String location) {
		if (location != null) {
			locationList.add(location);
		}
	}

	public boolean removeLocation(String name){
		return locationList.remove(name);
	}

	public boolean removeCategory(String name){
		return categoryList.remove(name);
	}

	public boolean isCategory(String name){
		return categoryList.contains(name) ;
	}

	public boolean isLocation(String name){
		return locationList.contains(name) ;
	}

	public boolean removeItem(int itemID, int itemTypeID, int quantity) {
		return false;
	}

	public boolean editItemType(ItemType itemType, String name, float price, String category) {
		return false;
	}

	public boolean editItem(Item item, String location) {
		return false;
	}



}