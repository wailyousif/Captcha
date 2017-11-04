package com.app;

import com.app.dto.ResponseObject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringJpaWebApplicationTests {

	@Test
	public void contextLoads() {

assertTrue(true);
	}

	@Test
	public void walkThroughTest()
	{
		assertTrue(true);
	}


	/*
	private void httpAddProperty(String authKey, String propertyName)
	{
		String url = "http://localhost:8080/rest/prop/add";
		MultiValueMap<String, Object> map= new LinkedMultiValueMap<String, Object>();

		map.add("propName", propertyName);
		map.add("propType", "4");
		map.add("street", "Church St.");
		map.add("city", "Orlando");
		map.add("country", "USA");
		map.add("zipCode", "32801");
		map.add("lat", "28.53955735608056");
		map.add("lng", "-81.40510114337201");
		map.add("rooms", "5");
		map.add("baths", "3");
		map.add("storeys", "2");
		map.add("ckbAC", "true");
		map.add("ckbWasher", "true");
		map.add("ckbGym", "false");
		map.add("ckbGarage", "true");
		map.add("ckbParking", "false");

		Resource resource = new FileSystemResource("/var/www/propFinder/collection/pexels-photo-323775.jpeg");
		//map.add("Content-Type", "image/jpeg");
		map.add("mainPic", resource);

		map.add("rentPrice", "1400");
		map.add("sellingPrice", "0");
		map.add("ckbAvailable", "true");

		HashMap<String, String> customHeaders = new HashMap<>();
		customHeaders.put("x-authorization-key", authKey);

//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
//		headers.add("x-authorization-key", authKey);
//		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<MultiValueMap<String, Object>>(map, headers);
//		ResponseObject responseObject = (new RestTemplate()).exchange(url, HttpMethod.POST, requestEntity, ResponseObject.class).getBody();

		ResponseObject responseObject = doHttp(url, map, MediaType.MULTIPART_FORM_DATA, customHeaders);
		Assert.assertNotNull(responseObject);
		Assert.assertEquals("Error while adding property", 1, responseObject.getSuccess());
		Assert.assertEquals(responseObject.getResponseString(), 0, responseObject.getResponseCode());
		System.out.println(responseObject.getResponseString());
	}
	*/


	private ResponseObject doHttp(String url, MultiValueMap<String, Object> map, MediaType mediaType,
								  HashMap<String, String> customHeaders)
	{
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(mediaType);
		if (customHeaders != null)
		{
			Iterator it = customHeaders.entrySet().iterator();
			while (it.hasNext())
			{
				Map.Entry pair = (Map.Entry)it.next();
				headers.add(pair.getKey().toString(), pair.getValue().toString());
			}
		}

		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<MultiValueMap<String, Object>>(map, headers);

		//ResponseObject responseObject = (new RestTemplate()).postForEntity(url, requestEntity, ResponseObject.class).getBody();
		ResponseObject responseObject = (new RestTemplate()).exchange(url, HttpMethod.POST, requestEntity, ResponseObject.class).getBody();
		return responseObject;
	}
}
