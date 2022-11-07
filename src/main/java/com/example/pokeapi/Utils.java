package com.example.pokeapi;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Utils {
    private static ObjectMapper objectMapper;
	
	public static String objectToJson(Object object)
	{
		ObjectMapper mapper = Utils.getMapperInstance();
		try {
			return mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String sendJSONRequestFinal(final String url, final String method, String json) throws IOException, URISyntaxException
	{
		HttpClient client = HttpClientBuilder.create().build();
		HttpEntityEnclosingRequestBase request = new HttpEntityEnclosingRequestBase() {
			@Override
			public String getMethod() {
				return method;
			}
		};

		request.setURI(new URI(url));
		StringEntity requestEntity = new StringEntity(json, ContentType.APPLICATION_JSON);
		request.setEntity(requestEntity);
		HttpResponse response = client.execute(request);
		InputStream is = response.getEntity().getContent();
		byte[] b = is.readAllBytes();
		is.close();
		return new String(b);
	}

	public static String sendJSONRequest(String url, String method, Object requestBody) throws IOException, URISyntaxException
	{
		return sendJSONRequestFinal(url, method, objectToJson(requestBody));
	}

	public static String sendJSONRequest(String url, String method) throws IOException, URISyntaxException
	{
		return sendJSONRequest(url, method, null);
	}
	
	public static ObjectMapper getMapperInstance()
	{
		if(objectMapper == null)
			objectMapper = new ObjectMapper();
		
		return objectMapper;
	}
}
