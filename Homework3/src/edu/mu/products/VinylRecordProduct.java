package edu.mu.products;

public class VinylRecordProduct extends MediaProduct{
	
	public VinylRecordProduct(String title, double price, int year, Genre genre) {
		super(title, price, year, genre);
	}
	
	//Inherited copy constructor
	public VinylRecordProduct(VinylRecordProduct original) {
		super(original);
	}

}
