package com.restmate.questioncollector.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    public Bootstrap() {
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Bootstrap class is working");
    }
}
