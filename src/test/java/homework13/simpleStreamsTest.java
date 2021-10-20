package homework13;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class simpleStreamsTest {

    @Test
    public void testAverage() {
        Assertions.assertEquals(5.5, simpleStreams.calculateAverageCol());
    }
    @Test
    public void testUpperCaseAndSort(){
        List<String> testList2 = Arrays.asList("OLEG", "IVAN", "ALEX", "EVGEN");
        Assertions.assertEquals(testList2,simpleStreams.upperCaseAndSort(simpleStreams.collection1()));
    }
    @Test
    public void testLoverCaseAndSort(){
        List<String> testList3 = Arrays.asList("vlad", "ivan", "alex");
        Assertions.assertEquals(testList3,simpleStreams.loverCaseAndSort(simpleStreams.collection2()));
    }
}
