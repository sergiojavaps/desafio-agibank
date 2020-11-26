package br.com.agibank.analysis.job;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.agibank.analysis.configuration.ConfigProperties;
import br.com.agibank.analysis.service.CreateDirectoryService;
import br.com.agibank.analysis.service.FileFinderService;
import br.com.agibank.analysis.service.FileReaderService;

/**
 * class responsible for executing the file processing job
 * 
 * @author sergio.melo
 * 
 */
@Component
public class ApplicationJob {

	private Logger logger = LoggerFactory.getLogger(ApplicationJob.class);
    private final String cronConfig = "*/10 * * * * *";
    private final String timeZone = "America/Sao_Paulo";
    @Autowired
    private CreateDirectoryService createDirectoriesService;
    @Autowired
    private FileReaderService reader;
    @Autowired
    private FileFinderService find;
    @Autowired
    private ConfigProperties configProperties;
    
    @PostConstruct
    private void ini() {
    	logger.info("-------------------");
    	logger.info(" INI JOB");
    	logger.info("-------------------");    	
    	logger.info("Local directories created:");
    	logger.info(System.getProperty("user.home") + configProperties.getInpuFilePath());
    	logger.info(System.getProperty("user.home") + configProperties.getOutputFilePath());    	
    }
    
    /**
     * 
     * job scheduling and execution
     * 
     * @author sergio.melo
     * 
     */
    @Scheduled(cron = cronConfig, zone = timeZone)
    @Async
    public void processFilesJob() {
    	try {
    		createDirectoriesService.create();
			find.search(System.getProperty("user.home") + configProperties.getInpuFilePath()).stream()
			.forEach(file -> reader.readFile(file, System.getProperty("user.home") + configProperties.getOutputFilePath()));
		} catch (Exception e) {
			logger.error("" + e);
		}
    }
     
}
