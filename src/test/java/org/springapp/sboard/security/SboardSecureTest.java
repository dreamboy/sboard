package org.springapp.sboard.security;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springapp.sboard.SboardApplication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


/**
 * @author dreamboy
 *
 */

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = SboardApplication.class)
//@WebAppConfiguration
//@IntegrationTest("server.port:0")
//@DirtiesContext
//public class SboardSecureTest {
//	
//	@Value("${local.server.port}")
//	private int port;
//	
////	@Test
////	public void testHome() throws Exception {
////		HttpHeaders headers = new HttpHeaders();
////		headers.setAccept(Arrays.asList(MediaType.TEXT_HTML));
////		ResponseEntity<String> entity = new TestRestTemplate().exchange(
////				"http://localhost:" + this.port, HttpMethod.GET, new HttpEntity<Void> (
////						headers), String.class);
//		
//		assertEquals(HttpStatus.FOUND, entity.getStatusCode());
////		assertTrue("Wrong location:\n" + entity.getHeaders(), entity.getHeaders()
////				.getLocation().toString().endsWith(port + "login"));
//		
////	}
//	
//
//}
