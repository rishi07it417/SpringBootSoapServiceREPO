package com.test.TestSoapSpringProvider;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import localhost._8080.studentdetails.ws.GetStudentRequest;
import localhost._8080.studentdetails.ws.GetStudentResponse;
import localhost._8080.studentdetails.ws.UniMaster;

@Endpoint
public class StudentEndpoint {
	private static final String NAMESPACE_URI = "http://localhost:8080/studentdetails/ws";
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getStudentRequest")
	@ResponsePayload
	public GetStudentResponse getStudentResponse(@RequestPayload GetStudentRequest request) {
		GetStudentResponse res = new GetStudentResponse();
		UniMaster uni = new UniMaster();
		uni.setCollege("ADIT");
		uni.setStudent("Rishi");
		uni.setStuId("07IT444");
		
		res.setStudent(uni);
		
		return res;
	}

}
