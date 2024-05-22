package com.example.sample;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EnemyRepository extends JpaRepository<Enemy, Integer>{

	//List<Person> findByName(String name);
	Enemy findByName(String name);
	//同じ意味
	List<Enemy> findByNameLike(String name);
	//前後に％などを付けなくていい
	List<Enemy> findByNameContaining(String name);
	Enemy findById(int id);
	

}
