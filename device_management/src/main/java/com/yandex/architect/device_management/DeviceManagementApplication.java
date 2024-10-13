package com.yandex.architect.device_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableJdbcRepositories
@EnableAsync
@EnableKafka
public class DeviceManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeviceManagementApplication.class, args);
	}

}
