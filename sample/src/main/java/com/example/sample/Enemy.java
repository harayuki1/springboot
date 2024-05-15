package com.example.sample;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class Enemy {
	public Enemy(String name,int Hp,int attack){
		this.name=name;
		this.Hp=Hp;
		this.attack=attack;
	}
	
	public Enemy() {
		this("a",1,1);
	}
	
	@Id
	@GeneratedValue
	private int id;
	
	private String name = "あ";

	private int Hp = 0;

	private int attack;

	
}
