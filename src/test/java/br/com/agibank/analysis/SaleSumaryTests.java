package br.com.agibank.analysis;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.agibank.analysis.model.GenericStore;
import br.com.agibank.analysis.service.FileReaderService;
import br.com.agibank.analysis.service.SaleSummaryService;

@SpringBootTest
class SaleSumaryTests {

	@SuppressWarnings("rawtypes")
	private GenericStore store;
	@Autowired
	private FileReaderService read;
	@Autowired
	private SaleSummaryService saleSummaryService;
	
	@SuppressWarnings("rawtypes")
	@BeforeEach
    void Setup(){
		store = new GenericStore();
    }
	
	@SuppressWarnings("unchecked")
	@Test
	void testTotalCustomers() {
		String[] lines = {"002ç92560174000127çEric Von DoomçLatveria", "002ç28973199000153çTony StarkçStark Enterprise"};
		read.lineInterpreter(Arrays.stream(lines), store);
		assertEquals(new Integer(2), saleSummaryService.totalCostumers(store.getCostumers()));     
	}
	
	@SuppressWarnings("unchecked")
	@Test
	void testTotalSellers() {
		String[] lines = {"001ç05708232005çJean Gray Summersç50000", "001ç41093470097çCharles Xavierç40000.99"};
	    read.lineInterpreter(Arrays.stream(lines), store);
	    assertEquals(new Integer(2), saleSummaryService.totalSalespeople(store.getSalespeople()));
	}
	
	@SuppressWarnings("unchecked")
	@Test
	void testMostExpensiveSaleId() {
		String[] lines = {"003ç03ç[1-10-1000000,2-30-1000000,3-40-1000000]çJean Gray Summers", "003ç04ç[1-34-10,2-33-1.50,3-40-0.10]çCharles Xavier"};
        read.lineInterpreter(Arrays.stream(lines), store);
        assertEquals(new Integer(3), saleSummaryService.highestSale(store.getSales()));
	}
	
	@SuppressWarnings("unchecked")
	@Test
	void testWorstSeller() {
		String[] lines = {"003ç03ç[1-10-1000000,2-30-1000000,3-40-1000000]çJean Gray Summers", "003ç04ç[1-34-10,2-33-1.50,3-40-0.10]çCharles Xavier"};
        read.lineInterpreter(Arrays.stream(lines), store);
        assertEquals(new String("Charles Xavier"), saleSummaryService.worstVendorName(store.getSales()));
	}

}
