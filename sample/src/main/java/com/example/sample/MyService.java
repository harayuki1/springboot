package com.example.sample;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MyService {
	@Autowired
	PersonRepository personRepository;
	

	public ArrayList<Person> getPersonList() {
//		
//		Person person = new Person("徳川家康", 5, "江戸");
//		Person p1 = new Person("織田信長", 18, "安土城");
//		Person p2 = new Person("豊臣秀吉", 15, "大阪城");
//		Person p3 = new Person("徳川家康", 10, "江戸城");
//
//		
//
//		personRepository.save(person);
//		personRepository.save(p1);
//		personRepository.save(p2);
//		personRepository.save(p3);
		
		ArrayList<Person> arrayList = (ArrayList<Person>) personRepository.findAll();
		
		/*
		arrayList.add(new Person("あ", 1, "日本",1));
		arrayList.add(new Person("B", 3, "アメリカ",2));
		arrayList.add(new Person("い", 10, "北海道",3));
		arrayList.add(new Person("う", 100, "東京",4));
		arrayList.add(new Person("え", 101, "千葉",5));
		*/
		return arrayList;
	}

}
