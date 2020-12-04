package br.com.agibank.analysis.model;

import java.util.ArrayList;
import java.util.List;

public class GenericStore<T,U,V> {

    private List<T> salespeople;
    private List<U> costumers;
    private List<V> sales;
    
    public GenericStore() {
    	salespeople = new ArrayList<T>();
        costumers = new ArrayList<U>();
        sales = new ArrayList<V>();
	}
    
	public void addVendor(T salesman){
    	salespeople.add(salesman);
    }

    public void addCosutmer(U costumer){
        costumers.add(costumer);
    }

    public void addSale(V sale){
        sales.add(sale);
    }
    
	public List<T> getSalespeople() {
		return salespeople;
	}

	public List<U> getCostumers() {
		return costumers;
	}

	public List<V> getSales() {
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
