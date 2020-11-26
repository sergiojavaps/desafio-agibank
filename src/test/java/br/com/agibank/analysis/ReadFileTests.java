package br.com.agibank.analysis;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.agibank.analysis.service.FileFinderService;

@SpringBootTest
class ReadFileTests {

	@Mock
	FileFinderService fileFinderService;
	
	@Test
	public void findFile() throws IOException {
		 when(fileFinderService.search(anyString())).thenReturn( new ArrayList<Path>());	
		 List<Path> pathList = fileFinderService.search("");
	     assertNotNull(pathList);
	}
	
	@Test()
    public void ioError() {
		try {
        when(fileFinderService.search(anyString()))
                .thenThrow(IOException.class);
        fileFinderService.search("");
        
		} catch (IOException e) {
			fail(e);
		}
    }

}
