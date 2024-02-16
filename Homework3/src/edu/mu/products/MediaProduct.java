package edu.mu.products;

public class MediaProduct {
	

	protected String title;
	protected double price;
	protected int year;
	protected Genre genre;
	protected String type = "None";
	
	public MediaProduct(String title, double price, int year, Genre genre) {
		this.title = title;
		this.price = price;
		this.year = year;
		this.genre = genre;
	}
	
	//copy constructor
	public MediaProduct(MediaProduct original) {
		this.title = original.title;
		this.price = original.price;
		this.year = original.year;
		this.genre = original.genre;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public boolean equals(Object obj) {
		MediaProduct other = (MediaProduct)obj;
		// Compares all attributes individually
		return other.getPrice() == price && other.getYear() == year && 
			   other.getGenre() == genre && other.getTitle() == title &&
			   this.getClass() == other.getClass();
	}
	
	public static boolean toString(MediaProduct mediaProduct) {
		if(mediaProduct==null) {
			return false;
		}
		else {
			System.out.println("Type: " + mediaProduct.getType() + ", Title: " + mediaProduct.getTitle() + ", Price: " + mediaProduct.getPrice()+ ", Year: " + mediaProduct.getYear() + ", Genre: " + mediaProduct.getGenre());
			return true;
		}
	}
}
