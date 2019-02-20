package me.jincs.springcloud.serviceconsumer;


import com.codingapi.txlcn.client.config.EnableDistributedTransaction;
import com.codingapi.txlcn.commons.annotation.LcnTransaction;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@EnableFeignClients
@EnableDistributedTransaction
public class ServiceConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceConsumerApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	@Autowired
	HelloRemote HelloRemote;
	@Autowired
	private JdbcTemplate jdbcTemplate;


	@LcnTransaction
	@Transactional
	@RequestMapping("/hello/{name}")
	public String index(@PathVariable("name") String name) {
		jdbcTemplate.update("insert INTO USER (id,name) VALUES (?,?)","2",name);
		HelloRemote.hello(name);

		return HelloRemote.hello(name);
	}
}

