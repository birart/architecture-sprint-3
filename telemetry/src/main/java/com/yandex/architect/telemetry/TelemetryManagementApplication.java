package com.yandex.architect.telemetry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableJdbcRepositories
public class TelemetryManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(TelemetryManagementApplication.class, args);
	}

}
