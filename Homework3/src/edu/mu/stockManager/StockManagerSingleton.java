package edu.mu.stockManager;

import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import edu.mu.products.*;

public class StockManagerSingleton {
	
	private final String inventoryFilePath = "files/inventory.csv";
	
	private ArrayList<MediaProduct> productList = new ArrayList<MediaProduct>();
	private static StockManagerSingleton instance = null;
	
	public static StockManagerSingleton getInstance() {
		if (instance == null) {
			instance = new StockManagerSingleton();
		}
		
		return instance;
	}
	
	private StockManagerSingleton() { }
	
	public boolean initializeStock(String filePath) {
		try (BufferedReader br = new BufferedReader(new FileReader(inventoryFilePath))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        String[] values = line.split(",");
		        String type = values[0];
		        String title = values[1];
                double price = Double.parseDouble(values[2]);
                int year = Integer.parseInt(values[3]);
                Genre genre = Genre.valueOf(values[4]);
                if(type == "CD") {
                	MediaProduct product = new CDRecordProduct(type,title,price,year,genre);
                	productList.add(product);
                }
                if(type == "Vinyl") {
                	MediaProduct product = new VinylRecordProduct(type,title,price,year,genre);
                	productList.add(product);
                }
                if(type == "Tape") {
                	MediaProduct product = new TapeRecordProduct(type,title,price,year,genre);
                	productList.add(product);
                }
		    }
		    br.close();
		    return true;
		}catch (IOException e) {
			System.out.println("Error occured");
            e.printStackTrace();
            return false;
        }
		catch(IllegalArgumentException e) {
			System.out.println("Data is incompatible");
			e.printStackTrace();
			return false;
		}
	}
	
//	o Updates the price of the given media product to the newPrice.
//	o Returns true if the update is successful, false otherwise
	public boolean updateItemPrice(MediaProduct product, double newPrice) {
		if(product != null && product.getPrice() != newPrice) {
			product.setPrice(newPrice);
			return true;
		}
		return false;
	}
	

//		o Adds a new media product to the inventory.
//		o Returns true if the addiHon is successful, false otherwise.
	public boolean addItem(MediaProduct product){
		if (product == null) {
			      // If product is null, do not add it to the inventory and return false.
			      return false;
			  }

			  // Check if the product already exists in the inventory
			  for (MediaProduct existingProduct : productList) {
			      if (existingProduct.getTitle().equals(product.getTitle()) && existingProduct.getYear() == product.getYear()) {
			          // Product already exists in the inventory, do not add.
			          return false;
			      }
			  }
			  // If product is new, add it to inventory
			  productList.add(product);
			  return true;
	}
	

//		o Removes the given media product from the inventory.
//		o Returns true if the removal is successful, false otherwise.	
	public boolean removeItem(MediaProduct product) {
		if (product == null) {
			return false;
		}
				
		// Ensure that product is in productList
		boolean productExists = false;
		for (MediaProduct existingProduct : productList) {
			if (existingProduct.equals(product)) {
				productExists = true;
				break;
			}
		}
				
		if (productExists) {
			productList.remove(product);
		}
				
		return productExists;
	}

		
//			o Saves the updated inventory back to the CSV file located at inventoryFilePath.
//			o Overwrites the exisHng file with the updated inventory data.
//			o Returns true if the saving is successful, false otherwise (file does not exist, or file empty).	
	public boolean saveStock() {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(inventoryFilePath));
					
			// truncates the file
			bw.flush();
					
			String line1 = "Type,Title,Price,Year,Genre";
			bw.write(line1, 0, line1.length());
					
			// Write each product to the file
			for (MediaProduct product : productList) {
				// Formats the genre to only have the first character capitalized
				String genre = product.getGenre().name().toLowerCase();
				String firstChar = String.valueOf(genre.charAt(0));
				genre = genre.replaceFirst(firstChar, firstChar.toUpperCase());
						
				String line = String.format("%s,%s,%f,%d,%s", 
											product.getType(), product.getTitle(), product.getPrice(), product.getYear(), genre);
				bw.write(line, 0, line.length());
				bw.newLine();
			}
				
			bw.close();
		}
		catch (IOException e){
			System.out.println(e);
			return false;
		}
				
		return true;
	}

	
	
//			• public ArrayList<MediaProduct> getMediaProductBelowPrice(int maxPrice):
//			o Gets the media products that are below the given maxPrice.
//			o This creates a new ArrayList of media products that is below the maxPrice. Beware of
//			not leaking any informaHon.
	
	
//			• public void printListOfMediaProduct(ArrayList<MediaProduct>
//			productList):
//			o Prints the given media product list.
	
	
//			• public ArrayList<VinylRecordProduct> getVinylRecordList(ArrayList<MediaProduct> productList):
//			o Gets the media products as an ArrayList.
//			o This creates a new ArrayList of VinylRecordProduct that filters the vinyl records and
//			returns the ArrayList. Beware of not leaking any informaHon.
	
	
//			• public ArrayList<CDRecordProduct>
//			getCDRecordsList(ArrayList<MediaProduct> productList):
//			o Gets the media products as an ArrayList.
//			o This creates a new ArrayList of CDRecordProduct that filters the CD records and returns
//			the ArrayList. Beware of not leaking any informaHon.
	
	
//			• public ArrayList<TapeRecordProduct>
//			getTapeRecordList(ArrayList<MediaProduct> productList):
//			o Gets the media products as an ArrayList.
//			o This creates a new ArrayList of TapeRecordProduct that filters the tape records and
//			returns the ArrayList. Beware of not leaking any informaHon.

	public ArrayList<MediaProduct> getproductList() {
		return productList;
	}

	public String getInventoryFilePath() {
		return inventoryFilePath;
	}
}
