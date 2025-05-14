package com.sode.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("Testing")
public class TestingProfile implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		
		// ADD WEAPON CATEGORY TO CASE OPENING (NORMAL, STT, GLOVES, KNIFES)
	
		}
}
