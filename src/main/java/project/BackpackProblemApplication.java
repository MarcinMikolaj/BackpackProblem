package project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BackpackProblemApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(BackpackProblemApplication.class, args);
		Service service = context.getBean(Service.class);
		service.menu();	
		context.close();
	}

}
