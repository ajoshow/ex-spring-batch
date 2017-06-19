package com.ajoshow;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @author chiahung.chu on 2017/6/19.
 */
@Configuration
@EnableAsync
public class AsyncConfiguration {
    @Bean
    public Executor asyncExecutor() {
	ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
	executor.setCorePoolSize(2);
	executor.setMaxPoolSize(2);
	executor.setQueueCapacity(500);
	executor.setThreadNamePrefix("Async-");
	executor.initialize();
	return executor;
    }

}
