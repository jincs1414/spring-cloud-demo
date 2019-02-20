package me.jincs.springcloud.servicelogger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin2.server.internal.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
@EnableEurekaClient
public class ServiceLoggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceLoggerApplication.class, args);
	}

}

