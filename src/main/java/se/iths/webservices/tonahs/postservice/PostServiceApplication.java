package se.iths.webservices.tonahs.postservice;

import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.bson.types.ObjectId;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class PostServiceApplication  {

	public static void main(String[] args) {
		SpringApplication.run(PostServiceApplication.class, args);
	}

	@Bean
	public Jackson2ObjectMapperBuilderCustomizer customizer()
	{
		return builder -> builder.serializerByType(ObjectId.class,new ToStringSerializer());
	}
}
