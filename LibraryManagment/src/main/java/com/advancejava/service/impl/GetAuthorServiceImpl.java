package com.advancejava.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.advancejava.model.Author;
import com.advancejava.service.GetAuthorService;


@Component
public class GetAuthorServiceImpl implements GetAuthorService{

	@Override
	public Author[] getAuthor() {
		RestTemplate restTemplate=new RestTemplate();
		ResponseEntity<Author[]> responseEntity=restTemplate.getForEntity("http://localhost:8081/author",Author[].class);
		return responseEntity.getBody();
	}

}
