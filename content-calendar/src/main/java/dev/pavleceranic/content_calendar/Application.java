package dev.pavleceranic.content_calendar;

import dev.pavleceranic.content_calendar.config.ContentCalendarProperties;
import dev.pavleceranic.content_calendar.model.Content;
import dev.pavleceranic.content_calendar.model.Status;
import dev.pavleceranic.content_calendar.model.Type;
import dev.pavleceranic.content_calendar.repository.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@EnableConfigurationProperties(ContentCalendarProperties.class)
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	// programatically insert some data in db. This will be executed after every other process finishes .
//	@Bean
//	CommandLineRunner commandLineRunner(ContentRepository repository) {
//		return args -> {
//			Content c = new Content(
//					null,
//					"Some Project",
//					"Some new project in this world ",
//					Status.IDEA,
//					Type.ARTICLE,
//					LocalDateTime.now(),
//					null,
//					""
//			);
//
//			repository.save(c);
//		};
//	}

}
