package com.example.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {

	@Autowired
	MyService service;
	@Autowired
	EnemyService enemyservice;
	@Autowired
	EnemyRepository enemyRepository;
	
	
	@GetMapping("/")
	public String getIndex(Model model) {
		model.addAttribute("greeting", "こんにちは");
		model.addAttribute("abc", "aaa");
		model.addAttribute("aaa", "abc");

		return "index";
	}

	@GetMapping("/home")
	public String getHome() {
		return "home";
	}

	@GetMapping("/effect")
	public String getEffect(Model model) {
		model.addAttribute("greeting", "こんにちは");

		Person p = new Person();
		p.setName("あ");
		p.setAge(10);

		model.addAttribute("person", p);

		return "effect";
	}

	@GetMapping("/users/{name}")
	public String getUsers(@PathVariable String name, Model model) {
		System.out.println("name = " + name);
		model.addAttribute("message", name + "さん、こんにちは！");
		return "hello";
	}

	@GetMapping("/form")
	public String getForm(Model model) {
		model.addAttribute("title", "入力画面1です。");
		return "form";
	}

	@GetMapping("/result")
	public String getresult(@RequestParam String paramA, @RequestParam String paramB, @RequestParam String paramC,
			Model model) {
		model.addAttribute("param1", paramA);
		model.addAttribute("param2", paramB);
		model.addAttribute("param3", paramC);
		return "result";
	}

	@GetMapping("/form_post")
	public String getForm_post(Model model) {
		model.addAttribute("title", "入力画面2です。");
		return "form_post";
	}

	@PostMapping("/result_post")
	public String getresult_post(ThreeTextForm form, Model model) {
		model.addAttribute("form", form);

		return "result_post";
	}

	@GetMapping("/form_validated")
	public String form_validated(Model model) {
		model.addAttribute("title", "入力画面3です。");
		model.addAttribute("form", new ThreeTextForm_Validated());
		return "form_validated";
	}

	@PostMapping("/result_validated")
	public String result_validated(@Validated @ModelAttribute("form") ThreeTextForm_Validated form,
			BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("title", "入力画面3の再入力です。");
			model.addAttribute("form", form);
			return "form_validated";
		}

		model.addAttribute("form", form);

		return "result_validated";
	}

	@GetMapping("/form_validated2")
	public String form_validated2(Model model) {
		model.addAttribute("title", "入力画面4です。");
		model.addAttribute("threeTextForm_Validated", new ThreeTextForm_Validated());
		return "form_validated2";
	}

	@PostMapping("/result_validated2")
	public String result_validated2(@Validated ThreeTextForm_Validated threeTextForm_Validated,
			BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("title", "入力画面4の再入力です。");
			model.addAttribute("threeTextForm_Validated", threeTextForm_Validated);
			return "form_validated2";
		}

		model.addAttribute("threeTextForm_Validated", threeTextForm_Validated);

		return "result_validated2";
	}

	@GetMapping("/persons")
	public String showPersons(Model model) {
		
		model.addAttribute("persons", service.getPersonList());
		return "persons";
	}
	
	@GetMapping("/enemys")
	public String showEnemys(@RequestParam String paramA, @RequestParam String paramB, @RequestParam String paramC,Model model) {
		int B=Integer.parseInt(paramB);
		int C=Integer.parseInt(paramC);
		Enemy e = new Enemy(paramA, B, C);

		System.out.println(B);
		System.out.println(C);
		enemyRepository.save(e);
		model.addAttribute("enemys", enemyservice.getEnemyList());
		
		return "enemys";
	}
	
	@GetMapping("/enemy_form")
	public String getEnemyform(Model model) {
		model.addAttribute("title", "入力画面");
		return "enemy_form";
	}
	
}
