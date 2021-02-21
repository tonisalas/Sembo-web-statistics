package com.Sembo.web.app.controllers;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.Sembo.web.app.data.StatisticsData;

@Controller
public class StatisticsController {
		
	private static final String url = "http://localhost:8080/statistics";	
	
	@GetMapping({"","/"})
	public String readStatistics(Map<String, Object> model) throws InterruptedException, ExecutionException {

		model.put("tittle", "Sembo web statistics");
		model.put("headerPage", "Country statistics");
		
		RestTemplate restTemplate = new RestTemplate();
						
		ResponseEntity<StatisticsData[]> response = restTemplate.getForEntity(url, StatisticsData[].class);
				
		model.put("statistics", Arrays.asList(response.getBody()));
		
		
		return 	"index";
		
	}
	
			
}
