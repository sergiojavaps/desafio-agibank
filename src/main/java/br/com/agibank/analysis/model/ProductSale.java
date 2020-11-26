package br.com.agibank.analysis.model;

public class ProductSale {

    private final Integer saleID;
    private final Product product;
    private final Integer quantity;

    public ProductSale(Integer saleID, String[] product) {
        this.saleID = new Integer(saleID);
        this.product = new Product(product);
        this.quantity = new Integer(product[1]);
    }

    public Integer getSaleID() {
        return saleID;
    }

    public Product getProduct() {
        return product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getTotalValue(){
        return this.product.getValue() * this.quantity;
    }
}
