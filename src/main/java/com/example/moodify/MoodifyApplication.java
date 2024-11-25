package com.example.moodify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@SpringBootApplication
@EnableJdbcRepositories  // Habilita os repositórios JDBC
public class MoodifyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoodifyApplication.class, args);
    }
}