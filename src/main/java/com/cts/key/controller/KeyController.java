package com.cts.key.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.key.service.IKeyStore;

@RestController
@RequestMapping(path = "keys")
public class KeyController {
	
	@Autowired
	private IKeyStore keyStoreService;
	
	@PostMapping(path = "/load")
	public String loadKeys() {
		return keyStoreService.loadKeys();
	}
	
	@GetMapping(path = "/get/{id}")
	public List<String> getKey(@PathVariable(name = "id") String id) {
		return keyStoreService.getPrivateKey(id);
	}
}
