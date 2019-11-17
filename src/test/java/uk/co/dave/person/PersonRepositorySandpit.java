package uk.co.dave.person;

import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisOperations;

@SpringBootTest
class PersonRepositorySandpit {

	@Autowired RedisOperations<Object, Object> operations;
	@Autowired PersonRepository repository;
	
	Person dave = new Person("dave", "melia");
	
	//@BeforeEach
	public void setUp() {
		operations.execute((RedisConnection connection) -> {
			connection.flushDb();
			return "OK";
		});
	}
	
	@Test
	public void populate() {
		Person id = repository.save(dave);
		
		Optional<Person> found = repository.findById(id.getId());
		
		System.out.println(found.get());
		
		System.out.println(repository.count());
		
		
	}

}
