package com.example.swimmingpoolservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableScheduling
public class SwimmingpoolServiceApplication {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(SwimmingpoolServiceApplication.class, args);
    }
}
