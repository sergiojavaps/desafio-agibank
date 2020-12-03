package br.com.agibank.analysis.model;

import java.util.ArrayList;
import java.util.List;

public class Store {

	private List<Salesman> salespeople;
    private List<Costumer> costumers;
    private List<Sale> sales;
    
    public Store() {
    	salespeople = new ArrayList<>();
        costumers = new ArrayList<>();
        sales = new ArrayList<>();
	}
    
    public void addVendor(Salesman salesman){
    	salespeople.add(salesman);
    }

    public void addCosutmer(Costumer costumer){
        costumers.add(costumer);
    }

    public void addSale(Sale sale){
        sales.add(sale);
    }
    
    public List<Salesman> getSalespeople() {
		return salespeople;
	}

	public List<Costumer> getCostumers() {
		return costumers;
	}

	public List<Sale> getSales() {
		return sales;
	}
	
	public void finalize(){
        try {
            super.finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
	
}
