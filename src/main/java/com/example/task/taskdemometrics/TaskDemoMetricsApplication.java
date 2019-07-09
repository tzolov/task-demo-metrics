package com.example.task.taskdemometrics;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTask
public class TaskDemoMetricsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskDemoMetricsApplication.class, args);
	}

	@Bean
	public TimestampTask timeStampTask() {
		return new TimestampTask();
	}

	/**
	 * A commandline runner that prints a timestamp.
	 */
	public class TimestampTask implements CommandLineRunner {
		private final Log logger = LogFactory.getLog(TimestampTask.class);


		@Override
		public void run(String... strings) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			logger.info(dateFormat.format(new Date()));
		}
	}
}
