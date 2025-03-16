package com.antilope.antilopeManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AntilopeManagerApplication {
	private AntilopeManagerApplication() {
		// Prevent instantiation
	}
	/**
	 * The main entry point for the Antilope Manager application.
	 *
	 * @param args the command line arguments
	 */
	public static void main(final String[] args) {
		SpringApplication.run(AntilopeManagerApplication.class, args);
	}

}
