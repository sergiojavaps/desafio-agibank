package br.com.agibank.analysis;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.agibank.analysis.model.Costumer;
import br.com.agibank.analysis.model.Product;
import br.com.agibank.analysis.model.ProductSale;
import br.com.agibank.analysis.model.Sale;
import br.com.agibank.analysis.model.Salesman;
import br.com.agibank.analysis.model.Store;
import br.com.agibank.analysis.service.FileReaderService;


@SpringBootTest
class ModelTests {

	private Store store;
	@Autowired
	private FileReaderService read;
	
	@BeforeEach
    void Setup(){
		store = new Store();
    }

	@Test 
	void testSalesmanLineSummary() {
		String[] line = {"001ç93616248060çLoganç5240.03"};
	    read.lineInterpreter(Arrays.stream(line), store);
	    Salesman salesman = store.getSalespeople().get(0);
	    assertEquals(new String("93616248060"), salesman.getCpf());
	    assertEquals(new String("Logan"), salesman.getName());
	    assertEquals(new Double(5240.03), salesman.getSalary());
	 }
	 
	@Test
    void testCostumerLineSummary() {
        String[] line = {"002ç11467794000114çTony StarkçCiência"};
        read.lineInterpreter(Arrays.stream(line), store);
        Costumer costumer = store.getCostumers().get(0);
        assertEquals(new String("11467794000114"), costumer.getCnpj());
        assertEquals(new String("Tony Stark"), costumer.getName());
        assertEquals(new String("Ciência"), costumer.getBusinessArea());
    }
	
	@Test
    void testSaleLineSummary() {
        String[] line = {"003ç25ç[21-200-800]çVan Bastern"};
        read.lineInterpreter(Arrays.stream(line), store);
        Sale sale = store.getSales().get(0);
        ProductSale productSale = sale.getProducts().get(0);
        Product product = productSale.getProduct();
        assertEquals(new Integer(25), sale.getId());
        assertEquals(new String("Van Bastern"), sale.getSalesman());
        assertEquals(new Integer(25), productSale.getSaleID());
        assertEquals(new Integer(200), productSale.getQuantity());
        assertEquals(new Double(160000), productSale.getTotalValue());
        assertEquals(new Integer(21), product.getId());
        assertEquals(new Double(800), product.getValue());
    }
    
}
