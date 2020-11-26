package br.com.agibank.analysis.job;

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
    		logger.info("job");
    		createDirectoriesService.create();
			find.search(configProperties.getInpuFilePath()).stream()
			.forEach(file -> reader.readFile(file, configProperties.getOutputFilePath()));
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
    }
     
}
