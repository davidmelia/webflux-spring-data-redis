package uk.co.dave;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.convert.KeyspaceConfiguration;
import org.springframework.data.redis.core.convert.MappingConfiguration;
import org.springframework.data.redis.core.index.IndexConfiguration;
import org.springframework.data.redis.core.mapping.RedisMappingContext;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;

import uk.co.dave.holding.Holdings;
import uk.co.dave.person.Person;

@Configuration
public class RedisConfig {
	@Bean
	public RedisMappingContext keyValueMappingContext(@Value("${spring.application.name}") String applicationName) {
		return new RedisMappingContext(
				new MappingConfiguration(new IndexConfiguration(), new MyKeyspaceConfiguration(applicationName)));
	}

	public static class MyKeyspaceConfiguration extends KeyspaceConfiguration {

		public MyKeyspaceConfiguration(String applicationName) {
			super();
			KeyspaceSettings personKeyspaceSettings = new KeyspaceSettings(Person.class, applicationName + ":person");
			// personKeyspaceSettings.setTimeToLive(10L);
			this.addKeyspaceSettings(personKeyspaceSettings);
		}

	}

	@Bean
	public ReactiveRedisTemplate<String, Holdings> dave(final ReactiveRedisConnectionFactory factory,
			Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder) {
		ObjectMapper objectMapper = jackson2ObjectMapperBuilder.modules(new JaxbAnnotationModule()).build();
		Jackson2JsonRedisSerializer<Holdings> serializer = new Jackson2JsonRedisSerializer<>(Holdings.class);
		serializer.setObjectMapper(objectMapper);
		RedisSerializationContext.RedisSerializationContextBuilder<String, Holdings> builder = RedisSerializationContext
				.newSerializationContext(new StringRedisSerializer());

		RedisSerializationContext<String, Holdings> context = builder.value(serializer).build();

		return new ReactiveRedisTemplate<>(factory, context);
	}

}
