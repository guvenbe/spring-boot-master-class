package com.in28minutes.spring.basics.springin5minutes;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class QuickSortAlgoritm implements SortAlgorithm {

    public int[] sort(int[] numbers) {
        return numbers;
    }
}
