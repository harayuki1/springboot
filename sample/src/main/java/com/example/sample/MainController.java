package com.example.sample;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	@Autowired
	PersonRepository personRepository;
	@Autowired
	ItemRepository itemRepository;
	@Autowired
	Game game;

	
	//商品リスト
	@GetMapping("/item_list")
	public String Item_list(@RequestParam(value = "keyword", required = false) String keyword, Model model) {

		List<Item> items;
		if (keyword != null && !keyword.isEmpty()) {
			items = itemRepository.findByNameContaining(keyword);
		} else {
			items = itemRepository.findAll();
		}
		model.addAttribute("items", items);
		model.addAttribute("keyword", keyword);

		return "item_list";
	}

	//購入数追加
	@PostMapping("/plus_item/{id}")
	public String plusItem(@PathVariable("id") int id) {
		if ((itemRepository.findById(id).getStorage() - 1) >= 0) {
			itemRepository.findById(id).setBuy(itemRepository.findById(id).getBuy() + 1);
			itemRepository.findById(id).setStorage(itemRepository.findById(id).getStorage() - 1);
		}

		itemRepository.save(itemRepository.findById(id));
		return "redirect:/item_list";
	}

	//購入数減少
	@PostMapping("/minus_item/{id}")
	public String minusItem(@PathVariable("id") int id) {
		if ((itemRepository.findById(id).getBuy() - 1) >= 0) {
			itemRepository.findById(id).setBuy(itemRepository.findById(id).getBuy() - 1);
			itemRepository.findById(id).setStorage(itemRepository.findById(id).getStorage() + 1);
		}

		itemRepository.save(itemRepository.findById(id));
		return "redirect:/item_list";
	}

	//お気に入り商品
	@PostMapping("/favorite_item/{id}")
	public String favoriteItem(@PathVariable("id") int id) {
		if (itemRepository.findById(id).isFavorite()) {
			itemRepository.findById(id).setFavorite(false);
		} else {
			itemRepository.findById(id).setFavorite(true);
		}

		itemRepository.save(itemRepository.findById(id));
		return "redirect:/item_list";
	}

	//お気に入りのみ
	@GetMapping("/item_favorite")
	public String item_favorite(Model model) {
		List<Item> items;
		items = itemRepository.findByFavorite(true);
		model.addAttribute("items", items);
		return "item_favorite";
	}

	//購入数追加
	@PostMapping("/plus_item/{id}/favorite")
	public String plusItem_favorite(@PathVariable("id") int id) {
		if ((itemRepository.findById(id).getStorage() - 1) >= 0) {
			itemRepository.findById(id).setBuy(itemRepository.findById(id).getBuy() + 1);
			itemRepository.findById(id).setStorage(itemRepository.findById(id).getStorage() - 1);
		}

		itemRepository.save(itemRepository.findById(id));
		return "redirect:/item_favorite";
	}

	//購入数減少
	@PostMapping("/minus_item/{id}/favorite")
	public String minusItem_favorite(@PathVariable("id") int id) {
		if ((itemRepository.findById(id).getBuy() - 1) >= 0) {
			itemRepository.findById(id).setBuy(itemRepository.findById(id).getBuy() - 1);
			itemRepository.findById(id).setStorage(itemRepository.findById(id).getStorage() + 1);
		}

		itemRepository.save(itemRepository.findById(id));
		return "redirect:/item_favorite";
	}

	//お気に入り
	@PostMapping("/favorite_item/{id}/favorite")
	public String favoriteItem_favorite(@PathVariable("id") int id) {
		if (itemRepository.findById(id).isFavorite()) {
			itemRepository.findById(id).setFavorite(false);
		} else {
			itemRepository.findById(id).setFavorite(true);
		}

		itemRepository.save(itemRepository.findById(id));
		return "redirect:/item_favorite";
	}

	//カート内

	@GetMapping("/item_cart")
	public String Item_list_cart(Model model) {

		List<Item> items = itemRepository.findByBuyGreaterThan(0);
		int total = 0;
		for (Item item : items) {
			total = total + item.getBuy() * item.getValue();
		}
		model.addAttribute("items", items);
		model.addAttribute("total", total);
		return "item_cart";
	}

	//購入数追加
	@PostMapping("/plus_item/{id}/cart")
	public String plusItem_cart(@PathVariable("id") int id) {
		if ((itemRepository.findById(id).getStorage() - 1) >= 0) {
			itemRepository.findById(id).setBuy(itemRepository.findById(id).getBuy() + 1);
			itemRepository.findById(id).setStorage(itemRepository.findById(id).getStorage() - 1);
		}

		itemRepository.save(itemRepository.findById(id));
		return "redirect:/item_cart";
	}

	//購入数減少
	@PostMapping("/minus_item/{id}/cart")
	public String minusItem_cart(@PathVariable("id") int id) {
		if ((itemRepository.findById(id).getBuy() - 1) >= 0) {
			itemRepository.findById(id).setBuy(itemRepository.findById(id).getBuy() - 1);
			itemRepository.findById(id).setStorage(itemRepository.findById(id).getStorage() + 1);
		}

		itemRepository.save(itemRepository.findById(id));
		return "redirect:/item_cart";
	}

	//お気に入り商品
	@PostMapping("/favorite_item/{id}/cart")
	public String favoriteItem_cart(@PathVariable("id") int id) {
		if (itemRepository.findById(id).isFavorite()) {
			itemRepository.findById(id).setFavorite(false);
		} else {
			itemRepository.findById(id).setFavorite(true);
		}

		itemRepository.save(itemRepository.findById(id));
		return "redirect:/item_cart";
	}

	//購入完了
	@GetMapping("/ok")
	public String ok(Model model) {
		List<Item> items = itemRepository.findAll();
		for (Item item : items) {
			
			item.getValue_data().add(item.getBuy());
			item.setBuy(0);
			item.setDay(Game.today);
			item.setOrigin(item.getStorage());
			itemRepository.save(item);
		}
		
		game.day();
		if(Game.gameover==true) {
			return "gameover";
		}
		
		model.addAttribute("items", items);
		return "ok";
	}
	@GetMapping("/next")
	public String next(Model model) {
		List<Item> items = itemRepository.findAll();
		for (Item item : items) {
			//
			item.getValue_data().add(item.getBuy());
			item.setBuy(0);
			item.setDay(Game.today);
			item.setOrigin(item.getStorage());
			itemRepository.save(item);
		}
		
		game.day();
		if(Game.gameover==true) {
			game.init();
			return "gameover";
		}
		model.addAttribute("items", items);
		return "item_list";
	}
	
	@GetMapping("/gameover")
	public String gameover(Model model) {
		game.init();
		
		return "gameover";
	}


	//商品データ
	@GetMapping("/items")
	public String showItems(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
		List<Item> items;
		if (keyword != null && !keyword.isEmpty()) {
			switch(keyword) {
			case "category1":
				items = itemRepository.findByCategory("1");
				break;
			case "category2":
				items = itemRepository.findByCategory("2");
				break;
			case "category3":
				items = itemRepository.findByCategory("3");
				break;
			case "category4":
				items = itemRepository.findByCategory("4");
				break;
			case "category5":
				items = itemRepository.findByCategory("5");
				break;
			default:
				items = itemRepository.findByNameContaining(keyword);
			}
			
		} else {
			items = itemRepository.findAll();
		}
		model.addAttribute("items", items);
		//model.addAttribute("keyword", keyword);
		return "items";
	}
	

	@PostMapping("/items")
	public String saveItem(@Validated Item item, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("title", "入力画面");
			model.addAttribute("item", item);
			return "item_form";
		}
		itemRepository.save(item);
		return "redirect:/items";
	}

	//削除ボタン
	@PostMapping("/delete_item/{id}")
	public String deleteItem(@PathVariable("id") int id) {
		itemRepository.deleteById(id);
		return "redirect:/items";
	}

	//商品追加
	@GetMapping("/item_form")
	public String item_form(Model model) {
		model.addAttribute("title", "入力画面");
		model.addAttribute("item", new Item());
		return "item_form";
	}

	//商品編集
	@GetMapping("/change_item/{id}")
	public String itemChange(@PathVariable("id") int id, Model model) {
		Item item = itemRepository.findById(id);
		model.addAttribute("title", "編集画面");
		model.addAttribute("item", item);
		return "item_form";
	}

	@PostMapping("/change_item/{id}")
	public String item_change(@PathVariable("id") int id, @Validated Item item, BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("title", "編集画面");
			model.addAttribute("item", itemRepository.findById(id));
			return "item_form";
		}

		Item newItem = itemRepository.findById(id);
		newItem = item;
		itemRepository.save(newItem);

		return "redirect:/items";

	}
	
	@GetMapping("/data_search")
	public String datasearch(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
		Item items;
		List<Integer> data=new ArrayList<>();
		if (keyword != null && !keyword.isEmpty()) {
			int pass=Integer.parseInt(keyword);
			items = itemRepository.findById(pass);
			data= items.getValue_data();
		}
		model.addAttribute("data", data);
		//model.addAttribute("keyword", keyword);
		return "data_search";
	}
	
	@GetMapping("/data_search_category")
	public String datasearch_category(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
	    List<Item> items = new ArrayList<>();
	    if (keyword != null && !keyword.isEmpty()) {
	        items = itemRepository.findByCategory(keyword);
	    }

	    List<Integer> data = new ArrayList<>();
	    
	    
	        for (int i = 0; i < Game.today-1 ; i++) {
	            int total = 0;
	            for (Item item : items) {
	                if (item.getValue_data().size() > i) {
	                    total += item.getValue_data().get(i);
	                } 
	            }
	            data.add(total);
	        }
	        
	        if(data.size()<Game.today-1) {
	        	int a=Game.today-data.size()-1;
	        	for(int i=0;i<a;i++){
	        		int none=0;
	        		data.add(none);
	        		
	        	}
	        }
	    
	    model.addAttribute("data", data);
	    return "data_search_category";
	}

}
