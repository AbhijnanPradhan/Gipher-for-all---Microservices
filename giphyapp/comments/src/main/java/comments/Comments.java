package comments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan("comments")
@SpringBootApplication
public class Comments {

	public static void main(String[] args) {
		SpringApplication.run(Comments.class, args);
	}

}
