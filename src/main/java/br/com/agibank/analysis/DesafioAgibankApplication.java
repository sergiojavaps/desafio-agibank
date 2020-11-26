package br.com.agibank.analysis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;

import br.com.agibank.analysis.configuration.ConfigProperties;

@SpringBootApplication
@EnableConfigurationProperties(ConfigProperties.class)
@EnableScheduling
@Async
public class DesafioAgibankApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioAgibankApplication.class, args);
	}

}
