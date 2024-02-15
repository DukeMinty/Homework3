package edu.mu.products;

public class TapeRecordProduct extends MediaProduct {
	
	public TapeRecordProduct(String title, double price, int year, Genre genre) {
        super(title, price, year, genre);
	}  
      //Copy Constructor
        public TapeRecordProduct(TapeRecordProduct original) {
    		super(original);	
    	
    	}

}
