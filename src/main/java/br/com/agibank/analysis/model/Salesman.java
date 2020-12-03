package br.com.agibank.analysis.model;



public class Salesman extends GenericType {

    private final String cpf;
    private final String name;
    private final Double salary;

    public Salesman(String[] buffer) {
        this.cpf = buffer[1];
        this.name = buffer[2];
        this.salary = Double.parseDouble(buffer[3]);
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public Double getSalary() {
        return salary;
    }

    @Override
    public void store(Store store) {
    	store.addVendor(this);
    }

}
