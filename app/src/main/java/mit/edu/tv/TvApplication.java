package mit.edu.tv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TvApplication {

	public static void main(String[] args) {
        System.out.println("--- Hello World! ---");
		SpringApplication.run(TvApplication.class, args);
	}

}
