package com.example.sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class Game {

	@Autowired
	ItemRepository itemRepository;

	public static int[] category = new int[6];

	public static int today = 1;
	public static boolean gameover = false;

	@Transactional
	public void init() {
		

		if (Game.gameover == true) {
			
//			for (int i = 1; i <= itemRepository.findAll().size(); i++) {
//				itemRepository.deleteById(i);
//			}
			for (int i = 1; i < 51; i++) {
				Random random = new Random();
				int cate = random.nextInt(5) + 1;

				itemRepository.findById(i).setStorage(20);
				itemRepository.findById(i).setValue( (random.nextInt(100) + 1) * 100);
				itemRepository.findById(i).setCategory(Integer.toString(cate));
				itemRepository.findById(i).setBuy(0);
				itemRepository.findById(i).setFavorite(false);
				itemRepository.findById(i).setDay(1);
				itemRepository.findById(i).setOrigin(20);
				itemRepository.findById(i).setValue_data(new ArrayList<>());
				
				
				itemRepository.save(itemRepository.findById(i));
			}
			Game.today = 1;
			Game.gameover = false;

		}
		for (int i = 0; i < 10; i++) {
			for (int k = 0; k < 3; k++) {
				Random random = new Random();
				int id = random.nextInt(50) + 1;
				int change = random.nextInt(5) + 1;

				itemRepository.findById(id).setBuy(itemRepository.findById(id).getBuy() + change);
				itemRepository.findById(id).setStorage(itemRepository.findById(id).getStorage() - change);
				category[Integer.parseInt(itemRepository.findById(id).getCategory())]++;
				itemRepository.save(itemRepository.findById(id));
			}
			List<Item> items = itemRepository.findAll();
			for (Item item : items) {

				item.getValue_data().add(item.getBuy());
				item.setBuy(0);
				item.setDay(Game.today);
				item.setOrigin(item.getStorage());
				itemRepository.save(item);
			}

			Game.today++;
		}
	}

	public void day() {
		for (int k = 0; k < 3; k++) {
			Random random = new Random();
			int value = random.nextInt(100) + 1;
			int change = random.nextInt(15) + 1;
			List<Item> items;
			if (value > 60) {

				items = itemRepository.findByCategory(String.valueOf(findMaxIndex(category)));

			} else {
				items = itemRepository.findAll();
			}
			int randomIndex = random.nextInt(items.size());
			Item item = items.get(randomIndex);
			if ((item.getStorage() - 1) >= 0) {
				item.setBuy(item.getBuy() + change);
				if (item.getStorage() - change < 0) {
					item.setStorage(0);
				} else {
					item.setStorage(item.getStorage() - change);
				}
			} else {
				Game.gameover = true;
				return;
			}
			category[Integer.parseInt(item.getCategory())]++;
			itemRepository.save(item);
		}
		List<Item> items = itemRepository.findAll();
		for (Item item : items) {

			item.getValue_data().add(item.getBuy());
			item.setBuy(0);
			item.setDay(Game.today);
			item.setOrigin(item.getStorage());
			itemRepository.save(item);
		}

		System.out.println(String.valueOf(findMaxIndex(category)));

		Game.today++;
	}

	public static int findMaxIndex(int[] array) {
		if (array == null || array.length == 0) {
			throw new IllegalArgumentException("配列はnullまたは空であってはなりません");
		}

		int maxIndex = 0;
		int maxValue = array[0];

		for (int i = 1; i < array.length; i++) {
			if (array[i] > maxValue) {
				maxValue = array[i];
				maxIndex = i;
			}
		}

		return maxIndex;
	}
}
