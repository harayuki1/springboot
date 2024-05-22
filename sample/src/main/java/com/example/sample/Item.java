package com.example.sample;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
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
@Table(name="items")
public class Item {
	
	public Item(String name,int storage,String exp,int value,String category){
		this.name=name;
		this.storage=storage;
		this.exp=exp;
		this.value=value;
		this.category=category;
		this.buy=0;
		this.favorite=false;
		this.day=1;
		this.origin=storage;
		this.value_data = new ArrayList<>();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	

	@NotBlank(message = "名前を入力してください")
    private String name;

    @NotNull(message = "数を入力してください")
    @PositiveOrZero(message = "数量は0以上の値で入力してください")
    private int storage;
    		
    @NotBlank(message = "説明を入力してください")
    private String exp;
    
    @NotNull(message = "数を入力してください")
    @PositiveOrZero(message = "数量は0以上の値で入力してください")
    private int value;
    
    @NotBlank(message = "説明を入力してください")
    private String category;

    private int buy;
    
    private boolean favorite;
    
    private int day;
    
    private int origin;

    @Lob
	@ElementCollection
	private List<Integer> value_data;


	
	
	

}