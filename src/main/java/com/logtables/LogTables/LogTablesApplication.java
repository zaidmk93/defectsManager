package com.logtables.LogTables;

import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.logtables.LogTables.domain.Deffect;
import com.logtables.LogTables.domain.DeffectInstance;
import com.logtables.LogTables.domain.DeffectInstanceRepository;
import com.logtables.LogTables.domain.DeffectRepository;

@SpringBootApplication
public class LogTablesApplication {

	@Autowired
	private DeffectInstanceRepository DefInsRepos;
	@Autowired
	private DeffectRepository deffectRepository;

	public static void main(String[] args) {
		SpringApplication.run(LogTablesApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(){
		return args -> {
			// Save demo data to database
			Start.start();
			DefInsRepos.deleteAll();
			DefInsRepos.save(new DeffectInstance("Ford", "Mustang", 555));

			deffectRepository.deleteAll();
			Iterator<ErrorDescription> iterator=Start.errorsDescriptions.iterator();
			while(iterator.hasNext()) {
				ErrorDescription err=iterator.next();
				deffectRepository.save(new Deffect(err.getAppName(),err.getSeverity().toString(), err.getErrorCode(), err.getErrorMassage()));
			}
		};
	}

}

