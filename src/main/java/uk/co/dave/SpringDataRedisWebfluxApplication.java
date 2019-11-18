package uk.co.dave;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;

@SpringBootApplication
public class SpringDataRedisWebfluxApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataRedisWebfluxApplication.class, args);
	}

	@Bean
	public JaxbAnnotationModule createJaxbAnnotationModule() {
		return new JaxbAnnotationModule();
	}
}
