package com.integration.test.controller;

import javax.xml.bind.JAXBElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.integration.test.SoapClient;
import com.integration.test.stub.DetailsType;
import com.integration.test.stub.GetBankResponseType;
import com.integration.test.stub.GetBankType;
import com.integration.test.stub.ObjectFactory;




@RestController
@RequestMapping("/testBLCodes")
public class TestController {
	
	@Autowired
	SoapClient soapclient;
	
	@PostMapping("/getBank")
	public DetailsType getAddition(@RequestParam int a) {
		ObjectFactory obj = new ObjectFactory();
		GetBankType add = obj.createGetBankType();
		add.setBlz(a+"");
		
		JAXBElement<GetBankResponseType> res =   (JAXBElement<GetBankResponseType>) soapclient.callWebService("http://www.thomas-bayer.com/axis2/services/BLZService", obj.createGetBank(add) );
		System.out.println("obj:::::::"+res.getValue());
		
		System.out.println("string:::::::"+res.toString());
		return res.getValue().getDetails();
		
		//return a+b;
	}

}
