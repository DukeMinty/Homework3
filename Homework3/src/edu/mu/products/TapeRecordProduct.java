package edu.mu.products;

public class TapeRecordProduct extends MediaProduct {
	
	public TapeRecordProduct(String type, String title, double price, int year, Genre genre) {
        super(title, price, year, genre);
        setType(type);
        
	}  
      //Copy Constructor
        public TapeRecordProduct(TapeRecordProduct original) {
    		super(original);	
    		setType(original.getType());
    	}

}
