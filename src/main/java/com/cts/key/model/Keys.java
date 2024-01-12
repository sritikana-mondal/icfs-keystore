package com.cts.key.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Keys{
	private List<KeyDetails> keys;

	public Keys() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Keys(List<KeyDetails> keys) {
		super();
		this.keys = keys;
	}

	public List<KeyDetails> getKeys() {
		return keys;
	}

	public void setKeys(List<KeyDetails> keys) {
		this.keys = keys;
	}
	
}