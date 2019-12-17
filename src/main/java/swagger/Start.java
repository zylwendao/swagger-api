package swagger;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableSwagger2Doc
//@EnableSwagger2
@SpringBootApplication
public class Start {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication();
        app.run(Start.class);
    }
}
