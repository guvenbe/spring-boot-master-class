package com.in28minutesmock.mockitodemo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SomeBusinessMockAnnotationsTest {

    @Mock
    DataService dataServiceMock;

    @InjectMocks
    SomeBusinessImpl businessImpl;

    @Test
    public void findTheGreatesFromAllDataTest(){
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{24,15,3});
        assertEquals(24, businessImpl.findTheGreatesFromAllData());
    }


    @Test
    public void findTheGreatesFromAllData_ForOneValue(){
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{15});
        assertEquals(15, businessImpl.findTheGreatesFromAllData());
    }

    @Test
    public void findTheGreatesFromAllData_NoOneValue(){
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{});
        assertEquals(Integer.MIN_VALUE, businessImpl.findTheGreatesFromAllData());
    }
}

