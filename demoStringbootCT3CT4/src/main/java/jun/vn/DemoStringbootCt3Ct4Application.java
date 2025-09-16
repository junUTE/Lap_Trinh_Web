package jun.vn;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;


@SpringBootApplication(scanBasePackages = {"jun.vn.Controller"})
@Component
public class DemoStringbootCt3Ct4Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoStringbootCt3Ct4Application.class, args);
	}
	 
}
