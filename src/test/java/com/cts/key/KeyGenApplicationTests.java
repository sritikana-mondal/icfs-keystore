package com.cts.key;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cts.key.controller.KeyController;
import com.cts.key.exception.KeyException;

@SpringBootTest
//@ContextConfiguration(classes = {KeyController.class})
@ActiveProfiles("test")
public class KeyGenApplicationTests {

	@Autowired
	private KeyController controller;
	
	private  MockMvc mvc;
	
	@BeforeEach
	void setup() {
		mvc = MockMvcBuilders.standaloneSetup(controller)
		.build();
	}
	
	@Order(1)
	@Test
	void test_loadkeys() throws Exception {
		mvc.perform(post("/keys/load").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		
		}
	@Order(2)
	@Test
	void test_getPrivateKey() throws Exception{
		String idString = "lHLIu4moKqzPcokwlfCRPHyjl5g";
		String reString = "[\"MIIC6TCCAdGgAwIBAgIIT3fcexMa3ggwDQYJKoZIhvcNAQELBQAwIzEhMB8GA1UEAxMYbG9naW4ubWljcm9zb2Z0b25saW5lLnVzMB4XDTIzMDcxNDAwNDU0NFoXDTI4MDcxNDAwNDU0NFowIzEhMB8GA1UEAxMYbG9naW4ubWljcm9zb2Z0b25saW5lLnVzMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAxlc+u9LJvOdbwAsgsYZpaJrgmrGHaEkoa/3/7Jvu4+Hb8LNtszrQy5Ik4CXgQ/uiLPt4+ePprX3klFAx91ahfd5LwX6mEQPT8WuHMDunx8MaNQrYNVvnOI1L5NxFBFV/6ghi/0d+cOslErcTMML2lbMCSjQ8jwltxz1Oy+Hd9wdY2pz2YC3WR4tHzAGreWGeOB2Vs2NLGv0U3CGSCMqpM9vxbWLZQPuCNpKF93RkxHj5bLng9U/rM6YScacEnTFlKIOOrk4pcVVdoSNNIK2uNUs1hHS1mBXuQjfceghzj3QQYHfp1Z5qWXPRIw3PDyn/1Sowe5UljLurkpj/8m3KnQIDAQABoyEwHzAdBgNVHQ4EFgQUCSJrrznFYz1BLqd17S8HFjGrAOAwDQYJKoZIhvcNAQELBQADggEBAAQHNudtmYpeh9x5+rGDVy6OYpTnQ2D5+rmgOHM5yRvgEnFBNuZ6bnr3Ap9nb6EM08juYKPaVyhkV+5axMl+dT8KOuCgrfcKvXqzdQ3BgVFkyU9XfajHzq3JALYpNkixCs/BvqRhXx2ecYxFHB2D671cOwhYIaMZdGtbmOOk8puYSgJ9DBqqn3pLksHmxLP656l/U3hPATTCdfDaNcTagIPx+Q2d9RBn8zOIa/p4CLsu3E0aJfDw3ljPD8inLJ2mpKq06TBfd5Rr/auwipb4J8Y/PHhef8b2kOf42fikIKAP538k9lLsXSowyPWn7KZDTEsku7xpyqvKvEiFkmaV+RY=\"]";
		MvcResult result= mvc.perform(get("/keys/get/"+idString).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andDo(print())
		.andReturn();
		
		assertEquals(reString ,result.getResponse().getContentAsString());
	}
	

	@Order(3)@Test void test_getPrivateKeyWhenPublicKeyNotAvailable() {
		String idString = "lHLIu4moKqzPcokwlfCRPHyj78g";
		try {
			mvc.perform(
					get("/keys/get/"+idString)
					).andExpect(status().isNotFound());
		} catch (Exception e) {
			assertInstanceOf(KeyException.class, e.getCause());
		}	
	}
}