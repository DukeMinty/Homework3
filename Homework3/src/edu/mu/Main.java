package edu.mu;


import edu.mu.stockManager.StockManagerSingleton;

public class Main {

	public static void main(String[] args) {

		StockManagerSingleton manager = new StockManagerSingleton();
		manager.initializeStock();
		manager.printListOfMediaProduct(manager.getproductList());
		
		//All of the commented methods within the StockManagerSingleton class need to be made

	}

}
