package br.com.agibank.analysis;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.agibank.analysis.service.FileReaderService;

class CreateFileTests {

	@Autowired
	private FileReaderService createFile;
	
	private Path path = Paths.get("./src/teste/java/resources/data/in/xmen_test.dat");
	
	@Test
	public void test() {
		
		createFile.readFile(path, "./src/teste/java/resources/data/out/");
		
		assertEquals("./src/teste/java/resources/data/out/xmen_test.done.dat"
				, new File("./src/teste/java/resources/data/out/xmen_test.done.dat"));
		
	}

}
