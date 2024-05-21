package com.example.sample;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {

	@Autowired
	ItemRepository itemRepository;

	//商品リスト
	@GetMapping("/category1")
	public String Item_category1(Model model) {

		List<Item> items=itemRepository.findByCategory("1");
		model.addAttribute("items", items);
		
		return "category1";
	}

	//購入数追加
	@PostMapping("/plus_item/{id}/category1")
	public String pluscategory1(@PathVariable("id") int id) {
		if ((itemRepository.findById(id).getStorage() - 1) >= 0) {
			itemRepository.findById(id).setBuy(itemRepository.findById(id).getBuy() + 1);
			itemRepository.findById(id).setStorage(itemRepository.findById(id).getStorage() - 1);
		}

		itemRepository.save(itemRepository.findById(id));
		return "redirect:/category1";
	}

	//購入数減少
	@PostMapping("/minus_item/{id}/category1")
	public String minuscategory1(@PathVariable("id") int id) {
		if ((itemRepository.findById(id).getBuy() - 1) >= 0) {
			itemRepository.findById(id).setBuy(itemRepository.findById(id).getBuy() - 1);
			itemRepository.findById(id).setStorage(itemRepository.findById(id).getStorage() + 1);
		}

		itemRepository.save(itemRepository.findById(id));
		return "redirect:/category1";
	}

	//お気に入り商品
	@PostMapping("/favorite_item/{id}/category1")
	public String favoritecategory1(@PathVariable("id") int id) {
		if (itemRepository.findById(id).isFavorite()) {
			itemRepository.findById(id).setFavorite(false);
		} else {
			itemRepository.findById(id).setFavorite(true);
		}

		itemRepository.save(itemRepository.findById(id));
		return "redirect:/category1";
	}
	//商品リスト
		@GetMapping("/category2")
		public String Item_category2(Model model) {

			List<Item> items=itemRepository.findByCategory("2");
			model.addAttribute("items", items);
			
			return "category2";
		}

		//購入数追加
		@PostMapping("/plus_item/{id}/category2")
		public String pluscategory2(@PathVariable("id") int id) {
			if ((itemRepository.findById(id).getStorage() - 1) >= 0) {
				itemRepository.findById(id).setBuy(itemRepository.findById(id).getBuy() + 1);
				itemRepository.findById(id).setStorage(itemRepository.findById(id).getStorage() - 1);
			}

			itemRepository.save(itemRepository.findById(id));
			return "redirect:/category2";
		}

		//購入数減少
		@PostMapping("/minus_item/{id}/category2")
		public String minuscategory2(@PathVariable("id") int id) {
			if ((itemRepository.findById(id).getBuy() - 1) >= 0) {
				itemRepository.findById(id).setBuy(itemRepository.findById(id).getBuy() - 1);
				itemRepository.findById(id).setStorage(itemRepository.findById(id).getStorage() + 1);
			}

			itemRepository.save(itemRepository.findById(id));
			return "redirect:/category2";
		}

		//お気に入り商品
		@PostMapping("/favorite_item/{id}/category2")
		public String favoritecategory2(@PathVariable("id") int id) {
			if (itemRepository.findById(id).isFavorite()) {
				itemRepository.findById(id).setFavorite(false);
			} else {
				itemRepository.findById(id).setFavorite(true);
			}

			itemRepository.save(itemRepository.findById(id));
			return "redirect:/category2";
		}
		//商品リスト
		@GetMapping("/category3")
		public String Item_category3(Model model) {

			List<Item> items=itemRepository.findByCategory("3");
			model.addAttribute("items", items);
			
			return "category3";
		}

		//購入数追加
		@PostMapping("/plus_item/{id}/category3")
		public String pluscategory3(@PathVariable("id") int id) {
			if ((itemRepository.findById(id).getStorage() - 1) >= 0) {
				itemRepository.findById(id).setBuy(itemRepository.findById(id).getBuy() + 1);
				itemRepository.findById(id).setStorage(itemRepository.findById(id).getStorage() - 1);
			}

			itemRepository.save(itemRepository.findById(id));
			return "redirect:/category3";
		}

		//購入数減少
		@PostMapping("/minus_item/{id}/category3")
		public String minuscategory3(@PathVariable("id") int id) {
			if ((itemRepository.findById(id).getBuy() - 1) >= 0) {
				itemRepository.findById(id).setBuy(itemRepository.findById(id).getBuy() - 1);
				itemRepository.findById(id).setStorage(itemRepository.findById(id).getStorage() + 1);
			}

			itemRepository.save(itemRepository.findById(id));
			return "redirect:/category3";
		}

		//お気に入り商品
		@PostMapping("/favorite_item/{id}/category3")
		public String favoritecategory3(@PathVariable("id") int id) {
			if (itemRepository.findById(id).isFavorite()) {
				itemRepository.findById(id).setFavorite(false);
			} else {
				itemRepository.findById(id).setFavorite(true);
			}

			itemRepository.save(itemRepository.findById(id));
			return "redirect:/category3";
		}
		//商品リスト
		@GetMapping("/category4")
		public String Item_category4(Model model) {

			List<Item> items=itemRepository.findByCategory("4");
			model.addAttribute("items", items);
			
			return "category4";
		}

		//購入数追加
		@PostMapping("/plus_item/{id}/category4")
		public String pluscategory4(@PathVariable("id") int id) {
			if ((itemRepository.findById(id).getStorage() - 1) >= 0) {
				itemRepository.findById(id).setBuy(itemRepository.findById(id).getBuy() + 1);
				itemRepository.findById(id).setStorage(itemRepository.findById(id).getStorage() - 1);
			}

			itemRepository.save(itemRepository.findById(id));
			return "redirect:/category4";
		}

		//購入数減少
		@PostMapping("/minus_item/{id}/category4")
		public String minuscategory4(@PathVariable("id") int id) {
			if ((itemRepository.findById(id).getBuy() - 1) >= 0) {
				itemRepository.findById(id).setBuy(itemRepository.findById(id).getBuy() - 1);
				itemRepository.findById(id).setStorage(itemRepository.findById(id).getStorage() + 1);
			}

			itemRepository.save(itemRepository.findById(id));
			return "redirect:/category4";
		}

		//お気に入り商品
		@PostMapping("/favorite_item/{id}/category4")
		public String favoritecategory4(@PathVariable("id") int id) {
			if (itemRepository.findById(id).isFavorite()) {
				itemRepository.findById(id).setFavorite(false);
			} else {
				itemRepository.findById(id).setFavorite(true);
			}

			itemRepository.save(itemRepository.findById(id));
			return "redirect:/category4";
		}
		//商品リスト
		@GetMapping("/category5")
		public String Item_category5(Model model) {

			List<Item> items=itemRepository.findByCategory("5");
			model.addAttribute("items", items);
			
			return "category5";
		}

		//購入数追加
		@PostMapping("/plus_item/{id}/category5")
		public String pluscategory5(@PathVariable("id") int id) {
			if ((itemRepository.findById(id).getStorage() - 1) >= 0) {
				itemRepository.findById(id).setBuy(itemRepository.findById(id).getBuy() + 1);
				itemRepository.findById(id).setStorage(itemRepository.findById(id).getStorage() - 1);
			}

			itemRepository.save(itemRepository.findById(id));
			return "redirect:/category5";
		}

		//購入数減少
		@PostMapping("/minus_item/{id}/category5")
		public String minuscategory5(@PathVariable("id") int id) {
			if ((itemRepository.findById(id).getBuy() - 1) >= 0) {
				itemRepository.findById(id).setBuy(itemRepository.findById(id).getBuy() - 1);
				itemRepository.findById(id).setStorage(itemRepository.findById(id).getStorage() + 1);
			}

			itemRepository.save(itemRepository.findById(id));
			return "redirect:/category5";
		}

		//お気に入り商品
		@PostMapping("/favorite_item/{id}/category5")
		public String favoritecategory5(@PathVariable("id") int id) {
			if (itemRepository.findById(id).isFavorite()) {
				itemRepository.findById(id).setFavorite(false);
			} else {
				itemRepository.findById(id).setFavorite(true);
			}

			itemRepository.save(itemRepository.findById(id));
			return "redirect:/category5";
		}
}
