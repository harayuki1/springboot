package com.example.sample;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import jakarta.transaction.Transactional;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

	@Autowired
	PersonRepository personRepository;
	@Autowired
	EnemyRepository enemyRepository;
	@Autowired
	ItemRepository itemRepository;
	@Autowired
	Game game;
	

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		System.out.println("コマンドラインランナー実行開始");

		
		Person person = new Person("徳川家康", 5, "江戸");
		Person p1 = new Person("織田信長", 18, "安土城");
		Person p2 = new Person("豊臣秀吉", 15, "大阪城");
		Person p3 = new Person("徳川家康", 10, "江戸城");
		Enemy e = new Enemy("monster", 10, 1);
		Enemy e1 = new Enemy("monster1", 10, 1);
//
//		Person person=personRepository.findById(1);
//		person.setName("徳川家康");
//		
//		System.out.println(person.toString());
		personRepository.save(person);
		personRepository.save(p1);
		personRepository.save(p2);
		personRepository.save(p3);
		
		enemyRepository.save(e);
//		enemyRepository.save(e1);
		for(int i=1;i<51;i++) {
			Random random = new Random();
			int cate=random.nextInt(5)+1;
			itemRepository.save(new Item("name"+i,20,"exp"+i,(random.nextInt(100) + 1)*100,Integer.toString(cate)));
		}
		
		
	
		game.init();
//
//		List<Person> list = personRepository.findByAgeBetween(8,16);
//		for (Person p : list) {
//			System.out.println(p.toString());
//
//		}
		List<Enemy> elist = enemyRepository.findAll();
		for (Enemy enemy : elist) {
			if (enemy.getId() == 1) {
				
				int a = enemy.getHp() - 1;
				enemy.setHp(a);
				enemyRepository.save(enemy);
			}

		}
		//personRepository.deleteById();
		//personRepository.save(person);
		System.out.println("コマンドラインランナー実行終了");
	}

}
