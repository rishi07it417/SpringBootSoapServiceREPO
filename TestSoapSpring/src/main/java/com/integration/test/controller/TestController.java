package com.integration.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.integration.test.SoapClient;
import com.integration.test.stub.Add;
import com.integration.test.stub.AddResponse;
import com.integration.test.stub.ObjectFactory;



@RestController
@RequestMapping("/testSoap")
public class TestController {
	
	@Autowired
	SoapClient soapclient;
	
	@PostMapping("/Add")
	public int getAddition(@RequestParam int a,@RequestParam int b) {
		ObjectFactory obj = new ObjectFactory();
		Add add = obj.createAdd();
		add.setIntA(a);
		add.setIntB(b);
		
		AddResponse res = (AddResponse) soapclient.callWebService("http://tempuri.org/Add", add );
		return res.getAddResult();
		
		//return a+b;
	}

}
