package br.com.agibank.analysis.service;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;

import br.com.agibank.analysis.model.SaleSummary;


/**
 * 
 * Class responsible for writing the output file
 * 
 * @author sergio.melo
 *
 */
@Service
public class FileWriterService {

	public static void generateFile(Path file, SaleSummary storage, String outputFilePath){
        try {        	      
        	StringBuilder outputFileName = new StringBuilder().append(outputFilePath).append(FilenameUtils
        			.getBaseName(file.toString())).append(".done.dat");        	 
            FileWriter fileWriter = new FileWriter(outputFileName.toString());
            fileWriter.write(lineConstructor("Total customers: " + storage.totalCostumers()));
            fileWriter.write(lineConstructor("Total sellers: " + storage.totalSalespeople()));
            fileWriter.write(lineConstructor("Most expensive sale ID: " + storage.getHighestSale()));
            fileWriter.write(lineConstructor("The worst seller: " + storage.getWorstVendorName()));
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String lineConstructor(String msg){
        return new String(msg + System.lineSeparator());
    }
	
}
