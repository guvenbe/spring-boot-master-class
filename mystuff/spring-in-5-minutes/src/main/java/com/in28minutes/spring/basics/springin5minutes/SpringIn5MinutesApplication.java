package com.in28minutes.spring.basics.springin5minutes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringIn5MinutesApplication {

    public static void main(String[] args) {

//        BinarySearchImpl binarySearch = new BinarySearchImpl(new BubbleSortAlgoritm());
        // Application Context
        ConfigurableApplicationContext applicationContext =
                SpringApplication.run(SpringIn5MinutesApplication.class, args);

        BinarySearchImpl binarySearch = applicationContext.getBean(BinarySearchImpl.class);

        int result = binarySearch.binarySearch(new int[]{12, 4, 6}, 3);
        System.out.println(result);
    }

}
