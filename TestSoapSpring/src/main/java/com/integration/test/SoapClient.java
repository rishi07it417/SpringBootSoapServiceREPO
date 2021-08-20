package com.integration.test;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class SoapClient extends WebServiceGatewaySupport {
	public Object callWebService(String soapAction, Object request){
        return getWebServiceTemplate().marshalSendAndReceive(request, new SoapActionCallback(soapAction) );
    }

}
