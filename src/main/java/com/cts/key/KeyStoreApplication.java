package com.cts.key;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication


public class KeyStoreApplication /*implements CommandLineRunner*/{

	public static void main(String[] args) {
		SpringApplication.run(KeyStoreApplication.class, args);
	}
	
//	@Autowired
//	private IKeyStore service;
//	
//	private Logger logger = LoggerFactory.getLogger(KeyStoreApplication.class);
//	@Override
//	public void run(String... args) throws Exception {
//		logger.info("{}",service.getKeys().getKeys().get(0));
//	}

}
