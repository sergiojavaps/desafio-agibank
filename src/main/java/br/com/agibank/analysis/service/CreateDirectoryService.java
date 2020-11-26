package br.com.agibank.analysis.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.agibank.analysis.configuration.ConfigProperties;

/**
 * 
 * responsible for creating the input and output files directories
 * 
 * @author sergio.melo
 *
 */
@Service
public class CreateDirectoryService {

	@Autowired
	ConfigProperties configProperties;
	
	public void create() {
		new File(System.getProperty("user.home") + configProperties.getInpuFilePath()).mkdirs();
		new File(System.getProperty("user.home") + configProperties.getOutputFilePath()).mkdirs();
	}
	
}
