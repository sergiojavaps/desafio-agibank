package br.com.agibank.analysis.model;

public class Costumer extends GenericType {

    private final String cnpj;
    private final String name;
    private final String businessArea;

    public Costumer(String[] buffer) {
        this.cnpj = buffer[1];
        this.name = buffer[2];
        this.businessArea = buffer[3];
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getName() {
        return name;
    }

    public String getBusinessArea() {
        return businessArea;
    }

    @Override
    public void store(Store store) {
        store.addCosutmer(this);
    }
}
