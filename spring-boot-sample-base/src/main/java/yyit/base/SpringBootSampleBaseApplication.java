package yyit.base;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SpringBootSampleBaseApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SpringBootSampleBaseApplication.class, args);

		SpringApplication application = new SpringApplication(SpringBootSampleBaseApplication.class);
		application.setBannerMode(Banner.Mode.OFF);
		
		application.run(args);
	}

	




}
