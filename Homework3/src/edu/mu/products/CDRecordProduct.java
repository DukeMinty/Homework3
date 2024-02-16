package edu.mu.products;

public class CDRecordProduct extends MediaProduct{
	public CDRecordProduct(String type, String title, double price, int year, Genre genre) {
		super(title, price, year, genre);
		setType(type);
	}
	
	//Copy Constructor
	public CDRecordProduct(CDRecordProduct original) {
		super(original);
		setType(original.getType());
	}
}
