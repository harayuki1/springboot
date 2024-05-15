package com.example.sample;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer>{
	List<Person> findByAge(int age);
	List<Person> findByAgeLessThan(int age);
	List<Person> findByAgeGreaterThan(int age);
	List<Person> findByAgeBetween(int age,int age2);
	
	//List<Person> findByName(String name);
	Person findByName(String name);
	//同じ意味
	List<Person> findByNameLike(String name);
	//前後に％などを付けなくていい
	List<Person> findByNameContaining(String name);
	Person findById(int id);

}