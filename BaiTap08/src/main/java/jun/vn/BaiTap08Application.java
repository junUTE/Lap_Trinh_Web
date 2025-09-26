package jun.vn;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import jun.vn.services.IStorageService;

@SpringBootApplication
public class BaiTap08Application {

	public static void main(String[] args) {
		SpringApplication.run(BaiTap08Application.class, args);
	}
	
	 @Bean
	    CommandLineRunner init(IStorageService storageService) {
	        return (args) -> {
	            storageService.init();
	        };
	    }
}
