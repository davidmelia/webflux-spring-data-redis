package uk.co.dave.person;


import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@RedisHash("persons")
@NoArgsConstructor
class Person {

	private @Id String id;
	private String firstname;
	private String lastname;


	public Person(String firstname, String lastname) {

		this.firstname = firstname;
		this.lastname = lastname;
	}
}
