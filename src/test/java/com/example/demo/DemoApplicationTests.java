package com.example.demo;


import java.net.URI;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.ey.poc.common.util.JsonResponseBody;
import com.ey.poc.entity.RmtCompetencyTopics;
import com.ey.poc.entity.RmtSubCompetency;
import com.nimbusds.oauth2.sdk.http.HTTPRequest.Method;

public class DemoApplicationTests {
    
   
    public void addTopic() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        
	String url = "http://localhost:8080/add/topic";
	RmtSubCompetency subCompetency=new RmtSubCompetency();
	subCompetency.setSubCompetencyId(89);
	RmtCompetencyTopics obj = new RmtCompetencyTopics(subCompetency,"Spring REST Security using Hibernate");
	
	
	
	
	
	

        HttpEntity<RmtCompetencyTopics> requestEntity = new HttpEntity<RmtCompetencyTopics>(obj, headers);
      
        ResponseEntity<String> uri = restTemplate.postForEntity(url, requestEntity, String.class);
        System.out.println(uri);    	
    }
    
    public static void main(String args[]) {
    	DemoApplicationTests util = new DemoApplicationTests();
        //util.getArticleByIdDemo();
    	util.addTopic();
    	//util.updateArticleDemo();
    	//util.deleteArticleDemo();
    	//util.getAllArticlesDemo();    	
    }    
} 