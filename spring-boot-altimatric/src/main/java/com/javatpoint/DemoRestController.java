package com.javatpoint;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DemoRestController {
	
	@GetMapping("/userIdCount")
	public int  getUserIdCount() {
		RestTemplate restTemplate = new RestTemplate();
		String uri = "https://jsonplaceholder.typicode.com/posts";
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));	
        ResponseEntity<UserDetail[]> responseEntity = restTemplate.getForEntity(uri,UserDetail[].class);       
        Set<Integer> s=new HashSet<Integer>();
        for(UserDetail ud:responseEntity.getBody()) {
        	s.add(ud.getUserId());
        	System.out.println(ud.getUserId()+" "+ud.getId()+" "+ud.getTitle());
        }       
		return s.size();

	}
	
	@GetMapping("updateUser")
	public  ResponseEntity<UserDetail> updatePost(/*@RequestBody UserDetail userDetail*/) {
	    String url = "https://jsonplaceholder.typicode.com/posts/{id}";
	    RestTemplate restTemplate = new RestTemplate();
	    
	    HttpHeaders headers = new HttpHeaders();
	    
	    headers.setContentType(MediaType.APPLICATION_JSON);
	   
	    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

	    
	    UserDetail userDetail = new UserDetail(4, 5,"flower", "1800Flowers");

	   
	    HttpEntity<UserDetail> entity = new HttpEntity<>(userDetail, headers);

	   
	    ResponseEntity<UserDetail> response = restTemplate.exchange(url, HttpMethod.PUT, entity, UserDetail.class, 10);
	    
	    return response;
	}
	
	
	
	
}
