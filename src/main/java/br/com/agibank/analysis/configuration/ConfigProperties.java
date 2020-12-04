package br.com.agibank.analysis.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;


/**
 * 
 * set and get data from the properties file
 * 
 * @author sergio.melo
 *
 */
@ConfigurationProperties("config")
public class ConfigProperties {

	private String inpuFilePath;
	private String outputFilePath;
	private String inputFilePathTest;
	private String outputFilePathTest;
	
	public String getInpuFilePath() {
		return inpuFilePath;
	}
	
	public void setInpuFilePath(String inpuFilePath) {
		this.inpuFilePath = inpuFilePath;
	}
	
	public String getOutputFilePath() {
		return outputFilePath;
	}
	
	public void setOutputFilePath(String outputFilePath) {
		this.outputFilePath = outputFilePath;
	}
	
	public String getInputFilePathTest() {
		return inputFilePathTest;
	}
	
	public void setInputFilePathTest(String inputFilePathTest) {
		this.inputFilePathTest = inputFilePathTest;
	}
	
	public String getOutputFilePathTest() {
		return outputFilePathTest;
	}
	
	public void setOutputFilePathTest(String outputFilePathTest) {
		this.outputFilePathTest = outputFilePathTest;
	}
	
}
