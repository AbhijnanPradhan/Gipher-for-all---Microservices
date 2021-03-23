package recommend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan("recommend")
@SpringBootApplication
public class Recommend {

	public static void main(String[] args) {
		SpringApplication.run(Recommend.class, args);
	}

}
