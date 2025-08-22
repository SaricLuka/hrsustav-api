package hr.tvz.hrsustav;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@EnableTransactionManagement
public class HrsustavApplication {
	public static void main(String[] args) {
		SpringApplication.run(HrsustavApplication.class, args);
		log.info("HRSustav Application started successfully.");
		log.info("http://localhost:8080/swagger-ui/index.html");
	}
}