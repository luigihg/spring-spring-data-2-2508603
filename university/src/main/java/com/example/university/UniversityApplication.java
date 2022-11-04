package com.example.university;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Configuration Class for the University library
 */
@SpringBootApplication
public class UniversityApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(UniversityApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
    }
}
