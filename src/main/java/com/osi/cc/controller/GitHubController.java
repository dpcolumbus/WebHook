package com.osi.cc.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.fasterxml.jackson.databind.ObjectMapper;



@Controller
@RestController
public class GitHubController {

private static final Logger logger = LoggerFactory.getLogger(GitHubController.class);


@Autowired
ObjectMapper mapper;
	
	@RequestMapping(value = "/PostReceive", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<Object> getGitHubData(Object data, HttpServletRequest request)  
    {
			
			logger.info("entering getAllFilesInConstantContact   "+data);
			System.out.println("post reecive get called"+data);
			
			logger.info("exiting getAllFilesInConstantContact   ");
			return new ResponseEntity<Object>(data,HttpStatus.OK);
 	   
    }
	
	

}