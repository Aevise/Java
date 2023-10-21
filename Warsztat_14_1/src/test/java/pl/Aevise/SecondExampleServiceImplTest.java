package pl.Aevise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SecondExampleServiceImplTest {


    @InjectMocks
    private SecondExampleServiceImpl secondExampleService;

    @Spy
    private List<String> sampleList = new ArrayList<>();


    @Test
    void sampleMethod_whenOneValueToAdd() {
        //given
String testValue = "testValue";
        //when
        secondExampleService.sampleMethod(testValue);
        //then/
        Mockito.verify(sampleList).add(Mockito.anyString());
        Mockito.verify(sampleList).add(testValue);
        Assertions.assertEquals(1, sampleList.size());
    }

    @Test
    void sampleMethod_whenTwoValuesToAdd() {
        //given
            String testvalue1 = "testvalue1";
            String testvalue2 = "testvalue2";
        //when
        secondExampleService.sampleMethod(testvalue1, testvalue2);
        //then/
        Mockito.verify(sampleList, Mockito.times(2)).add(Mockito.anyString());
        Mockito.verify(sampleList).add(testvalue1);
        Mockito.verify(sampleList).add(testvalue2);
        Assertions.assertEquals(2, sampleList.size());
    }

    }
