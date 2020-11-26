package br.com.agibank.analysis.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

/**
 * 
 * responsible for searching the input files and returning only the .dat files
 * 
 * @author sergio.melo
 *
 */
@Service
public class FileFinderService {
	
	public List<Path> search(String filePath) throws IOException {
        return Files.list(Paths.get(filePath))
                .filter(path -> path.toFile().isFile())
                .filter(path -> path.toFile().getName().endsWith(".dat"))             
                .collect(Collectors.toList());
    }
	
}
