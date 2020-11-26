package br.com.agibank.analysis.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sale extends GenericType{

    private final Integer id;
    private final List<ProductSale> products;
    private final String salesman;

    public Sale(String[] lineData) {
        this.id = Integer.valueOf(lineData[1]);
        this.products = new ArrayList<>();
        this.salesman = lineData[3];

        String[] splitedLine = lineData[2].replace("[", "").replace("]", "").split(",");

        Arrays.stream(splitedLine)
                .forEach(product -> products.add(new ProductSale(this.id, product.split("-"))));
    }

    public Double getTotalValue(){
        return products.stream()
                .mapToDouble(v -> v.getTotalValue())
                .sum();
    }

    public Integer getId() {
        return id;
    }

    public String getSalesman() {
        return salesman;
    }

    public List<ProductSale> getProducts() {
        return products;
    }

	@Override
	public void store(SaleSummary storage) {
		storage.addSale(this);
	}

}
