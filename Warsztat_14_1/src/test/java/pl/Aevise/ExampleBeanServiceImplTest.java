package pl.Aevise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class ExampleBeanServiceImplTest {

    @InjectMocks
    private ExampleBeanServiceImpl exampleBeanService;

    @Mock
    private InjectedBeanService injectedBeanService;

//    implementacja bez adnotacji
//    @BeforeEach
//    void init(){
//        this.injectedBeanService = Mockito.mock(InjectedBeanService.class);
//        this.exampleBeanService = new ExampleBeanServiceImpl();
//        this.exampleBeanService.setInjectedBeanService(injectedBeanService);
//    }

    @ParameterizedTest
    @MethodSource
    void sampleMethod(String val1, String val2) {
        //given
        Mockito.when(injectedBeanService.anotherSampleMethod(ArgumentMatchers.any())).thenReturn(val1);
        Mockito.when(injectedBeanService.someOtherMethod()).thenReturn(val2);

        //When
        String result = exampleBeanService.sampleMethod(val1);

        //then
//        assertEquals("val2val1", result);
//        Mockito.verify(injectedBeanService, Mockito.times(1)).someOtherMethod();
//        Mockito.verify(injectedBeanService, Mockito.times(1)).anotherSampleMethod(ArgumentMatchers.anyString());
        Mockito.verify(injectedBeanService, Mockito.times(1)).someOtherMethod();
    }

    static Stream<Arguments> sampleMethod(){
        return Stream.of(
                Arguments.of("val1", "val2"),
                Arguments.of("val3", "val4"),
                Arguments.of("val5", "val6")
        );
    }
}