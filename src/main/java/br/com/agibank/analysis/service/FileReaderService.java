package br.com.agibank.analysis.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.agibank.analysis.model.GenericType;
import br.com.agibank.analysis.model.Store;

/**
 * 
 * Responsible for reading data from input files
 * 
 * @author sergio.melo
 *
 */
@Service
public class FileReaderService {

	@Autowired
	private FileWriterService fileWriterService;
	
	public void readFile(Path file, String outputFilePath, SaleSummaryService saleSummaryService) {
		try {		    
			Store store = new Store();
		    Stream<String> stream = Files.lines(file);
		    lineInterpreter(stream, store);
		    fileWriterService.generateFile(file, store, outputFilePath, saleSummaryService);
		    store.finalize();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}

    public void lineInterpreter(Stream<String> stream, Store store){
        stream.map(line -> line.split("ç"))
                .collect(Collectors.toList())
                .forEach(line -> GenericType.identify(line).store(store));
    }
	
}
