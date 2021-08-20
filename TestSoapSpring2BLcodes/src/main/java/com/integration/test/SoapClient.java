package com.integration.test;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class SoapClient extends WebServiceGatewaySupport {
	public Object callWebService(String uri,Object request){
        return getWebServiceTemplate().marshalSendAndReceive(uri,request);
    }

}
