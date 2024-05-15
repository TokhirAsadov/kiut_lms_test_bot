package uz.kiut.kiut_test_bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
@ImportAutoConfiguration({FeignAutoConfiguration.class})
public class KiutTestBotApplication {
	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(KiutTestBotApplication.class, args);
	}

}
