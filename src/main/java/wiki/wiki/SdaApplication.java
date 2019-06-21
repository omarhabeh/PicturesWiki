package wiki.wiki;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication(scanBasePackages={"controllers"})
@EnableAutoConfiguration
public class SdaApplication  {
	
	public static void main(String[] args) {
		SpringApplication.run(SdaApplication.class, args);
	}
}
