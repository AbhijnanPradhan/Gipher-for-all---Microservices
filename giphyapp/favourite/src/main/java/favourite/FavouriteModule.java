package favourite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan("favourite")
@SpringBootApplication
public class FavouriteModule {

	public static void main(String[] args) {
		SpringApplication.run(FavouriteModule.class, args);
	}

}
