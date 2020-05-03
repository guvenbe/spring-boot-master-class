package com.in28minutesmock.mockitodemo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SomeBusinessStubTest {

    @Test
    public void findTheGreatesFromAllDataTest(){
        SomeBusinessImpl businessImpl = new SomeBusinessImpl(new DataServiceStub());
        int result = businessImpl.findTheGreatesFromAllData();
        assertEquals(24,result);
    }

}

class DataServiceStub implements DataService{

    @Override
    public int[] retrieveAllData() {
        return new int[] {24,6,15};
    }
}