package com.in28minutes.junit;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class MyMathTest {

    MyMath myMatch = new MyMath();

    @BeforeAll
    public static void beofreAll() {
        System.out.println("beofreAll");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("afterAll");
    }

    @BeforeEach
    public void beofreEach() {
        System.out.println("beofreEach");
    }

    @AfterEach
    public void AfterEach() {
        System.out.println("AfterEach");
    }

   @Test
    public void sum_with3numbers() {
        System.out.println("sum_with3numbers");
        assertEquals(6, myMatch.sum(new int[]{1, 2, 3}));
    }

    @Test
    public void sum_with1numbers() {
        System.out.println("sum_with1numbers");
        assertEquals(3, myMatch.sum(new int[]{3}));
    }


}
