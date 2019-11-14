package uk.co.dave;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

@Configuration
public class BlockingSchedulerConfig {

	 @Bean(name = "schedulerForBlocking")
	 public Scheduler schedulerForBlocking() {
		 return Schedulers.newElastic("blocking-scheduler");
	 }
	
}
