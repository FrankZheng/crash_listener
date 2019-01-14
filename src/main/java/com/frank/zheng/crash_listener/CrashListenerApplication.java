package com.frank.zheng.crash_listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CrashListenerApplication {
	private static final Logger logger = LoggerFactory.getLogger(CrashListenerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CrashListenerApplication.class, args);
		logger.info("started...");
	}

}

