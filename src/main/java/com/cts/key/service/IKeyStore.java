package com.cts.key.service;

import java.util.List;

import com.cts.key.model.Keys;

public interface IKeyStore {
	public String loadKeys();
	public Keys getKeys();
	
	public List<String> getPrivateKey(String key);
}
