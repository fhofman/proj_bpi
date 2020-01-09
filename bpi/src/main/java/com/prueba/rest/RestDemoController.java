package com.prueba.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
public class RestDemoController {
	
	@GetMapping("/prices")
	@CrossOrigin(origins = "http://localhost:4200")
	public String currentprice() {
		RestTemplate restTemplate = new RestTemplate();
		String fooResourceUrl
		  = "http://api.coindesk.com/v1/bpi/currentprice.json";
		/*ResponseEntity<String> response
		  = restTemplate.getForEntity(fooResourceUrl, String.class);*/
		String response
		  = restTemplate.getForObject(fooResourceUrl, String.class);
		//assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
		return response;
	}
}
