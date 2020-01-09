package com.prueba.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.apache.http.HttpEntity;
import org.apache.http.client.cache.CacheResponseStatus;
import org.apache.http.client.cache.HttpCacheContext;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.cache.CacheConfig;
import org.apache.http.impl.client.cache.CachingHttpClients;
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
	
	@GetMapping("/prices2")
	@CrossOrigin(origins = "http://localhost:4200")
	public String currentprice2() throws IOException {
		CacheConfig cacheConfig = CacheConfig.custom()
		        .setMaxCacheEntries(1000)
		        .setMaxObjectSize(8192)
		        .build();
		RequestConfig requestConfig = RequestConfig.custom()
		        .setConnectTimeout(30000)
		        .setSocketTimeout(30000)
		        .build();
		CloseableHttpClient cachingClient = CachingHttpClients.custom()
		        .setCacheConfig(cacheConfig)
		        .setDefaultRequestConfig(requestConfig)
		        .build();
		
		
		
		HttpCacheContext context = HttpCacheContext.create();
		HttpGet httpget = new HttpGet("http://api.coindesk.com/v1/bpi/currentprice.json");
		String ret = "";
		CloseableHttpResponse response = null;
		try {
			response = cachingClient.execute(httpget, context);
	        HttpEntity entity = response.getEntity();
	        if (entity != null) {
	            InputStream instream = entity.getContent();
	            try {
	            	StringBuilder textBuilder = new StringBuilder();
	                try (Reader reader = new BufferedReader(new InputStreamReader
	                  (instream, Charset.forName(StandardCharsets.UTF_8.name())))) {
	                    int c = 0;
	                    while ((c = reader.read()) != -1) {
	                        textBuilder.append((char) c);
	                    }
	                }
	                ret = textBuilder.toString();
	            } finally {
	                instream.close();
	            }
	        }
		}catch(IOException e) {
			System.err.println(e.getLocalizedMessage());
		} finally {
		    response.close();
		}
		
		return ret;
	}
}
