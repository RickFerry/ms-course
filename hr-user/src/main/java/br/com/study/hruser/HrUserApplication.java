package br.com.study.hruser;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//@Slf4j
@EnableEurekaClient
@SpringBootApplication
public class HrUserApplication implements CommandLineRunner{

	/* @Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder; */

	public static void main(String[] args) {
		SpringApplication.run(HrUserApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//log.info("A senha gerada foi: " + bCryptPasswordEncoder.encode("123456"));
	}
}
