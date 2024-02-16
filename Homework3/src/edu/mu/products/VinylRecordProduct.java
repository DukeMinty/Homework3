package edu.mu.products;

public class VinylRecordProduct extends MediaProduct{
	
	protected String type;
	
	public VinylRecordProduct(String type, String title, double price, int year, Genre genre) {
		super(title, price, year, genre);
		this.type = type;
	}
	
	//Inherited copy constructor
	public VinylRecordProduct(VinylRecordProduct original) {
		super(original);
	}

}
