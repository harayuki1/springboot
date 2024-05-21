package com.example.sample;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer>{
	
	Item findByName(String name);
	List<Item>findByNameContaining(String name);
	List<Item>findByFavorite(boolean favorite);
	List<Item> findByBuyGreaterThan(int buy);
	List<Item> findByCategory(String category);

	Item findById(int id);
	

}