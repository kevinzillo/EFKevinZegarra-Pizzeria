package EFKevinZegarraPizzeria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableFeignClients
@SpringBootApplication
public class MicroServicioPizzeriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServicioPizzeriaApplication.class, args);
	}

}
