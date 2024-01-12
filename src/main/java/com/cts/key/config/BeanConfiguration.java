package com.cts.key.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class BeanConfiguration {
	@Value(value = "${app.key.url}")
	private String baseURL;
	@Bean
	public RestClient restClient() {
			return RestClient.builder()
					.baseUrl(baseURL)
					.build();
		}
	}
