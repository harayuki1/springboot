package com.example.sample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {
	@GetMapping("/weather")
	public WeatherReport getWeather() {
		WeatherReport report=new WeatherReport();
		report.setHeadlineText("ヘッドラインです");
		report.setPublishingOffice("天文台");
		report.setTargetArea("日本");
		report.setText("晴れ");
		return report;
	}
	
	@PostMapping("/weather")
	public WeatherReport postWeather(@RequestParam String areacode) {
		WeatherReport report=new WeatherReport();
		report.setHeadlineText("ヘッドラインです");
		report.setPublishingOffice("天文台");
		report.setTargetArea("日本");
		report.setText("晴れ");
		return report;
	}
	
	@GetMapping("/weather/{areacode}")
	public WeatherReport getWeatherCode(@PathVariable String areacode) {
		WeatherReport report=new WeatherReport();
		report.setHeadlineText(areacode);
		report.setPublishingOffice("天文台");
		report.setTargetArea("日本");
		report.setText("晴れ");
		return report;
	}
}
