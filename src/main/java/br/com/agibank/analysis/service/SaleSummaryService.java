package br.com.agibank.analysis.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.agibank.analysis.model.Costumer;
import br.com.agibank.analysis.model.Sale;
import br.com.agibank.analysis.model.Salesman;

/**
 * 
 * interface for the sales summary business class
 * 
 * @author sergio.melo
 *
 */
@Service
public class SaleSummaryService {

	public int totalCostumers(List<Costumer> costumers) {
		return costumers.size();
	}

	public int totalSalespeople(List<Salesman> salespeople) {
		return salespeople.size();
	}

	public Integer highestSale(List<Sale> sales) {
		return sales.stream()
                .collect(Collectors.groupingBy(Sale::getId,
                        Collectors.summingDouble(Sale::getTotalValue)))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toList())
                .get(sales.size()-1).getKey();
	}

	public String worstVendorName(List<Sale> sales) {
		return sales.stream()
                .collect(Collectors.groupingBy(Sale::getSalesman,
                        Collectors.summingDouble(Sale::getTotalValue)))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toList())
                .get(0).getKey();
	}

}
