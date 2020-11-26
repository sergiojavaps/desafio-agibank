package br.com.agibank.analysis.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 
 * class responsible for holding the data for sales summary
 * 
 * @author sergio.melo
 * 
 */
public class SaleSummary {

    private List<Salesman> salespeople;
    private List<Costumer> costumers;
    private List<Sale> sales;

    private Sale highestSale;

    public SaleSummary() {
    	salespeople = new ArrayList<>();
        costumers = new ArrayList<>();
        sales = new ArrayList<>();
        highestSale = null;
    }

    public void addVendor(Salesman salesman){
    	salespeople.add(salesman);
    }

    public void addCosutmer(Costumer costumer){
        costumers.add(costumer);
    }

    public void addSale(Sale sale){
        sales.add(sale);
        checkHighestSale(sale);
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

    public Integer totalCostumers(){
        return costumers.size();
    }

    public Integer totalSalespeople(){
        return salespeople.size();
    }

    private void checkHighestSale(Sale sale) {
        if (highestSale == null || highestSale.getTotalValue() < sale.getTotalValue())
            highestSale = sale;
    }

    public Integer getHighestSale() {
        return highestSale.getId();
    }

    public String getWorstVendorName() {
        return sales.stream()
                .collect(Collectors.groupingBy(Sale::getSalesman,
                        Collectors.summingDouble(Sale::getTotalValue)))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toList())
                .get(0).getKey();
    }

    public void finalize(){
        try {
            super.finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
