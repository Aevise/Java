package pl.Aevise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SecondExampleServiceImpl implements SecondExampleService {

    private List<String> someList = new ArrayList<>();
    @Override
    public void sampleMethod(String... valuesToAdd) {
        for (String s : valuesToAdd) {
            someList.add(s);
        }
    }
}
