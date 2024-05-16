package com.example.sample;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
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
	
	
	@NotBlank(message = "名前を入力してください")
    private String name;

    @NotNull(message = "年齢を入力してください")
    @PositiveOrZero(message = "年齢は0以上の値で入力してください")
    private int age;

    @NotBlank(message = "住所を入力してください")
    private String address;

	
	@Override
	public String toString() {
	return "Person [id=" + id + ", name=" + name + "]";
	}

}
