package edu.mu.products;

public class VinylRecordProduct extends MediaProduct{
	
	public VinylRecordProduct(String type, String title, double price, int year, Genre genre) {
		super(title, price, year, genre);
		setType(type);
	}
	
	//Inherited copy constructor
	public VinylRecordProduct(VinylRecordProduct original) {
		super(original);
		setType(original.getType());
	}

}
