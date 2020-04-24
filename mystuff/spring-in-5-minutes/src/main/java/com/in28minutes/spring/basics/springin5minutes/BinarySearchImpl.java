package com.in28minutes.spring.basics.springin5minutes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BinarySearchImpl {

    @Autowired
    private SortAlgorithm sortAlgorithm;

//    public BinarySearchImpl(SortAlgorithm sortAlgorithm) {
//        this.sortAlgorithm=sortAlgorithm;
//    }

//    public void setSortAlgorithm(SortAlgorithm sortAlgorithm) {
//        this.sortAlgorithm = sortAlgorithm;
//    }

    //Implementing Sorting Logic
    //Bubble sort Algorithm
    //Quick sort Algoritm
    public int binarySearch(int[] numbers, int numberToSearchFor) {
        //Implement Sort Logic
        BubbleSortAlgoritm bubbleSortAlgoritm = new BubbleSortAlgoritm();
        int[] sortedNumbers = sortAlgorithm.sort(numbers);
        System.out.println(sortAlgorithm);

        return 3;
    }


    //search the array
    //return the result


}
