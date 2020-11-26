package br.com.agibank.analysis.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import br.com.agibank.analysis.model.GenericType;
import br.com.agibank.analysis.model.SaleSummary;

/**
 * 
 * Responsible for reading data from input files
 * 
 * @author sergio
 *
 */
@Service
public class FileReaderService {

	public void readFile(Path file, String outputFilePath) {
		try {
		    SaleSummary storage = new SaleSummary();
		    Stream<String> stream = Files.lines(file);
		    lineInterpreter(stream, storage);
		    FileWriterService.generateFile(file, storage, outputFilePath);
		    storage.finalize();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}

    public void lineInterpreter(Stream<String> stream, SaleSummary saleSummary){
        stream.map(line -> line.split("ç"))
                .collect(Collectors.toList())
                .forEach(line -> GenericType.identify(line).store(saleSummary));
    }
	
}
