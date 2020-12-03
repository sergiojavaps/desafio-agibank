package br.com.agibank.analysis;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.agibank.analysis.configuration.ConfigProperties;
import br.com.agibank.analysis.service.FileFinderService;
import br.com.agibank.analysis.service.FileReaderService;
import br.com.agibank.analysis.service.FileWriterService;
import br.com.agibank.analysis.service.SaleSummaryService;

@SpringBootTest
class WriteFileTests {

	@Autowired
	private ConfigProperties configProperties;
	@Autowired
	private FileReaderService read;
	@Autowired
	private SaleSummaryService saleSummaryService;
	@Autowired
	FileWriterService write;
	@Autowired
	FileFinderService finder;
	
	@Test
	void testWriteFile() throws IOException {										   
		new File(configProperties.getInputFilePathTest()).mkdirs();
		new File(configProperties.getOutputFilePathTest()).mkdirs();
		finder.search(configProperties.getInputFilePathTest()).stream()
		.forEach(file -> read.readFile(file, configProperties.getOutputFilePathTest(), saleSummaryService));         
        File directory = new File(configProperties.getOutputFilePathTest()); 
        File[] files = directory.listFiles();                     
        assertEquals(1, files.length);
	}

}
