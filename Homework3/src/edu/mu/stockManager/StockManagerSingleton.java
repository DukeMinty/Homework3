package edu.mu.stockManager;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import edu.mu.products.Genre;
import edu.mu.products.MediaProduct;

public class StockManagerSingleton {
	
	private final String inventoryFilePath = "files/inventory.csv";
	
	//Ask prof how to make list more protected
	private ArrayList<MediaProduct> productList = new ArrayList<MediaProduct>();
	
	
	public boolean initializeStock(String filePath) {
		try (BufferedReader br = new BufferedReader(new FileReader(inventoryFilePath))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        String[] values = line.split(",");
		        String title = values[0];
                double price = Double.parseDouble(values[1]);
                int year = Integer.parseInt(values[2]);
                Genre genre = Genre.valueOf(values[3]);
		        MediaProduct product = new MediaProduct(title,price,year,genre);
		        productList.add(product);
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
		public boolean updateItemPrice(MediaProduct product, double newPrice) {
			if(product != null && product.getPrice() != newPrice) {
				product.setPrice(newPrice);
				return true;
			}
			return false;
		}
//			o Updates the price of the given media product to the newPrice.
//			o Returns true if the update is successful, false otherwise
	
	
//			• public boolean addItem(MediaProduct product):
//			o Adds a new media product to the inventory.
//			o Returns true if the addiHon is successful, false otherwise.
	
	
//			• public boolean removeItem(MediaProduct product):
//			o Removes the given media product from the inventory.
//			o Returns true if the removal is successful, false otherwise.
	
	
//			• public boolean saveStock():
//			o Saves the updated inventory back to the CSV file located at inventoryFilePath.
//			o Overwrites the exisHng file with the updated inventory data.
//			o Returns true if the saving is successful, false otherwise (file does not exist, or file empty).
	
	
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
