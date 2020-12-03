package br.com.agibank.analysis;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.agibank.analysis.configuration.ConfigProperties;
import br.com.agibank.analysis.model.Store;
import br.com.agibank.analysis.service.FileReaderService;
import br.com.agibank.analysis.service.FileWriterService;
import br.com.agibank.analysis.service.SaleSummaryService;

@SpringBootTest
class WriteFileTests {

	@Autowired
	private ConfigProperties configProperties;
	private Store store;
	@Autowired
	private FileReaderService read;
	@Autowired
	private SaleSummaryService saleSummaryService;
	@Mock
	FileWriterService write;
	
	@BeforeEach
    void Setup(){
		store = new Store();
    }
	
	@Test
	void testWriteFile() {
		
		Path pathIn = Paths.get(configProperties.getInpuFilePath() + "xmen.dat");
		
		String pathOut = configProperties.getInputFilePathTest();
		
		String[] salesmanLine = {"001ç93616248060çLoganç5240.03"};
	    read.lineInterpreter(Arrays.stream(salesmanLine), store);
	    	    
	    String[] costumerLine = {"002ç11467794000114çTony StarkçCiência"};
        read.lineInterpreter(Arrays.stream(costumerLine), store);
              
        String[] SalesLine = {"003ç25ç[21-200-800]çVan Bastern"};
        read.lineInterpreter(Arrays.stream(SalesLine), store);
        
        doNothing().when(write).generateFile(any(Path.class), any(Store.class), anyString(), any(SaleSummaryService.class));
	    
        write.generateFile(pathIn, store, pathOut, saleSummaryService);
        
        verify(write).generateFile(any(Path.class), any(Store.class), anyString(), any(SaleSummaryService.class));
        
	}

}
