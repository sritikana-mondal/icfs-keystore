package com.cts.key.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity(name = "Keys_TBL")
public class KeyDetails {
	@Id
	@Column(name = "PUBLIC_KEY")
	private String kid;
	@Column(name = "PRIVATE_KEY",columnDefinition="VARCHAR(10000)")
	
	@ElementCollection(fetch = FetchType.EAGER)
	
	private List<String> x5c;
	
	public String getKid() {
		return kid;
	}
	public void setKid(String kid) {
		this.kid = kid;
	}
	public List<String> getX5c() {
		return x5c;
	}
	public void setX5c(List<String> x5c) {
		this.x5c = x5c;
	}
	@Override
	public String toString() {
		return "KeyDetails [kid=" + kid + ", x5c=" + x5c + "]";
	}
	public KeyDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KeyDetails(String kid, List<String> x5c) {
		super();
		this.kid = kid;
		this.x5c = x5c;
	}
	
	
}
