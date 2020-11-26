package br.com.agibank.analysis.model;

public abstract class GenericType {

    public static GenericType identify(String[] lineData){
        String identifier = lineData[0];
        switch (identifier) {
            case "001":
                return new Salesman(lineData);
            case "002":
                return new Costumer(lineData);
            case "003":
                return new Sale(lineData);
        }
        return null;
    }

    public abstract void store(SaleSummary storage);
}