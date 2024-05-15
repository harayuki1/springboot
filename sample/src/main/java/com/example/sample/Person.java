package com.example.sample;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="persons")
public class Person {
	
	public Person(String name,int age,String address){
		this.name=name;
		this.age=age;
		this.address=address;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@NotBlank(message = "何か入力してください")
	@Size(min = 3, max = 10, message = "3～10文字以内にしてください")
	private String name = "あ";

	@Min(value=0, message = "3～10文字以内にしてください")
	private int age = 0;

	@NotBlank(message = "何か入力してください")
	private String address;
	
	@Override
	public String toString() {
	return "Person [id=" + id + ", name=" + name + "]";
	}

}
