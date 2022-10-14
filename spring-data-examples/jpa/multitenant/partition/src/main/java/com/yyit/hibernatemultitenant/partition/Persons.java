package com.yyit.hibernatemultitenant.partition;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Persons extends JpaRepository<Person, Long> {

	static Person named(String name) {
		Person person = new Person();
		person.setName(name);
		return person;
	}

	@Query("select p from Person p where name = :name")
	Person findJpqlByName(String name);

	@Query(value = "select * from Person p where name = :name", nativeQuery = true)
	Person findSqlByName(String name);
}
