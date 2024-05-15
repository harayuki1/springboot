package com.example.sample;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EnemyService {
	@Autowired
	EnemyRepository enemyRepository;
	

	public ArrayList<Enemy> getEnemyList() {
//		
//		
		
		ArrayList<Enemy> arrayList = (ArrayList<Enemy>) enemyRepository.findAll();
		
		
		return arrayList;
	}

}
