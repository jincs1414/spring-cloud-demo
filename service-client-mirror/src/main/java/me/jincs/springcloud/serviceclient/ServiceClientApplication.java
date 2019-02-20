package me.jincs.springcloud.serviceclient;

import com.codingapi.txlcn.commons.annotation.LcnTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ServiceClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceClientApplication.class, args);
	}

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@LcnTransaction
	@Transactional
	@RequestMapping("/hello")
	public String home(@RequestParam(value = "name") String name) {
		jdbcTemplate.update("insert INTO USER (id,name) VALUES (?,?)","1",name);
		throw new RuntimeException("1");
		//return "Hello world： mirror";
	}
}

