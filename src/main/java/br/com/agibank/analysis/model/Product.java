package br.com.agibank.analysis.model;

public class Product {

    private final Integer id;
    private final Double price;

    public Product(String[] lineData) {
        this.id = new Integer(lineData[0]);
        this.price = new Double(lineData[2]);
    }

    public Integer getId() {
        return id;
    }

    public Double getPrice() {
        return price;
    }

    public Double getValue(){
        return this.price;
    }
}
