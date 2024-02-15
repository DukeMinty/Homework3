package edu.mu.products;

public class CDRecordProduct extends MediaProduct{
	public CDRecordProduct(String title, double price, int year, Genre genre) {
		super(title, price, year, genre);
	}
	
	//Copy Constructor
	public CDRecordProduct(CDRecordProduct original) {
		super(original);
	}
}
