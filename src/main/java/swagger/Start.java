package swagger;

//import com.spring4all.swagger.EnableSwagger2Doc;
import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@EnableSwagger2Doc//要生成文档就用这个 swagger 开启注解,这个注解功能更强大且也能启用 swagger
//@EnableSwagger2
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Start {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication();
        app.run(Start.class);
    }
}
