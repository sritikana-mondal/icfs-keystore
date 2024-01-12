package com.cts.key.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.cts.key.exception.KeyException;
import com.cts.key.model.KeyDetails;
import com.cts.key.model.Keys;
import com.cts.key.repository.KeyRepository;

@Service
public class KeyStoreService implements IKeyStore{
	
	private static final Logger log = LoggerFactory.getLogger(KeyStoreService.class);

	@Autowired
	private RestClient restclient;
	@Autowired
	private KeyRepository repository;
	@Override
	public Keys getKeys() {
		// TODO Auto-generated method stub
		return restclient.get()
				.uri("/keys")
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.body(Keys.class);				
		}

	@Override
	public String loadKeys() {
		int num =0;
		for(KeyDetails key:this.getKeys().getKeys()) {
			
			log.debug("Saving :{}",key);
			repository.save(key);
			num++;
		}
		return String.format("%d rows updated.", num);
	}

	@Override
	public List<String> getPrivateKey(String key) {
		log.info("Key : {}",key);
		KeyDetails details =  repository.findByKid(key).orElseThrow(
				()->new KeyException("No Entry found with key "+key+"\n Try loading keys with /keys/load")
			);
		log.debug("{}",details);
		return details.getX5c();
	}
}
